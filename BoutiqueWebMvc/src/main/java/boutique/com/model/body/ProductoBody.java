package boutique.com.model.body;


public class ProductoBody {

	public Integer producto_id;
	public String producto_nombre;
	public String producto_descripcion;
	public Boolean producto_estado;
	public Double producto_precio;
	public String producto_imagen;
	public Integer marca_id;
	public Integer tipoproducto_id;
	
	public ProductoBody(Integer producto_id, String producto_nombre, String producto_descripcion,
			Boolean producto_estado, Double producto_precio, String producto_imagen, Integer marca_id,
			Integer tipoproducto_id) {
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

	
	
}
