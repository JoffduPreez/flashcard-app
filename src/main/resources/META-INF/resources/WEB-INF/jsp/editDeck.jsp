<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Flashcard Deck</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/deckForm.css"/>
    </head>
    <body>

        <div class="container">
            <h1>Add a New Flashcard Deck</h1>
            <form id="editDeckForm" method="post">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" value="${deck.title}" required>
                
                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="4" required>${deck.description}</textarea>

                <button type="submit" id="submitBtn" data-deck-id=${deck.id}>Save Deck</button>
            </form>
        </div>
    </body>

    <script src="${pageContext.request.contextPath}/js/editDeck.js"></script>
</html>
