<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
    <title>Books</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="../resources/js/books_controler.js"></script>
    <link rel="stylesheet" type="text/css" href="../resources/css/index.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/table.css">
</head>

<body>
<div id="lang">
    Language : <a href="?language=en">English</a>|
    <a href="?language=ua">Ukrainian</a>
</div>

        <spring:message code="title"/>:
        <input type="text" id="title" class="datainput"/>
        <spring:message code="author"/>:
        <input type="text" id="author" class="datainput"/>
        <spring:message code="pages"/>:
        <input type="text" id="pages" class="datainput"/>
        <spring:message code="genre"/>:
        <input type="text" id="genre" class="datainput"/>
        <button id=addBtn class="funcBtn" onclick="addBook()" ><spring:message code="addBook"/></button>

<table id="table" border="1">
    <tr>
        <th><spring:message code="id"/></th>
        <th><spring:message code="title"/></th>
        <th><spring:message code="author"/></th>
        <th><spring:message code="pages"/></th>
        <th><spring:message code="genre"/></th>
        <th><spring:message code="update"/></th>
        <th><spring:message code="delete"/></th>
    </tr>
</table>

<div id="openModal" class="modalDialog">
    <div>
        <a href="#close" title="Close" id="close" class="close">X</a>

        <form class="form-container">
            <div class="form-title"><h2><spring:message code="update"/></h2></div>
            <div class="form-title"><spring:message code="id"/>: <span id="bookId"></span></div>
            <div class="form-title"><spring:message code="title"/></div>
            <input class="datainput" type="text" name="title"/><br/>
            <div class="form-title"><spring:message code="author"/></div>
            <input class="datainput" type="text" name="author"/><br/>
            <div class="form-title"><spring:message code="pages"/></div>
            <input class="datainput" type="text" name="pages"/><br/>
            <div class="form-title"><spring:message code="genre"/></div>
            <input class="datainput" type="text" name="genre"/><br/>
            <button class="submit-button" id="save"><spring:message code="save"/></button>
            <br/>
        </form>
    </div>
</div>
<a id="openM" href="#openModal"></a>
</body>
</html>
