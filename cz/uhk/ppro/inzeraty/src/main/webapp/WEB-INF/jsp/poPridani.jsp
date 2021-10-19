<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Detail položky</title>
</head>
<body>
<h1>Vaše heslo pro pozdější editaci inzerátu</h1>
<strong>${inzerat.getHesloProUpravu()}</strong>
[<a href="vypis.do">Zpět k inzerátům</a>]
</body>
</html>
