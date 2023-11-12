package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tipoproducto")
public class Tipoproducto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tipoproducto_id;
	
	@Column(name = "tipoproducto_nombre")
	private String tipoproducto_nombre;

	public Tipoproducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipoproducto(Integer tipoproducto_id, String tipoproducto_nombre) {
		super();
		this.tipoproducto_id = tipoproducto_id;
		this.tipoproducto_nombre = tipoproducto_nombre;
	}

	public Integer getTipoproducto_id() {
		return tipoproducto_id;
	}

	public void setTipoproducto_id(Integer tipoproducto_id) {
		this.tipoproducto_id = tipoproducto_id;
	}

	public String getTipoproducto_nombre() {
		return tipoproducto_nombre;
	}

	public void setTipoproducto_nombre(String tipoproducto_nombre) {
		this.tipoproducto_nombre = tipoproducto_nombre;
	}
	
	
}
