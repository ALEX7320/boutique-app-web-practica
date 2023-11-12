package boutique.com.model.body;

import java.util.Date;

public class VentaBody {
	public Integer venta_id;
	public Date venta_fecha;
	public String venta_descripcion;
	public Double venta_igv;
	public Boolean venta_estado;
	public Integer tipopago_id;
	public Integer cliente_id;
	public Integer comprobante_id;
	
	public VentaBody(Integer venta_id, Date venta_fecha, String venta_descripcion, Double venta_igv,
			Boolean venta_estado, Integer tipopago_id, Integer cliente_id, Integer comprobante_id) {
		super();
		this.venta_id = venta_id;
		this.venta_fecha = venta_fecha;
		this.venta_descripcion = venta_descripcion;
		this.venta_igv = venta_igv;
		this.venta_estado = venta_estado;
		this.tipopago_id = tipopago_id;
		this.cliente_id = cliente_id;
		this.comprobante_id = comprobante_id;
	}	
}
