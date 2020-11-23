package br.com.zup.estrelas.prefeitura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.prefeitura.dto.AlteraProjetoDTO;
import br.com.zup.estrelas.prefeitura.dto.DataFinalProjetoDTO;
import br.com.zup.estrelas.prefeitura.dto.MensagemDTO;
import br.com.zup.estrelas.prefeitura.dto.ProjetoDTO;
import br.com.zup.estrelas.prefeitura.entity.Projeto;
import br.com.zup.estrelas.prefeitura.entity.Secretaria;
import br.com.zup.estrelas.prefeitura.repository.ProjetoRepository;
import br.com.zup.estrelas.prefeitura.repository.SecretariaRepository;

@Service
public class ProjetoService implements IProjetoService {

	@Autowired
	ProjetoRepository projetoRepository;

	@Autowired
	SecretariaRepository secretariaRepository;

	public MensagemDTO adicionaProjeto(ProjetoDTO projetoDto) {

		if (projetoRepository.findByNome(projetoDto.getNome()).isPresent()) {
		    // FIXME: Crie constantes para as Strings literais.
			return new MensagemDTO("Projeto já cadastrado");
		}

		Optional<Secretaria> secretariaConsultada = secretariaRepository.findById(projetoDto.getIdSecretaria());
		//FIXME: Devemos sempre verificar com o isPresent antes de fazer o get.
		Secretaria secretaria = secretariaConsultada.get();

		if (secretaria.getOrcamentoProjetos() < projetoDto.getCusto()) {
	        // FIXME: Crie constantes para as Strings literais.
			return new MensagemDTO("orçamento insulficiente");
		}

		Projeto projeto = new Projeto();
		BeanUtils.copyProperties(projetoDto, projeto);
		projeto.setDataEntrega(null);
		projeto.setSecretaria(secretaria);
		projetoRepository.save(projeto);

		secretaria.setOrcamentoProjetos(secretaria.getOrcamentoProjetos() - projetoDto.getCusto());
		secretariaRepository.save(secretaria);

		return new MensagemDTO("Projeto cadastrado com sucesso.");
	}

	public Projeto consultaProjeto(Long idProjeto) {
		return projetoRepository.findById(idProjeto).orElse(null);
	}

	public MensagemDTO alteraProjeto(Long idProjeto, AlteraProjetoDTO alteraprojetoDto) {

		Optional<Projeto> projetoConsultado = projetoRepository.findById(idProjeto);

		if (projetoConsultado.isEmpty()) {
			return new MensagemDTO("Projeto não encontrado");
		}

		Projeto projetoAlterado = projetoConsultado.get();

		projetoAlterado.setDescricao(alteraprojetoDto.getDescricao());

		projetoRepository.save(projetoAlterado);

        // FIXME: Crie constantes para as Strings literais.
		return new MensagemDTO("O Projeto foi alterado com sucesso");
	}

	public List<Projeto> listaProjetos() {
		return (List<Projeto>) projetoRepository.findAll();
	}

	public MensagemDTO finalizaProjeto(Long idProjeto, DataFinalProjetoDTO dataFinal) {

		Optional<Projeto> projetoConsultado = projetoRepository.findById(idProjeto);

		if (projetoConsultado.isEmpty()) {
			return new MensagemDTO("Não foi possivel localizar o projeto.");
		}

		Projeto projeto = projetoConsultado.get();

		if (projeto.getDataInicio().isAfter(dataFinal.getDataEntrega())) {
		    //FIXME: Faltou retornar o erro aqui.
		}

		projeto.setDataEntrega(dataFinal.getDataEntrega());
		projeto.setConcluido(true);

		projetoRepository.save(projeto);

		return new MensagemDTO("Alteração feita com sucesso.");
	}

}

