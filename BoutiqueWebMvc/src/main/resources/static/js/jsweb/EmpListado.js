// VALIDAR INGRESO NUMERO
$(document).on("input", "#textdni", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

})