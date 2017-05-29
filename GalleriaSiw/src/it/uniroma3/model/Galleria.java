package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

public class Galleria {
	private String nome;
	private String indirizzo;
	private String citta;
	@OneToMany
	private List<Autore> autori;
	@OneToMany
	private List<Quadro> quadri;
	
	public Galleria(){
		this.autori = new ArrayList<>();
		this.quadri = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public List<Autore> getAutori() {
		return autori;
	}

	public List<Quadro> getQuadri() {
		return quadri;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}

	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}
	
	
}
