package controle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MedicoDAO;
import beans.Medico;


@WebServlet("/controleMedicos")
public class ControleMedicos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControleMedicos() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.print("Médico cadastrado");
		
		int idMedico = 0;
		String nome;
		
		nome = request.getParameter("nome");
		
		Medico medico = new Medico();
		MedicoDAO mDAO = new MedicoDAO();
		
		medico.setNome(nome);
		medico.setId(mDAO.geraId());
		//System.out.println("da classe medico: " + medico.getId());
		//System.out.println("do gerador: " + mDAO.geraId());
		
		mDAO.inserir(medico);
	}

}
