package boutique.com.model.body;

import java.util.Date;

public class SalidaBody {

	public Integer salida_id;
	public Integer salida_cantidad;
	public Date salida_fecha;
	public String salida_descripcion;
	public Integer producto_id;

	public SalidaBody(Integer salida_id, Integer salida_cantidad, Date salida_fecha, String salida_descripcion,
			Integer producto_id) {
		super();
		this.salida_id = salida_id;
		this.salida_cantidad = salida_cantidad;
		this.salida_fecha = salida_fecha;
		this.salida_descripcion = salida_descripcion;
		this.producto_id = producto_id;
	}
}
