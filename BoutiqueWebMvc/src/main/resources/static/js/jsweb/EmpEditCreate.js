// VALIDAR INGRESO NUMERO
$(document).on("input", "#txtdni", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

})

$(document).on("input", "#txtmovil", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

})

