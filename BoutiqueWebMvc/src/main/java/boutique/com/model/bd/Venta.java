package boutique.com.model.bd;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer venta_id;
	
	@Column(name = "venta_fecha")
	private Date venta_fecha;
	
	@Column(name = "venta_descripcion")
	private String venta_descripcion;
	
	@Column(name = "venta_igv")
	private Double venta_igv;
	
	@Column(name = "venta_estado")
	private Boolean venta_estado;
	
	@OneToOne
	@JoinColumn(name="tipopago_id")
	private Tipopago tipopago_id;
	
	@OneToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente_id;

	@OneToOne
	@JoinColumn(name="comprobante_id")
	private Comprobante comprobante_id;
	
	// PARA UNIR
	@OneToMany(mappedBy="venta_id", fetch=FetchType.EAGER)
	private List<Detalleventa> detalleventa_list;

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venta(Integer venta_id, Date venta_fecha, String venta_descripcion, Double venta_igv, Boolean venta_estado,
			Tipopago tipopago_id, Cliente cliente_id, Comprobante comprobante_id,
			List<Detalleventa> detalleventa_list) {
		super();
		this.venta_id = venta_id;
		this.venta_fecha = venta_fecha;
		this.venta_descripcion = venta_descripcion;
		this.venta_igv = venta_igv;
		this.venta_estado = venta_estado;
		this.tipopago_id = tipopago_id;
		this.cliente_id = cliente_id;
		this.comprobante_id = comprobante_id;
		this.detalleventa_list = detalleventa_list;
	}

	public Integer getVenta_id() {
		return venta_id;
	}

	public void setVenta_id(Integer venta_id) {
		this.venta_id = venta_id;
	}

	public Date getVenta_fecha() {
		return venta_fecha;
	}

	public void setVenta_fecha(Date venta_fecha) {
		this.venta_fecha = venta_fecha;
	}

	public String getVenta_descripcion() {
		return venta_descripcion;
	}

	public void setVenta_descripcion(String venta_descripcion) {
		this.venta_descripcion = venta_descripcion;
	}

	public Double getVenta_igv() {
		return venta_igv;
	}

	public void setVenta_igv(Double venta_igv) {
		this.venta_igv = venta_igv;
	}

	public Boolean getVenta_estado() {
		return venta_estado;
	}

	public void setVenta_estado(Boolean venta_estado) {
		this.venta_estado = venta_estado;
	}

	public Tipopago getTipopago_id() {
		return tipopago_id;
	}

	public void setTipopago_id(Tipopago tipopago_id) {
		this.tipopago_id = tipopago_id;
	}

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Comprobante getComprobante_id() {
		return comprobante_id;
	}

	public void setComprobante_id(Comprobante comprobante_id) {
		this.comprobante_id = comprobante_id;
	}

	public List<Detalleventa> getDetalleventa_list() {
		return detalleventa_list;
	}

	public void setDetalleventa_list(List<Detalleventa> detalleventa_list) {
		this.detalleventa_list = detalleventa_list;
	}

}
