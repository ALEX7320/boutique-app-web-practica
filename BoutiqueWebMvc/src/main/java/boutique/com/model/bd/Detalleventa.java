package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleventa")
public class Detalleventa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer detalleventa_id;
	
	@Column(name = "detalleventa_cantidad")
	private Integer detalleventa_cantidad;
	
	// SIMPLES
	
	@OneToOne
	@JoinColumn(name="producto_id") // nombre de la fk en la bd
	private Producto producto_id;
	
	@OneToOne
	@JoinColumn(name="descuento_id") // nombre de la fk en la bd
	private Descuento descuento_id;

	//@Transient // para ignorar el campo
	@ManyToOne
	@JoinColumn(name="venta_id")
	private Venta venta_id;

	public Detalleventa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detalleventa(Integer detalleventa_id, Integer detalleventa_cantidad, Producto producto_id,
			Descuento descuento_id, Venta venta_id) {
		super();
		this.detalleventa_id = detalleventa_id;
		this.detalleventa_cantidad = detalleventa_cantidad;
		this.producto_id = producto_id;
		this.descuento_id = descuento_id;
		this.venta_id = venta_id;
	}

	public Integer getDetalleventa_id() {
		return detalleventa_id;
	}

	public void setDetalleventa_id(Integer detalleventa_id) {
		this.detalleventa_id = detalleventa_id;
	}

	public Integer getDetalleventa_cantidad() {
		return detalleventa_cantidad;
	}

	public void setDetalleventa_cantidad(Integer detalleventa_cantidad) {
		this.detalleventa_cantidad = detalleventa_cantidad;
	}

	public Producto getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Producto producto_id) {
		this.producto_id = producto_id;
	}

	public Descuento getDescuento_id() {
		return descuento_id;
	}

	public void setDescuento_id(Descuento descuento_id) {
		this.descuento_id = descuento_id;
	}

	public Venta getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Venta venta_id) {
		this.venta_id = venta_id;
	}
	
	
}
