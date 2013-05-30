package br.com.idecaph.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HierarquiaView extends Composite {

	private static HierarquiaViewUiBinder uiBinder = GWT
			.create(HierarquiaViewUiBinder.class);

	interface HierarquiaViewUiBinder extends UiBinder<Widget, HierarquiaView> {
	}

	public HierarquiaView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
