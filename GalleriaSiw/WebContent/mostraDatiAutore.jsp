<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati autore</title>
</head>
<body>
<%-- Mostro i dati dell'elemento , prendendoli dalla richiesta --%>
	<div>  Nome         : ${autore.nome } </div>
	<div> Cognome      : ${autore.cognome } </div>
	<div> Nazionalita  : ${autore.nazionalita } </div>
	<div> Data Nascita : ${autore.dataNascita } </div>
	<div> Data Morte   : ${autore.dataMorte } </div>
</body>
</html>