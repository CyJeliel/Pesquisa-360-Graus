package br.com.idecaph.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.idecaph.model.Model;
import br.com.idecaph.shared.FuncionarioSelecionavel;
import br.com.idecaph.shared.Pergunta;
import br.com.idecaph.shared.Pesquisa;

public class PesquisaMock extends Model<Pesquisa, Pesquisa> {

	@Override
	public boolean update(Pesquisa u) {
		// TODO Auto-generated method stub
		return false;
	}

	public static List<Pesquisa> getAll() {
		List<FuncionarioSelecionavel> avaliados = getAvaliados();
		List<Pergunta> perguntas = getPerguntas();
		
		List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
		Pesquisa pesquisa1 = new Pesquisa("Pesquisa RH", avaliados, avaliados, perguntas);
		Pesquisa pesquisa2 = new Pesquisa("Pesquisa TI", avaliados, avaliados, perguntas);
		Pesquisa pesquisa3 = new Pesquisa("Pesquisa NOVEMBRO/2012", avaliados, avaliados, perguntas);
		pesquisas.add(pesquisa1);
		pesquisas.add(pesquisa2);
		pesquisas.add(pesquisa3);
		return pesquisas;
	}

	public static Pesquisa getPesquisa() {
		List<FuncionarioSelecionavel> avaliados = getAvaliados();
		List<Pergunta> perguntas = getPerguntas();
		Pesquisa pesquisa = new Pesquisa("Pesquisa TI", avaliados, avaliados, perguntas );
		return pesquisa;
	}

	private static List<Pergunta> getPerguntas() {
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
		Pergunta pergunta1 = new Pergunta("Como você avalia a habilidade de comunicação oral desse profissional?", null);
		Pergunta pergunta2 = new Pergunta("Como você avalia a habilidade de comunicação escrita desse profissional?", null);
		Pergunta pergunta3 = new Pergunta("O profissional consegue realizar as atividades que lhe são atribuídas?", null);
		Pergunta pergunta4 = new Pergunta("O profissional realiza suas atividades com eficácia e eficiência?", null);
		Pergunta pergunta5 = new Pergunta("O profissional tem um bom relacionamento com seus clientes (internos ou externos)?", null);
		Pergunta pergunta6 = new Pergunta("O profissional é organizado?", null);
		Pergunta pergunta7 = new Pergunta("E FILHOS?", null);
		Pergunta pergunta8 = new Pergunta("Que tipo de música vc gosta?", null);
		Pergunta pergunta9 = new Pergunta("E de filmes?", null);
		Pergunta pergunta10 = new Pergunta("Quantos anos vc tem?", null);
		Pergunta pergunta11 = new Pergunta("Qual o seu nome", null);
		perguntas.add(pergunta1);
		perguntas.add(pergunta2);
		perguntas.add(pergunta3);
		perguntas.add(pergunta4);
		perguntas.add(pergunta5);
		perguntas.add(pergunta6);
		perguntas.add(pergunta7);
		perguntas.add(pergunta8);
		perguntas.add(pergunta9);
		perguntas.add(pergunta10);
		perguntas.add(pergunta11);
		return perguntas;
	}

	private static List<FuncionarioSelecionavel> getAvaliados() {
		List<FuncionarioSelecionavel> avaliados = new ArrayList<FuncionarioSelecionavel>();
		FuncionarioSelecionavel cindy   = new FuncionarioSelecionavel("Cindy de Albuquerque",          "8351569", "gerente de projetos", "TI",              false, "100%");
		FuncionarioSelecionavel helio   = new FuncionarioSelecionavel("Helio Campos Mello de Andrade", "4954631", "diretor operacional", "TI",              false, "100%");
		FuncionarioSelecionavel lia     = new FuncionarioSelecionavel("Lia Mara Lourenço",             "3346314", "diretor de marketing","marketing",       false, "50%");
		FuncionarioSelecionavel tina    = new FuncionarioSelecionavel("Tereza Andrade",                "4823197", "analista de testes",  "desenvolvimento", false, "60%");
		FuncionarioSelecionavel ari     = new FuncionarioSelecionavel("Arivaldo Guedes",               "8217653", "desenvolvedor",       "desenvolvimento", false, "40%");
		FuncionarioSelecionavel andrea  = new FuncionarioSelecionavel("Andrea Carvalho",               "3386918", "P.O.",                "desenvolvimento", false, "100%");
		FuncionarioSelecionavel victor  = new FuncionarioSelecionavel("Victor Campos",                 "4790897", "web designer",        "design",          false, "30%");
		FuncionarioSelecionavel estevao = new FuncionarioSelecionavel("Estevão Mello",                 "7445412", "Scrum Master",        "desenvolvimento", false, "20%");
		avaliados.add(cindy);
		avaliados.add(helio);
		avaliados.add(lia);
		avaliados.add(tina);
		avaliados.add(ari);
		avaliados.add(andrea);
		avaliados.add(victor);
		avaliados.add(estevao);
		return avaliados;
	}

}
