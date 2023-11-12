/*-------------------------- */


// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_ing", function () {

    $("#mant_cantidad_ing").val("1"),
    $("#mant_fecha_ing").val($("#get_dia_actual").val()),
    $("#mant_proveedor_ing").val(""),
    $("#mant_descripcion_ing").val(""),

    $("#mant_id_ing").val("0"),
    $('#mant_producto_ing option:eq(0)').prop('selected', true)


    $("#mant_descripcion_ing").css("height", "5em");
    $("#modal_mantenimiento_ing").modal("show");

});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_ing", function () {

    $("#mant_cantidad_ing").val($(this).attr("data-ing_cantidad"));
    $("#mant_fecha_ing").val($(this).attr("data-ing_fecha"));
    $("#mant_proveedor_ing").val($(this).attr("data-ing_proveedor"));
    $("#mant_descripcion_ing").val($(this).attr("data-ing_descripcion"));
    $("#mant_producto_ing").val($(this).attr("data-ing_producto"));

    $("#mant_id_ing").val($(this).attr("data-ing_id"));

    $("#mant_descripcion_ing").css("height", "5em");
    $("#modal_mantenimiento_ing").modal("show");

});



// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_ing", function () {


    $("#del_mesaje_eliminar_ing").text("¿Estas seguro de eliminar el ingreso: " + $(this).attr("data-ing_fecha") + "?");

    $("#del_id_ing").val($(this).attr("data-ing_id"));

    $("#modal_eliminar_ing").modal("show");

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_ing", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/ingreso/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO

            ingreso_id: $("#del_id_ing").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_ing").modal("hide");
                ListarCategorias();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_ing", function () {
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/ingreso/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            ingreso_id: $("#mant_id_ing").val(),
            ingreso_cantidad: $("#mant_cantidad_ing").val(),
            ingreso_fecha: $("#mant_fecha_ing").val(),
            ingreso_proveedor: $("#mant_proveedor_ing").val(),
            ingreso_descripcion: $("#mant_descripcion_ing").val(),
            producto_id: $("#mant_producto_ing option:selected").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_ing").modal("hide");
                
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
        url: "/ingreso/listarIngresosJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_ingresos > tbody").html("");

            $.each(resultado, function (index, value) {



                //console.log(``);

                $("#tabla_ingresos > tbody").append(

                    `
                    <tr>
                        <td class="text-center">${value.ingreso_id}</td>
                        <td class="text-center">${value.ingreso_cantidad}</td>
                        <td class="text-center">${formatoDia(value.ingreso_fecha)}</td>
                        <td>${value.ingreso_proveedor}</td>
                        <td>${value.producto_id.producto_nombre}</td>

                        <td class="text-center">
                            <button type="button" class="btn btn-success btn_editar_ing"
                                data-ing_id="${value.ingreso_id}"
                                data-ing_cantidad="${value.ingreso_cantidad}"
                                data-ing_fecha="${formatoDia(value.ingreso_fecha)}"
                                data-ing_proveedor="${value.ingreso_proveedor}"
                                data-ing_descripcion="${value.ingreso_descripcion}"
                                data-ing_producto="${value.producto_id.producto_id}">
                                <i class="fa-solid fa-file-pen"></i>
                            </button>
                        </td>

                        <td class="text-center">
                            <button type="button" class="btn btn-danger btn_eliminar_ing"
                                data-ing_id="${value.ingreso_id}"
                                data-ing_fecha="${formatoDia(value.ingreso_fecha)}"
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
$(document).on("input", "#mant_cantidad_ing", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

    if (this.value < 1) {
        this.value = 1;
    }


})


