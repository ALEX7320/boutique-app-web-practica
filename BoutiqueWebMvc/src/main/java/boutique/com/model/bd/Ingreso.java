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
@Table(name = "ingreso")
public class Ingreso {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ingreso_id;
	
	@Column(name = "ingreso_cantidad")
	private Integer ingreso_cantidad;
	
	@Column(name = "ingreso_fecha")
	//@JsonFormat(pattern="yyyy-MM-dd")
	private Date ingreso_fecha;
	
	@Column(name = "ingreso_proveedor")
	private String ingreso_proveedor;
	
	@Column(name = "ingreso_descripcion")
	private String ingreso_descripcion;
	
	@OneToOne
	@JoinColumn(name="producto_id") // nombre de la fk en la bd
	private Producto producto_id;

	public Ingreso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingreso(Integer ingreso_id, Integer ingreso_cantidad, Date ingreso_fecha, String ingreso_proveedor,
			String ingreso_descripcion, Producto producto_id) {
		super();
		this.ingreso_id = ingreso_id;
		this.ingreso_cantidad = ingreso_cantidad;
		this.ingreso_fecha = ingreso_fecha;
		this.ingreso_proveedor = ingreso_proveedor;
		this.ingreso_descripcion = ingreso_descripcion;
		this.producto_id = producto_id;
	}

	public Integer getIngreso_id() {
		return ingreso_id;
	}

	public void setIngreso_id(Integer ingreso_id) {
		this.ingreso_id = ingreso_id;
	}

	public Integer getIngreso_cantidad() {
		return ingreso_cantidad;
	}

	public void setIngreso_cantidad(Integer ingreso_cantidad) {
		this.ingreso_cantidad = ingreso_cantidad;
	}

	public Date getIngreso_fecha() {
		return ingreso_fecha;
	}

	public void setIngreso_fecha(Date ingreso_fecha) {
		this.ingreso_fecha = ingreso_fecha;
	}

	public String getIngreso_proveedor() {
		return ingreso_proveedor;
	}

	public void setIngreso_proveedor(String ingreso_proveedor) {
		this.ingreso_proveedor = ingreso_proveedor;
	}

	public String getIngreso_descripcion() {
		return ingreso_descripcion;
	}

	public void setIngreso_descripcion(String ingreso_descripcion) {
		this.ingreso_descripcion = ingreso_descripcion;
	}

	public Producto getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Producto producto_id) {
		this.producto_id = producto_id;
	}



	
}
