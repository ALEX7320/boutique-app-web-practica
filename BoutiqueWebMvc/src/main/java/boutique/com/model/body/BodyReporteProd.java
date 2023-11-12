package boutique.com.model.body;


public class BodyReporteProd {
	private String re_marca;
	private String re_tipo;
	private String re_producto;
	private String re_finicio;
	private String re_ffinal;
	
	
	public void resetearValores() {
		this.re_marca = "";
		this.re_tipo = "";
		this.re_producto = "";
		this.re_finicio = "";
		this.re_ffinal = "";
	}


	public BodyReporteProd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BodyReporteProd(String re_marca, String re_tipo, String re_producto, String re_finicio, String re_ffinal) {
		super();
		this.re_marca = re_marca;
		this.re_tipo = re_tipo;
		this.re_producto = re_producto;
		this.re_finicio = re_finicio;
		this.re_ffinal = re_ffinal;
	}

	public String getRe_marca() {
		return re_marca;
	}

	public void setRe_marca(String re_marca) {
		this.re_marca = re_marca;
	}

	public String getRe_tipo() {
		return re_tipo;
	}

	public void setRe_tipo(String re_tipo) {
		this.re_tipo = re_tipo;
	}

	public String getRe_producto() {
		return re_producto;
	}

	public void setRe_producto(String re_producto) {
		this.re_producto = re_producto;
	}

	public String getRe_finicio() {
		return re_finicio;
	}

	public void setRe_finicio(String re_finicio) {
		this.re_finicio = re_finicio;
	}

	public String getRe_ffinal() {
		return re_ffinal;
	}

	public void setRe_ffinal(String re_ffinal) {
		this.re_ffinal = re_ffinal;
	}

	
}
