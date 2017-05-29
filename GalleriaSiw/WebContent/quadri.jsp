<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Quadri</title>
</head>
<body>
<%-- itero sulla lista aggiunta come attributo nella richiesta --%>
<%-- per ogni elemento creo un campo della lista <li> che contiene un link per mostare i dati del item --%>
<%-- aggiungengo una query con id=item.id --%>
<%-- aggiungo per ogni elemento un bottone cancella "command" e un campo nascosto con id --%>
	<ul>
	 <c:forEach var="quadro" items="${quadri}" >
		<li><a href="quadro?id=${quadro.id}"> ${quadro.titolo} </a>
		<form action="quadro" method="post">
			 	<input type="hidden" value="${quadro.id}" name="id"/>
			    <input type="submit" value="cancella" name="command"/>
			</form>
		</li>
	</c:forEach>
	</ul>
</body>
</html>