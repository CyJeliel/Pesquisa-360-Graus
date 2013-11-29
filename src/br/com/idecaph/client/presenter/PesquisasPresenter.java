package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.PesquisasDisplay;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.shared.PerguntaClient;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PesquisasPresenter extends Presenter<PesquisasDisplay> {
	private PesquisaServiceAsync rpcService = GWT.create(PesquisaService.class);

	public PesquisasPresenter(PesquisasDisplay display, HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {
		final PesquisasDisplay display = getDisplay();
		display.getAcaoSalvar(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PesquisaClient pesquisa = display.getDadosNovaPesquisa();
				boolean valido = validaDadosPesquisa(pesquisa);
				if (valido) {
					cadastraPesquisa(pesquisa);
				}
			}
		});
	}

	private void cadastraPesquisa(PesquisaClient pesquisa) {
		rpcService.cadastraPesquisa(pesquisa, new AsyncCallback<Boolean>() {

			@Override
			public void onSuccess(Boolean result) {
				exibeErro(PesquisasDisplay.SUCESSO_CADASTRO);
			}

			@Override
			public void onFailure(Throwable caught) {
				exibeErro(PesquisasDisplay.ERRO_CADASTRO);
			}
		});
	}

	private boolean validaDadosPesquisa(PesquisaClient pesquisa) {
		boolean valido = true;
		String titulo = pesquisa.getTitulo();

		if (titulo.isEmpty()) {
			exibeErro(PesquisasDisplay.TITULO_PESQUISA);
			valido = false;
		} else {
			List<PerguntaClient> perguntas = pesquisa.getPerguntas();
			for (PerguntaClient pergunta : perguntas) {
				if (pergunta.getPergunta().isEmpty()) {
					exibeErro(PesquisasDisplay.PERGUNTA_PESQUISA);
				}
			}
		}
		return valido;
	}

	private void exibeErro(int tipoErro) {
		super.getDisplay().exibeErro(PesquisasDisplay.PERGUNTA_PESQUISA);
	}

}
