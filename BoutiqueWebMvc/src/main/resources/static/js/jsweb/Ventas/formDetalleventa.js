// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_det", function () {
    $("#mant_producto_det").prop("disabled", false);
    $("#btn_form_registrar_det").prop("disabled", false);
    
    $("#mant_id_venta_det").val($(this).attr("data-ven_id")); // no se usara

    
    $("#mant_cantidad_det").val("1");
    //$("#mant_producto_det").val("");
    //$("#mant_descuento_det").val("");

    $("#mant_id_det").val("0");


    ListarCategorias();
    $("#modal_mantenimiento_det").modal("show");

    $('#mant_producto_det option:eq(0)').prop('selected', true)
    $('#mant_descuento_det option:eq(0)').prop('selected', true)


});


// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_det", function () {

    $("#del_mesaje_eliminar_det").text("¿Estas seguro de eliminar el producto '"+$(this).attr("data-det_nombre")+"' ?")

    $("#del_id_det").val($(this).attr("data-det_id"));

    $("#modal_eliminar_det").modal("show");

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_det", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/venta/eliminardetalleventa",
        data: JSON.stringify({ // DEFINIR MODELO

            detalleventa_id: $("#del_id_det").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_det").modal("hide");
                ListarTabla();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_det", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/venta/registrardetalleventa",
        data: JSON.stringify({ // DEFINIR MODELO

            detalleventa_id: $("#mant_id_det").val(),
            detalleventa_cantidad: $("#mant_cantidad_det").val(),
            venta_id: $("#mant_id_venta_det").val(),
            producto_id: $("#mant_producto_det option:selected").val(),
            descuento_id: $("#mant_descuento_det option:selected").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_det").modal("hide");
                ListarTabla();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});




// NPUT GENERAL ___ VAL EDIT
function ListarCategorias() {

    let datos_insertados;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/venta/listarProductosPorIdVentaJson",
        data: JSON.stringify({
            venta_id: $("#mant_id_venta_det").val(),
        }),

        success: function (resultado) {

            validar_producto_seleccionado(resultado)
   
        }
    });

    console.log(datos_insertados)
}

function validar_producto_seleccionado(lista_prod_exitentes) {


    $.ajax({
        type: "GET",
        url: "/venta/listarProductosJson",
        dataType: "json",
        success: function (resultado) {
            
            let llenado_total = false;

            $("#mant_producto_det").html("");
            $("#mant_producto_det").append(`<option style="display:none;" value="-1" selected>Seleccionar producto</option>`)

            $.each(resultado, function (index, value) {            

                // OBTENER VALORES REPEDITOS
                let repetido_val=false;
                $.each(lista_prod_exitentes, function (idx, prod_id){
                    if(value.producto_id==prod_id){
                        repetido_val=true;
                        return false;
                    }             
                })

                if(!repetido_val){
                    llenado_total = true;
                    $("#mant_producto_det").append(
                        `<option value="${value.producto_id}">${value.producto_nombre}</option>`
                    )
                }

            });

            if(!llenado_total){
                $("#mant_producto_det").html("");
                $("#mant_producto_det").append(`<option style="display:none;" selected>Todos los productos fueron agregados</option>`)

                $("#mant_producto_det").prop("disabled", true);
                $("#btn_form_registrar_det").prop("disabled", true);


                



            }
        }
    })

}






// OBTENER TABLA HTML
function ListarTabla() {

    //Actualizamos la página
    location.reload();

}


// VALIDAR INGRESO NUMERO - VALOR MINIMO  Y MAXIMO DE COMPRA
$(document).on("input", "#mant_cantidad_det", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');


    if (this.value < 1) {
        this.value = 1;
    }
    else if (this.value > 100) {
        this.value = 100;
    }

})




