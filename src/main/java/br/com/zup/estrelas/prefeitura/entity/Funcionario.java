package br.com.zup.estrelas.prefeitura.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@Column(name = "id_funcionario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncionario;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private Double salario;

	@ManyToOne
	private Secretaria secretaria;

	@Column(nullable = false)
	private String funcao;

	@Column(nullable = false)
	private Boolean concursado;

	@Column(nullable = false)
	private LocalDate dataAdmissao;

	public Funcionario() {

	}

	public Funcionario(Long idFuncionario, String nome, String cpf, Double salario, Secretaria secretaria,
			String funcao, Boolean concursado, LocalDate dataAdmissao) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.secretaria = secretaria;
		this.funcao = funcao;
		this.concursado = concursado;
		this.dataAdmissao = dataAdmissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Boolean getConcursado() {
		return concursado;
	}

	public void setConcursado(Boolean concursado) {
		this.concursado = concursado;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}