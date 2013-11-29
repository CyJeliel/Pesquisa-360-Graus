package br.com.idecaph.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.idecaph.client.interfaces.RelatorioService;
import br.com.idecaph.dao.PerguntaDAO;
import br.com.idecaph.dao.RespostaDAO;
import br.com.idecaph.model.Pergunta;
import br.com.idecaph.model.Resposta;
import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RelatorioServiceImpl extends RemoteServiceServlet implements
		RelatorioService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<RelatorioClient> getRelatorioGeral(Long idPesquisa,
			Long idAvaliado) {
		PerguntaDAO perguntaDAO = new PerguntaDAO();
		List<Pergunta> perguntasPorPesquisa = perguntaDAO
				.getPerguntasPorPesquisa(idPesquisa);
		if (perguntasPorPesquisa == null || perguntasPorPesquisa.isEmpty()) {
			return null;
		}
		RespostaDAO respostaDAO = new RespostaDAO();
		List<Resposta> respostas = respostaDAO.getRespostasAvaliado(idPesquisa,
				idAvaliado);

		List<RelatorioClient> relatorios = new ArrayList<RelatorioClient>();
		for (Pergunta pergunta : perguntasPorPesquisa) {
			Map<String, Integer> porcentagensRespostas = new HashMap<String, Integer>();
			int qtdRespostas = 0;
			for (Resposta resposta : respostas) {
				if (pergunta.getId() == resposta.getIdPergunta()) {
					Integer porcentagem = porcentagensRespostas.get(resposta.getDescricao());
					if (porcentagem == null) {
						porcentagem = 0;
					}
					++porcentagem;
					++qtdRespostas;
					porcentagensRespostas.put(resposta.getDescricao(),
							porcentagem);
				}
			}
			for (String resposta : porcentagensRespostas.keySet()) {
				Integer porcentagem = porcentagensRespostas.get(resposta);
				if (porcentagem == null) {
					porcentagem = 0;
				}
				porcentagem = (porcentagem * 100) / qtdRespostas;
				porcentagensRespostas.put(resposta, porcentagem);
			}
			RelatorioClient relatorio = new RelatorioClient(
					pergunta.getPerguntaClient(), porcentagensRespostas);
			relatorios.add(relatorio);
		}

		return relatorios;
	}

}
