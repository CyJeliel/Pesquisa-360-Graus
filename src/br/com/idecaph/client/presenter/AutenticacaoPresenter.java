package br.com.idecaph.client.presenter;

import br.com.idecaph.client.display.AutenticacaoDisplay;
import br.com.idecaph.client.eventos.EventoLogout;
import br.com.idecaph.client.eventos.handlers.EventoLogoutHandler;
import br.com.idecaph.client.interfaces.AutenticacaoService;
import br.com.idecaph.client.interfaces.AutenticacaoServiceAsync;
import br.com.idecaph.client.view.CabecalhoAdministracaoView;
import br.com.idecaph.client.view.ConteudoView;

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

	private ConteudoPresenter conteudoPresenter;

	private CabecalhoAdministracaoPresenter cabecalhoPresenter;

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
		rpcService.login(login, senha, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Login ou senha incorretos.");
			}

			@Override
			public void onSuccess(Boolean result) {

				if (result) {

					carregaTelaInicial();

				} else {

					Window.alert("Login ou senha incorretos.");
				}
			}
		});
	}

	private void carregaTelaInicial() {

		RootPanel.get().clear();

		showCabecalhoPresenter();

		showConteudoPresenter();
	}

	private void showConteudoPresenter() {
		
		if (conteudoPresenter == null) {
		
			conteudoPresenter = new ConteudoPresenter(new ConteudoView(),
					eventBus);
			
			conteudoPresenter.go(RootPanel.get());
		
		} else {
		
			conteudoPresenter.carregaTelaFuncionarios();
		}
	}

	private void showCabecalhoPresenter() {
		
		if (cabecalhoPresenter == null) {
		
			cabecalhoPresenter = new CabecalhoAdministracaoPresenter(
					new CabecalhoAdministracaoView(), eventBus);
			
			cabecalhoPresenter.go(RootPanel.get());
		
		} else {
		
			cabecalhoPresenter.show(RootPanel.get());
		}
	}

}
