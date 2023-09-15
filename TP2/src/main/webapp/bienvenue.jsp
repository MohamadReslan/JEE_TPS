<%@ page import="tp2.example.tp2.model.EmployesEntity" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/09/2023
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
    <title>Bienvenue</title>
</head>
<body>
<p>Bienvenue ${utilisateur.getPrenomSaisi()} !</p>
<ul>

    <table style="border: solid gray 4px">
        <c:forEach var="employee" items="${allEmployees}">
            <tr style="border: solid aqua 4px">
                <th>Nom</th>
                <th>Prenom</th>
                <th>Adresse</th>
                <th>Email</th>
                <th>Telephone</th>
            </tr>
        <tr style="border: solid aqua 4px">
                <td>${employee.getNom()}</td>
                <td>${employee.getPrenom()}</td>
                <td>${employee.getAdresse()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getTelDom()}</td>
        </tr>
        </c:forEach>
    </table>
</ul>
</body>
</html>
