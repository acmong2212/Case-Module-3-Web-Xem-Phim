<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Admin Manager Movie</title>
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
            <input type="radio" name="slide" id="create-product" checked>
            <input type="radio" name="slide" id="list-products">
            <label for="create-product" class="slide create-product">Create Movie</label>
            <label for="list-products" class="slide list-products">List Movie</label>
            <div class="slider-tab"></div>
        </div>
        <a href="/homeAccount" type="button" class="btn btn-secondary">Back to Home</a>
        <div class="form-inner">
            <form action="/admin?action=createMovie" method="post" class="create-product">
                <div class="field">
                    <input type="text" placeholder="Enter a Name Movie" name="nameMovie" required>
                </div>
                <div class="field">
                    <input type="text" placeholder="Enter a Description" name="description" required>
                </div>
                <div class="margin">Categories
                    <div>
                        <select name="Categories">
                            <c:forEach var="ctg" items="${categories}">
                                <option value="${ctg.idCategories}">${ctg.nameCategories}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="field">
                    <input type="number" placeholder="Enter a Year" name="year" required>
                </div>
                <div class="field">
                    <input type="text" placeholder="Enter a Image" name="image" required/>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Create">
                </div>
            </form>
            <form action="" class="list-products">
                <div class="wrapperr">
                    <table class="table table-compare">
                        <c:forEach var="m" items="${movies}">
                            <tr>
                                <th class="compare-label">ID</th>
                                <th class="compare-label">Movie Image</th>
                                <th class="compare-label">Movie Name</th>
                                <th class="compare-label">Description</th>
                                <th class="compare-label">Year</th>
                                <th class="compare-label">Categories</th>
                                <th class="compare-label">Action</th>
                            </tr>
                            <tr>
                                <td>${m.idMovie}</td>
                                <td><a href="#"><img src="${m.image}" alt="Not found"></a></td>
                                <td><a href="#">${m.nameMovie}</a></td>
                                <td class="price">${m.description}</td>
                                <td>${m.year}</td>
                                <td class="instock">${m.nameCategories}</td>
                                <td class="action">
                                    <button class="add-cart button button-sm"><a href="/admin?action=edit&idMovie=${m.idMovie}">Edit</a></button>
                                    <a class="button button-sm" href="/admin?action=delete&idMovie=${m.idMovie}"><i class="fa fa-close"></i></a>
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
