package mariusz.szmagara.cookbook.preparationtime.converter;

import mariusz.szmagara.cookbook.preparationtime.model.PreparationTime;
import mariusz.szmagara.cookbook.preparationtime.model.TimeUnit;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class PreparationTimeConverter implements AttributeConverter<PreparationTime, String> {
    private static final String SEPARATOR = " ";


    @Override
    public String convertToDatabaseColumn(PreparationTime entityPreparationTime) {
        if (entityPreparationTime == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (entityPreparationTime.getValue() != 0) {
            stringBuilder.append(entityPreparationTime.getValue());
            stringBuilder.append(SEPARATOR);
        }
        if (!entityPreparationTime.getTimeUnit().name().isEmpty()) {
            stringBuilder.append(entityPreparationTime.getTimeUnit().name());
        }
        return stringBuilder.toString();
    }

    @Override
    public PreparationTime convertToEntityAttribute(String dataBasePreparationTime) {
        if (dataBasePreparationTime == null || dataBasePreparationTime.isEmpty()) {
            return null;
        }
        String[] preparationTimeValueAndUnitSeparately = dataBasePreparationTime.split(SEPARATOR);
        if (preparationTimeValueAndUnitSeparately.length == 0) {
            return null;
        }
        PreparationTime preparationTime = new PreparationTime();
        int value = !preparationTimeValueAndUnitSeparately[0].isEmpty() ? Integer.parseInt(preparationTimeValueAndUnitSeparately[0]) : 0;
        if (dataBasePreparationTime.contains(SEPARATOR)) {
            preparationTime.setValue(value);
            if (preparationTimeValueAndUnitSeparately.length >= 2 && !preparationTimeValueAndUnitSeparately[1].isEmpty()) {
                preparationTime.setTimeUnit(TimeUnit.valueOf(preparationTimeValueAndUnitSeparately[1]));
            }
        } else {
            // What to do when dataBasePreparationTime.contains(SEPARATOR) is false???
        }
        return preparationTime;
    }
}
