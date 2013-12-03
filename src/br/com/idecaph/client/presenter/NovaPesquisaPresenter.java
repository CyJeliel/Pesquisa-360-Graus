package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.NovaPesquisaDisplay;
import br.com.idecaph.client.eventos.EventoPaginaParticipantes;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;

public class NovaPesquisaPresenter extends Presenter<NovaPesquisaDisplay> {
	private PesquisaClient pesquisa;

	private List<FuncionarioSelecionavel> funcionarios;

	public NovaPesquisaPresenter(NovaPesquisaDisplay display,
			HandlerManager eventBus, PesquisaClient pesquisa, List<FuncionarioSelecionavel> funcionarios) {
		super(display, eventBus);
		this.pesquisa = pesquisa;
		this.funcionarios = funcionarios;
	}

	@Override
	public void bind() {
		final NovaPesquisaDisplay display = super.getDisplay();
		display.getAcaoProximaEtapa().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				String titulo = display.getTituloPesquisa();
				if (validaTitulo(titulo)) {
					pesquisa.setTitulo(titulo);
					eventBus.fireEvent(new EventoPaginaParticipantes(pesquisa, funcionarios));
				} else {
					display.exibeErro(NovaPesquisaDisplay.TITULO_INVALIDO);
				}
			}
		});
	}

	private boolean validaTitulo(String titulo) {
		boolean retorno = true;
		if (titulo == null || titulo.isEmpty()) {
			retorno = false;
		}
		return retorno;
	}

}
