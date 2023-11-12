package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer marca_id;
	
	@Column(name = "marca_nombre")
	private String marca_nombre;

	public Marca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Marca(Integer marca_id, String marca_nombre) {
		super();
		this.marca_id = marca_id;
		this.marca_nombre = marca_nombre;
	}

	public Integer getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(Integer marca_id) {
		this.marca_id = marca_id;
	}

	public String getMarca_nombre() {
		return marca_nombre;
	}

	public void setMarca_nombre(String marca_nombre) {
		this.marca_nombre = marca_nombre;
	}

	
    
}
