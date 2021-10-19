<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Výpis inzerátů v kategorii Prodej</title>
</head>
<body>
<h1>Výpis inzerátů v kategorii Prodej</h1>
<br>
<p>Filtrace:</p></br>
[<a href="vypis">Všechny</a>]
[<a href="vypis-nakup">Nákup</a>]
[<a href="vypis-vymena">Výměna</a>]
</div>
<table border="1">
    <tr>
        <th>Text inzerátu</th>
        <th>Cena</th>
        <th>Kategorie</th>
    </tr>
    <c:forEach var="i" items="${inzerat}">
        <tr>
            <td>${i.nazev }</td>
            <td align="right">
                    ${i.text }
            </td>
            <td align="center">
                <fmt:formatNumber pattern="#,##0.00 Kč" value="${i.cena }"/>
            </td>
            <td align="right">
                    ${i.kategorie }
            </td>
        </tr>
    </c:forEach>
</table>
[<a href="inzerat">Přidej inzerát</a>]<br/>
[<a href="editace">Edituj inzeráty</a>]<br/>
</body>
</html>

