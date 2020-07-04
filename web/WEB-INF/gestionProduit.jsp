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
        <link href="inc/resources/favicon.ico" rel="icon" type="image/x-icon">
        <title>Gestion produit</title>
    </head>
    <body>
        <header>
            <h1>La Java </h1>
            <figure id =  "img1">
                <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="310px" width="600px" /></figure>
            <h2>Pizzeria</h2>
        </header>
        <form action="AjouteProduit" method="post">
            <fieldset class="fieldset10">
                <legend>Ajouter des Produits</legend>


                <input type="radio" id="typeP" name="type" value='0'> Pizza<br>
                <input type="radio" id="typeB" name="type" value='1'> Boisson<br>
                <label for="nom">Nom:  <span class="requis"></span></label>
                <input type="text" id="nom" name="nomProduit" value="" /> <br /><br />
                <label for="description">description: <span class="requis"></span></label>
                <textarea name="detail"></textarea><br><br />

                <table>
                    <tr>
                        <th>Produit:</th>
                        <th>PETITE: <input id="toggle" type="checkbox" name="sizeSmall" value="PETITE"></th>
                        <th>MOYENNE: <input id="toggle" type="checkbox" name="sizeMedium"value="MOYENNE"></th>
                        <th>LARGE: <input id="toggle" type="checkbox"name="sizeLarge"value="GRANDE"></th>

                    </tr><br>
                    <tr>  
                        <th> Prix: </th>
                        <td> <input type="number" id="idCompany" name="priceSmall"  /></td>
                        <td> <input type="number" id="idCompany" name="priceMedium"  /></td>
                        <td> <input type="number" id="idCompany" name="priceLarge"  /></td> 

                    </tr>
                   
                </table>
               


 </table>
                <tr>
                 <input type="submit" value="Ajouter">       
                    <a href="http://localhost:8084/MiamDepot/GestionProduit"> 
                <input type="button" value="Annuler" href="./Home"></a> 
                </tr>
                
                <table>


                




            </fieldset>
        </form>
        
        
        
        
        <footer>
    </body>


</html>