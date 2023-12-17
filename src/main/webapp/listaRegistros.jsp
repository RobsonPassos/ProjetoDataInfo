<%@ page import="br.com.robson.bean.MeuEJB" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.robson.entity.SalvadadosxmlEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Lista de Dados XML</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        table {
            width: 80%; /* Ajuste conforme necessário */
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center; /* Alinhe o texto de todas as células ao centro */
        }

        th {
            background-color: #f2f2f2;
        }

        tbody {
            height: 300px; /* Altura desejada para o corpo da tabela */
            overflow-y: auto;
            display: block;
        }
    </style>
</head>
<body>

<jsp:useBean id="meuEJB" class="br.com.robson.bean.MeuEJB" />
<table>
    <thead>
    <tr>
        <th>Tags XML</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dados" items="${listaDados}">
        <tr>
            <td>${dados.id}</td>
            <td>${dados.tagsxml}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
