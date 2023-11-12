package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "producto")
public class Producto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer producto_id;
	
	@Column(name = "producto_nombre")
	private String producto_nombre;
	
	@Column(name = "producto_descripcion")
	private String producto_descripcion;
	
	@Column(name = "producto_estado")
	private Boolean producto_estado;
	
	@Column(name = "producto_precio")
	private Double producto_precio;
	
	//@Transient // para ignorar el campo
	@Column(name = "producto_imagen")
	private String producto_imagen;
		
	@OneToOne
	@JoinColumn(name="marca_id") // nombre de la fk en la bd
	private Marca marca_id;
	
	@OneToOne
	@JoinColumn(name="tipoproducto_id") // nombre de la fk en la bd
	private Tipoproducto tipoproducto_id;

	/*
    @JoinColumn(name = "marca", referencedColumnName = "marca_id")
    @ManyToOne(optional = false)
    private Marca marca_id;
    
    @JoinColumn(name = "tipoproducto", referencedColumnName = "tipoproducto_id")
    @ManyToOne(optional = false)
    private Tipoproducto tipoproducto_id ;
	
	*/
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer producto_id, String producto_nombre, String producto_descripcion, Boolean producto_estado,
			Double producto_precio, String producto_imagen, Marca marca_id, Tipoproducto tipoproducto_id) {
		super();
		this.producto_id = producto_id;
		this.producto_nombre = producto_nombre;
		this.producto_descripcion = producto_descripcion;
		this.producto_estado = producto_estado;
		this.producto_precio = producto_precio;
		this.producto_imagen = producto_imagen;
		this.marca_id = marca_id;
		this.tipoproducto_id = tipoproducto_id;
	}

	public Integer getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Integer producto_id) {
		this.producto_id = producto_id;
	}

	public String getProducto_nombre() {
		return producto_nombre;
	}

	public void setProducto_nombre(String producto_nombre) {
		this.producto_nombre = producto_nombre;
	}

	public String getProducto_descripcion() {
		return producto_descripcion;
	}

	public void setProducto_descripcion(String producto_descripcion) {
		this.producto_descripcion = producto_descripcion;
	}

	public Boolean getProducto_estado() {
		return producto_estado;
	}

	public void setProducto_estado(Boolean producto_estado) {
		this.producto_estado = producto_estado;
	}

	public Double getProducto_precio() {
		return producto_precio;
	}

	public void setProducto_precio(Double producto_precio) {
		this.producto_precio = producto_precio;
	}

	public String getProducto_imagen() {
		return producto_imagen;
	}

	public void setProducto_imagen(String producto_imagen) {
		this.producto_imagen = producto_imagen;
	}

	public Marca getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(Marca marca_id) {
		this.marca_id = marca_id;
	}

	public Tipoproducto getTipoproducto_id() {
		return tipoproducto_id;
	}

	public void setTipoproducto_id(Tipoproducto tipoproducto_id) {
		this.tipoproducto_id = tipoproducto_id;
	}
	
	
}
