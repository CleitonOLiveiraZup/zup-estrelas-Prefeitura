package br.com.zup.estrelas.prefeitura.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.zup.estrelas.prefeitura.repository.SecretariaRepository;
import br.com.zup.prefeitura.controller.form.SecretariaForm;
import br.com.zup.estrelas.prefeitura.dto.SecretariaDTO;
import br.com.zup.estrelas.prefeitura.entity.Secretaria;

@RestController
@RequestMapping("/cadastrarSecretaria")
public class SecretariaController {

	@Autowired
	private SecretariaRepository secretariaRepository;

	@PostMapping
	public ResponseEntity<SecretariaDTO> cadastrar(@RequestBody SecretariaForm form, UriComponentsBuilder uriBuilder) {

		Secretaria secretaria = form.converter();
		secretariaRepository.save(secretaria);
         
		URI uri = uriBuilder.path("/cadastrarSecretaria/{idSecretaria}").buildAndExpand(secretaria.getIdSecretaria())
				.toUri();
		return ResponseEntity.created(uri).body(new SecretariaDTO(secretaria));
		

	}

	@GetMapping("/{idSecretaria}")
	public SecretariaDTO detalhar(@PathVariable Long idSecretaria) {
		Secretaria secretaria = secretariaRepository.getOne(idSecretaria);
		return new SecretariaDTO(secretaria);

	}

	@PutMapping("/{idSecretaria}")
	@Transactional
	public ResponseEntity<SecretariaDTO> alterar(@PathVariable Long idSecretaria,
			@RequestBody @Valid SecretariaForm form) {
		Secretaria secretaria = form.alterar(idSecretaria, secretariaRepository);
		return ResponseEntity.ok(new SecretariaDTO(secretaria));
	}

	@DeleteMapping("/{idSecretaria}")
	public ResponseEntity<?> remover(@PathVariable Long idSecretaria) {
		secretariaRepository.deleteById(idSecretaria);
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public List<SecretariaDTO> lista() {
		List<Secretaria> secretaria = secretariaRepository.findAll();
		return SecretariaDTO.converter(secretaria);

	}

}
