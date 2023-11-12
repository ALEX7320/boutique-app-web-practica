package boutique.com.model.bd;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horario_id;
	
	@Column(name = "horario_fecha")
	private Date horario_fecha;
	
	@Column(name = "horario_hora_inicio")
	private String horario_hora_inicio;
	
	@Column(name = "horario_hora_fin")
	private String horario_hora_fin;
	
	@Column(name = "horario_detalle")
	private String horario_detalle;
	
	@OneToOne
	@JoinColumn(name="userid") // nombre de la fk en la bd
	private User userid;
	
	@OneToOne
	@JoinColumn(name="estadolaboral_id") // nombre de la fk en la bd
	private Estadolaboral estadolaboral_id;

	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Horario(Integer horario_id, Date horario_fecha, String horario_hora_inicio, String horario_hora_fin,
			String horario_detalle, User userid, Estadolaboral estadolaboral_id) {
		super();
		this.horario_id = horario_id;
		this.horario_fecha = horario_fecha;
		this.horario_hora_inicio = horario_hora_inicio;
		this.horario_hora_fin = horario_hora_fin;
		this.horario_detalle = horario_detalle;
		this.userid = userid;
		this.estadolaboral_id = estadolaboral_id;
	}

	public Integer getHorario_id() {
		return horario_id;
	}

	public void setHorario_id(Integer horario_id) {
		this.horario_id = horario_id;
	}

	public Date getHorario_fecha() {
		return horario_fecha;
	}

	public void setHorario_fecha(Date horario_fecha) {
		this.horario_fecha = horario_fecha;
	}

	public String getHorario_hora_inicio() {
		return horario_hora_inicio;
	}

	public void setHorario_hora_inicio(String horario_hora_inicio) {
		this.horario_hora_inicio = horario_hora_inicio;
	}

	public String getHorario_hora_fin() {
		return horario_hora_fin;
	}

	public void setHorario_hora_fin(String horario_hora_fin) {
		this.horario_hora_fin = horario_hora_fin;
	}

	public String getHorario_detalle() {
		return horario_detalle;
	}

	public void setHorario_detalle(String horario_detalle) {
		this.horario_detalle = horario_detalle;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Estadolaboral getEstadolaboral_id() {
		return estadolaboral_id;
	}

	public void setEstadolaboral_id(Estadolaboral estadolaboral_id) {
		this.estadolaboral_id = estadolaboral_id;
	}


}
