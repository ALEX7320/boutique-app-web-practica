package boutique.com.model.body;

public class DetalleventaBody {

	public Integer detalleventa_id;
	public Integer detalleventa_cantidad;
	public Integer producto_id;
	public Integer descuento_id;
	public Integer venta_id;
		
	public DetalleventaBody(Integer detalleventa_id, Integer detalleventa_cantidad, Integer producto_id,
			Integer descuento_id, Integer venta_id) {
		super();
		this.detalleventa_id = detalleventa_id;
		this.detalleventa_cantidad = detalleventa_cantidad;
		this.producto_id = producto_id;
		this.descuento_id = descuento_id;
		this.venta_id = venta_id;
	}

	
}
