package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.ResponderPesquisaFuncionarioDisplay;
import br.com.idecaph.client.eventos.EventoResponderPesquisa;
import br.com.idecaph.client.eventos.EventoResponderPesquisaFuncionario;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.PerguntaClient;
import br.com.idecaph.shared.PesquisaClient;
import br.com.idecaph.shared.RespostaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ResponderPesquisaFuncionarioPresenter extends
		Presenter<ResponderPesquisaFuncionarioDisplay> {

	private PerguntaClient pergunta;
	private FuncionarioClient funcionario;
	private int posicaoPerguntaAtual;

	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private PesquisaClient pesquisa;

	public ResponderPesquisaFuncionarioPresenter(
			ResponderPesquisaFuncionarioDisplay display,
			HandlerManager eventBus, FuncionarioClient funcionario,
			PesquisaClient pesquisa) {
		super(display, eventBus);
		this.funcionario = funcionario;
		this.posicaoPerguntaAtual = pesquisa
				.getPosicaoUltimaPerguntaRespondida();

		if (posicaoPerguntaAtual >= 0) {
			pergunta = pesquisa.getPerguntas().get(posicaoPerguntaAtual);
			if (pergunta == null) {
				pergunta = pesquisa.getPerguntas().get(0);
			}
			this.pesquisa = pesquisa;
		} else {
			eventBus.fireEvent(new EventoResponderPesquisa(pesquisa));
		}
	}

	@Override
	public void bind() {
		final ResponderPesquisaFuncionarioDisplay display = super.getDisplay();
		display.getNomeFuncionario().setText(funcionario.getDisplayNome());
		String perguntaDescricao = pergunta.getPergunta();
		display.getLabelPergunta().setText(perguntaDescricao);

		display.getActionNextPage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String resposta = display.getResposta();
				if (resposta != null && !resposta.isEmpty()) {
					salvarResposta(resposta);
				} else {
					Window.alert("Não é possível ir para a próxima questão sem responder à questão atual.");
				}
			}
		});

	}

	private void salvarResposta(String resposta) {
		RespostaClient respostaClient = new RespostaClient(null, resposta,
				pergunta.getId(), null, funcionario.getId(), pesquisa.getId());
		rpcService.salvarResposta(respostaClient, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean ok) {
				if (!ok) {
					Window.alert("Erro ao cadastrar resposta. Por favor, contate o administrador do sistema.");
				} else {
					if (posicaoPerguntaAtual == pesquisa.getPerguntas().size() - 1) {
						eventBus.fireEvent(new EventoResponderPesquisa(pesquisa));
					} else {
						carregarProximaPergunta();
					}
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void carregarProximaPergunta() {
		rpcService.getPosicaoUltimaPerguntaRespondida(pesquisa.getId(),
				funcionario.getId(), new AsyncCallback<Integer>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Integer result) {
						pesquisa.setPosicaoUltimaPerguntaRespondida(result);
						eventBus.fireEvent(new EventoResponderPesquisaFuncionario(
								funcionario, pesquisa));
					}
				});

	}

}
