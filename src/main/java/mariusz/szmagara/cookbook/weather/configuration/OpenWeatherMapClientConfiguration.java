package mariusz.szmagara.cookbook.weather.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OpenWeatherMapClientConfiguration {
    @Bean
    @Autowired
    @Qualifier("openWeatherMapTemplate")
    public RestTemplate openWeatherMapTemplate(@Value("${open.weather.map.host.URL}") String openWeatherMapHostUrl) {
        return new RestTemplateBuilder()
                .rootUri(openWeatherMapHostUrl)
                .build();
    }
}
