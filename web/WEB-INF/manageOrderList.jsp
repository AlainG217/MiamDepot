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

            <span class="product">Vos commandes :  </span><br>
            <c:set var="orders" value="${sessionScope.orders}" />
        <table> <span class="name">
            <tr>
                <th>Numéro</th>
                <th>Nom client</th>
                <th>Mode livraison</th>
                <th>Date</th>
                <th>Statut</th>
                <th>Prix total</th>
                <th></th>
            </tr>
            <c:forEach items="${orders}" var="order" varStatus="status">
                <tr>
                    <td><c:out value="${order.id}" /></td>
                    <td><c:out value="${order.clientName}" /></td>
                    <td><c:out value="${order.mode}" /></td>
                    <td><c:out value="${order.deliveryTime}" /></td>
                    <td>Réglée</td>
                    <td><c:out value="${order.orderTotal}" /></td>
                    <td><a class="favorite styled" href="./UpdateProduct?id=${status.index}&type=1">  Détails</a><span class="edit"></span> </td>
                </tr>
                <br>
            </c:forEach>
        </table>
        </p>
<br>

     
<form action="${pageContext.request.contextPath}/managerProductList" method="get">
    <fieldset class="fieldset10">
                    
                    
        <p class =" flotte">
            <text rows="" cols="4" name="total" placeholder="00"></text><img id ="cook" src="./inc/resources/cook-1773658_1280.png" alt="img cook" height="200px" width="200px" /></figure>
        </p>
        <p class =" btnApparence" style="margin: 20px">
            Total commandes : <c:out value="${sessionScope.ca}" />
        </p>
        <input type="submit" class="validate" value="Gestion de la carte">
    </fieldset>
</form>


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