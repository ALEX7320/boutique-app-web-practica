// AL CARGAR LA PAGINA
$(document).ready(function () {

    $('#select_producto_rep option:eq(0)').prop('selected', true);
    $("#contenedor_resultado").hide();
   // $("#fecha_inicio_rep").val("2022-08-01");
    // $("#fecha_fin_rep").val("2022-08-06");
})


// MODAL CREAR - USUARIO
$(document).on("click", "#btn_borrar_rep", function () {

    $("#contenedor_resultado").hide();

    $("#tabla_ventas_reporte > tbody").html("");

    
    $('#select_producto_rep option:eq(0)').prop('selected', true)
    $("#fecha_inicio_rep").val("");
    $("#fecha_fin_rep").val("");
    


    /*
    $.ajax({
        type: "GET",
        url: "/reporte/limpiarListaJson",
        dataType: "json",
        success: function (resultado) {
            alert("sds - "+resultado.mensaje);
        },
        error: function () {
            alert("sds - ERRO");
          },
    })
*/


});


// MODAL CREAR - USUARIO
$(document).on("click", "#btn_generar_rep", function () {
        
    ListarSalidaPorProducto();
    
});

// OBTENER TABLA HTML

function ListarSalidaPorProducto() {


    $("#titulo_prod").html("");
    $("#marca_prod").html("");
    $("#date_prod").html("");


    let val_id_reporte= $("#select_producto_rep option:selected").val();
    let val_fecha_inicio_reporte= $("#fecha_inicio_rep").val();
    let val_fecha_fin_reporte= $("#fecha_fin_rep").val();

    let mensaje = "";

    if(val_id_reporte==-1){
        mensaje+="- Producto\n";	
    }
    if(val_fecha_inicio_reporte==""){
        mensaje+="- Fecha Inicio\n";	

    }
    if(val_fecha_fin_reporte==""){
        mensaje+="- Fecha Final\n";	
    }

    if(!mensaje==""){
        mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;

        alert(mensaje);
        return;
    }

    
    
    // SET TITULO
    $("#titulo_prod").append($("#select_producto_rep option:selected").text())
    $("#marca_prod").append(`<i class="fa-solid fa-box"></i>`+" Producto seleccionado")
    $("#date_prod").append("Fecha desde "+val_fecha_inicio_reporte+" hasta " +val_fecha_fin_reporte)

    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/reporte/listarReporteVentasJson",
        data: JSON.stringify({ // DEFINIR MODELO
            id_reporte: $("#select_producto_rep option:selected").val(),
            fecha_inicio_reporte: $("#fecha_inicio_rep").val(),
            fecha_fin_reporte: $("#fecha_fin_rep").val(),
        }),
        success: function (resultado) {

            

            $("#tabla_ventas_reporte > tbody").html("");

            if(resultado==""){
                $("#contenedor_resultado").hide();
                alert("No se encontraron resultados.")
                return null;
            }else{
                $("#contenedor_resultado").show();
            }
           

            $.each(resultado, function (index, value) {


                $("#descripcion_prod").text(value.marca_nombre+" - "+value.tipoproducto_nombre)


                // ESTABLECE VARIABLES
                let v_precio = value.producto_precio;
                let v_cantidad = value.detalleventa_cantidad;
                let v_descuento = value.descuento_procentaje;
                let v_igv = value.venta_igv;

                let v_total = 0;

                // CALCULOS
                let f_descuento = v_descuento / 100;

                let f_precio = v_precio; // precio sin igv cu
                let f_precio_con_igv = f_precio + (f_precio * v_igv); // PRECIO CON IGV

                let f_precio_del_descuento = f_precio_con_igv * f_descuento; // PRECIO DEL DSC CON IGV
                let f_precio_con_descuento = f_precio_con_igv - f_precio_del_descuento; // PRECIO DEL DSC CON IGV

                let f_precio_x_cantidad = f_precio_con_descuento * v_cantidad;

                
                if (v_descuento == 0) {
                    f_precio_con_descuento_html = `${roundDos(f_precio_con_descuento)}`
                }
                else {
                    f_precio_con_descuento_html = `${roundDos(f_precio_con_descuento)} <span class="badge rounded-pill bg-success">-${v_descuento}%</span>`
                }


                // SUMAR EL TOTAL
                v_total = v_total + f_precio_x_cantidad;
                v_total=roundDos(v_total);

                $("#tabla_ventas_reporte > tbody").append(

                    `
                <tr>
                    <td>${value.reporte_detalleventa_id}</td>
                    <td>${value.cliente_nombre} ${value.cliente_apellido}</td>
                    <td>${value.cliente_dni}</td>

                    <td>S/ ${f_precio}</td>
                    <td>S/ ${roundDos(f_precio_con_igv)}</td>
                    <td>S/ ${f_precio_con_descuento_html}</td>
                    <td>${v_cantidad}</td>
                    <td>S/ ${roundDos(f_precio_x_cantidad)}</td>

                </tr>
                    `
                )

            });


       
        }

    })

}
/*

// MODAL CREAR - USUARIO
$(document).on("click", "#btn_generar_pdf", function () {

    GenerarPdfReporteVentas();
});
*/


function formatoDia(fecha){
    //yyyy-MM-dd
    let d = new Date(fecha);              
    let ye = new Intl.DateTimeFormat('en', { year: 'numeric' }).format(d);
    let mo = new Intl.DateTimeFormat('en', { month: '2-digit' }).format(d);
    let da = new Intl.DateTimeFormat('en', { day: '2-digit' }).format(d);

    return `${ye}-${mo}-${da}`
}

function roundDos(decimal){
    return Number((decimal).toFixed(2));
}