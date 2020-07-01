<%-- 
    Document   : loginAdmin
    Created on : 30 juin 2020, 21:47:32
    Author     : stagjava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link  href="<c:url value="inc/css/loginAmin.css" />" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
        <h1>La Java </h1>
        <figure id =  "img1">
        <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="310px" width="600px" /></figure>
        <h2>Pizzeria</h2>
    </header>
        <form action="/WEB-INF/admin.jsp" method="post">
            <fieldset>
                 <legend>Connexion</legend>
                
                <label for="motdepasse">Login:  <span class="requis">*</span></label>
                <input type="login" id="login" name="motdepasse" value="" /> <br />
                <label for="motdepasse">Mot de passe: <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" /> <br />
                <input type="submit" value="connexion" href="http://localhost:8084/MiamDepot/admin"><br>
                <a href="http://localhost:8084/MiamDepot/Home">Retour</a>

            </fieldset>


        </form>
    </body>
</html>
