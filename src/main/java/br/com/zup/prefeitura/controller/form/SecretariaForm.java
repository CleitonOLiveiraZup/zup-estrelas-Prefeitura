package br.com.zup.prefeitura.controller.form;


import br.com.zup.estrelas.prefeitura.entity.Secretaria;
import br.com.zup.estrelas.prefeitura.enums.DepartamentoPrefeitura;
import br.com.zup.estrelas.prefeitura.repository.SecretariaRepository;

public class SecretariaForm {
	
	
	private double orcamentoProjetos;
	private double orcamentoFolha ;
	private DepartamentoPrefeitura area;
	private String telefone;
	private String endereco;
	private String site;
	private String email;
	
	
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
	public DepartamentoPrefeitura getArea() {
		return area;
	}
	public void setArea(DepartamentoPrefeitura area) {
		this.area = area;
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
	public Secretaria converter() {
		
		return new Secretaria(area, orcamentoProjetos, orcamentoFolha, telefone, endereco, site, email);
	}
	public Secretaria alterar(Long idSecretaria, SecretariaRepository secretariaRepository) {
		Secretaria secretaria = secretariaRepository.getOne(idSecretaria);
		
		secretaria.setArea(this.area);
		secretaria.setEmail(this.email);
		secretaria.setEndereco(this.endereco);
		secretaria.setOrcamentoFolha(this.orcamentoFolha);
		secretaria.setOrcamentoProjetos(this.orcamentoProjetos);
		secretaria.setSite(this.site);
		secretaria.setTelefone(this.telefone);
		
		return secretaria;
	}
	
	

}
