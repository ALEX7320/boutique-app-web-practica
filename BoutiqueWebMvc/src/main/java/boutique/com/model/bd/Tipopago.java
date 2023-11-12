package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipopago")
public class Tipopago {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipopago_id;
	
	@Column(name = "tipopago_nombre")
	private String tipopago_nombre;

	public Tipopago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipopago(Integer tipopago_id, String tipopago_nombre) {
		super();
		this.tipopago_id = tipopago_id;
		this.tipopago_nombre = tipopago_nombre;
	}

	public Integer getTipopago_id() {
		return tipopago_id;
	}

	public void setTipopago_id(Integer tipopago_id) {
		this.tipopago_id = tipopago_id;
	}

	public String getTipopago_nombre() {
		return tipopago_nombre;
	}

	public void setTipopago_nombre(String tipopago_nombre) {
		this.tipopago_nombre = tipopago_nombre;
	}

	
}
