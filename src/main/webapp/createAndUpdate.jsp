<%@ page session="false" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
<head>
    <title>CreateAndUpdate</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Edit meal</h2>
<form method="post" action="createAndUpdate">
    <label> DateTime:
        <input name="date" value="${meal.dateTime}" type="datetime-local"/>
    </label>
    <br><br>

    <label> Description:
        <input name="description" value="${meal.description}"/>
    </label>
    <br><br>

    <label> Calories:
        <input name="calories" value="${meal.calories}" type="number"/>
    </label>
    <br><br>

    <label>
        <input type="number" hidden name="id" value="${meal.id}"/>
        <input type="submit" value="Save"/>
        <button type="cancel" onclick="window.location='http://localhost:8080/topjava/meals';return false;">Cancel
        </button>
    </label>
</form>
</body>
</html>
