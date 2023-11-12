package boutique.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import boutique.com.model.bd.Producto;
import boutique.com.model.body.ProductoBody;
import boutique.com.model.response.ResultadoResponse;
import boutique.com.service.MarcaService;
import boutique.com.service.ProductoService;
import boutique.com.service.TipoproductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private TipoproductoService tipoproductoService;
	
	private String imagen_por_defecto = "https://i.postimg.cc/jd0dzc7R/imagen.png";

	
	// LISTADO ESTATICO
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("listado", productoService.buscarTodo());
		model.addAttribute("marca_list", marcaService.buscarTodo());
		model.addAttribute("tipo_list", tipoproductoService.buscarTodo());
		//model.addAttribute("valor_bool", true);
		model.addAttribute("imagen_por_defecto", imagen_por_defecto);

		return "FolderProducto/listar";
	
	}
	
	//ELIMINAR CATEGORIA
	@DeleteMapping("/eliminar")
	@ResponseBody
	public ResultadoResponse eliminar(@RequestBody Producto prod) {
		
		String mensaje = "Producto eliminado correctamente";
		Boolean respuesta = true;
		
		try {

			productoService.eliminar(prod.getProducto_id());
		}
		catch(Exception ex){
			
			mensaje = "Producto no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	
	// CREAR CATEGORIA
	@PostMapping("/registrar")
	@ResponseBody
	public ResultadoResponse registrar(@RequestBody ProductoBody prod)  {
		
		String mensaje = "Registrado correctamente";
		Boolean respuesta = true;

		try {
			
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			String sms_val = validacionRegistro(prod);
			if(sms_val!="") {
				mensaje = sms_val;
				Integer er_val = Integer.parseInt("ERROR_REGISTRO");er_val+=1;
			}
			// VALIDACION REGISTRO  ///////////////////////////// INICIO
			
			Producto p = new Producto();		
			p.setProducto_id(prod.producto_id);
			p.setProducto_precio(prod.producto_precio);
			p.setProducto_descripcion(prod.producto_descripcion);
			p.setProducto_estado(prod.producto_estado);
			p.setProducto_nombre(prod.producto_nombre);
			p.setMarca_id(marcaService.buscarPorId(prod.marca_id));
			if(prod.producto_imagen.trim().equals("")) {
				p.setProducto_imagen(imagen_por_defecto);
			}else {
				p.setProducto_imagen(prod.producto_imagen);
			}
			p.setTipoproducto_id(tipoproductoService.buscarPorId(prod.tipoproducto_id));
			
			productoService.registrar(p);
			
		}
		catch(Exception ex){
			mensaje = "Completar los siguientes datos de manera correcta:\n\n"+mensaje;
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
		
	}
	
	@GetMapping("/listarProductosJson")
	@ResponseBody
	public List<Producto> listarProductosJson() {
		return productoService.buscarTodo();
	}	
	
	// VALIDACION REGISTRO
	public String validacionRegistro(ProductoBody obj) {
		
		String mensaje = "";
		
		if(obj.producto_precio<=0) {
			mensaje+="- Precio\n";
		}
		if(obj.producto_nombre.equals("")) {
			mensaje+="- Nombre\n";	
		}
		if(obj.producto_descripcion.equals("")) {
			mensaje+="- Descripcion\n";	
		}
		if(obj.marca_id==-1) {
			mensaje+="- Marca\n";	
		}
		if(obj.tipoproducto_id==-1) {
			mensaje+="- Tipo producto\n";	
		}	
		return mensaje;
	}
	
		

}

