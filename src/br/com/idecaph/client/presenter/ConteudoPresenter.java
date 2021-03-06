package br.com.idecaph.client.presenter;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.client.display.AvaliadosPesquisaDisplay;
import br.com.idecaph.client.display.ConteudoDisplay;
import br.com.idecaph.client.display.ExibirRelatorioDisplay;
import br.com.idecaph.client.display.FuncionariosDisplay;
import br.com.idecaph.client.display.NovaPesquisaDisplay;
import br.com.idecaph.client.display.NovoFuncionarioDisplay;
import br.com.idecaph.client.display.ParticipantesPesquisaDisplay;
import br.com.idecaph.client.display.PerguntasPesquisaDisplay;
import br.com.idecaph.client.display.RelatoriosDisplay;
import br.com.idecaph.client.display.ResponderPesquisaDisplay;
import br.com.idecaph.client.display.ResponderPesquisaFuncionarioDisplay;
import br.com.idecaph.client.eventos.EventoCarregaFuncionarios;
import br.com.idecaph.client.eventos.EventoCarregaFuncionariosHandler;
import br.com.idecaph.client.eventos.EventoCarregaPesquisa;
import br.com.idecaph.client.eventos.EventoCarregaPesquisaHandler;
import br.com.idecaph.client.eventos.EventoEditarFuncionario;
import br.com.idecaph.client.eventos.EventoEditarFuncionarioHandler;
import br.com.idecaph.client.eventos.EventoExibeFuncionarios;
import br.com.idecaph.client.eventos.EventoExibeFuncionariosHandler;
import br.com.idecaph.client.eventos.EventoExibirRelatorio;
import br.com.idecaph.client.eventos.EventoExibirRelatorioHandler;
import br.com.idecaph.client.eventos.EventoNovaPesquisa;
import br.com.idecaph.client.eventos.EventoNovaPesquisaHandler;
import br.com.idecaph.client.eventos.EventoNovoFuncionario;
import br.com.idecaph.client.eventos.EventoNovoFuncionarioHandler;
import br.com.idecaph.client.eventos.EventoPaginaAvaliados;
import br.com.idecaph.client.eventos.EventoPaginaAvaliadosHandler;
import br.com.idecaph.client.eventos.EventoPaginaParticipantes;
import br.com.idecaph.client.eventos.EventoPaginaParticipantesHandler;
import br.com.idecaph.client.eventos.EventoPaginaPerguntas;
import br.com.idecaph.client.eventos.EventoPaginaPerguntasHandler;
import br.com.idecaph.client.eventos.EventoRelatorios;
import br.com.idecaph.client.eventos.EventoRelatoriosHandler;
import br.com.idecaph.client.eventos.EventoResponderPesquisa;
import br.com.idecaph.client.eventos.EventoResponderPesquisaFuncionario;
import br.com.idecaph.client.eventos.EventoResponderPesquisaFuncionarioHandler;
import br.com.idecaph.client.eventos.EventoResponderPesquisaHandler;
import br.com.idecaph.client.utils.FuncionariosHelper;
import br.com.idecaph.client.view.ExibirRelatorioView;
import br.com.idecaph.client.view.FuncionariosView;
import br.com.idecaph.client.view.NovoFuncionarioView;
import br.com.idecaph.client.view.PerguntasPesquisaView;
import br.com.idecaph.client.view.RelatoriosView;
import br.com.idecaph.client.view.ResponderPesquisaFuncionarioView;
import br.com.idecaph.client.view.ResponderPesquisaView;
import br.com.idecaph.client.view.novaPesquisa.AvaliadosPesquisaView;
import br.com.idecaph.client.view.novaPesquisa.NovaPesquisaView;
import br.com.idecaph.client.view.novaPesquisa.ParticipantesPesquisaView;
import br.com.idecaph.shared.Funcionario;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.Pesquisa;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConteudoPresenter extends Presenter<ConteudoDisplay> {
	private static final int TELA_FUNCIONARIOS = 0;
	private static final int TELA_PARTICIPANTES_PESQUISA = 1;
	private static final int TELA_NOVO_FUNCIONARIO = 2;
	private static final int TELA_EDITAR_FUNCIONARIO = 3;
	private static final int TELA_NOVA_PESQUISA = 4;
	private static final int TELA_AVALIADOS_PESQUISA = 5;
	private static final int TELA_PERGUNTAS_PESQUISA = 6;
	private static final int TELA_RELATORIOS = 7;
	private static final int TELA_EXIBIR_RELATORIO = 8;
	private static final int TELA_RESPONDER_PESQUISA = 9;
	private static final int TELA_RESPONDER_PESQUISA_FUNCIONARIO = 10;
	private ComplexPanel bodyPanel = new VerticalPanel();
	private List<Funcionario> funcionarios;

	public ConteudoPresenter(ConteudoDisplay display, HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {

		eventBus.addHandler(EventoExibeFuncionarios.TYPE,
				new EventoExibeFuncionariosHandler() {

					@Override
					public void onEventoExibeFuncionarios(
							EventoExibeFuncionarios eventoExibeFuncionarios) {
						funcionarios = eventoExibeFuncionarios
								.getFuncionarios();
						carregaTela(TELA_FUNCIONARIOS);
					}
				});

		eventBus.addHandler(EventoNovoFuncionario.TYPE,
				new EventoNovoFuncionarioHandler() {

					@Override
					public void onEventoNovoFuncionario(
							EventoNovoFuncionario eventoNovoFuncionario) {
						carregaTelaNovoFuncionario();
					}
				});

		eventBus.addHandler(EventoEditarFuncionario.TYPE,
				new EventoEditarFuncionarioHandler() {

					@Override
					public void onEventoEditarFuncionario(
							EventoEditarFuncionario eventoEditarFuncionario) {
						carregaTelaEditarFuncionario(eventoEditarFuncionario
								.getFuncionario());
					}
				});

		eventBus.addHandler(EventoNovaPesquisa.TYPE,
				new EventoNovaPesquisaHandler() {

					@Override
					public void onEventoNovaPesquisa(
							EventoNovaPesquisa eventoNovaPesquisa) {
						List<FuncionarioSelecionavel> funcionarioSelecionados = eventoNovaPesquisa
								.getFuncionarios();
						if (funcionarioSelecionados == null) {
							funcionarioSelecionados = novaLista();
						}
						carregaTelaNovaPesquisa(funcionarioSelecionados);
					}
				});

		eventBus.addHandler(EventoPaginaParticipantes.TYPE,
				new EventoPaginaParticipantesHandler() {

					@Override
					public void onEventoPaginaParticipantes(
							EventoPaginaParticipantes eventoPaginaParticipantes) {
						carregaTelaParticipantesPesquisa(eventoPaginaParticipantes
								.getPesquisa());
					}
				});

		eventBus.addHandler(EventoCarregaFuncionarios.TYPE,
				new EventoCarregaFuncionariosHandler() {

					@Override
					public void onEventoCarregaFuncionarios(
							EventoCarregaFuncionarios eventoCarregaFuncionarios) {
						funcionarios = eventoCarregaFuncionarios
								.getFuncionarios();
					}
				});

		eventBus.addHandler(EventoCarregaPesquisa.TYPE,
				new EventoCarregaPesquisaHandler() {

					@Override
					public void onEventoCarregaPesquisa(
							EventoCarregaPesquisa eventoCarregaPesquisa) {
						funcionarios = eventoCarregaPesquisa.getFuncionarios();
						List<FuncionarioSelecionavel> funcionariosSelecionados = novaLista();
						carregaTelaNovaPesquisa(funcionariosSelecionados);
					}
				});

		eventBus.addHandler(EventoPaginaAvaliados.TYPE,
				new EventoPaginaAvaliadosHandler() {

					@Override
					public void onEventoAvaliadosPesquisa(
							EventoPaginaAvaliados eventoAvaliadosPesquisa) {
						carregaTelaAvaliadosPesquisa(eventoAvaliadosPesquisa
								.getPesquisa());
					}
				});

		eventBus.addHandler(EventoPaginaPerguntas.TYPE,
				new EventoPaginaPerguntasHandler() {

					@Override
					public void onEventoPaginaPerguntas(
							EventoPaginaPerguntas eventoPaginaPerguntas) {
						carregaTelaPerguntasPesquisa(eventoPaginaPerguntas
								.getPesquisa());
					}
				});

		eventBus.addHandler(EventoRelatorios.TYPE,
				new EventoRelatoriosHandler() {

					@Override
					public void onEventoRelatorios(
							EventoRelatorios eventoRelatorios) {
						carregaTelaRelatorios();
					}
				});

		eventBus.addHandler(EventoExibirRelatorio.TYPE,
				new EventoExibirRelatorioHandler() {

					@Override
					public void onEventoExibirRelatorio(
							EventoExibirRelatorio eventoExibirRelatorio) {
						carregaTelaExibirRelatorio(eventoExibirRelatorio
								.getFuncionario(), eventoExibirRelatorio.getPesquisa());
					}
				});

		eventBus.addHandler(EventoResponderPesquisa.TYPE,
				new EventoResponderPesquisaHandler() {

					@Override
					public void onEventoResponderPesquisa(
							EventoResponderPesquisa eventoResponderPesquisa) {
						carregaTelaResponderPesquisa();
					}
				});

		eventBus.addHandler(EventoResponderPesquisaFuncionario.TYPE,
				new EventoResponderPesquisaFuncionarioHandler() {

					@Override
					public void onEventoResponderPesquisaFuncionario(
							EventoResponderPesquisaFuncionario eventoResponderPesquisaFuncionario) {
						carregaTelaResponderPesquisaFuncionario(eventoResponderPesquisaFuncionario
								.getFuncionario(), eventoResponderPesquisaFuncionario.getPesquisa());
					}
				});
	}

	private void carregaTelaResponderPesquisaFuncionario(Funcionario funcionario, Pesquisa pesquisa) {
		carregaTela(TELA_RESPONDER_PESQUISA_FUNCIONARIO, funcionario, null, pesquisa);
	}

	private void carregaTelaResponderPesquisa() {
		carregaTela(TELA_RESPONDER_PESQUISA);
	}

	private void carregaTelaExibirRelatorio(Funcionario funcionario, Pesquisa pesquisa) {
		carregaTela(TELA_EXIBIR_RELATORIO, funcionario, null, pesquisa);
	}

	private void carregaTelaRelatorios() {
		carregaTela(TELA_RELATORIOS, null, null, null);

	}

	private List<FuncionarioSelecionavel> novaLista() {
		List<FuncionarioSelecionavel> funcionariosSelecionados = new ArrayList<FuncionarioSelecionavel>();
		for (Funcionario funcionario : funcionarios) {
			FuncionarioSelecionavel funcionarioSelecionado = new FuncionarioSelecionavel(
					funcionario);
			funcionariosSelecionados.add(funcionarioSelecionado);
		}
		return funcionariosSelecionados;
	}

	private void carregaTela(int tela) {
		carregaTela(tela, null, null);
	}

	private void carregaTelaFuncionarios() {
		FuncionariosHelper funcionariosHelper = new FuncionariosHelper(
				eventBus, true);
		funcionariosHelper.getFuncionarios();
	}

	private void carregaTelaNovoFuncionario() {
		carregaTela(TELA_NOVO_FUNCIONARIO);
	}

	private void carregaTelaEditarFuncionario(Funcionario funcionario) {
		carregaTela(TELA_EDITAR_FUNCIONARIO, funcionario, null);
	}

	private void carregaTelaNovaPesquisa(List<FuncionarioSelecionavel> list) {
		carregaTela(TELA_NOVA_PESQUISA, null, list);
	}

	private void carregaTelaParticipantesPesquisa(Pesquisa pesquisa) {
		carregaTela(TELA_PARTICIPANTES_PESQUISA, null, null, pesquisa);
	}

	private void carregaTelaAvaliadosPesquisa(Pesquisa pesquisa) {
		carregaTela(TELA_AVALIADOS_PESQUISA, null, null, pesquisa);
	}

	private void carregaTelaPerguntasPesquisa(Pesquisa pesquisa) {
		carregaTela(TELA_PERGUNTAS_PESQUISA, null, null, pesquisa);
	}

	private void carregaTela(int tela, Funcionario funcionario,
			List<FuncionarioSelecionavel> funcionarios) {
		carregaTela(tela, funcionario, funcionarios, null);
	}

	private void carregaTela(int tela, Funcionario funcionario,
			List<FuncionarioSelecionavel> funcionarios, Pesquisa pesquisa) {
		this.container.remove(bodyPanel);
		this.bodyPanel.clear();
		switch (tela) {
		case TELA_FUNCIONARIOS:
			Presenter<FuncionariosDisplay> funcionarioPresenter = new FuncionariosPresenter(
					new FuncionariosView(), eventBus, this.funcionarios);
			funcionarioPresenter.go(this.bodyPanel);
			break;
		case TELA_NOVO_FUNCIONARIO:
			Presenter<NovoFuncionarioDisplay> novoFuncionarioPresenter = new NovoFuncionarioPresenter(
					new NovoFuncionarioView(), eventBus);
			novoFuncionarioPresenter.go(this.bodyPanel);
			break;
		case TELA_EDITAR_FUNCIONARIO:
			Presenter<NovoFuncionarioDisplay> editarFuncionarioPresenter = new NovoFuncionarioPresenter(
					new NovoFuncionarioView(), eventBus, funcionario);
			editarFuncionarioPresenter.go(this.bodyPanel);
			break;
		case TELA_NOVA_PESQUISA:
			pesquisa = new Pesquisa(null, funcionarios, funcionarios, null);
			Presenter<NovaPesquisaDisplay> novaPesquisaPresenter = new NovaPesquisaPresenter(
					new NovaPesquisaView(), eventBus, pesquisa);
			novaPesquisaPresenter.go(this.bodyPanel);
			break;
		case TELA_PARTICIPANTES_PESQUISA:
			Presenter<ParticipantesPesquisaDisplay> participantesPesquisaPresenter = new ParticipantesPesquisaPresenter(
					new ParticipantesPesquisaView(), eventBus, pesquisa);
			participantesPesquisaPresenter.go(this.bodyPanel);
			break;
		case TELA_AVALIADOS_PESQUISA:
			Presenter<AvaliadosPesquisaDisplay> avaliadosPesquisaPresenter = new AvaliadosPesquisaPresenter(
					new AvaliadosPesquisaView(), eventBus, pesquisa);
			avaliadosPesquisaPresenter.go(this.bodyPanel);
			break;
		case TELA_PERGUNTAS_PESQUISA:
			Presenter<PerguntasPesquisaDisplay> perguntasPesquisaPresenter = new PerguntasPesquisaPresenter(
					new PerguntasPesquisaView(), eventBus, pesquisa);
			perguntasPesquisaPresenter.go(this.bodyPanel);
			break;
		case TELA_RELATORIOS:
			Presenter<RelatoriosDisplay> relatoriosPresenter = new RelatoriosPresenter(
					new RelatoriosView(), eventBus);
			relatoriosPresenter.go(this.bodyPanel);
			break;
		case TELA_EXIBIR_RELATORIO:
			Presenter<ExibirRelatorioDisplay> exibirRelatorioPresenter = new ExibirRelatorioPresenter(
					new ExibirRelatorioView(), eventBus, funcionario, pesquisa);
			exibirRelatorioPresenter.go(this.bodyPanel);
			break;
		case TELA_RESPONDER_PESQUISA:
			Presenter<ResponderPesquisaDisplay> responderPesquisaPresenter = new ResponderPesquisaPresenter(
					new ResponderPesquisaView(), eventBus);
			responderPesquisaPresenter.go(this.bodyPanel);
			break;
		case TELA_RESPONDER_PESQUISA_FUNCIONARIO:
			Presenter<ResponderPesquisaFuncionarioDisplay> responderPesquisaFuncionarioPresenter = new ResponderPesquisaFuncionarioPresenter(
					new ResponderPesquisaFuncionarioView(), eventBus, funcionario, pesquisa.getPerguntas());
			responderPesquisaFuncionarioPresenter.go(this.bodyPanel);
			break;
		default:
			throw new UnsupportedOperationException("Link inválido");
		}

		super.container.add(bodyPanel);
	}

	@Override
	public void go(HasWidgets container) {
		super.go(container);
		carregaTelaFuncionarios();
	}

}
