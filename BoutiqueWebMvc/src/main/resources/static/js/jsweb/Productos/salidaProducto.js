// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_sal", function () {


    $("#mant_cantidad_sal").val("1"),
    $("#mant_fecha_sal").val($("#get_dia_actual").val()),
    $("#mant_descripcion_sal").val(""),

    $("#mant_id_sal").val("0"),

    $('#mant_producto_sal option:eq(0)').prop('selected', true)

    $("#mant_descripcion_sal").css("height", "5em");
    $("#modal_mantenimiento_sal").modal("show");

});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_sal", function () {

    $("#mant_cantidad_sal").val($(this).attr("data-sal_cantidad"));
    $("#mant_fecha_sal").val($(this).attr("data-sal_fecha"));
    $("#mant_descripcion_sal").val($(this).attr("data-sal_descripcion"));
    $("#mant_producto_sal").val($(this).attr("data-sal_producto"));

    $("#mant_id_sal").val($(this).attr("data-sal_id"));

    $("#mant_descripcion_sal").css("height", "5em");
    $("#modal_mantenimiento_sal").modal("show");

});



// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_sal", function () {


    $("#del_mesaje_eliminar_sal").text("¿Estas seguro de eliminar el ingreso: " + $(this).attr("data-sal_fecha") + "?");

    $("#del_id_sal").val($(this).attr("data-sal_id"));

    $("#modal_eliminar_sal").modal("show");

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_sal", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/salida/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO

            salida_id: $("#del_id_sal").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_sal").modal("hide");
                ListarCategorias();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_sal", function () {
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/salida/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            salida_id: $("#mant_id_sal").val(),
            salida_cantidad: $("#mant_cantidad_sal").val(),
            salida_fecha: $("#mant_fecha_sal").val(),
            salida_descripcion: String($("#mant_descripcion_sal").val()).trim(),
            producto_id: $("#mant_producto_sal option:selected").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_sal").modal("hide");
                
                ListarCategorias();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});



// OBTENER TABLA HTML
function ListarCategorias() {

    $.ajax({
        type: "GET",
        url: "/salida/listarSalidaJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_salidas > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_salidas > tbody").append(

                    `
                    <tr>
                        <td class="text-center">${value.salida_id}</td>
                        <td class="text-center">${value.salida_cantidad}</td>
                        <td class="text-center">${formatoDia(value.salida_fecha)}</td>
                        <td>${value.producto_id.producto_nombre}</td>

                        <td class="text-center">
                            <button type="button" class="btn btn-success btn_editar_sal"
                                data-sal_id="${value.salida_id}"
                                data-sal_cantidad="${value.salida_cantidad}"
                                data-sal_fecha="${formatoDia(value.salida_fecha)}"
                                data-sal_descripcion="${value.salida_descripcion}"
                                data-sal_producto="${value.producto_id.producto_id}">
                                <i class="fa-solid fa-file-pen"></i>
                            </button>
                        </td>

                        <td class="text-center">
                            <button type="button" class="btn btn-danger btn_eliminar_sal"
                                data-sal_id="${value.salida_id}"
                                data-sal_fecha="${formatoDia(value.salida_fecha)}"
                                >
                                <i class="fa-solid fa-trash-can"></i>
                            </button>
                        </td>
                    </tr>
                    
                    `

                )

            });

        }


    })

}




function formatoDia(fecha){
    //yyyy-MM-dd
    let d = new Date(fecha);              
    let ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d);
    let mo = new Intl.DateTimeFormat('en', { month: '2-digit' }).format(d);
    let da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d);

    return `${ye}-${mo}-${da}`
}

// VALIDAR INGRESO NUMERO
$(document).on("input", "#mant_cantidad_sal", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');
    
    if (this.value < 1) {
        this.value = 1;
    }


})