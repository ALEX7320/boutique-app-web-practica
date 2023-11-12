// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_cli", function () {

    $("#mant_dni_cli").prop("disabled", false);


    $("#mant_nombre_cli").val("");
    $("#mant_apellido_cli").val("");
    $("#mant_dni_cli").val("");
    $("#mant_celular_cli").val("");

    $("#mant_id_cli").val("0");

    $("#modal_mantenimiento_cli").modal("show");


});

// MODAL ELIMINAR - CLIENTE
$(document).on("click", ".btn_eliminar_cli", function () {


    $("#del_mesaje_eliminar_cli").text("¿Estas seguro de eliminar el cliente: " + $(this).attr("data-cli_nombre") +" "+ $(this).attr("data-cli_apellido") + "?");

    $("#del_id_cli").val($(this).attr("data-cli_id"));

    $("#modal_eliminar_cli").modal("show");

});


// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_cli", function () {

    $("#mant_dni_cli").prop("disabled", true);

    $("#mant_nombre_cli").val($(this).attr("data-cli_nombre"));
    $("#mant_apellido_cli").val($(this).attr("data-cli_apellido"));
    $("#mant_dni_cli").val($(this).attr("data-cli_dni"));
    $("#mant_celular_cli").val($(this).attr("data-cli_celular"));

    $("#mant_id_cli").val($(this).attr("data-cli_id"));

    $("#modal_mantenimiento_cli").modal("show");

});



// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_cli", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/cliente/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            cliente_id: $("#mant_id_cli").val(),
            cliente_nombre: String($("#mant_nombre_cli").val()).trim(),
            cliente_apellido: String($("#mant_apellido_cli").val()).trim(),
            cliente_dni: String($("#mant_dni_cli").val()).trim(),
            cliente_celular: String($("#mant_celular_cli").val()).trim(),
            cliente_estado: true,

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_cli").modal("hide");
                ListarClientes();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});



// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_cli", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/cliente/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO

            cliente_id: $("#del_id_cli").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_cli").modal("hide");
                ListarClientes();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});



// OBTENER TABLA HTML
function ListarClientes() {

    $.ajax({
        type: "GET",
        url: "/cliente/listarClientesJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_clientes > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_clientes > tbody").append(

                    `<tr>
                        <td>${value.cliente_id}</td>
                        <td>${value.cliente_nombre}</td>
                        <td>${value.cliente_apellido}</td>
                        <td>${value.cliente_dni}</td>
                        <td>${value.cliente_celular}</td>

                        <td class="text-center">
                            <button type="button" class="btn btn-success btn_editar_cli"
                                data-cli_id="${value.cliente_id}"
                                data-cli_nombre="${value.cliente_nombre}"
                                data-cli_apellido="${value.cliente_apellido}"
                                data-cli_dni="${value.cliente_dni}"
                                data-cli_celular="${value.cliente_celular}"
                                >
                                <i class="fa-solid fa-file-pen"></i>
                            </button>
                        </td>

                        <td class="text-center">

                            <button type="button" class="btn btn-danger btn_eliminar_cli"
                                data-cli_id="${value.cliente_id}"
                                data-cli_nombre="${value.cliente_nombre}"
                                data-cli_apellido="${value.cliente_apellido}"
                                >
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
$(document).on("input", "#mant_dni_cli,#mant_celular_cli", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

})