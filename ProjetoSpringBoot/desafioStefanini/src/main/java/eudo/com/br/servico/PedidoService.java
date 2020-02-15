package eudo.com.br.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eudo.com.br.modelo.Pedido;
import eudo.com.br.repositorio.IPedidoRepositorio;


@Service
public class PedidoService {
	
	@Autowired
	private IPedidoRepositorio pedidoRepositorio;
	
	
	public List<Pedido> buscarTodos() {
		return pedidoRepositorio.findAll();
	}
	
	public Optional<Pedido> buscarPorId(Long id) {
		return pedidoRepositorio.findById(id);
	}
	
	public Pedido salvar(Pedido pedido) {
		return pedidoRepositorio.saveAndFlush(pedido);
	}
	
	public void delete(Long id) {
		pedidoRepositorio.deleteById(id);
	}
	
//	public List<PedidoVo> buscarPedidos(){
//		
//		return pedidoRepositorio.findByDataPedidoAndDescritivoProdutoAndQtdeValorAndTotal();
//	}
	
	

}
