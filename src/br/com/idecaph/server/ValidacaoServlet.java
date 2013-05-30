package br.com.idecaph.server;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.idecaph.model.ColaboradorTemp;

public class ValidacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ValidacaoServlet.class
			.getName());

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String idEmpresa = request.getParameter("idEmpresa");
		List<ColaboradorTemp> colaboradores = ColaboradorTemp
				.getAllByIdEmpresa(idEmpresa);
		for (ColaboradorTemp colaborador: colaboradores){
			//TODO Fazer validacao
			log.info("email colaborador = " + colaborador.getEmail());
		}
	}

}
