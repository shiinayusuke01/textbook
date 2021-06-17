<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
List<String> list = new ArrayList<>();
list.add("Hello 1.");
list.add("Hello 2.");
request.setAttribute("list", list);
%>

<c:forEach var="item" items="${list}">
<c:out value="${item}" />
</c:forEach>