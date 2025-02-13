package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import beans.Pedido;
import beans.Produto;
import dao.PedidoDAO;

/**
 * Servlet implementation class ControlePedidoServlet
 */
@WebServlet("/controlePedido")
public class ControlePedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlePedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		int idPedido = 0;
		String data = null;
		int idCliente = 0;
		int idProduto = 0;
		
		try {
			idCliente = Integer.valueOf(request.getParameter("cliente")); 
			idProduto = Integer.valueOf(request.getParameter("produto"));
			data = request.getParameter("data");
			
		} catch (NumberFormatException e) {
            e.printStackTrace();
            }		
		
		pedido.setId(pedidoDAO.selecionaID());
		
		//cliente.setId(idCliente);
		pedidoDAO.buscaCliente(idCliente);	
	
		//System.out.println("nome do cliente: " + pedidoDAO.buscaCliente(idCliente).getNome() + " -- " + "ID: " + pedidoDAO.buscaCliente(idCliente).getId());
		
		
		//produto.setId(idProduto);
		pedidoDAO.buscaProduto(idProduto);
		//System.out.println("servlet id do produto: " + pedidoDAO.buscaProduto(idProduto));
		//System.out.println("nome do produto: " + pedidoDAO.buscaProduto(idProduto).getDescricao() + " -- " + "ID: " + pedidoDAO.buscaProduto(idProduto).getId());

		pedido.setCliente(pedidoDAO.buscaCliente(idCliente));
		pedido.setProduto(pedidoDAO.buscaProduto(idProduto));
		
		
		System.out.println("nome do cliente: " + pedido.getCliente().getNome() + " -- produto: " + pedido.getProduto().getDescricao());
		
		pedidoDAO.inserir(pedido);
		//pedido.setCliente(cliente)
		
		/*System.out.println("id do cliente: " + idCliente);
		System.out.println("id do produto: " + idProduto);*/
		
		/*pedido.setDate(data);
		pedido.getCliente().setId(idCliente);
		pedido.getProduto().setId(idProduto);
		pedido.setId(pedidoDAO.selecionaID());*/
		
		//System.out.println("id do cliente: " + idCliente);
		
		//System.out.println(pedido.getProduto().getDescricao() + " -- " + pedido.getId() + " -- " + pedido.getCliente().getNome());

		
		//pedidoDAO.inserir(pedido);
		
		
	}

}
