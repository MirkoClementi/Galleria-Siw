package it.uniroma3.validator;

import javax.servlet.http.HttpServletRequest;

import it.uniroma3.model.Quadro;

public class QuadroValidator {

	public QuadroValidator(){
	}

// definisco un metodo validate che prende la richiesta = tutti i valori immessi e controlla che i campi
// siano validi. Se un campo è valido lo setta nell'oggetto = setXXX , se un campo non è valido aggiunge 
// un attributo errXXX con una stringa di errore e imposta tuttoOk= false.
	public boolean validate( HttpServletRequest request){
		boolean tuttoOk = true;
		String titolo = request.getParameter("titolo");
		String anno = request.getParameter("anno");
		String tecnica = request.getParameter("tecnica");
		String dimensione = request.getParameter("dimensione");
		Quadro quadro = (Quadro) request.getAttribute("quadro");

		if(titolo == null || titolo.equals("")) {
			request.setAttribute("errTitolo", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			quadro.setTitolo(titolo);

		if(anno == null || anno.equals("")) {
			request.setAttribute("errAnno", "Campo obbligatorio");
			tuttoOk = false;
		}
		else {
			try{
				quadro.setAnno(Integer.parseInt(anno));
			}
			catch(NumberFormatException e){
				request.setAttribute("errAnno", "Deve essere un anno ");
			}
		}

		if(tecnica == null || tecnica.equals("")) {
			request.setAttribute("errTecnica", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			quadro.setTecnica(tecnica);

		if(dimensione == null || dimensione.equals("")) {
			request.setAttribute("errDimensione", "Campo obbligatorio");
			tuttoOk = false;
		}
		else 
			quadro.setDimensione(dimensione);
		
		return tuttoOk;
	}
}
