<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
<head>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<form method="get" action="createAndUpdate">
    <a href="createAndUpdate">Add Meal</a>
    <br>
</form>

<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="mealTo" items="${requestScope.mealsTo}">
        <c:set var="color" value="${mealTo.excess ? 'red' : 'green'}"/>
        <fmt:parseDate value="${mealTo.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both"/>
        <tr style="color: ${color}" class="outer">
            <td>
                <a> <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ parsedDateTime }"/></a>
            </td>

            <td>
                <a> <c:out value="${mealTo.description}"/></a>
            </td>

            <td>
                <a> <c:out value="${mealTo.calories}"/></a>
            </td>

            <td>
                <form method="get" action="createAndUpdate">
                    <label>
                        <input type="number" hidden name="id" value="${mealTo.id}"/>
                        <input type="submit" name="update" value="Update" class="inner"/>
                    </label>
                </form>
            </td>

            <td>
                <form method="post" action="delete">
                    <label>
                        <input type="number" hidden name="id" value="${mealTo.id}"/>
                        <input type="submit" name="delete" value="Delete" class="inner"/>
                    </label>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
