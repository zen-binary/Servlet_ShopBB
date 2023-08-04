<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/07/2023
  Time: 3:30 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Main -->
<main class="main-container">
    <div class="main-title">
        <p class="font-weight-bold">DASHBOARD</p>
    </div>

    <div class="main-cards">

        <div class="card">
            <div class="card-inner">
                <p class="text-primary">PRODUCTS</p>
                <span class="material-icons-outlined text-blue">inventory_2</span>
            </div>
            <span class="text-primary font-weight-bold">${countPros}</span>
        </div>

        <div class="card">
            <div class="card-inner">
                <p class="text-primary">PURCHASE ORDERS</p>
                <span class="material-icons-outlined text-orange">add_shopping_cart</span>
            </div>
            <span class="text-primary font-weight-bold">${countOder}</span>
        </div>

        <div class="card">
            <div class="card-inner">
                <p class="text-primary">SALES ORDERS</p>
                <span class="material-icons-outlined text-green">shopping_cart</span>
            </div>
            <span class="text-primary font-weight-bold">0</span>
        </div>

        <div class="card">
            <div class="card-inner">
                <p class="text-primary">INVENTORY ALERTS</p>
                <span class="material-icons-outlined text-red">notification_important</span>
            </div>
            <span class="text-primary font-weight-bold">0</span>
        </div>

    </div>

</main>
<!-- End Main -->

