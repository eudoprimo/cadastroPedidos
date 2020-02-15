package eudo.com.br.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eudo.com.br.modelo.ItemPedido;

import eudo.com.br.repositorio.IItemPedidoRepositorio;

@Service
public class ItemPedidoService {

	@Autowired
	private IItemPedidoRepositorio itemPedidoRepositorio;

	public List<ItemPedido> buscarTodos() {
		return itemPedidoRepositorio.findAll();
	}

}
