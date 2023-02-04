function addIngredient(){
    var row = $("#ingredients > tbody > tr:first").html();
    $('#ingredients > tbody ').append('<tr>'+row+'</tr>');

}

function removeIngredient(obj){
    var row =  $('#ingredients > tbody > tr').length;

    if(row <= 1){
        alert("Recipe has to have at least one ingredient!");
        return;
    }

    $(obj).parent().parent().remove();
}