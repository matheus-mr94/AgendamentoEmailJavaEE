package br.com.alura.dto;

import java.util.Date;
import java.util.List;

public class MensagemErroDTO {
	
	private List<String> mensagens;
	
	private Date dataErro;

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public Date getDataErro() {
		return dataErro;
	}

	public void setDataErro(Date dataErro) {
		this.dataErro = dataErro;
	}
	
	
	public static MensagemErroDTO build(List<String> mensagem) {
		
		MensagemErroDTO mensagemErroDto = new MensagemErroDTO();
		mensagemErroDto.setMensagens(mensagem);
		mensagemErroDto.setDataErro(new Date());
		
		return mensagemErroDto;
	}

}
