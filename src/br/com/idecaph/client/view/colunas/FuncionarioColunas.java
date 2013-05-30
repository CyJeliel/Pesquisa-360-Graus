package br.com.idecaph.client.view.colunas;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public abstract class FuncionarioColunas extends ListaColunas {
	private List<Coluna<FuncionarioSelecionavel>> definicoesColunas = new ArrayList<Coluna<FuncionarioSelecionavel>>();

	protected FuncionarioColunas() {
		super("Não há funcionários cadastrados.");
		definicoesColunas.add(new Coluna<FuncionarioSelecionavel>() {
			boolean selecionado = false;

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				CheckBox checkBox = new CheckBox();
				checkBox.setValue(selecionado);
				return checkBox;
			}

			public boolean isSelectable() {
				return true;
			}

			@Override
			public void setIsSelecionado(boolean selecionado) {
				this.selecionado = selecionado;
			}
		});
		addColunasDisplay();
	}
	
	protected FuncionarioColunas(String mensagemListaVazia){
		super(mensagemListaVazia);
		addColunasDisplay();
	}

	private void addColunasDisplay() {
		definicoesColunas.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				return new HTML(dado.getDisplayNome());
			}
		});
		definicoesColunas.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				return new HTML(dado.getDisplayIdentificacao());
			}
		});
		definicoesColunas.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				return new HTML(dado.getDisplayCargo());
			}
		});
		definicoesColunas.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				return new HTML(dado.getDisplayDepartamento());
			}
		});
	}

	public List<Coluna<FuncionarioSelecionavel>> getDefinicoesColunas() {
		return definicoesColunas;
	}

	protected void add(Coluna<FuncionarioSelecionavel> coluna) {
		definicoesColunas.add(coluna);
	}

}
