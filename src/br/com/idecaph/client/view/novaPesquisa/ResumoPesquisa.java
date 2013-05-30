package br.com.idecaph.client.view.novaPesquisa;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ResumoPesquisa extends Composite {

	private static ResumoPesquisaUiBinder uiBinder = GWT
			.create(ResumoPesquisaUiBinder.class);

	interface ResumoPesquisaUiBinder extends UiBinder<Widget, ResumoPesquisa> {
	}

	public ResumoPesquisa() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
