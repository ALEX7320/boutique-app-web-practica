package boutique.com.model.body;

import java.util.Date;

public class IngresoBody {
	public Integer ingreso_id;
	public Integer ingreso_cantidad;
	public Date ingreso_fecha;
	public String ingreso_proveedor;
	public String ingreso_descripcion;
	public Integer producto_id;
	
	public IngresoBody(Integer ingreso_id, Integer ingreso_cantidad, Date ingreso_fecha, String ingreso_proveedor,
			String ingreso_descripcion, Integer producto_id) {
		super();
		this.ingreso_id = ingreso_id;
		this.ingreso_cantidad = ingreso_cantidad;
		this.ingreso_fecha = ingreso_fecha;
		this.ingreso_proveedor = ingreso_proveedor;
		this.ingreso_descripcion = ingreso_descripcion;
		this.producto_id = producto_id;
	}
}
