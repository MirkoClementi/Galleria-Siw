package it.uniroma3.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import it.uniroma3.model.Autore;

public class AutoreValidator {
	public AutoreValidator(){
	}

	// definisco un metodo validate che prende la richiesta = tutti i valori immessi e controlla che i campi
	// siano validi. Se un campo è valido lo setta nell'oggetto = setXXX , se un campo non è valido aggiunge 
	// un attributo errXXX con una stringa di errore e imposta tuttoOk= false.
	public boolean validate( HttpServletRequest request){
		boolean tuttoOk = true;
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String nazionalita = request.getParameter("nazionalita");
		String dataNascita = request.getParameter("dataNascita");
		String dataMorte = request.getParameter("dataMorte");
		Autore autore = (Autore) request.getAttribute("autore");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		if(nome == null || nome.equals("")) {
			request.setAttribute("errNome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			autore.setNome(nome);

		if(cognome == null || cognome.equals("")) {
			request.setAttribute("errCognome", "Campo obbligatorio");
			tuttoOk = false;
		}
		else
			autore.setCognome(cognome);

		if(nazionalita == null || nazionalita.equals("")) {
			request.setAttribute("errNazionalita", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			autore.setNazionalita(nazionalita);

		if(dataNascita == null || dataNascita.equals("")) {
			request.setAttribute("errDataNascita", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try {
				autore.setDataNascita(df.parse(dataNascita));
			} catch (ParseException e) {
				request.setAttribute("errDataNascita", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}

		if(dataMorte == null || dataMorte.equals("")) {
			autore.setDataMorte(null);
		}
		else{
			try {
				autore.setDataMorte(df.parse(dataMorte));
			} catch (ParseException e) {
				request.setAttribute("errDataMorte", "Deve essere una data valida!");
				tuttoOk = false;
			}
		}
		return tuttoOk;
	}
}
