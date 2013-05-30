package br.com.idecaph.client.view.novaPesquisa;

import java.util.List;

import br.com.idecaph.client.display.ParticipantesPesquisaDisplay;
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

public class ParticipantesPesquisaView extends
		TableView<FuncionarioSelecionavel> implements
		ParticipantesPesquisaDisplay {
	@UiField
	CellPanel body;
	@UiField
	FlexTable tabelaParticipantes;
	@UiField
	Image proximaPagina;

	private static ParticipantesPesquisaViewUiBinder uiBinder = GWT
			.create(ParticipantesPesquisaViewUiBinder.class);

	interface ParticipantesPesquisaViewUiBinder extends
			UiBinder<Widget, ParticipantesPesquisaView> {
	}

	public ParticipantesPesquisaView() {
		initWidget(uiBinder.createAndBindUi(this));
		super.setTable(tabelaParticipantes);
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
		CheckBox checkBox = (CheckBox) tabelaParticipantes.getWidget(0, 0);
		checkBox.setValue(true);
	}

	@Override
	public void marcarSelecionados(List<FuncionarioSelecionavel> todos) {
		for (int i = 0; i < todos.size(); ++i) {
			FuncionarioSelecionavel funcionarioSelecionavel = todos.get(i);
			if (funcionarioSelecionavel.isSelecionado()) {
				CheckBox checkBox = (CheckBox) tabelaParticipantes.getWidget(
						i + 1, 0);
				checkBox.setValue(true);
			}
		}
	}

}
