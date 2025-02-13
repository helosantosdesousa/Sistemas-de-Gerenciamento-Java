package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;


@WebServlet("/controleProduto")
public class ControleProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControleProdutoServlet() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO();
		
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		
		cliente.setNome(nome);
		cliente.setFone(fone);
		cliente.setEmail(email);
		
		cliente.setId(clienteDao.selecionaID());
		
		System.out.println(cliente.getNome() + " -- " + cliente.getId() + " -- " + cliente.getEmail());
		
		clienteDao.cadastrarCliente(cliente);
		//clienteDao.deletar();
		
		
		//clienteDao.cadastrarCliente(cliente);
		
		
		//System.out.println(clienteDao.procuraMaiorID());
		
		/*PrintWriter out = response.getWriter();
		
		out.print(clienteDao.procuraMaiorID());*/
	}

}

