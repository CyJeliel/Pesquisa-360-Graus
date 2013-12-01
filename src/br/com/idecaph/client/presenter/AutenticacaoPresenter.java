package br.com.idecaph.client.presenter;

import java.util.List;

import br.com.idecaph.client.display.AutenticacaoDisplay;
import br.com.idecaph.client.eventos.EventoLogout;
import br.com.idecaph.client.eventos.handlers.EventoLogoutHandler;
import br.com.idecaph.client.interfaces.AutenticacaoService;
import br.com.idecaph.client.interfaces.AutenticacaoServiceAsync;
import br.com.idecaph.client.interfaces.PesquisaService;
import br.com.idecaph.client.interfaces.PesquisaServiceAsync;
import br.com.idecaph.client.view.CabecalhoAdministracaoView;
import br.com.idecaph.client.view.CabecalhoView;
import br.com.idecaph.client.view.ConteudoView;
import br.com.idecaph.shared.FuncionarioClient;
import br.com.idecaph.shared.PesquisaClient;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

public class AutenticacaoPresenter extends Presenter<AutenticacaoDisplay> {

	public HandlerRegistration handler;

	private AutenticacaoServiceAsync rpcService = GWT
			.create(AutenticacaoService.class);

	private PesquisaServiceAsync rpcPesquisaService = GWT
			.create(PesquisaService.class);

	private ConteudoPresenter conteudoPresenter;

	private CabecalhoPresenter cabecalhoPresenter;

	public AutenticacaoPresenter(AutenticacaoDisplay display,
			HandlerManager eventBus) {
		super(display, eventBus);
	}

	@Override
	public void bind() {

		final AutenticacaoDisplay display = super.getDisplay();

		if (handler != null) {
			handler.removeHandler();
		}

		handler = display.getAcaoLogin().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				String login = display.getTextLogin().getText();

				String senha = display.getTextSenha().getText();

				login(login, senha);
			}
		});

		eventBus.addHandler(EventoLogout.TYPE, new EventoLogoutHandler() {

			@Override
			public void onEventoLogout(EventoLogout eventoLogout) {
				logout();
			}
		});

	}

	private void logout() {
		rpcService.logout(new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				carregaPaginaLogin();
			}

			@Override
			public void onSuccess(Void result) {
				carregaPaginaLogin();
			}
		});
	}

	private void carregaPaginaLogin() {

		RootPanel.get().clear();

		show(RootPanel.get());
	}

	private void login(String login, String senha) {
		rpcService.login(login, senha, new AsyncCallback<FuncionarioClient>() {

			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Login ou senha incorretos.");
			}

			@Override
			public void onSuccess(FuncionarioClient result) {

				if (result != null) {

					carregaTelaInicial(result.isAdmin());

				} else {

					Window.alert("Login ou senha incorretos.");
				}
			}
		});
	}

	private void carregaTelaInicial(Boolean isAdmin) {

		RootPanel.get().clear();

		showCabecalhoPresenter(isAdmin);

		showConteudoPresenter(isAdmin);
	}

	private void showConteudoPresenter(Boolean isAdmin) {

		if (conteudoPresenter == null) {

			conteudoPresenter = new ConteudoPresenter(new ConteudoView(),
					eventBus);

			if (isAdmin) {
				conteudoPresenter.go(RootPanel.get());
			} else {
				showTelaInicialFuncionarios();
			}
		} else {
			if (isAdmin) {
				conteudoPresenter.showTelaInicialAdministracao();
			} else {
				showTelaInicialFuncionarios();
			}
		}
	}

	private void showTelaInicialFuncionarios() {
		
		rpcPesquisaService.getPesquisasPorParticipante(new AsyncCallback<List<PesquisaClient>>() {
			
			@Override
			public void onSuccess(List<PesquisaClient> result) {
				conteudoPresenter.goFuncionarios(RootPanel.get(), result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erro ao buscar pesquisas. Por favor, contate o administrador do sistema.");
			}
		});
	}

	private void showCabecalhoPresenter(Boolean isAdmin) {

		if (cabecalhoPresenter == null) {

			buildCabecalhoPresenter(isAdmin);

			cabecalhoPresenter.go(RootPanel.get());

		} else {

			if ((isAdmin && !(cabecalhoPresenter instanceof CabecalhoAdministracaoPresenter))
					|| (!isAdmin && !(cabecalhoPresenter instanceof CabecalhoFuncionarioPresenter))) {
				
				buildCabecalhoPresenter(isAdmin);
			}
		}

		cabecalhoPresenter.go(RootPanel.get());
	}

	private void buildCabecalhoPresenter(Boolean isAdmin) {

		if (isAdmin) {
			cabecalhoPresenter = new CabecalhoAdministracaoPresenter(
					new CabecalhoAdministracaoView(), eventBus);

		} else {

			cabecalhoPresenter = new CabecalhoFuncionarioPresenter(
					new CabecalhoView(), eventBus);
		}
	}

}
