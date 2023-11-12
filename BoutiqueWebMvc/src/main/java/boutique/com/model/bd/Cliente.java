package boutique.com.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cliente_id;
	
	@Column(name = "cliente_nombre")
	private String cliente_nombre;
	
	@Column(name = "cliente_apellido")
	private String cliente_apellido;
	
	@Column(name = "cliente_dni")
	private String cliente_dni;
	
	@Column(name = "cliente_celular")
	private String cliente_celular;

	
	@Column(name = "cliente_estado")
	private Boolean cliente_estado=true;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer cliente_id, String cliente_nombre, String cliente_apellido, String cliente_dni,
			String cliente_celular, Boolean cliente_estado) {
		super();
		this.cliente_id = cliente_id;
		this.cliente_nombre = cliente_nombre;
		this.cliente_apellido = cliente_apellido;
		this.cliente_dni = cliente_dni;
		this.cliente_celular = cliente_celular;
		this.cliente_estado = cliente_estado;
	}

	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getCliente_nombre() {
		return cliente_nombre;
	}
	public void setCliente_nombre(String cliente_nombre) {
		this.cliente_nombre = cliente_nombre;
	}
	public String getCliente_apellido() {
		return cliente_apellido;
	}
	public void setCliente_apellido(String cliente_apellido) {
		this.cliente_apellido = cliente_apellido;
	}
	public String getCliente_dni() {
		return cliente_dni;
	}
	public void setCliente_dni(String cliente_dni) {
		this.cliente_dni = cliente_dni;
	}
	public String getCliente_celular() {
		return cliente_celular;
	}
	public void setCliente_celular(String cliente_celular) {
		this.cliente_celular = cliente_celular;
	}

	public Boolean getCliente_estado() {
		return cliente_estado;
	}

	public void setCliente_estado(Boolean cliente_estado) {
		this.cliente_estado = cliente_estado;
	}
	
	
	

}
