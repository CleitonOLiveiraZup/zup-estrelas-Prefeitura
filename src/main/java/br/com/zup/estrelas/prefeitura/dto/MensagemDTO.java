package br.com.zup.estrelas.prefeitura.dto;

public class MensagemDTO {

	private String mensagem;

	public MensagemDTO(String mensagem) {

		this.mensagem = mensagem;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MensagemDTO other = (MensagemDTO) obj;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

	public String getMensagem() {
		return mensagem;
	}

}