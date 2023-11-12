
// CONSULTA SOTCK
$(document).on("click", "#btn_consulta_stock", function () {


    $("#id_consulta_stock").val("0");
    $("#consulta_stock_sel").val("0");
    
    $("#card_stock_producto").html("");
    $("#modal_consulta_stock").modal("show");


});


$(document).on("click", "#btn_buscar_consulta_stock", function () {


    $.ajax({
        type: "DELETE",
        contentType: "application/json",
        url: "/venta/consultaStockJson_All",
        data: JSON.stringify({ // DEFINIR MODELO
            llave_id:  $("#consulta_stock_sel option:selected").val(),
        }),

        success: function (resultado) {

            $("#card_stock_producto").html("");

            $.each(resultado, function (index, value) {

                $("#card_stock_producto").append(

                    `
                    <div class="card mb-3">
                        <div class="row g-0" style="max-height:400px !important; overflow: show;">
                            <div class="col-md-6 color_con_card" >
                                <img  src="${value.stock_imagen}" class="img-fluid rounded-start"  style="height: 100%; object-fit: cover !important;"  alt="vestido">
                            </div>
                            <div class="col-md-6" style="border-left: 1px solid rgb(209, 209, 209) !important;">
                                <ul class="list-group list-group-flush">        
                                    <div class="list-group-item">
                                        <h6> <span class="badge bg-secondary">Nombre</span></h6>
                                        <p class="card-text">${value.stock_nombre}</p>
                                    </div>
                                    <div class="list-group-item">
                                        <h6> <span class="badge bg-secondary">Marca</span></h6>
                                        <p class="card-text">${value.stock_marca}</p>
                                    </div>
                                    <div class="list-group-item">
                                        <h6> <span class="badge bg-secondary">Tipo</span></h6>
                                        <p class="card-text">${value.stock_tipo_producto}</p>
                                    </div>
                                    <div class="list-group-item">
                                        <h6> <span class="badge bg-secondary">Precio</span></h6>
                                        <p class="card-text">S/ ${value.stock_precio}</p>
                                    </div>
                                    <div class="list-group-item">
                                        <h6> <span class="badge bg-secondary">Stock Disponible</span></h6>
                                        <p class="card-text">${value.stock_total}</p>
                                    </div>
                                </ul>
                            </div>
                        </div>
                    </div>
                
                    `
                )

            });

        }
    })

}

)
