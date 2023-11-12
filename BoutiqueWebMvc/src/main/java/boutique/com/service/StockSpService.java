package boutique.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.com.model.sp.StockProductoSp;
import boutique.com.model.sp.StockSp;
import boutique.com.repository.StockProductoSpRepository;
import boutique.com.repository.StockSpRepository;



@Service
public class StockSpService {
	
	@Autowired
	private StockSpRepository stockSpRepository;
	
	@Autowired
	private StockProductoSpRepository stockProductoSpRepository;
	
	public List<StockSp> listarStock(){
		return stockSpRepository.listarStock();
	}
	
	public List<StockProductoSp> stockPorIdProducto(Integer id){
		return stockProductoSpRepository.stockPorIdProducto(id);
	}

}
