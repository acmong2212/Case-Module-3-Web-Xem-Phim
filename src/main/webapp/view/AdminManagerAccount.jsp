<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Admin Manager Account</title>
    <link rel="stylesheet" href="/css/styleViewAdmin.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper">
    <div class="form-container">
        <div class="slide-controls">
            <input type="radio" name="slide" id="list-products">
            <label for="list-products" class="slide list-products">Manager Account</label>
            <a href="/homeAccount" type="button" class="btn btn-secondary">Back to Home</a>
        </div>
        <div class="form-inner">
            <form action="" class="list-products">
                <div class="wrapperr">
                    <table class="table table-compare">
                        <c:forEach var="u" items="${user}" varStatus="loop">
                            <tr>
                                <th class="compare-label">ID</th>
                                <th class="compare-label">User Name</th>
                                <th class="compare-label">Pass Word</th>
                                <th class="compare-label">Phone Number</th>
                                <th class="compare-label">isPremium</th>
                                <th class="compare-label">isUser</th>
                                <th class="compare-label">isAdmin</th>
                                <th class="compare-label">Key Code</th>
                                <th class="compare-label">Action</th>
                            </tr>
                            <tr>
                                <td>${loop.count}</td>
                                <td>${u.nameUser}</td>
                                <td class="price">${u.passUser}</td>
                                <td>${u.phoneNumber}</td>
                                <td>${u.isPremium}</td>
                                <td class="instock">${u.isUser}</td>
                                <td class="instock">${u.isAdmin}</td>
                                <td class="instock">${u.keyCode}</td>
                                <td class="action">
                                    <button class="add-cart button button-sm"><a href="/admin?action=editAccount&idUser=${u.idUser}">Edit</a></button>
                                    <a class="button button-sm" href="/admin?action=deleteAccount&idUser=${u.idUser}"><i class="fa fa-close"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    const loginText = document.querySelector(".title-text .create-product");
    const loginForm = document.querySelector("form.create-product");
    const loginBtn = document.querySelector("label.create-product");
    const signupBtn = document.querySelector("label.list-products");
    const signupLink = document.querySelector("form .list-products-link a");
    signupBtn.onclick = (()=>{
        loginForm.style.marginLeft = "-50%";
        loginText.style.marginLeft = "-50%";
    });
    loginBtn.onclick = (()=>{
        loginForm.style.marginLeft = "0%";
        loginText.style.marginLeft = "0%";
    });
    signupLink.onclick = (()=>{
        signupBtn.click();
        return false;
    });
</script>
</body>
</html>
