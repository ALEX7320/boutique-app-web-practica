package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "comprobante")
public class Comprobante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comprobante_id;
	
	@Column(name = "comprobante_nombre")
	private String comprobante_nombre;

	public Comprobante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comprobante(Integer comprobante_id, String comprobante_nombre) {
		super();
		this.comprobante_id = comprobante_id;
		this.comprobante_nombre = comprobante_nombre;
	}

	public Integer getComprobante_id() {
		return comprobante_id;
	}

	public void setComprobante_id(Integer comprobante_id) {
		this.comprobante_id = comprobante_id;
	}

	public String getComprobante_nombre() {
		return comprobante_nombre;
	}

	public void setComprobante_nombre(String comprobante_nombre) {
		this.comprobante_nombre = comprobante_nombre;
	}
	
	

}
