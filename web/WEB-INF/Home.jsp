<%-- 
    Document   : Home
    Created on : 30 juin 2020, 10:41:07
    Author     : Monnier.M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link  href="<c:url value="inc/css/Home.css" />" rel="stylesheet">
        <link href="inc/resources/favicon.ico" rel="icon" type="image/x-icon">
    </head>
    <body>
        <header>
            <h1>La Java </h1>
            <figure id =  "img1">
                <img src="./inc/resources/big-2530142_640.jpg" alt="image pizza" height="310px" width="600px" /></figure>
            <h2>Pizzeria</h2>
        </header>
        <br><br><br><br>a
        <p>

            <span class="product">Pizzas :  </span><br>
    <li>
        <c:forEach items="${requestScope.products}" var="product" varStatus="status">
            <ul>-  <span class="name"><c:out value="${product.name}" /></span> :  <c:out value="${product.description}" />             <button class="favorite styled" type="button"> +1</button>
                <br>
            </ul>
            <br>
        </c:forEach>
    </li>
</p>
<br>
<c:out value="${requestScope.views}" />
<p>
    <span class="product">Boissons :  </span><br> 
<li>
    <ul>-        </ul>
    <ul>-       </ul>
    <ul>-       </ul>

</li>
</p>

<p class =" flotte">Total TTC : <text rows="" cols="4" name="total" placeholder="00"></text><img id ="cook" src="./inc/resources/cook-1773658_1280.png" alt="img cook" height="200px" width="200px" /></figure>
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