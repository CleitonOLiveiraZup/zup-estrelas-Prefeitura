package br.com.zup.estrelas.prefeitura.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.estrelas.prefeitura.entity.Secretaria;
import br.com.zup.estrelas.prefeitura.enums.DepartamentoPrefeitura;

public class SecretariaDTO {

	Long idSecretaria;

	private double orcamentoProjetos;

	private double orcamentoFolha;

	private DepartamentoPrefeitura area;
	private String telefone;
	private String endereco;
	private String site;
	private String email;

	public SecretariaDTO(Long idSecretaria, double orcamentoProjetos, double orcamentoFolha,
			DepartamentoPrefeitura area, String telefone, String endereco, String site, String email) {
		super();
		this.idSecretaria = idSecretaria;
		this.orcamentoProjetos = orcamentoProjetos;
		this.orcamentoFolha = orcamentoFolha;
		this.area = area;
		this.telefone = telefone;
		this.endereco = endereco;
		this.site = site;
		this.email = email;
	}

	public SecretariaDTO(Secretaria secretaria) {

		this.orcamentoProjetos = secretaria.getOrcamentoProjetos();
		this.orcamentoFolha = secretaria.getOrcamentoFolha();
		this.area = secretaria.getArea();
		this.telefone = secretaria.getTelefone();
		this.endereco = secretaria.getEndereco();
		this.site = secretaria.getSite();
		this.email = secretaria.getEmail();

	}

	public Long getIdSecretaria() {
		return idSecretaria;
	}

	public DepartamentoPrefeitura getArea() {
		return area;
	}

	public double getOrcamentoProjetos() {
		return orcamentoProjetos;
	}

	public double getOrcamentoFolha() {
		return orcamentoFolha;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getSite() {
		return site;
	}

	public String getEmail() {
		return email;
	}

	public static List<SecretariaDTO> converter(List<Secretaria> secretaria) {

		return secretaria.stream().map(SecretariaDTO::new).collect(Collectors.toList());
	}

}
