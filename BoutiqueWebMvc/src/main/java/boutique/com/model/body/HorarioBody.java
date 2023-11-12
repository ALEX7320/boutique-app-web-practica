package boutique.com.model.body;

import java.util.Date;


public class HorarioBody {
	
	public Integer horario_id;
	public Date horario_fecha;
	public String horario_hora_inicio;
	public String horario_hora_fin;
	public String horario_detalle;
	public Integer userid;
	public Integer estadolaboral_id;
	
	public HorarioBody(Integer horario_id, Date horario_fecha, String horario_hora_inicio, String horario_hora_fin,
			String horario_detalle, Integer userid, Integer estadolaboral_id) {
		super();
		this.horario_id = horario_id;
		this.horario_fecha = horario_fecha;
		this.horario_hora_inicio = horario_hora_inicio;
		this.horario_hora_fin = horario_hora_fin;
		this.horario_detalle = horario_detalle;
		this.userid = userid;
		this.estadolaboral_id = estadolaboral_id;
	}
	
	

}
