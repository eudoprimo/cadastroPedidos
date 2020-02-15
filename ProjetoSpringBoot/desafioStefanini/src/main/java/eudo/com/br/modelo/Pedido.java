package eudo.com.br.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "DATA_PEDIDO")
	private LocalDate data;

	@NotNull
	@Column(name = "VALOR_TOTAL")
	private Double valorTotal;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List<ItemPedido> itensPedido;

	public Pedido() {
		
	}	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	
	 public void comprar(Produto produto, Integer quantidade) {
	        ItemPedido itemPedido = new ItemPedido();
	        itemPedido.setPrecoUnitario(produto.getPreco());
	        itemPedido.setQuantidade(quantidade);
	        itemPedido.setPrecoTotal(produto.getPreco() * quantidade);
	        itemPedido.setProduto(produto);
	        itemPedido.setPedido(this);

	        this.itensPedido = new ArrayList<>();
	        this.itensPedido.add(itemPedido);

	        List<ItemPedido> itensPedidosProduto = new ArrayList<>();
	        if(produto.getItensPedido() != null) {
	            itensPedidosProduto = produto.getItensPedido();
	        }
	        itensPedidosProduto.add(itemPedido);
	        produto.setItensPedido(itensPedidosProduto);

	        this.setValorTotal(itemPedido.getPrecoTotal());
	    }


	@Override
	public String toString() {
		return "Pedido{" + "id=" + id + ", data=" + data + ", valorTotal=" + valorTotal + ", itensPedido=" + itensPedido
				+ '}';
	}
}
