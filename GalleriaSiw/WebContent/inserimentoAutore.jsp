<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Autore</title>
</head>
<body>
	<form action="autore" method="post">
		<div>
			Nome*: <input type="text" name="nome" value="${autore.nome }" />
			${errNome}
		</div>
		<div>
			Cognome*: <input type="text" name="cognome" value="${autore.cognome }" />
			${errCognome}
		</div>
		<div>
			Nazionalità*: <input type="text" name="nazionalita" value="${autore.nazionalita }" /> 
			${errNazionalita}
		</div>
		<div>
			Data Nascita*: <input type="text" name="dataNascita" value="${autore.dataNascita }" /> 
			${errDataNascita}
		</div>
		<div>
			Data Morte: <input type="text" name="dataMorte" value="${autore.dataMorte }" />
			${errDataMorte}
		</div>
		<div>*Campo obbligatorio</div>
		<input type="submit" name="sumbit" value="invia" />
	</form>
</body>
</html>