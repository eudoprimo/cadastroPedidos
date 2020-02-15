package eudo.com.br.controlador;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import eudo.com.br.modelo.Produto;
import eudo.com.br.servico.ProdutoServico;

@CrossOrigin
@RestController
@RequestMapping("/produtos")
public class ControladorProduto {

	@Autowired
	private ProdutoServico produtoServico;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@Valid @RequestBody Produto produto) {

		Optional<Produto> produtoExistente = produtoServico.buscarProdutoExitente(produto.getNome());

		if (produtoExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um produto com este nome.");
		}

		return produtoServico.salvar(produto);
	}
}
