package eudo.com.br.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eudo.com.br.modelo.Pedido;
import eudo.com.br.modelo.Produto;
import eudo.com.br.servico.PedidoService;
import eudo.com.br.servico.ProdutoServico;

@CrossOrigin
@RestController
@RequestMapping("/pedidos")
public class ControladorPedido {
	
	@Autowired
	private PedidoService pedidoServico;
	
	private ProdutoServico produtoServico;
	

	@GetMapping
	public List<Pedido> listar() {
		return pedidoServico.buscarTodos();
	}
	
	 @RequestMapping(value = "/comprar/{idProduto}/{quantidade}", method = RequestMethod.POST)
	    public String comprar(@PathVariable Long idProduto, @PathVariable Integer quantidade) {	       
	        Optional<Produto> produto = produtoServico.buscarPorId(idProduto);
	        
	        Pedido pedido = new Pedido();
	        
	        pedido.comprar(produto.get(), quantidade);
	        
	        pedidoServico.salvar(pedido);

	        return "Sucesso na compra do produto: " + produto.get().getNome() + "\n";
	    }

}
