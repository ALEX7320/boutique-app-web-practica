
// INGRESO ----------- MODAL 1

// EDITAR - USUARIO OK 
$(document).on("click", ".btn_ingreso_list", function () {


    // CARGAR TITULO ---------------
    $("#modal_ingreso_titulo").text($(this).attr("data-stk_nombre"));
    $("#modal_ingreso_mod_titulo").text($(this).attr("data-stk_nombre"));

    // CARGA DATOS ---------------
    $("#mant_stock_general").val($(this).attr("data-stk_id"));
    // CARGA LA TABLA DE MODAL
    ListarIngresoPorProducto($(this).attr("data-stk_id"))


    $("#modal_ingreso").modal("show");

});

// MODAL CREAR - USUARIO
$(document).on("click", "#btn_agregar_ing", function () {

    $("#mant_cantidad_ing").val("1"),
    $("#mant_fecha_ing").val($("#get_dia_actual").val()),
    $("#mant_proveedor_ing").val(""),
    $("#mant_descripcion_ing").val(""),

    $("#mant_id_ing").val("0"),
    $("#mant_producto_ing").val($("#mant_stock_general").val()),


    $("#mant_descripcion_ing").css("height", "5em");
    $("#modal_ingreso").modal("hide");
    $("#modal_ingreso_mod").modal("show");

});

// BTN RETROCESO
$(document).on("click", "#btn_atras_ingreso", function () {

    $("#modal_ingreso_mod").modal("hide");
    $("#modal_ingreso").modal("show");

});

// OBTENER TABLA HTML

function ListarIngresoPorProducto(llave) {


    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/almacen/listarIngresosJsonAll",
        data: JSON.stringify({ // DEFINIR MODELO
            llave_id:llave//$("#mant_stock_general").val(),
        }),
        success: function (resultado) {

            console.log("resultado")

            console.log(resultado)

            $("#tabla_ingresos_modal > tbody").html("");

            $.each(resultado, function (index, value) {

                $("#tabla_ingresos_modal > tbody").append(

                    `
                    <tr>
                        <td>${value.ingreso_id}</td>
                        <td>${value.ingreso_cantidad}</td>
                        <td>${formatoDia(value.ingreso_fecha)}</td>
                        <td>${value.ingreso_proveedor}</td>

                        <td class="text-center" style="min-width: 120px">

                            <button type="button" class="btn btn-success btn_editar_ing"
                                data-ing_id="${value.ingreso_id}"
                                data-ing_cantidad="${value.ingreso_cantidad}"
                                data-ing_fecha="${formatoDia(value.ingreso_fecha)}"
                                data-ing_proveedor="${value.ingreso_proveedor}"
                                data-ing_descripcion="${value.ingreso_descripcion}"
                                data-ing_producto="${value.producto_id.producto_id}">
                                <i class="fa-solid fa-file-pen"></i> 
                            </button>

                            <button type="button" class="btn btn-danger btn_eliminar_ing" role="button"
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

// EDITAR CADA INGRESO BY ID ------------------------
$(document).on("click", ".btn_editar_ing", function () {

    $("#modal_ingreso").modal("hide");

    $("#mant_cantidad_ing").val($(this).attr("data-ing_cantidad"));
    $("#mant_fecha_ing").val($(this).attr("data-ing_fecha"));
    $("#mant_proveedor_ing").val($(this).attr("data-ing_proveedor"));
    $("#mant_descripcion_ing").val($(this).attr("data-ing_descripcion"));
    $("#mant_producto_ing").val($(this).attr("data-ing_producto"));

    $("#mant_id_ing").val($(this).attr("data-ing_id"));


    $("#mant_descripcion_ing").css("height", "5em");
    $("#modal_ingreso_mod").modal("show");

});


// GUARDAR / ACTUALIZAR CREAR ------------------------------
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
                $("#modal_ingreso_mod").modal("hide");
                ListarStock();
            } else {
                alert(resultado.mensaje);
            }
        }
    });

});


// ELIMINAR -------------
$(document).on("click", ".btn_eliminar_ing", function () {

    let seleccion = confirm('¿Estás seguro que deseas eliminar el ingreso?')
    if(!seleccion){
        return
    }

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/ingreso/eliminar",
        data: JSON.stringify({ // DEFINIR MODELO
            ingreso_id: $(this).attr("data-ing_id")
        }),
        success: function (resultado) {
            if (resultado.respuesta) {
                $("#modal_ingreso").modal("hide");
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
                            <button type="button" class="btn btn-success btn_editar_prod">
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
$(document).on("input", "#mant_cantidad_ing", function () {

    // validacion de numero
    this.value = this.value.replace(/[^0-9]/g, '');

    
    if (this.value < 1) {
        this.value = 1;
    }

})