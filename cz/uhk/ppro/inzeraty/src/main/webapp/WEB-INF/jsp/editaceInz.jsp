<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Výpis inzerátů</title>
</head>
<body>
<h1>Výpis inzerátů</h1>
<br>
<p>Filtrace:</p></br>

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
            <td>
                <form action="editace" style="display: inline">
                    <input type="hidden" name="akce" value="remove" />
                    <input type="hidden" name="polId" value="${p.id }" />
                    <input type="submit" value=" X ">
                </form>
                <form action="inzerat" style="display: inline">
                    <input type="hidden" name="polId" value="${p.id }" />
                    <input type="submit" value=" E ">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
[<a href="vypis">Zpět na výpis</a>]<br/>
</body>
</html>
