package br.com.idecaph.client.view.colunas;

import java.util.List;

import br.com.idecaph.shared.FuncionarioSelecionavel;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class FuncionarioEditavelColunas extends FuncionarioColunas {
	public FuncionarioEditavelColunas() {
		super();
		super.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				Image image = new Image("/img/editar.png");
				image.setTitle("Editar funcionário");
				return image;
			}

			public boolean isClickable() {
				return true;
			}
		});
		super.add(new Coluna<FuncionarioSelecionavel>() {

			@Override
			public Widget render(FuncionarioSelecionavel dado) {
				Image image = new Image("/img/excluir.png");
				image.setTitle("Excluir funcionário");
				return image;
			}

			public boolean isClickable() {
				return true;
			}
		});
	}

	public List<Coluna<FuncionarioSelecionavel>> getColunas() {
		return super.getDefinicoesColunas();
	}
}
