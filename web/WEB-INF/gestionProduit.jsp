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
        <link  href="<c:url value="inc/css/gestionProduit.css" />" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <h1>La Java </h1>
            <figure id =  "img1">
                <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="310px" width="600px" /></figure>
            <h2>Pizzeria</h2>
        </header>
        <form action="${pageContent.servletContext.contextPath}/registerProduct" method="post">
            <fieldset>
                <legend>Ajouter des Produits</legend>


                <label for="nom">Nom:  <span class="requis"></span></label>
                <input type="text" id="nom" name="nomProduit" value="" /> <br /><br />
                
                <label for="description">description: <span class="requis"></span></label>
                <textarea name="detail"></textarea><br><br />
                
                <label for="imageRep">imageRep <span class="requis"></span></label>
                <input type="imageRep" id="description" name="imageRep"  /> <br /><br />
                
                <label for="idCompany">idCompany: <span class="requis"></span></label>
                <input type="idCompany" id="idCompany" name="idCompany"  /> <br /><br />
                
                <select name="category"> 
                    <option value="pizzeria">Pizzeria</option>
                    <option value="boisson">Boisson</option>
                </select><br>
                

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