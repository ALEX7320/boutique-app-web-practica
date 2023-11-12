// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_hor", function () {


    $("#mant_detalle_hor").css("height", "5em");

    $('#mant_empleado_hor option:eq(0)').prop('selected', true)
    $("#mant_fecha_hor").val("");
    $("#mant_inicio_hor").val("");
    $("#mant_final_hor").val("");
    $('#mant_tipo_hor option:eq(0)').prop('selected', true)
    $("#mant_detalle_hor").val("");

    $("#mant_id_hor").val("0");

    ActivarWidget("");

    $("#modal_mantenimiento_hor").modal("show");

});

// MODAL CARGAR - ALUMNO ------------------------
$(document).on("click", ".btn_editar_hor", function () {
    $("#mant_detalle_hor").css("height", "5em");

    $('#mant_empleado_hor').val($(this).attr("data-hor_empleado"));
    $("#mant_fecha_hor").val($(this).attr("data-hor_fecha"));
    $("#mant_inicio_hor").val($(this).attr("data-hor_inicio"));
    $("#mant_final_hor").val($(this).attr("data-hor_fin"));
    $('#mant_tipo_hor').val($(this).attr("data-hor_estado"));
    $("#mant_detalle_hor").val($(this).attr("data-hor_detalle"));

    $("#mant_id_hor").val($(this).attr("data-hor_id"));

    ActivarWidget("TODOS");

    $("#modal_mantenimiento_hor").modal("show");


});


function ActivarWidget(tipo) {

    if (tipo != "TODOS") {
        $('#mant_empleado_hor').prop("disabled", false);
        $("#mant_fecha_hor").prop("disabled", false);
        $("#mant_inicio_hor").prop("disabled", false);
        $("#mant_final_hor").prop("disabled", false);
        $('#mant_tipo_hor').prop("disabled", false);
        $("#mant_detalle_hor").prop("disabled", false);

    } else {
        $('#mant_empleado_hor').prop("disabled", true);
        $("#mant_fecha_hor").prop("disabled", true);
        $("#mant_inicio_hor").prop("disabled", true);
        $("#mant_final_hor").prop("disabled", true);
        $('#mant_tipo_hor').prop("disabled", false);
        $("#mant_detalle_hor").prop("disabled", false);
    }

}


// GUARDAR / ACTUALIZAR CREAR - USUARO ------------------------------
$(document).on("click", "#btn_form_registrar_hor", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/horario/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            horario_id: $("#mant_id_hor").val(),
            horario_fecha: $("#mant_fecha_hor").val(),
            horario_hora_inicio: $("#mant_inicio_hor").val(),
            horario_hora_fin: $("#mant_final_hor").val(),
            horario_detalle: $("#mant_detalle_hor").val(),
            estadolaboral_id: $("#mant_tipo_hor option:selected").val(),
            userid: $("#mant_empleado_hor option:selected").val()

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_mantenimiento_hor").modal("hide");
                ListarHorarios();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});



// MODAL ELIMINAR - ALUMNO
$(document).on("click", ".btn_eliminar_hor", function () {

    $("#del_mesaje_eliminar_hor").text(
                            "¿Estas seguro de eliminar el horario? " + 
                            "ID "+ $(this).attr("data-hor_id") +" | "+
                            "FECHA "+ $(this).attr("data-hor_fecha") +" | "+
                            "EMPLEADO "+ $(this).attr("data-hor_name")+" "+ $(this).attr("data-hor_lastname")
                            );

    $("#del_id_hor").val($(this).attr("data-hor_id"));

    $("#modal_eliminar_hor").modal("show");

});


// ELIMINAR - ALUMNO -------------
$(document).on("click", "#btn_form_eliminar_hor", function () {
    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/horario/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO

            horario_id: $("#del_id_hor").val(),

        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_eliminar_hor").modal("hide");
                ListarHorarios();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});



// OBTENER TABLA HTML
function ListarHorarios() {

    $.ajax({
        type: "GET",
        url: "/horario/listarHorariosJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_horarios > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_horarios > tbody").append(

                    `
                <tr>
                    <td>${formatoDia(value.horario_fecha)}</td>
                    <td>${value.name} ${value.lastname}</td>
                    <td>${value.horario_hora_inicio}</td>
                    <td>${value.horario_hora_fin}</td>
                    <td>${value.diferencia}</td>
                    <td>${value.estadolaboral_nombre}</td>
                    <td class="text-center">
                        <button type="button" class="btn btn-danger btn_eliminar_hor"                           
                            data-hor_id="${value.horario_id}"
                            data-hor_fecha="${formatoDia(value.horario_fecha)}"
                            data-hor_name="${value.name}"
                            data-hor_lastname="${value.lastname}"

                            >
                            <i class="fa-solid fa-trash-can"></i>
                        </button>
                    </td>

                    <td class="text-center">
                        <button type="button" class="btn btn-success btn_editar_hor"
                            data-hor_id="${value.horario_id}" 
                            data-hor_fecha="${formatoDia(value.horario_fecha)}"
                            data-hor_inicio="${value.horario_hora_inicio}"
                            data-hor_fin="${value.horario_hora_fin}"
                            data-hor_detalle="${value.horario_detalle}"
                            data-hor_estado="${value.estadolaboral_id}"
                            data-hor_empleado="${value.userid}"
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
function formatoDia(fecha){
    //yyyy-MM-dd
    let d = new Date(fecha);              
    let ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d);
    let mo = new Intl.DateTimeFormat('en', { month: '2-digit' }).format(d);
    let da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d);

    return `${ye}-${mo}-${da}`
}