<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Administration panel</title>
		
		<link rel="stylesheet" type="text/css" media="screen" href="css/menu_up.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/menu_dropdown.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="css/bloki.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="css/background.css" />
	<link rel="stylesheet" type="text/css" media="screen" href="css/stopka.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="css/tabela.css" />
	</head>
	
<body>

<div class="bw-c"><div id="logo"><div class="TYTUL">Kraków: Serwis Pogodowy</div></div></div>
  <ol>
    <li><a href="index.html">Strona główna</a></li>

    <li><a href="#">Archiwalne</a>
      <ul>
        <li><a href="archiwum_dzien.html">Konkretny dzień</a></li>
        <li><a href="archiwum_przedzial.html">Przedział</a></li>
      </ul>
    </li>

    <li><a href="stats_dzien.html">Statystyki</a>
    <ul>
        	<li><a href="stats_dzien.html">Konkretny dzień</a></li>
        	<li><a href="stats_przedzial.html">Przedział</a></li>
      	</ul>
	</li>


    <li><a href="#">Galeria</a>
      <ul>
        <li><a href="galeria_zdjecia.html">Zdjęcia</a></li>
        <li><a href="galeria_kamery.html">Kamery on-line</a></li>
      </ul>
    </li>
    
    <li><a href="komentarz.html">Komentarze</a></li>
    
    <li><a href="#">Kontakt</a>
    	<ul>
			<li><a href="rejestracja.html">Rejestracja</a></li>
    		<li><a href="login.jsp">Zaloguj</a></li>
        	<li><a href="kontakt.html">Kontakt</a></li>
    		<li><a href="newsletter.html">Newsletter</a></li>
        </ul>
    </li>    
  </ol>
	
	<h3>Wszyscy administratorzy serwisu</h3>

	<table width="100%" border="1">
		<tr>
			<th>Administrator</th>
			<th>Password</th>
		</tr>
	
		<c:forEach items="${listOfRecords}" var="element">
			<tr>
				<td>${element.login}</td>
				<td>${element.password}</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		Dodawanie nowego administratora
	</div>
	<div>
		<form action="http://localhost:8080/PzCws/administration/add" method="post">
			Enter login : <input type="text" name="login" /> <br />
			Enter password : <input type="password" name="password" /> <br />
		     <input type="submit" value="Dodaj"/>
		</form>
	</div>
	
	
	<div>
		Wiadomosc do uzytkownikow
	</div>
	
	<textarea rows="4" cols="50" name="message" form="msgForm">
	Wpisz wiadomosc tutaj...</textarea>
	
	<div>
		<form action="http://localhost:8080/PzCws/subscriptions/send" method="post" id="msgForm">
		     <input type="submit" value="Wyslij"/>
		</form>
	</div>
	
	<div>
		Download Script is running: ${schedulerState} <br/>
		<form action="http://localhost:8080/PzCws/DownloadScriptHandler" method="post">
			<input type="hidden" name="wantedState" value="run"/> <br />
		     <input type="submit" value="Uruchom"/>
		</form>
		
		<form action="http://localhost:8080/PzCws/DownloadScriptHandler" method="post">
			<input type="hidden" name="wantedState" value="stop"/> <br />
		     <input type="submit" value="Zatrzymaj"/>
		</form>
	</div>
	

</body>
</html>