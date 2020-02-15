package eudo.com.br.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eudo.com.br.modelo.Pedido;

@Repository
public interface IPedidoRepositorio extends JpaRepository<Pedido, Long> {

}
