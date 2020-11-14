package br.com.zup.estrelas.prefeitura.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.zup.estrelas.prefeitura.enums.DepartamentoPrefeitura;

@Entity
public class Secretaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idSecretaria;

	@Enumerated(EnumType.STRING)
	private DepartamentoPrefeitura area;

	@Column(name = "orcamento_Projetos", nullable = false)
	private double orcamentoProjetos;

	@Column(name = "orcamento_Folha", nullable = false)
	private double orcamentoFolha;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private String site;

	@Column(nullable = false)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "secretaria")
	@JsonManagedReference
	private List<Funcionario> funcionarios;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "secretaria")
	@JsonManagedReference
	private List<Projeto> projetos;

	public Secretaria() {

	}

	public Secretaria(DepartamentoPrefeitura area, double orcamentoProjetos, double orcamentoFolha, String telefone,
			String endereco, String site, String email) {
		super();
		this.area = area;
		this.orcamentoProjetos = orcamentoProjetos;
		this.orcamentoFolha = orcamentoFolha;
		this.telefone = telefone;
		this.endereco = endereco;
		this.site = site;
		this.email = email;
	}

	public Long getIdSecretaria() {
		return idSecretaria;
	}

	public void setIdSecretaria(Long idSecretaria) {
		this.idSecretaria = idSecretaria;
	}

	public DepartamentoPrefeitura getArea() {
		return area;
	}

	public void setArea(DepartamentoPrefeitura area) {
		this.area = area;
	}

	public double getOrcamentoProjetos() {
		return orcamentoProjetos;
	}

	public void setOrcamentoProjetos(double orcamentoProjetos) {
		this.orcamentoProjetos = orcamentoProjetos;
	}

	public double getOrcamentoFolha() {
		return orcamentoFolha;
	}

	public void setOrcamentoFolha(double orcamentoFolha) {
		this.orcamentoFolha = orcamentoFolha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
