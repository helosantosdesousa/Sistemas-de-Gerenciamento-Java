package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AtendimentoDAO;
import DAO.MedicoDAO;
import DAO.TurnoDAO;
import beans.Atendimento;


@WebServlet("/controleAtendimentos")
public class ControleAtendimentos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ControleAtendimentos() {
        super();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome;
		String turno;
		int id;
		double valor;
		
		
		nome = request.getParameter("medico");
		turno = request.getParameter("turno");
		valor = Double.valueOf(request.getParameter("valor"));
		
		AtendimentoDAO adao = new AtendimentoDAO();
		MedicoDAO mdao = new MedicoDAO();
		TurnoDAO tdao = new TurnoDAO();
		//id = adao.gerarID();
		//System.out.println(id);
		
		Atendimento atendimento = new Atendimento();
		atendimento.setId(adao.gerarID());
		atendimento.setIdMedico(mdao.procuraMedico(nome));
		atendimento.setIdTurno(tdao.procuraTurno(turno));
		//atendimento.setIdTurno(idTurno);
		atendimento.setValor(valor);
		
		
		adao.inserir(atendimento);
	}

}
