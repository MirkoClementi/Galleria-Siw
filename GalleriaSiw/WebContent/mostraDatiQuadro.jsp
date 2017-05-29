<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dati Quadro</title>
</head>
<body>
<%-- Mostro i dati dell'elemento , prendendoli dalla richiesta --%>
	<div>  Titolo     : ${quadro.titolo } </div>
	<div> Anno       : ${quadro.anno } </div>
	<div> Tecnica    : ${quadro.tecnica } </div>
	<div> Dimensione : ${quadro.dimensione } </div>
	<div> Autore     : <a href="autore?id=${quadro.autore.id}"> ${quadro.autore.getNome()} </a> </div>
</body>
</html>