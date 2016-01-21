<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login page</title>

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
	
	<li><a href="#">Download</a>
      	<ul>
        	<li><a href="down_dzien.html">Konkretny dzień</a></li>
        	<li><a href="down_przedzial.html">Przedział</a></li>
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
    		<li><a href="login.html">Zaloguj</a></li>
        	<li><a href="kontakt.html">Kontakt</a></li>
    		<li><a href="newsletter.html">Newsletter</a></li>
        </ul>
    </li>    
  </ol>

	<div>
		Log in to see administration panel
	</div>
	<div>
		<form action="LoginController" method="post">
			Enter username : <input type="text" name="username" /> <br />
			Enter password : <input type="password" name="password" /> <br />
		     <input type="submit" value = " Zaloguj "/>
		</form>
	</div>
</body>
</html>