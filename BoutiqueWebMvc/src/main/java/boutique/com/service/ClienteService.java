package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.bd.Cliente;
import boutique.com.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;	
	
	
	public List<Cliente> buscarTodo(){
		// BUSCAR SOLO INGRESO DE PRODUCTOS ACTIVOS
		// return (List<Cliente>) clienteRepository.findAll();
		return (List<Cliente>) clienteRepository.findAllByClienteActivos(true);
		
	}
		
	public Cliente buscarPorId(int id) {
		return clienteRepository.findById(id).get();

	}
	
	public Cliente buscarDniExistente(String dni, Integer id) {
		return clienteRepository.buscarDniExistente(dni, id);

	}
	
	public void eliminar(Integer id) {
			
		Cliente c = clienteRepository.findById(id).get();
		c.setCliente_estado(false);
		
		clienteRepository.save(c);
		
	}
	
	
	
	public void registrar(Cliente cli) {
		// TODO Auto-generated method stub
				
		// CREAR
		if(cli.getCliente_id().equals(0)) {
			cli.setCliente_id(null);
			clienteRepository.save(cli);
		}

		// ACTUALIZAR
		else {
			clienteRepository.save(cli);
		}
	}
	
	

}
