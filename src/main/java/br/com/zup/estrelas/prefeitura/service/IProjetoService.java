package br.com.zup.estrelas.prefeitura.service;

import java.util.List;

import br.com.zup.estrelas.prefeitura.dto.AlteraProjetoDTO;
import br.com.zup.estrelas.prefeitura.dto.DataFinalProjetoDTO;
import br.com.zup.estrelas.prefeitura.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.dto.ProjetoDTO;
import br.com.zup.estrelas.prefeitura.entity.Projeto;

public interface IProjetoService {

	public MensagemDTO adicionaProjeto(ProjetoDTO projetoDto);

	public MensagemDTO finalizaProjeto(Long idProjeto, DataFinalProjetoDTO dataFinalProjetoDto);

	public MensagemDTO alteraProjeto(Long idProjeto, AlteraProjetoDTO alterarojetoDto);

	public Projeto consultaProjeto(Long idProjeto);

	public List<Projeto> listaProjetos();

}
