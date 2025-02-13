package beans;

public class Pedido {
	private int id;
	private Produto produto = new Produto();
	private Cliente cliente = new Cliente();
	private String date;
	
	
	public Pedido() {
		super();
		this.id = id;
		this.id = id;
		this.id = id;
		this.date = date;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}