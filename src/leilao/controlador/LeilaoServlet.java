package leilao.controlador;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import leilao.entidades.Leilao;
import leilao.entidades.Participante;

@WebServlet(urlPatterns = "/listaDeLeilao")
public class LeilaoServlet extends HttpServlet{
	
	@SuppressWarnings("deprecation")
	/*protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//
		String descricao = req.getParameter("descricao");
		String valorInicial = req.getParameter("valorInicial");
		String dataCriacao = req.getParameter("dataCriacao");
		String situacao = req.getParameter("situacao");
		String id = null;
		id = req.getParameter("id");

		
		
		
		@SuppressWarnings("deprecation")
		Leilao leilao = new Leilao(descricao, new Date(dataCriacao), Double.parseDouble(valorInicial), situacao);
		System.out.println("ID: "+id);
		if(isNumeric(id)) {
			leilao.setId(Long.parseLong(id));
		}
		LeilaoDAO dao = new LeilaoDAO();
		dao.salva(leilao);
		resp.sendRedirect("listaDeLeilao.html");
		//
		

		LeilaoDAO ldao = new LeilaoDAO();
		Leilao leilao = new Leilao();

		String descricao = req.getParameter("descricao");
		String valorInicial = req.getParameter("valorInicial");
		String dataCriacao = req.getParameter("dataCriacao");
		String situacao = req.getParameter("situacao");

		String id = null;
		//id = req.getParameter("id");

		
		System.out.println("ID: "+ id);
		if(isNumeric(id)) {
			leilao.setId(Long.parseLong(id));
		}
		//leilao.setId(Long.parseLong(id));
		leilao.setDescricao(descricao);
		leilao.setDataCriacao(new Date(dataCriacao));
		leilao.setValorInicial(Double.parseDouble(valorInicial));
		leilao.setSituacao(situacao);

		ldao.salva(leilao);
		resp.sendRedirect("listaDeLeilao.html");
		
	}*/
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		LeilaoDAO ldao = new LeilaoDAO();
		Leilao leilao = new Leilao();

		String descricao = req.getParameter("descricao");
		String valorInicial = req.getParameter("valorInicial");
		String dataCriacao = req.getParameter("dataCriacao");
		String situacao = req.getParameter("situacao");

		String id = null;
		id = req.getParameter("id");

		
		System.out.println("ID: "+id);
		if(isNumeric(id)) {
			leilao.setId(Long.parseLong(id));
		}
		

		leilao.setDescricao(descricao);
		leilao.setDataCriacao(new Date(dataCriacao));
		leilao.setValorInicial(Double.parseDouble(valorInicial));
		leilao.setSituacao(situacao);

		ldao.salva(leilao);
		resp.sendRedirect("listaDeLeilao.html");

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LeilaoDAO dao = new LeilaoDAO();
		Gson gson = new Gson();

		String descricao = req.getParameter("descricao");
		if (descricao == null) {
			resp.setContentType("aplication/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(dao.lista()));
		} else {
			String operacao = req.getParameter("operacao");
			if (operacao != null && operacao.equals("excluir")) {
				Leilao leilao = new Leilao();
				List<Leilao> listaLeilao = dao.lista();

				for (Leilao l : listaLeilao) {
					if (l.getDescricao().equals(descricao)) {
						leilao = l;
					}
				}
				dao.deleta(leilao);
				resp.sendRedirect("listaDeLeilao.html");
			} else {

				if (req.getParameter("origem") != null && req.getParameter("origem").equals("cadastro-leilao")) {
					Leilao leilao = new Leilao();
					List<Leilao> listaLeilao = dao.lista();

					for (Leilao l : listaLeilao) {
						if (l.getDescricao().equals(descricao)) {
							leilao = l;
						}
					}
					String jsonLeilao = gson.toJson(leilao);
					resp.setContentType("aplication/json");
					resp.getWriter().print(jsonLeilao.toString());
				} else {
					resp.sendRedirect("cadastro-leilao.html?descricao=" + req.getParameter("descricao"));
					// resp.sendRedirect("cadastro-leilao.html");
				}
			}
		}
	}
	public boolean isNumeric (String s) {
		try {
			Long.parseLong(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
