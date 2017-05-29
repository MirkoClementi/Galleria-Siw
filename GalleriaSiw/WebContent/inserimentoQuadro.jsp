<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci nuovo Quadro</title>
</head>
<body>
<%-- Creo una form nel valori prendo i dati dalla richiesta = se sbaglio un campo , gli altri rimangono--%>
<%-- Metto una label errXXX che viene mostrata se != da null = se ce un errore in quel campo --%>
	<form action="quadro" method="post">
		<div>
			Titolo*: <input type="text" name="titolo" value="${quadro.titolo }" />
			${errTitolo}
		</div>
		<div>
			Anno*: <input type="text" name="anno" value="${quadro.anno }" />
			${errAnno}
		</div>
		<div>
			Tecnica*: <input type="text" name="tecnica"
				value="${quadro.tecnica }" /> ${errTecnica}
		</div>
		<div>
			Dimensione*: <input type="text" name="dimensione"
				value="${quadro.dimensione }" /> ${errDimensione}
		</div>
		<div>*Campo obbligatorio</div>
<%-- Creo un menu a tendina che mostra tutti gli autori presenti nel db --%>
		<select name="autoreId">
			<c:forEach var="autore" items="${autori}">
				<option value="${autore.id}">${autore.nome} ${autore.cognome}</option>
			</c:forEach>
		</select> <input type="submit" name="sumbit" value="invia" />
	</form>
</body>
</html>