package leilao.controlador;
import leilao.entidades.Participante;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.google.gson.Gson;




@WebServlet(urlPatterns = "/listaDeParticipantes")
public class ParticipanteServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cpf = req.getParameter("cpf");
		String nome = req.getParameter("name");
		String dataAniversario = req.getParameter("dataAniversario");
		
		
		int maiorIdade = calculaIdade(dataAniversario, "yyyy/MM/dd");
		if(maiorIdade >= 18 && maiorIdade < 120) {
			@SuppressWarnings("deprecation")
			Participante participante = new Participante(nome, cpf, new Date(dataAniversario));
			ParticipanteDAO dao = new ParticipanteDAO();
			dao.salva(participante);
			resp.sendRedirect("listaDeParticipantes.html");
		}else {
			System.out.println("Só é possível cadastra pessoas com mais de 18 e menos de 120 anos");
			resp.sendRedirect("cadastro-participante.html");
		}
		
		
		
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
				
				Gson gson = new Gson();
				
				String cpf = req.getParameter("cpf");
				
				if(cpf==null) {
					resp.setContentType("application/json");
					resp.setCharacterEncoding("UTF-8");
					resp.getWriter().write(gson.toJson(participanteDAO.lista()));
				}else {
					
					String operacao = req.getParameter("operacao");
					
					if(operacao != null && operacao.equals("excluir")) {
						participanteDAO.deleta(new Participante(cpf));
						resp.sendRedirect("listaDeParticipantes.html");
					}else {
						
						if(req.getParameter("origem")!=null && req.getParameter("origem").equals("cadastro-participante")) {
							String jsonParticipante = gson.toJson(participanteDAO.get(cpf));
							resp.setContentType("application/json");
							resp.getWriter().print(jsonParticipante.toString());
						}else {
							resp.sendRedirect("cadastro-participante.html?cpf="+req.getParameter("cpf"));
						}
					}
				}
	}
	
	public static int calculaIdade(String dataNasc, String pattern){

		DateFormat sdf = new SimpleDateFormat(pattern);

		Date dataNascInput = null;

		try {

		dataNascInput= sdf.parse(dataNasc);

		} catch (Exception e) {}

		 

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNascInput);

		// Cria um objeto calendar com a data atual

		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano

		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		 

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {

			age--;

		}

		return age;

	}

}
