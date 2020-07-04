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
        <link  href="<c:url value="inc/css/Home.css" />" rel="stylesheet">
        <link href="inc/resources/favicon.ico" rel="icon" type="image/x-icon">
        <title>Confirmation panier</title>
    </head>
    <body>
        <header>
            <h1>La Java </h1>
            <figure id =  "img1">
                <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="310px" width="600px" /></figure>
            <h2>Pizzeria</h2>
        </header>
        <form action="OrderConfirmation" method="post">
            <fieldset >
                <legend>Confirmation</legend>


                <input type="radio" id="mode1" name="deliveryMode" value='0'> A emporter<br>
                <input type="radio" id="mode2" name="deliveryMode" value='1'> Livré<br>
                
                <label for="deliveyTime">Heure de livraison  </label>
                <input type="text" id="hour" name="deliveryTime" value="" /> <br><br>
                
                <label for="firstName">Prénom: </label>
                <input type="text" id="firstName" name="firstName" value="" /> <br>

                <label for="nom">Nom:  <span class="requis"></span></label>
                <input type="text" id="lastName" name="lastName" value="" /> <br /><br />
                
                    <div>
                        <label for="line1">  Adresse</label>
                        <input type="text" id="line1" name="line1" value="" /> <br>
                        <label for="line12" >  Complément</label>
                        <input type="text" id="line2" name="line2" value="" /> <br>
                        <label for="codePostal">Code Postal / Ville</label>
                        <input type="text" id="cp" name="postalCode" value="" size="10"/> 
                        <input type="text" id="city" name="city" value="" /> <br><br>                   
                    </div>
                                
                <label for="phone">Téléphone  </label>
                <input type="text" id="phone" name="phone" value="" /> <br />

                <label for="email">Courriel <span class="requis"></span></label>
                <input type="text" id="email" name="email" value="" /> <br /><br />

                 <input type="submit" class="validate" value="Régler">       
                    <a href="./home.jsp" class="validate"> Annuler</a>
                <input type="button" value="Annuler" href="./Home"></a> 
                </tr>
                
            </fieldset>
        </form>
        
        
        
        
        <footer>
    </body>


</html>