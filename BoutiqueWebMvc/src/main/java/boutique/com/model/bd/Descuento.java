package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "descuento")
public class Descuento {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer descuento_id;
	
	@Column(name = "descuento_nombre")
	private String descuento_nombre;
	
	@Column(name = "descuento_procentaje")
	private Integer descuento_procentaje;
	
	@Column(name = "descuento_disponible")
	private Boolean descuento_disponible;

	public Descuento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Descuento(Integer descuento_id, String descuento_nombre, Integer descuento_procentaje,
			Boolean descuento_disponible) {
		super();
		this.descuento_id = descuento_id;
		this.descuento_nombre = descuento_nombre;
		this.descuento_procentaje = descuento_procentaje;
		this.descuento_disponible = descuento_disponible;
	}

	public Integer getDescuento_id() {
		return descuento_id;
	}

	public void setDescuento_id(Integer descuento_id) {
		this.descuento_id = descuento_id;
	}

	public String getDescuento_nombre() {
		return descuento_nombre;
	}

	public void setDescuento_nombre(String descuento_nombre) {
		this.descuento_nombre = descuento_nombre;
	}

	public Integer getDescuento_procentaje() {
		return descuento_procentaje;
	}

	public void setDescuento_procentaje(Integer descuento_procentaje) {
		this.descuento_procentaje = descuento_procentaje;
	}

	public Boolean getDescuento_disponible() {
		return descuento_disponible;
	}

	public void setDescuento_disponible(Boolean descuento_disponible) {
		this.descuento_disponible = descuento_disponible;
	}
	
	
}
