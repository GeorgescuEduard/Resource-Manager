<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% if (pageContext.getAttribute("activeTab") == null) { pageContext.setAttribute("activeTab", "users"); } %>
    <!DOCTYPE html>
    <html>

    <head>
        <link rel="stylesheet" href="/resources/bootstrap.min.css" />
        <script src="/resources/jquery-3.5.1.min.js"></script>
        <script src="/resources/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/resources/style.css" />
        <title>Home</title>
        
    </head>

    <body>