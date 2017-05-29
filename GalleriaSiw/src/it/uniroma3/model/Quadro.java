package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findAllQuadri", query="SELECT q FROM Quadro q")
public class Quadro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titolo;
	private int anno;
	private String tecnica;
	private String dimensione;
	@ManyToOne
	private Autore autore;
	
	public Quadro(){
	}

	public Long getId() {
		return id;
	}

	public String getTitolo() {
		return titolo;
	}

	public int getAnno() {
		return anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}
