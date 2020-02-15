package eudo.com.br.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eudo.com.br.modelo.ItemPedido;

@Repository
public interface IItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {

}
