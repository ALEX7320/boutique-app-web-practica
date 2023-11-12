package boutique.com.model.bd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "salida")
public class Salida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer salida_id;
	
	@Column(name = "salida_cantidad")
	private Integer salida_cantidad;
	
	@Column(name = "salida_fecha")
	private Date salida_fecha;
	
	@Column(name = "salida_descripcion")
	private String salida_descripcion;
	
	@OneToOne
	@JoinColumn(name="producto_id") // nombre de la fk en la bd
	private Producto producto_id;

	public Salida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salida(Integer salida_id, Integer salida_cantidad, Date salida_fecha, String salida_descripcion,
			Producto producto_id) {
		super();
		this.salida_id = salida_id;
		this.salida_cantidad = salida_cantidad;
		this.salida_fecha = salida_fecha;
		this.salida_descripcion = salida_descripcion;
		this.producto_id = producto_id;
	}

	public Integer getSalida_id() {
		return salida_id;
	}

	public void setSalida_id(Integer salida_id) {
		this.salida_id = salida_id;
	}

	public Integer getSalida_cantidad() {
		return salida_cantidad;
	}

	public void setSalida_cantidad(Integer salida_cantidad) {
		this.salida_cantidad = salida_cantidad;
	}

	public Date getSalida_fecha() {
		return salida_fecha;
	}

	public void setSalida_fecha(Date salida_fecha) {
		this.salida_fecha = salida_fecha;
	}

	public String getSalida_descripcion() {
		return salida_descripcion;
	}

	public void setSalida_descripcion(String salida_descripcion) {
		this.salida_descripcion = salida_descripcion;
	}

	public Producto getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Producto producto_id) {
		this.producto_id = producto_id;
	}


	
}
