package boutique.com.model.body;

import java.util.Date;

public class ReporteVentasBody {

	
	public Integer id_reporte;
	public Date fecha_inicio_reporte;
	public Date fecha_fin_reporte;
	
	public ReporteVentasBody(Integer id_reporte, Date fecha_inicio_reporte, Date fecha_fin_reporte) {
		super();
		this.id_reporte = id_reporte;
		this.fecha_inicio_reporte = fecha_inicio_reporte;
		this.fecha_fin_reporte = fecha_fin_reporte;
	}


	
	
}
