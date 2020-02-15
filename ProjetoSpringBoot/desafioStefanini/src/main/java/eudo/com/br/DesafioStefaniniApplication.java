package eudo.com.br;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eudo.com.br.modelo.Produto;
import eudo.com.br.servico.PedidoService;
import eudo.com.br.servico.ProdutoServico;

@SpringBootApplication
public class DesafioStefaniniApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioStefaniniApplication.class, args);
	}

	@Autowired
	ProdutoServico produtoServico;

	@Autowired
	PedidoService pedidoServico;

	@Bean
	CommandLineRunner runner() {
		return args -> {
			carregarProdutos();
			// carregarPedido();
			// buscarPedidos();

		};
	}

	public void carregarProdutos() {

		List<Produto> produtos = new ArrayList<Produto>();
		Produto produto1 = new Produto("Bola", "Bola de Futebol Dente de Leite", 26.00);
		produtos.add(produto1);
		Produto produto2 = new Produto("Resma de Papel A4", "Resma de Papela A4", 15.99);
		produtos.add(produto2);
		Produto produto3 = new Produto("Caneta", "Caneta Bic", 2.50);
		produtos.add(produto3);

		produtoServico.salvarLista(produtos);

		System.out.println("Produtos cadastrados com sucesso!");

	}

}
