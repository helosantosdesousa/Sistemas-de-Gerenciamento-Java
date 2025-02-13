package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MedicoDAO;

/**
 * Servlet implementation class ControleQuantidade
 */
@WebServlet("/controleQuantidade")
public class ControleQuantidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleQuantidade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicoDAO mdao = new MedicoDAO();
		
		String nome = request.getParameter("medico");
		
		
		
		
		
		int idMedico = mdao.procuraMedico(nome);
		String qtdAtendimentos = String.valueOf(mdao.calculaQuantidadeAtendimentos(idMedico));
		
		request.setAttribute("nome", nome);
		request.setAttribute("qtdAtendimentos", qtdAtendimentos);
		
		 RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		    rd.forward(request, response);	
		    
	}

}
