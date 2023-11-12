// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_desc", function () {

    $("#mant_nombre_desc").val("");
    $("#mant_porcentaje_desc").val(0);
    $("#mant_estado_dsct").val("true");
    
    $("#mant_id_desc").val(0);

    $("#modal_mantenimiento_desc").modal("show");

});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_desc", function () {

    $("#mant_nombre_desc").val($(this).attr("data-desc_nombre"));
    $("#mant_porcentaje_desc").val($(this).attr("data-desc_porcentaje"));
    $("#mant_estado_dsct").val($(this).attr("data-desc_disponible"));

    $("#mant_id_desc").val($(this).attr("data-desc_id"));

    $("#modal_mantenimiento_desc").modal("show");

});



// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_desc", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/descuento/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            descuento_id: $("#mant_id_desc").val(),
            descuento_nombre: String($("#mant_nombre_desc").val()).trim(),
            descuento_procentaje: $("#mant_porcentaje_desc").val(),
            descuento_disponible: $("#mant_estado_dsct").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_desc").modal("hide");
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
        url: "/descuento/listarDescuentosJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_descuento > tbody").html("");

            $.each(resultado, function (index, value) {

                let estado = "NO DISPONIBLE"
                if(value.descuento_disponible) estado = "ACTIVO";

                $("#tabla_descuento > tbody").append(

                    `
                        <tr>
                            <td>${value.descuento_id}</td>
                            <td>${value.descuento_nombre}</td>
                            <td>${value.descuento_procentaje}%</td>
                            <td>${estado}</td>

                            <td class="text-center">
                                <button type="button" class="btn btn-success btn_editar_desc"
                                    data-desc_id="${value.descuento_id}"
                                    data-desc_nombre="${value.descuento_nombre}"
                                    data-desc_porcentaje="${value.descuento_procentaje}"
                                    data-desc_disponible="${value.descuento_disponible}"
                                    >
                                    <i class="fa-solid fa-file-pen"></i>
                                </button>
                            </td>

                        </tr>
                    
                    
                    `

                )

            });

        }


    })

}



// VALIDAR INGRESO NUMERO
$(document).on("input", "#mant_porcentaje_desc", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');


    if (this.value == "") {
        this.value = 0;
    }

    else if (this.value > 100) {
        this.value = 100;
    }


})