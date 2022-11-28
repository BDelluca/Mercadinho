package mercadinho;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private Cliente cliente;
	private ArrayList<itemPedido> listaProdutos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<itemPedido> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(ArrayList<itemPedido> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public Pedido() {
	}
	
	public Pedido(int id, Cliente cliente, ArrayList<itemPedido> listaProdutos) {
		this.id = id;
		this.cliente = cliente;
		this.listaProdutos = listaProdutos;
	}
	
	public String exibirPedido() {
		String mensagem = "---------------------------\nId: " + this.id + "\nCliente: " + this.cliente.getNome() + "\n";
		for(itemPedido p: listaProdutos) {
			mensagem += "\nIdItemPedido: " + p.getId() + "\nProduto: " + p.getProduto().getNome() + "\nQuantidade: " + p.getQuantidade() + "\n";
		}
		mensagem += "\n---------------------------\n";
		return mensagem;
	}
}
