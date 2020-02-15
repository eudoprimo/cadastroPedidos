package eudo.com.br.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import eudo.com.br.modelo.Produto;
import eudo.com.br.repositorio.IProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private IProdutoRepositorio produtoRepositorio;

	public List<Produto> buscarTodos() {
		return produtoRepositorio.findAll();
	}
	
	public List<Produto> salvarLista(List<Produto> lista) {
		return produtoRepositorio.saveAll(lista);
	}
	
	public Optional<Produto> buscarPorId(Long id) {
		return produtoRepositorio.findById(id);
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepositorio.save(produto);
	}
	
	public void delete(Long id) {
		produtoRepositorio.deleteById(id);
	}
	
	public Optional<Produto> buscarProdutoExitente(String nome){
		
		return produtoRepositorio.findByNomeAndDescricao(nome);
		
	}
}
