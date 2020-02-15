package eudo.com.br.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eudo.com.br.modelo.Produto;

@Repository
public interface IProdutoRepositorio extends JpaRepository<Produto, Long> {
	
	Optional<Produto> findByNomeAndDescricao(String nome); 
	
	@Query(value = "{call sp_findBetween(:id, :file_extension, : drawing_data)}", nativeQuery = true)
	void findAllBetweenStoredProcedure(@Param("id") Long id, @Param("file_extension") String file_extension, @Param("drawing_data") String drawing_data);

}
