package br.com.idecaph.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.model.Funcionarios;
import br.com.idecaph.model.Model;
import br.com.idecaph.shared.Funcionario;

public class FuncionariosMock extends Model<Funcionarios, Funcionario> {

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	public static List<Funcionarios> getAll() {
		List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
		Funcionarios funcionario1  = new Funcionarios("8351569", "gerente de projetos","Cindy de Albuquerque",          "TI");
		Funcionarios funcionario2  = new Funcionarios("4954631", "diretor operacional","Helio Campos Mello de Andrade", "TI");
		Funcionarios funcionario3  = new Funcionarios("3346314", "diretor",            "Lia Mara Lourenço",             "marketing");
		Funcionarios funcionario4  = new Funcionarios("4954333", "desenvolvedor",      "Henrique Pereira",              "desenvolvimento");
		Funcionarios funcionario5  = new Funcionarios("4823197", "analista de testes", "Tereza Andrade",                "desenvolvimento");
		Funcionarios funcionario6  = new Funcionarios("8217653", "desenvolvedor",      "Arivaldo Guedes",               "desenvolvimento");
		Funcionarios funcionario7  = new Funcionarios("3386918", "P.O.",               "Andrea Carvalho",               "desenvolvimento");
		Funcionarios funcionario8  = new Funcionarios("7445412", "Scrum Master",       "Estevão Mello",                 "desenvolvimento");
		Funcionarios funcionario9  = new Funcionarios("4790897", "web designer",       "Victor Campos",                 "design");
		Funcionarios funcionario10 = new Funcionarios("9226771", "vendedor",           "André Conde",                   "comercial");
		Funcionarios funcionario11 = new Funcionarios("3735329", "administrador",      "Camilla Navarro",               "administração");
		funcionarios.add(funcionario1);
		funcionarios.add(funcionario2);
		funcionarios.add(funcionario3);
		funcionarios.add(funcionario4);
		funcionarios.add(funcionario5);
		funcionarios.add(funcionario6);
		funcionarios.add(funcionario7);
		funcionarios.add(funcionario8);
		funcionarios.add(funcionario9);
		funcionarios.add(funcionario10);
		funcionarios.add(funcionario11);
//		funcionarios.removeAll(funcionarios);
		return funcionarios;
	}

	@Override
	public boolean update(Funcionario object) {
		// TODO Auto-generated method stub
		return false;
	}

}
