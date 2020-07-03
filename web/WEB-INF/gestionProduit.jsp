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
        <form action="AjouteProduit" method="post">
            <fieldset class="fieldset10">
                <legend>Ajouter des Produits</legend>


                <label for="nom">Nom:  <span class="requis"></span></label>
                <input type="text" id="nom" name="nomProduit" value="" /> <br /><br />
                <label for="description">description: <span class="requis"></span></label>
                <textarea name="detail"></textarea><br><br />
                <label for="imageRep">imageRep <span class="requis"></span></label>
                <input type="imageRep" id="description" name="imageRep"  /> <br /><br />
                <label for="idCompany">idCompany: <span class="requis"></span></label>
                <input type="idCompany" id="idCompany" name="idCompany"  /> 

                <table>
                    <tr>
                        <th>Produit:</th>
                        <th>petit: <input id="toggle" type="checkbox" name="size" value="petit"></th>
                        <th>Moyen: <input id="toggle" type="checkbox" name="size"value="moyen"></th>
                        <th>Grand: <input id="toggle" type="checkbox"name="size"value="grand"></th>

                    </tr><br>
                    <tr>  
                        <th> Prix: </th>
                        <td> <input type="prix" id="idCompany" name="prix"  /></td>
                        <td> <input type="prix" id="idCompany" name="prix"  /></td>
                        <td> <input type="prix" id="idCompany" name="prix"  /></td> 

                    </tr
                    
                   
               
                    
                </table>
               


 </table>
                <tr>
                 <input type="submit" value="Ajouter">       
                    <a href="http://localhost:8084/MiamDepot/GestionProduit"> <input type="button" value="Annuler" ></a> 
                </tr>
                
                <table>


                




            </fieldset>
        </form>
        
        
        
        
        <footer>
    </body>


</html>