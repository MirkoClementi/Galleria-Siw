package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="findAllAutori", query="SELECT q FROM Quadro q")
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String nazionalita;
	private Date dataNascita;
	private Date dataMorte;
	@OneToMany(mappedBy="autore")
	private List<Quadro> quadri;
	
	public Autore(){
		this.quadri = new ArrayList<>();
	}

	public Long getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public List<Quadro> getQuadri() {
		return quadri;
	}

	public void setId(Long id){
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}
}
