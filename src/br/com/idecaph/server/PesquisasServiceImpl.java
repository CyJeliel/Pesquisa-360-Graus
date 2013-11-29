package br.com.idecaph.server;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.dao.AvaliadoPesquisaDAO;
import br.com.idecaph.dao.FuncionarioDAO;
import br.com.idecaph.dao.ParticipantePesquisaDAO;
import br.com.idecaph.dao.PerguntaDAO;
import br.com.idecaph.dao.PesquisaDAO;
import br.com.idecaph.dao.RespostaDAO;
import br.com.idecaph.model.AvaliadoPesquisa;
import br.com.idecaph.model.Funcionario;
import br.com.idecaph.model.ParticipantePesquisa;
import br.com.idecaph.model.Pergunta;
import br.com.idecaph.model.Pesquisa;
import br.com.idecaph.model.Resposta;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PerguntaClient;
import br.com.idecaph.shared.PesquisaClient;
import br.com.idecaph.shared.RespostaClient;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PesquisasServiceImpl extends RemoteServiceServlet implements
		PesquisaService {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean cadastraPesquisa(PesquisaClient pesquisaClient) {
		Long idPesquisa = inserirPesquisa(pesquisaClient);
		boolean ok = true;
		if (idPesquisa != null && idPesquisa > 0l) {
			ok = inserirPerguntas(pesquisaClient.getPerguntas(), idPesquisa);
			if (ok) {
				ok = inserirParticipantes(pesquisaClient.getParticipantes(),
						idPesquisa);
				if (ok) {
					ok = inserirAvaliados(pesquisaClient.getAvaliados(),
							idPesquisa);
				}
			}
		} else {
			ok = false;
		}
		return ok;
	}

	private boolean inserirAvaliados(List<FuncionarioSelecionavel> avaliados,
			Long idPesquisa) {
		AvaliadoPesquisaDAO avaliadoPesquisaDAO = new AvaliadoPesquisaDAO();
		List<AvaliadoPesquisa> avaliadosPesquisa = new ArrayList<AvaliadoPesquisa>();
		for (FuncionarioSelecionavel funcionario : avaliados) {
			AvaliadoPesquisa avaliadoPesquisa = new AvaliadoPesquisa(
					funcionario.getId(), idPesquisa);
			avaliadosPesquisa.add(avaliadoPesquisa);
		}
		boolean ok = true;
		try {
			avaliadoPesquisaDAO.insertAll(avaliadosPesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	private boolean inserirParticipantes(
			List<FuncionarioSelecionavel> participantes, Long idPesquisa) {
		ParticipantePesquisaDAO participantePesquisaDAO = new ParticipantePesquisaDAO();
		List<ParticipantePesquisa> participantesPesquisa = new ArrayList<ParticipantePesquisa>();
		for (FuncionarioSelecionavel funcionario : participantes) {
			ParticipantePesquisa participantePesquisa = new ParticipantePesquisa(
					funcionario.getId(), idPesquisa);
			participantesPesquisa.add(participantePesquisa);
		}
		boolean ok = true;
		try {
			participantePesquisaDAO.insertAll(participantesPesquisa);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	private boolean inserirPerguntas(List<PerguntaClient> perguntasPesquisa,
			Long idPesquisa) {
		PerguntaDAO perguntaDAO = new PerguntaDAO();
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		for (PerguntaClient perguntaClient : perguntasPesquisa) {
			Pergunta pergunta = new Pergunta(perguntaClient, idPesquisa);
			perguntas.add(pergunta);
		}
		boolean ok = true;
		try {
			perguntaDAO.insertAll(perguntas);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	private Long inserirPesquisa(PesquisaClient pesquisaClient) {
		PesquisaDAO pesquisaDAO = new PesquisaDAO();
		Pesquisa pesquisa = new Pesquisa(pesquisaClient);
		try {
			pesquisa = pesquisaDAO.insert(pesquisa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pesquisa.getId();
	}

	@Override
	public List<PesquisaClient> getPesquisasExistentes() {
		List<PesquisaClient> pesquisasClient = new ArrayList<PesquisaClient>();
		PesquisaDAO pesquisaDAO = new PesquisaDAO();
		try {
			List<Pesquisa> pesquisas = pesquisaDAO.getAll();
			if (pesquisas != null) {
				for (Pesquisa pesquisa : pesquisas) {
					PesquisaClient pesquisaClient = buscarAvaliados(pesquisa
							.getId());
					if (pesquisaClient != null) {
						pesquisasClient.add(pesquisaClient);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pesquisasClient;
	}

	@Override
	public PesquisaClient getPesquisaAtual() {
		PesquisaDAO pesquisaDAO = new PesquisaDAO();
		PesquisaClient pesquisaClient = null;
		try {
			Pesquisa pesquisa = pesquisaDAO.getPesquisaAtual();
			if (pesquisa != null) {
				pesquisaClient = buscarAvaliados(pesquisa.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pesquisaClient;
	}

	private PesquisaClient buscarAvaliados(Long idPesquisa) {
		AvaliadoPesquisaDAO avaliadoPesquisaDAO = new AvaliadoPesquisaDAO();
		List<AvaliadoPesquisa> avaliados = avaliadoPesquisaDAO
				.buscarAvaliados(idPesquisa);

		PerguntaDAO perguntaDAO = new PerguntaDAO();
		List<Pergunta> perguntas = perguntaDAO
				.getPerguntasPorPesquisa(idPesquisa);
		Integer qtdPerguntasPesquisa = perguntas.size();

		RespostaDAO respostaDAO = new RespostaDAO();
		List<FuncionarioSelecionavel> funcionariosSelecionaveis = new ArrayList<FuncionarioSelecionavel>();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Integer totalPerguntasRespondidas = 0;

		Long idParticipante = getIdFuncionarioLogado();

		for (AvaliadoPesquisa avaliadoPesquisa : avaliados) {
			Long idAvaliado = avaliadoPesquisa.getIdFuncionario();
			Integer qtdRespostasAvaliado = respostaDAO
					.qtdRespostasParticipantePorAvaliado(idPesquisa,
							idParticipante, idAvaliado);
			Funcionario funcionario = funcionarioDAO.findById(idAvaliado);
			FuncionarioSelecionavel funcionarioSelecionavel = funcionario
					.getFuncionarioSelecionavel();
			funcionarioSelecionavel
					.setPorcentagemPerguntasRespondidas(qtdRespostasAvaliado
							* 100 / qtdPerguntasPesquisa);
			funcionariosSelecionaveis.add(funcionarioSelecionavel);
			totalPerguntasRespondidas += qtdRespostasAvaliado;
		}

		PesquisaClient pesquisaClient = new PesquisaClient();
		pesquisaClient.setAvaliados(funcionariosSelecionaveis);
		PesquisaDAO pesquisaDAO = new PesquisaDAO();
		Pesquisa pesquisa = pesquisaDAO.findById(idPesquisa);
		pesquisaClient.setTitulo(pesquisa.getNome());

		Integer qtdPerguntasResponder = qtdPerguntasPesquisa * avaliados.size();
		if (qtdPerguntasResponder == 0) {
			pesquisaDAO.deleteById(idPesquisa);
			return null;
		} else {
			pesquisaClient
					.setPorcentagemPesquisaRespondida(totalPerguntasRespondidas
							* 100 / qtdPerguntasResponder);
		}
		List<PerguntaClient> perguntasClient = new ArrayList<PerguntaClient>();
		for (Pergunta pergunta : perguntas) {
			PerguntaClient perguntaClient = pergunta.getPerguntaClient();
			perguntasClient.add(perguntaClient);
		}
		pesquisaClient.setPerguntas(perguntasClient);
		pesquisaClient.setId(idPesquisa);
		return pesquisaClient;
	}

	private Long getIdFuncionarioLogado() {
		UserService userService = UserServiceFactory.getUserService();
		User usuario = userService.getCurrentUser();
		String email = usuario.getEmail();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario participante = funcionarioDAO.getByEmail(email);
		Long idParticipante = participante.getId();
		return idParticipante;
	}

	@Override
	public Boolean salvarResposta(RespostaClient respostaClient) {
		boolean ok = true;
		respostaClient.setIdParticipante(getIdFuncionarioLogado());
		Resposta resposta = new Resposta(respostaClient);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.insert(resposta);
		} catch (Exception e) {
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}

	@Override
	public long getIdUltimaPerguntaRespondida(Long idPesquisa, Long idAvaliado) {
		RespostaDAO respostaDAO = new RespostaDAO();
		Long idParticipante = getIdFuncionarioLogado();
		Long idUltimaPerguntaRespondida = respostaDAO
				.getUltimaPerguntaRespondida(idPesquisa, idParticipante,
						idAvaliado);
		if (idUltimaPerguntaRespondida > 0) {
			PerguntaDAO perguntaDAO = new PerguntaDAO();
			List<Pergunta> perguntas = perguntaDAO
					.getPerguntasPorPesquisa(idPesquisa);
			List<Resposta> respostasAvaliado = respostaDAO
					.getRespostasAvaliado(idPesquisa, idAvaliado);
			if (perguntas != null && respostasAvaliado != null) {
				if (respostasAvaliado.size() >= perguntas.size()){
					idUltimaPerguntaRespondida = -999l;
				}
			}
		}

		return idUltimaPerguntaRespondida;
	}
}
