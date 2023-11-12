package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "roles")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer rolid;
	
	@Column(name = "rolname")
	private String rolname;

	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rol(Integer rolid, String rolname) {
		super();
		this.rolid = rolid;
		this.rolname = rolname;
	}

	public Integer getRolid() {
		return rolid;
	}

	public void setRolid(Integer rolid) {
		this.rolid = rolid;
	}

	public String getRolname() {
		return rolname;
	}

	public void setRolname(String rolname) {
		this.rolname = rolname;
	}

	
}
