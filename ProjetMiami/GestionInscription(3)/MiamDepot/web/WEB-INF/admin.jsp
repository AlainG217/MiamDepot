<%-- 
    Document   : admin
    Created on : 30 juin 2020, 21:48:04
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
        <form action="home.jsp" method="post">
            <fieldset>
                <legend>Ajouter des Produits</legend>
                
                
                 <label for="nom">Nom:  <span class="requis"></span></label>
                <input type="login" id="nom" name="login" value="" /> <br />
                <label for="description">description: <span class="requis"></span></label>
                <input type="description" id="description" name="description"  /> <br />
                <label for="imageRep">imageRep <span class="requis"></span></label>
                <input type="imageRep" id="description" name="imageRep"  /> <br />
                <label for="imageRep">idCompany: <span class="requis"></span></label>
                <input type="idCompany" id="idCompany" name="idCompany"  /> <br />
               
               
                            
                            <label for="photo">image en cliquant ici</label>
                            <input type="file" id="photo" name="photo" accept="image/*"><br>
                       
                
                <input type="submit" value="Ajouter">
                
                
                
                
                </form>
            </fieldset>
            <fieldset>
                <legend>Modifier Des Produits</legend> 
            </fieldset>
            
            <fieldset>
                <legend>Suprimer Des Produits</legend> 
            </fieldset>
    </body>
</html>
