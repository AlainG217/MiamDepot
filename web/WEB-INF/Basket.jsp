<%-- 
    Document   : Home
    Created on : 1 juillet 2020, 10:41:07
    Author     : Godefroy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
        <link  href="<c:url value="inc/css/Home.css" />" rel="stylesheet">
        <link href="inc/resources/favicon.ico" rel="icon" type="image/x-icon">
    </head>
    <body>
        <header>
            <h1>La Java </h1>
            <figure id =  "img1">
                <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="150px" width="300px" /></figure>
            <h2>Pizzeria</h2>
        </header>
        <br><br><br><br>
        <p>

            <span class="product">Votre panier :  </span><br>
            <c:set var="lines" value="${sessionScope.basket.lines}" />
        <table> <span class="name">
            <tr>
                <th>Nom</th>
                <th>Description</th>
                <th>Taille</th>
                <th>Quantité</th>
                <th>Prix Unitaire</th>
                <th>Prix total</th>
            </tr>
            <c:forEach items="${lines}" var="line" varStatus="status">
                <tr>
                    <td><c:out value="${line.name}" /></td>
                    <td><c:out value="${line.description}" /></td>
                    <td><c:out value="${line.size}" /></td>
                    <td><c:out value="${line.orderQty}" /></td>
                    <td><c:out value="${line.unitPrice}" /></td>
                    <td><c:out value="${line.totalPrice}" /></td>
                </tr>
                <br>
            </c:forEach>
        </table>
    </p>
    <br>
    <form>
   <fieldset>
        <legend>Livraison</legend>
        
        <label for="deliveryMode">Mode Livraison <span class="requis">*</span></label>
        <input type="text" id="deliveryMode" name="deliveryMode" 
               size="20" maxlength="20" 
               />
        <br>
        <label for="firstName">Prénom <span class="requis">*</span></label>
        <input type="text" id="firstName" name="firstName" 
               size="20" maxlength="60"
               />
        <span class="erreur"></span>
        <br>
        <label for="lastName">Nom <span class="requis">*</span></label>
        <input type="text" id="lastName" name="lastName" 
               size="20" maxlength="20" 
               />
        <span class="erreur"></span>
        <br>
        <label for="line1">Adresse <span class="requis">*</span></label>
        <input type="text" id="line" name="line1" 
               size="20" maxlength="60" 
               />
        <span class="erreur"></span>
        <input type="text" id="line" name="line2" 
               size="20" maxlength="60" 
               />
        <span class="erreur"></span>
        <br>
         <label for="CodePostal">Code Postal <span class="requis">*</span></label>
        <input type="text" id="CodePostal" name="CodePostal" 
               size="20" maxlength="10" 
               />
        <span class="erreur"></span>
        <input type="text" id="city" name="city" 
               size="20" maxlength="60" 
               />
        <span class="erreur"></span>
       <input type="submit" value='Confirmer' class="sansLabel"/>
        <p>Les champs marqués d'un <span class='requis'>*</span>
        sont obligatoires.</p>
            
    </fields1et>
         
    </form>
                    
    <p class =" flotte">
                    <text rows="" cols="4" name="total" placeholder="00"></text><img id ="cook" src="./inc/resources/cook-1773658_1280.png" alt="img cook" height="200px" width="200px" /></figure>
    </p>
    <p class =" flotte">
        <a class="favorite styled" href="./Home" style="und">Annuler</a>
    </p>
    <p class =" flotte">
        <a class="favorite styled" href="./Address">Confirmer</a>
    </p>
    <p class =" flotte" style="margin: 20px">
        Total TTC : <c:out value="${sessionScope.basket.orderTotal}" />
    </p>


</body>
<br><br><br><br> <br><br><br><br> <br><br><br><br> <br><br><br><br>
<footer>

    <span class="contact">Contacts : </span><br>
    <br>
    - Adresse : 13, rue de ..... <br>
    81000 XXXX <br>
    -Téléphone : 00.00.00.00.00 <br>
    - Mail : mmmmmmm@gmail.com<br><br>
    <a href="https://localhost:8084/MiamDepot/LoginAdmin">Espace gérant</a>
</footer>
</html>