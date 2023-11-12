package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "estadolaboral")
public class Estadolaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer estadolaboral_id;
	
	@Column(name = "estadolaboral_nombre")
	private String estadolaboral_nombre;

	public Estadolaboral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estadolaboral(Integer estadolaboral_id, String estadolaboral_nombre) {
		super();
		this.estadolaboral_id = estadolaboral_id;
		this.estadolaboral_nombre = estadolaboral_nombre;
	}

	public Integer getEstadolaboral_id() {
		return estadolaboral_id;
	}

	public void setEstadolaboral_id(Integer estadolaboral_id) {
		this.estadolaboral_id = estadolaboral_id;
	}

	public String getEstadolaboral_nombre() {
		return estadolaboral_nombre;
	}

	public void setEstadolaboral_nombre(String estadolaboral_nombre) {
		this.estadolaboral_nombre = estadolaboral_nombre;
	}
	
}
