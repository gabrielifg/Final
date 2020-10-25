package leilao.controlador;
import leilao.entidades.Participante;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet(urlPatterns = "/participantes")
public class ParticipanteServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("name");
		String dataAniversario = req.getParameter("dNascimento");
		
		Participante participante = new Participante(cpf, nome, new Date(dataAniversario));
		ParticipanteDAO dao = new ParticipanteDAO();
		dao.salva(participante);
		resp.sendRedirect("participante.html");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
