// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_prod", function () {


    $("#mant_nombre_prod").val("");
    $("#mant_imagen_prod").val($("#imagen_por_defecto").val());
    $("#mant_descripcion_prod").val("");
    $("#mant_precio_prod").val("1");
    
    $('#mant_tipo_prod option:eq(0)').prop('selected', true)
    $('#mant_marca_prod option:eq(0)').prop('selected', true)

    $("#mant_id_prod").val("0");
    $("#mant_estado_prod").val(true);

    $("#mant_descripcion_prod").css("height", "5em");
    $("#modal_mantenimiento_prod").modal("show");


});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_prod", function () {


    $("#mant_nombre_prod").val($(this).attr("data-prod_nombre"));
    $("#mant_imagen_prod").val($(this).attr("data-prod_imagen"));
    $("#mant_descripcion_prod").val($(this).attr("data-prod_descripcion"));
    $("#mant_precio_prod").val($(this).attr("data-prod_precio"));
    $("#mant_tipo_prod").val($(this).attr("data-prod_tipoproducto"));
    $("#mant_marca_prod").val($(this).attr("data-prod_marca"));


    $("#mant_id_prod").val($(this).attr("data-prod_id"));
    $("#mant_estado_prod").val($(this).attr("data-prod_estado"));

    $("#mant_descripcion_prod").css("height", "5em");
    $("#modal_mantenimiento_prod").modal("show");

});



// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_prod", function () {


    $("#del_mesaje_eliminar_prod").text("¿Estas seguro de eliminar el producto: " + $(this).attr("data-prod_nombre") + "?");

    $("#del_id_prod").val($(this).attr("data-prod_id"));

    $("#modal_eliminar_prod").modal("show");

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_prod", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/producto/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO

            producto_id: $("#del_id_prod").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_prod").modal("hide");
                ListarCategorias();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_prod", function () {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/producto/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            producto_id: $("#mant_id_prod").val(),
            producto_nombre: String($("#mant_nombre_prod").val()).trim(),
            producto_descripcion: String($("#mant_descripcion_prod").val()).trim(),
            producto_estado: $("#mant_estado_prod").val(),
            producto_precio: $("#mant_precio_prod").val(),
            producto_imagen: String($("#mant_imagen_prod").val()).trim(),
            marca_id: $("#mant_marca_prod option:selected").val(),
            tipoproducto_id: $("#mant_tipo_prod option:selected").val()

        }),

        error: function () {
            alert("errorrrrrr")
          },
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_prod").modal("hide");
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
        url: "/producto/listarProductosJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_productos > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_productos > tbody").append(

                    `<tr>
                        <td class="text-center">${value.producto_id}</td>
                        <td>${value.producto_nombre}</td>
                        <td class="text-center">S/ ${value.producto_precio}</td>

                        <td>${value.marca_id.marca_nombre}</td>
                        <td>${value.tipoproducto_id.tipoproducto_nombre}</td>

                        <td class="text-center">
                            <button type="button" class="btn btn-success btn_editar_prod"
                                data-prod_id="${value.producto_id}"
                                data-prod_nombre="${value.producto_nombre}"
                                data-prod_imagen="${value.producto_imagen}"
                                data-prod_descripcion="${value.producto_descripcion}"
                                data-prod_estado="${value.producto_estado}"
                                data-prod_precio="${value.producto_precio}"
                                data-prod_marca="${value.marca_id.marca_id}"
                                data-prod_tipoproducto="${value.tipoproducto_id.tipoproducto_id}">
                                <i class="fa-solid fa-file-pen"></i>
                            </button>


                        </td>

						<td class="text-center">
						
						    <button type="button" class="btn btn-danger btn_eliminar_prod"
						        data-prod_id="${value.producto_id}"
						        data-prod_nombre="${value.producto_nombre}">
						        <i class="fa-solid fa-trash-can"></i>
						    </button>
						</td>                   
                    </tr>`

                )

            });

        }


    })

}




// VALIDAR INGRESO NUMERO
$(document).on("input", "#mant_precio_prod", function () {

    // validacion de numero
    if (this.value < 1) {
        this.value = 1;
    }


})