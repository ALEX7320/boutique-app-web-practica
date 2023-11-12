package boutique.com.model.sp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


// NO SE HA CONTEMPLADO CONSTRUCTORES
@Entity
public class ConsultaHorarioSp {
	
	@Id // TABLA
	public Integer horario_id;
	public Date horario_fecha;
	public String horario_hora_inicio;
	public String horario_hora_fin;
	public String horario_detalle;
	public Integer userid;
	public Integer estadolaboral_id;
	
	// CALCULO
	public String diferencia;
	
	// TEXTOS
	public String name;
	public String lastname;
	public String estadolaboral_nombre;
	
	
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getEstadolaboral_id() {
		return estadolaboral_id;
	}
	public void setEstadolaboral_id(Integer estadolaboral_id) {
		this.estadolaboral_id = estadolaboral_id;
	}
	public String getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(String diferencia) {
		this.diferencia = diferencia;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEstadolaboral_nombre() {
		return estadolaboral_nombre;
	}
	public void setEstadolaboral_nombre(String estadolaboral_nombre) {
		this.estadolaboral_nombre = estadolaboral_nombre;
	}
	
	
	

}
