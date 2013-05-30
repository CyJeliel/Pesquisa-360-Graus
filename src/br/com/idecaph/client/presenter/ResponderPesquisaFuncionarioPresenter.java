package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.ResponderPesquisaFuncionarioDisplay;
import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.Pergunta;

import com.google.gwt.event.shared.HandlerManager;

public class ResponderPesquisaFuncionarioPresenter extends
		Presenter<ResponderPesquisaFuncionarioDisplay> {

	private List<Pergunta> perguntas;
	private Funcionario funcionario;
	private int perguntaAtual = 0;

	public ResponderPesquisaFuncionarioPresenter(
			ResponderPesquisaFuncionarioDisplay display,
			HandlerManager eventBus, Funcionario funcionario,
			List<Pergunta> perguntas) {
		super(display, eventBus);
		this.funcionario = funcionario;
		this.perguntas = perguntas;
	}

	@Override
	public void bind() {
		final ResponderPesquisaFuncionarioDisplay display = super.getDisplay();
		display.getNomeFuncionario().setText(funcionario.getDisplayNome());
		String pergunta = perguntas.get(perguntaAtual).getPergunta();
		display.getLabelPergunta().setText(pergunta);
	}

}
