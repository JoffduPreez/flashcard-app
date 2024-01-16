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
            <a class="button button-add" href="${pageContext.request.contextPath}/addDeck">Add a Deck</a>
            <div id="todo-container">
                <c:forEach items="${decks}" var="decks">
                    <div class="todo-item">
                        <p class="todo-text">${decks.title}</p>
                        <div class="actions">
                            <button class="button button-edit">Edit</button>
                            <!-- <a class="button button-delete" href="${pageContext.request.contextPath}/deleteDeck?id=${decks.id}">Delete</a> -->
                            <button class="button button-delete" data-deck-id=${decks.id}>Delete</button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>

    <script src="${pageContext.request.contextPath}/js/deck.js"></script>
</html>
