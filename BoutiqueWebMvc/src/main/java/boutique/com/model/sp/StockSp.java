package boutique.com.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

// NO SE HA CONTEMPLADO CONSTRUCTORES
@Entity
public class StockSp {
	
	@Id
	private Integer stock_id;
	private String stock_nombre;
	private Integer stock_ingreso;
	private Integer stock_salida;
	private Integer stock_usado;
	private Integer stock_total;
	private String stock_imagen;
	public Integer getStock_id() {
		return stock_id;
	}
	public void setStock_id(Integer stock_id) {
		this.stock_id = stock_id;
	}
	public String getStock_nombre() {
		return stock_nombre;
	}
	public void setStock_nombre(String stock_nombre) {
		this.stock_nombre = stock_nombre;
	}
	public Integer getStock_ingreso() {
		return stock_ingreso;
	}
	public void setStock_ingreso(Integer stock_ingreso) {
		this.stock_ingreso = stock_ingreso;
	}
	public Integer getStock_salida() {
		return stock_salida;
	}
	public void setStock_salida(Integer stock_salida) {
		this.stock_salida = stock_salida;
	}
	public Integer getStock_usado() {
		return stock_usado;
	}
	public void setStock_usado(Integer stock_usado) {
		this.stock_usado = stock_usado;
	}
	public Integer getStock_total() {
		return stock_total;
	}
	public void setStock_total(Integer stock_total) {
		this.stock_total = stock_total;
	}
	public String getStock_imagen() {
		return stock_imagen;
	}
	public void setStock_imagen(String stock_imagen) {
		this.stock_imagen = stock_imagen;
	}


}
