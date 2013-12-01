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
	private Long perguntaAtual = 0l;
	private int posicaoPerguntaAtual;

	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);
	private PesquisaClient pesquisa;

	public ResponderPesquisaFuncionarioPresenter(
			ResponderPesquisaFuncionarioDisplay display,
			HandlerManager eventBus, FuncionarioClient funcionario,
			PesquisaClient pesquisa) {
		super(display, eventBus);
		this.funcionario = funcionario;
		this.perguntaAtual = pesquisa.getIdUltimaPerguntaRespondida();
		int i = 0;
		for (PerguntaClient perguntaClient : pesquisa.getPerguntas()) {
			if (perguntaClient.getId() == perguntaAtual) {
				posicaoPerguntaAtual = i + 1;
				pergunta = pesquisa.getPerguntas().get(posicaoPerguntaAtual);
				break;
			}
			++i;
		}
		if (pergunta == null) {
			pergunta = pesquisa.getPerguntas().get(0);
		}
		this.pesquisa = pesquisa;
	}

	@Override
	public void bind() {
		Window.alert("Entrei no bind da ResponderPesquisaFuncionarioPresenter");
		final ResponderPesquisaFuncionarioDisplay display = super.getDisplay();
		display.getNomeFuncionario().setText(funcionario.getDisplayNome());
		String perguntaDescricao = pergunta.getPergunta();
		display.getLabelPergunta().setText(perguntaDescricao);

		display.getActionNextPage().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String resposta = display.getResposta();
				salvarResposta(resposta);
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
		rpcService.getIdUltimaPerguntaRespondida(pesquisa.getId(),
				funcionario.getId(), new AsyncCallback<Long>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Long result) {
						pesquisa.setIdUltimaPerguntaRespondida(result);
						eventBus.fireEvent(new EventoResponderPesquisaFuncionario(
								funcionario, pesquisa));
					}
				});

	}

}
