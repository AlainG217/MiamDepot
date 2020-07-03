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
        <br><br><br><br>
        <p>
        <form action="${pageContext.request.contextPath}/Basket" method="post">
            <span class="product">Pizzas :  </span><br>
    <li>
        <!--<div class="taille"><p id="small">Petite</p><p id="middle">Moyenne</p><p id="big">Grande</p></div><br>-->
        <c:forEach items="${sessionScope.foods}" var="product" varStatus="status">
            <ul>-  <span class="name"><c:out value="${product.name}" /></span> :  
                <br><br><c:out value="${product.description}" />
                <button class="favorite styled" type="button" onclick="updateOrder(${sessionScope.status})"> +1</button><span class="tailles"><c:out value="${product.small}" /> : <c:out value="${product.smallPrice}"/>€..........</span><br>     
                <button class="favorite styled" type="button" onclick="updateOrder(${sessionScope.status})"> +1</button><span class="tailles"><c:out value="${product.medium}" /> : <c:out value="${product.mediumPrice}"/>€..........</span><br>     
                <button class="favorite styled" type="button"  onclick="updateOrder(${sessionScope.status})"> +1</button><span class="tailles"><c:out value="${product.large}" /> : <c:out value="${product.largePrice}"/>€...........</span><br>     
                
            </ul>
            <br>
        </c:forEach>        
    </li>
</p>
<br>

<p>
    <span class="product">Boissons :  </span><br> 
<li>
<c:forEach items="${sessionScope.drinks}" var="drink" varStatus="status">
            <ul>-  <span class="name"><c:out value="${drink.name}" /></span> :  
                <br><br><c:out value="${drink.description}" />
                <button class="favorite styled" type="button"> +1</button><span class="tailles"><c:out value="${drink.small}" /> : <c:out value="${drink.smallPrice}"/>€..........</span><br>     
                <button class="favorite styled" type="button"> +1</button><span class="tailles"><c:out value="${drink.medium}" /> : <c:out value="${drink.mediumPrice}"/>€..........</span><br>     
                <button class="favorite styled" type="button"> +1</button><span class="tailles"><c:out value="${drink.large}" /> : <c:out value="${drink.largePrice}"/>€...........</span><br>     
                
            </ul>
            <br>
        </c:forEach>
</li>
</p>
<br>
<input type="submit" class="validate" value="Valider le panier">
<p class =" flotte"><img id ="cook" src="./inc/resources/cook-1773658_1280.png" alt="img cook" height="200px" width="200px" /></figure>
</p>
<br>
</form>
</body>
<br><br><br><br> <br><br><br><br> <br><br><br><br> <br><br><br><br>
<footer>

    <span class="contact">Contacts : </span><br>
    <br>
    <p><c:out value="${requestScope.companyName}" /></p>
    - Adresse : 13, rue de ..... <br>
    81000 XXXX <br>
    -Téléphone : 00.00.00.00.00 <br>
    - Mail : mmmmmmm@gmail.com<br><br>
    <a href="http://localhost:8084/MiamDepot/LoginAdmin">Espace gérant</a>
</footer>
</html>