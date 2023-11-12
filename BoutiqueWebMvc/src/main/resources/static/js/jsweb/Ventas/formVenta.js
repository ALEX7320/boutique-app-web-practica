// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_ven", function () {

    //$("#mant_cliente_ven").val("0");
    $("#mant_fecha_ven").val($("#get_dia_actual").val()),
    $("#mant_descripcion_ven").val("");
    $("#mant_igv_ven").val($("#igv_monto_tag").val());
    //$("#mant_tipopago_ven").val("0");
    //$("#mant_comprobante_ven").val("0");

    $("#mant_id_ven").val("0");
    $("#mant_estado_ven").val(true);

    $('#mant_cliente_ven option:eq(0)').prop('selected', true)
    $('#mant_tipopago_ven option:eq(0)').prop('selected', true)
    $('#mant_comprobante_ven option:eq(0)').prop('selected', true)

    // establecer caja de texto
    $("#mant_descripcion_ven").css("height", "5em");

    $("#modal_mantenimiento_ven").modal("show");


});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_ven", function () {


    $("#mant_cliente_ven").val($(this).attr("data-ven_cliente"));
    $("#mant_fecha_ven").val($(this).attr("data-ven_fecha"));
    $("#mant_descripcion_ven").val($(this).attr("data-ven_descripcion"));
    $("#mant_igv_ven").val($(this).attr("data-ven_igv"));
    $("#mant_tipopago_ven").val($(this).attr("data-ven_tipopago"));
    $("#mant_comprobante_ven").val($(this).attr("data-ven_comprobante"));

    $("#mant_id_ven").val($(this).attr("data-ven_id"));
    $("#mant_estado_ven").val($(this).attr("data-ven_estado"));


    // establecer caja de texto
    $("#mant_descripcion_ven").css("height", "5em");

    $("#modal_mantenimiento_ven").modal("show");


});

// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_ven", function () {

    $("#del_mesaje_eliminar_ven").text("¿Estas seguro de eliminar el la venta: " +
        "ID " + $(this).attr("data-ven_id") + " | " +
        "FECHA " + $(this).attr("data-ven_fecha") + " | " +
        "CLIENTE " + $(this).attr("data-ven_cliente")

    )

    $("#del_id_ven").val($(this).attr("data-ven_id"));

    $("#modal_eliminar_ven").modal("show");

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_ven", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/venta/eliminarventa",
        data: JSON.stringify({ // DEFINIR MODELO

            venta_id: $("#del_id_ven").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_ven").modal("hide");
                ListarTabla();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_ven", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/venta/registrarventa",
        data: JSON.stringify({ // DEFINIR MODELO

            venta_id: $("#mant_id_ven").val(),
            venta_fecha: $("#mant_fecha_ven").val(),
            venta_descripcion: String($("#mant_descripcion_ven").val()).trim(),
            venta_igv: $("#mant_igv_ven").val(),
            venta_estado: $("#mant_estado_ven").val(),
            tipopago_id: $("#mant_tipopago_ven option:selected").val(),
            cliente_id: $("#mant_cliente_ven option:selected").val(),
            comprobante_id: $("#mant_comprobante_ven option:selected").val()

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_ven").modal("hide");
                ListarTabla();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});




// OBTENER TABLA HTML
function ListarTabla() {

    //Actualizamos la página
    location.reload();

}


