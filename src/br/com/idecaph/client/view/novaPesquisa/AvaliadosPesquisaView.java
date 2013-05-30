package br.com.idecaph.client.view.novaPesquisa;

import java.util.List;

import br.com.idecaph.client.display.AvaliadosPesquisaDisplay;
import br.com.idecaph.client.view.TableView;
import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class AvaliadosPesquisaView extends
		TableView<FuncionarioSelecionavel> implements
		AvaliadosPesquisaDisplay {

	@UiField
	CellPanel body;
	@UiField
	FlexTable tabelaAvaliados;
	@UiField
	Image proximaPagina;
	
	private static AvaliadosPesquisaViewUiBinder uiBinder = GWT
			.create(AvaliadosPesquisaViewUiBinder.class);

	interface AvaliadosPesquisaViewUiBinder extends
			UiBinder<Widget, AvaliadosPesquisaView> {
	}

	public AvaliadosPesquisaView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaAvaliados);
	}

	@Override
	public Widget asWidget() {
		return body;
	}

	@Override
	public HasClickHandlers getAcaoProximaEtapa() {
		return proximaPagina;
	}

	@Override
	public void setCheckBoxTituloSelecionado() {
		CheckBox checkBox = (CheckBox) tabelaAvaliados.getWidget(0, 0);
		checkBox.setValue(true);
	}

	public void marcarSelecionados(List<FuncionarioSelecionavel> todos) {
		for (int i = 0; i < todos.size(); ++i){
			FuncionarioSelecionavel funcionarioSelecionavel = todos.get(i);
			if (funcionarioSelecionavel.isSelecionado()){
				CheckBox checkBox = (CheckBox) tabelaAvaliados.getWidget(i+1, 0);
				checkBox.setValue(true);
			}
		}
	}
}
