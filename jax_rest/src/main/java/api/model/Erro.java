package api.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Erro {
	private int statusCode;
	private String mensagem;
	
	public Erro(){}
	
	public Erro(int statusCode, String mensagem) {
		this.statusCode = statusCode;
		this.mensagem = mensagem;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
