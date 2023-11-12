package boutique.com.model.sp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

// NO SE HA CONTEMPLADO CONSTRUCTORES
@Entity
public class VentaProductoFechaSp {

	@Id
	private Integer reporte_detalleventa_id;
	private String producto_nombre;
    private String marca_nombre;
    private String tipoproducto_nombre;

    private String cliente_nombre;
    private String cliente_apellido;
    private String cliente_dni;

    private Double venta_igv;
    private Double producto_precio;
    private Double descuento_procentaje;
    private Integer detalleventa_cantidad;

    private Date venta_fecha;
    private String producto_imagen;
    
    private String var_fecha_inicio;
    private String var_fecha_fin;
	public Integer getReporte_detalleventa_id() {
		return reporte_detalleventa_id;
	}
	public void setReporte_detalleventa_id(Integer reporte_detalleventa_id) {
		this.reporte_detalleventa_id = reporte_detalleventa_id;
	}
	public String getProducto_nombre() {
		return producto_nombre;
	}
	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}
	public String getMarca_nombre() {
		return marca_nombre;
	}
	public void setMarca_nombre(String marca_nombre) {
		this.marca_nombre = marca_nombre;
	}
	public String getTipoproducto_nombre() {
		return tipoproducto_nombre;
	}
	public void setTipoproducto_nombre(String tipoproducto_nombre) {
		this.tipoproducto_nombre = tipoproducto_nombre;
	}
	public String getCliente_nombre() {
		return cliente_nombre;
	}
	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}
	public String getCliente_apellido() {
		return cliente_apellido;
	}
	public void setCliente_apellido(String cliente_apellido) {
		this.cliente_apellido = cliente_apellido;
	}
	public String getCliente_dni() {
		return cliente_dni;
	}
	public void setCliente_dni(String cliente_dni) {
		this.cliente_dni = cliente_dni;
	}
	public Double getVenta_igv() {
		return venta_igv;
	}
	public void setVenta_igv(Double venta_igv) {
		this.venta_igv = venta_igv;
	}
	public Double getProducto_precio() {
		return producto_precio;
	}
	public void setProducto_precio(Double producto_precio) {
		this.producto_precio = producto_precio;
	}
	public Double getDescuento_procentaje() {
		return descuento_procentaje;
	}
	public void setDescuento_procentaje(Double descuento_procentaje) {
		this.descuento_procentaje = descuento_procentaje;
	}
	public Integer getDetalleventa_cantidad() {
		return detalleventa_cantidad;
	}
	public void setDetalleventa_cantidad(Integer detalleventa_cantidad) {
		this.detalleventa_cantidad = detalleventa_cantidad;
	}
	public Date getVenta_fecha() {
		return venta_fecha;
	}
	public void setVenta_fecha(Date venta_fecha) {
		this.venta_fecha = venta_fecha;
	}
	public String getProducto_imagen() {
		return producto_imagen;
	}
	public void setProducto_imagen(String producto_imagen) {
		this.producto_imagen = producto_imagen;
	}
	public String getVar_fecha_inicio() {
		return var_fecha_inicio;
	}
	public void setVar_fecha_inicio(String var_fecha_inicio) {
		this.var_fecha_inicio = var_fecha_inicio;
	}
	public String getVar_fecha_fin() {
		return var_fecha_fin;
	}
	public void setVar_fecha_fin(String var_fecha_fin) {
		this.var_fecha_fin = var_fecha_fin;
	}

    
    
}
