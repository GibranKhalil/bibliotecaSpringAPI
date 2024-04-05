package controller;

public class Livro {
	
	private boolean estaLido; 
	private boolean estaSalvo; 
	private String titulo; 
	private String autor; 
	private String sobre;
	private String genero;
	private boolean ehFavorito; 
	private String capa;
	private String resumo;
	private Number qtdCapitulo;
	private Number qtdPagina;
	
	public Livro(){
		this.estaLido = false;
		this.estaSalvo = false;
		this.ehFavorito = false;
	}
	
	
	public void mudarLido() {
		if(estaLido == false) {
			estaLido = true; 
		}else {
			estaLido = false;
		}
	}
	
	public void mudarSalvo() {
		if(estaSalvo == false) {
			estaSalvo = true; 
		}else {
			estaSalvo = false;
		}
	}
	
	public void mudarFavorito() {
		if(ehFavorito == false) {
			ehFavorito= true; 
		}else {
			ehFavorito = false;
		}
	}
	
	public boolean isEstaLido() {
		return estaLido;
	}
	public boolean isEstaSalvo() {
		return estaSalvo;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return autor;
	}
	public String getSobre() {
		return sobre;
	}
	public String getGenero() {
		return genero;
	}
	public boolean isEhFavorito() {
		return ehFavorito;
	}
	public String getCapa() {
		return capa;
	}
	public String getResumo() {
		return resumo;
	}
	public Number getQtdCapitulo() {
		return qtdCapitulo;
	}
	public Number getQtdPagina() {
		return qtdPagina;
	} 
}
