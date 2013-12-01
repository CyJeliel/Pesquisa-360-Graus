package br.com.idecaph.client.presenter;

import java.util.List;
import java.util.Map;

import br.com.idecaph.client.display.ExibirRelatorioDisplay;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.RelatorioClient;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ExibirRelatorioPresenter extends Presenter<ExibirRelatorioDisplay> {

	private FuncionarioClient funcionario;
	private List<RelatorioClient> relatorios;

	public ExibirRelatorioPresenter(ExibirRelatorioDisplay display,
			HandlerManager eventBus, FuncionarioClient funcionario,
			List<RelatorioClient> relatorios) {
		super(display, eventBus);
		this.funcionario = funcionario;
		this.relatorios = relatorios;
	}

	@Override
	public void bind() {
		final ExibirRelatorioDisplay display = super.getDisplay();
		display.getNomeFuncionario().setText(funcionario.getDisplayNome());
		exibirDadosRelatorio();
	}

	private void exibirDadosRelatorio() {
		ExibirRelatorioDisplay display = super.getDisplay();
		if (relatorios != null && !relatorios.isEmpty()) {
			for (RelatorioClient relatorioClient : relatorios) {
				VerticalPanel resultado = display.getNovoPainelResultado();
				display.add(relatorioClient.getPerguntaClient().getPergunta(),
						resultado, "perguntaRelatorio");
				Map<String, Integer> porcentagensRespostas = relatorioClient
						.getPorcentagensRespostas();
				if (porcentagensRespostas != null && !porcentagensRespostas.isEmpty()){
					for (String resposta : porcentagensRespostas.keySet()) {
						String valor = resposta + ": "
								+ porcentagensRespostas.get(resposta) + "%";
						display.add(valor, resultado, "resposta");
					}
				} else {
					display.add("Não há respostas a essa pergunta para esse funcionário.", resultado, "resposta");
				}
				display.addResultado(resultado);
			}
		} else {
			display.setMensagemRelatorioVazio();
		}

	}
}
