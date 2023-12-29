<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Flashcard Decks</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/deck.css"/>
    </head>
    <body>
        <div class="container">
            <h1>Decks</h1>
            <a class="button button-add" href="/addDeck">Add a Deck</a>
            <div id="todo-container">
                <c:forEach items="${decks}" var="decks">
                    <div class="todo-item">
                        <p class="todo-text">${decks.title}</p>
                        <div class="actions">
                            <button class="button button-edit">Edit</button>
                            <button class="button button-delete">Delete</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </body>
</html>
