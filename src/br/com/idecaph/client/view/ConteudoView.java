package br.com.idecaph.client.view;

import br.com.idecaph.client.display.ConteudoDisplay;
import br.com.idecaph.client.display.HasFeedbackDisplay;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ConteudoView extends Composite implements ConteudoDisplay, HasFeedbackDisplay{

	private static ConteudoViewUiBinder uiBinder = GWT
			.create(ConteudoViewUiBinder.class);

	interface ConteudoViewUiBinder extends UiBinder<Widget, ConteudoView> {
	}

	public ConteudoView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void exibeErro(int tipoErro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exibeFeedback(int tipoFeedback) {
		// TODO Auto-generated method stub
		
	}

}
