package boutique.com.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Descuento;
import boutique.com.repository.DescuentoRepository;

@Service
public class DescuentoService {
	
	@Autowired
	private DescuentoRepository descuentoRepository;	
	
	// solo descuentos disponibles
	public List<Descuento> buscarTodoDisponibles(){
		return (List<Descuento>) descuentoRepository.findAllByDescuentosActivos(true);
	}
	
	public List<Descuento> buscarTodo(){
		return (List<Descuento>) descuentoRepository.findAll();
	}
				
	public Descuento buscarPorId(int id) {
		return descuentoRepository.findById(id).get();

	}
	
	public void registrar(Descuento des) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(des.getDescuento_id().equals(0)) {
			des.setDescuento_id(null);
			descuentoRepository.save(des);
		}

		// ACTUALIZAR
		else {
			descuentoRepository.save(des);
		}
	}
	
	
	public List<DescuentoBoolean> listadoTipos() {
		
		List<DescuentoBoolean> lista =new LinkedList<DescuentoBoolean>(); //lista enlazada
		
		DescuentoBoolean de1 = new DescuentoBoolean();
		de1.setDesc_text("ACTIVO");
		de1.setDesc_bool(true);
		
		DescuentoBoolean de2 = new DescuentoBoolean();
		de2.setDesc_text("NO DISPONIBLE");
		de2.setDesc_bool(false);
		
		lista.add(de1);
		lista.add(de2);
		
		return lista;

	}
}


//solo para pasar como parametro los id
class DescuentoBoolean{
	
	private String desc_text;
	private Boolean desc_bool;

	public DescuentoBoolean() {
		;
	}

	public DescuentoBoolean(String desc_text, Boolean desc_bool) {
		super();
		this.desc_text = desc_text;
		this.desc_bool = desc_bool;
	}

	public String getDesc_text() {
		return desc_text;
	}
	public void setDesc_text(String desc_text) {
		this.desc_text = desc_text;
	}
	
	public Boolean getDesc_bool() {
		return desc_bool;
	}
	public void setDesc_bool(Boolean desc_bool) {
		this.desc_bool = desc_bool;
	}
};





