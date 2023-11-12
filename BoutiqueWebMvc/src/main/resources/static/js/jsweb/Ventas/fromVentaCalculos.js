
// CALCULAR POR PRECIO
let v_precio = 0;
let v_cantidad = 0;
let v_descuento = 0;
let v_igv = 0;

let v_total = 0;


// ETIEUTAS
let id_precio = null;
let id_precio_igv = null
let id_precio_descuento = null
let id_precio_total = null
let id_total = null;

// TOTAL

function set_variables_price(param_precio, param_cantidad, param_descuento, param_igv) {
    v_precio = parseFloat(param_precio);
    v_cantidad = parseInt(param_cantidad);
    v_descuento = parseFloat(param_descuento);
    v_igv = parseFloat(param_igv);
}

function set_variables_tag(param_tag_id) {
    id_precio = "#id_precio_" + param_tag_id;
    id_precio_igv = "#id_precio_igv_" + param_tag_id;
    id_precio_descuento = "#id_precio_descuento_" + param_tag_id;
    id_precio_total = "#id_precio_total_" + param_tag_id;
}


function calcular_total_tabla() {


    let f_descuento = v_descuento / 100;

    let f_precio = v_precio; // precio sin igv cu
    let f_precio_con_igv = f_precio + (f_precio * v_igv); // PRECIO CON IGV

    let f_precio_del_descuento = f_precio_con_igv * f_descuento; // PRECIO DEL DSC CON IGV
    let f_precio_con_descuento = f_precio_con_igv - f_precio_del_descuento; // PRECIO DEL DSC CON IGV

    let f_precio_x_cantidad = f_precio_con_descuento * v_cantidad;

    $(id_precio).text("S/ " + roundDos(f_precio));
    $(id_precio_igv).text("S/ " + roundDos(f_precio_con_igv));
    $(id_precio_total).text("S/ " + roundDos(f_precio_x_cantidad));


    if (v_descuento == 0) {

        $(id_precio_descuento).text("S/ " + roundDos(f_precio_con_descuento));

    }
    else {
        $(id_precio_descuento).html("");
        $(id_precio_descuento).html("").append(
            `S/ ${roundDos(f_precio_con_descuento)} <span class="badge rounded-pill bg-success">-${v_descuento}%</span>`)
    }

    // SUMAR EL TOTAL
    v_total = v_total + f_precio_x_cantidad;
    v_total = roundDos(v_total);
}

// FUNCIONALIDADES

function calcular_set_zero() {

    v_precio = 0;
    v_cantidad = 0;
    v_descuento = 0;
    v_igv = 0;
    v_total = 0;

    id_precio = null;
    id_precio_igv = null
    id_precio_descuento = null
    id_precio_total = null
}



function calcular_totales_ret(id_objeto) {

    $("#ID_REGISTRO_" + id_objeto).text("S/ " + v_total);
}

function roundDos(decimal){
    return Number((decimal).toFixed(2));
}