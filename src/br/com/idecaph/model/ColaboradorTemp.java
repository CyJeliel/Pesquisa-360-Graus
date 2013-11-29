package br.com.idecaph.model;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import br.com.idecaph.dao.PMF;

@PersistenceCapable
public class ColaboradorTemp extends Model<ColaboradorTemp> {
	@NotPersistent
	private static final Logger log = Logger.getLogger(ColaboradorTemp.class
			.getName());

	@SuppressWarnings("unused")
	@Persistent
	private String idEmpresa;

	@Persistent
	private String cargo;

	@Persistent
	private String nome;

	@PrimaryKey
	@Persistent
	private String email;

	@Persistent
	private String area;

	@Persistent
	private String departamento;

	@Persistent
	private String escolaridade;

	@Persistent
	private String sexo;

	@Persistent
	private String telefone;

	@Persistent
	private String celular;

	@Persistent
	private String cpf;

	@Persistent
	private Double dataAdmissao;

	@Persistent
	private Double dataDemissao;

	public ColaboradorTemp(String idEmpresa, String cargo, String nome,
			String email, String area, String departamento,
			String escolaridade, String sexo, String telefone, String celular,
			String cpf, Double dataAdmissao, Double dataDemissao) {
		this.idEmpresa = idEmpresa;
		this.cargo = cargo;
		this.nome = nome;
		this.email = email;
		this.area = area;
		this.departamento = departamento;
		this.escolaridade = escolaridade;
		this.sexo = sexo;
		this.telefone = telefone;
		this.celular = celular;
		this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}

	public String getCargo() {
		return cargo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getArea() {
		return area;
	}

	public String getDepartamento() {
		return departamento;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getDataAdmissao() {
		return dataAdmissao;
	}

	public Double getDataDemissao() {
		return dataDemissao;
	}

	public static boolean saveAll(List<ColaboradorTemp> colaboradores) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean retorno = true;
		try {
			pm.makePersistentAll(colaboradores);
		} catch (Exception e) {
			retorno = false;
		} finally {
			pm.close();
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public static List<ColaboradorTemp> getAllByIdEmpresa(String idEmpresa) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(ColaboradorTemp.class);
		query.setFilter("idEmpresa == " + idEmpresa);
		List<ColaboradorTemp> colaboradores = null;
		try {
			colaboradores = (List<ColaboradorTemp>) query.execute();
			colaboradores.size();
		} catch (Exception e) {
			log.severe(e.toString());
		} finally {
			pm.close();
		}
		return colaboradores;
	}

	@Override
	public boolean update(ColaboradorTemp t) {
		// TODO Auto-generated method stub
		return false;
	}
}
