<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Adiciona/Salva um XML</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        form {
            text-align: center;
        }

        label {
            margin-bottom: 10px;
            display: block;
        }
    </style>
</head>
<body>

<form action="minhaServlet" method="POST" enctype="multipart/form-data">

    <h2>Adiciona/Salva um XML</h2>

    <label for="xmlFile">Escolha um arquivo XML:</label>
    <br>
    <input type="file" name="xmlFile" id="xmlFile" accept=".xml" required>
    <br>
    <input type="submit" value="Enviar Arquivo">
</form>

</body>
</html>