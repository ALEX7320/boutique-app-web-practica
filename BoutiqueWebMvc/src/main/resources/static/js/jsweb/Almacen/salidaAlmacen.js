
// INGRESO ----------- MODAL 1

// EDITAR - USUARIO
$(document).on("click", ".btn_salida_list", function () {


    // CARGAR TITULO ---------------
    $("#modal_salida_titulo").text($(this).attr("data-stk_nombre"));
    $("#modal_salida_mod_titulo").text($(this).attr("data-stk_nombre"));

    // CARGA DATOS ---------------
    $("#mant_stock_general").val($(this).attr("data-stk_id"));
    // CARGA LA TABLA DE MODAL
    ListarSalidaPorProducto($(this).attr("data-stk_id"))

    $("#modal_salida").modal("show");

});

// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_sal", function () {


    $("#mant_cantidad_sal").val("1"),
    $("#mant_fecha_sal").val($("#get_dia_actual").val()),
    $("#mant_descripcion_sal").val(""),

    $("#mant_id_sal").val("0"),
    $("#mant_producto_sal").val($("#mant_stock_general").val()),


    $("#mant_descripcion_sal").css("height", "5em");
    $("#modal_salida").modal("hide");
    $("#modal_salida_mod").modal("show");


});

// BTN RETROCESO
$(document).on("click", "#btn_atras_salida", function () {

    $("#modal_salida_mod").modal("hide");
    $("#modal_salida").modal("show");

});

// OBTENER TABLA HTML

function ListarSalidaPorProducto(llave) {


    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/almacen/listarSalidasJson_All",
        data: JSON.stringify({ // DEFINIR MODELO
            llave_id:llave//$("#mant_stock_general").val(),
        }),
        success: function (resultado) {

            $("#tabla_salidas_modal > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_salidas_modal > tbody").append(

                    `
                    <tr>
                        <td>${value.salida_id}</td>
                        <td>${value.salida_cantidad}</td>
                        <td>${formatoDia(value.salida_fecha)}</td>
                        <td>Salida registrada por almacen.</td>

                        <td class="text-center" style="min-width: 120px">

                            <button type="button" class="btn btn-success btn_editar_sal"
                                data-sal_id="${value.salida_id}"
                                data-sal_cantidad="${value.salida_cantidad}"
                                data-sal_fecha="${formatoDia(value.salida_fecha)}"
                                data-sal_descripcion="${value.salida_descripcion}"
                                data-sal_producto="${value.producto_id.producto_id}">
                                <i class="fa-solid fa-file-pen"></i> 
                            </button>

                            <button type="button" class="btn btn-danger btn_eliminar_sal" role="button"
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


// EDITAR CADA INGRESO BY ID ------------------------
$(document).on("click", ".btn_editar_sal", function () {

    ///

    $("#modal_salida").modal("hide");


    $("#mant_cantidad_sal").val($(this).attr("data-sal_cantidad"));
    $("#mant_fecha_sal").val($(this).attr("data-sal_fecha"));
    $("#mant_descripcion_sal").val($(this).attr("data-sal_descripcion"));
    $("#mant_producto_sal").val($(this).attr("data-sal_producto"));

    $("#mant_id_sal").val($(this).attr("data-sal_id"));


    $("#mant_descripcion_sal").css("height", "5em");
    $("#modal_salida_mod").modal("show");

});




// GUARDAR / ACTUALIZAR CREAR ------------------------------
$(document).on("click", "#btn_form_registrar_sal", function () {

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/salida/registrar",
        data: JSON.stringify({ // DEFINIR MODELO

            salida_id: $("#mant_id_sal").val(),
            salida_cantidad: $("#mant_cantidad_sal").val(),
            salida_fecha: $("#mant_fecha_sal").val(),
            salida_descripcion: $("#mant_descripcion_sal").val(),
            producto_id: $("#mant_producto_sal option:selected").val(),

        }),
        error: function(){
            alert("Error: ");
         },
        success: function (resultado) {
            if (resultado.respuesta) {
                alert(resultado.mensaje);
                $("#modal_salida_mod").modal("hide");
                ListarStock();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});




// ELIMINAR -------------
$(document).on("click", ".btn_eliminar_sal", function () {

    let seleccion = confirm('¿Estás seguro que deseas eliminar la salida?')
    if(!seleccion){
        return
    }

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/salida/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO
            salida_id: $(this).attr("data-sal_id")
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                $("#modal_salida").modal("hide");
                alert(resultado.mensaje);
                ListarStock();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// OBTENER TABLA HTML
function ListarStock() {

    $.ajax({
        type: "GET",
        url: "/almacen/listarStockJson",
        dataType: "json",
        success: function (resultado) {

            $("#tabla_stock_reporte > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_stock_reporte > tbody").append(
                    `
                    <tr>
                        <td>${value.stock_id}</td>
                        <td>${value.stock_nombre}</td>
                        <td>${value.stock_ingreso}</td>
                        <td>${value.stock_salida}</td>
                        <td>${value.stock_usado}</td>
                        <td>${value.stock_total}</td>

                        <td class="text-center">
                            <button type="button" class="btn btn-primary btn_salida_list"
                                data-stk_id="${value.stock_id}" 
                                data-stk_nombre="${value.stock_nombre}">
                                <i class="fa-solid fa-dolly"></i> SALIDA
                            </button>

                        </td>

                        <td class="text-center">
                            <button type="button" class="btn btn-secondary btn_ingreso_list"
                                data-stk_id="${value.stock_id}"
                                data-stk_nombre="${value.stock_nombre}">
                                <i class="fa-solid fa-box-open"></i> INGRESO
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
