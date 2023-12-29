<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add New Flashcard Deck</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/addDeck.css"/>
    </head>
    <body>

        <div class="container">
            <h1>Add a New Flashcard Deck</h1>
            <form id="newDeckForm" action="/addDeck" method="post">
                <label for="title">Title:</label>
                <input type="text" id="title" name="title" required>

                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="4" required></textarea>

                <button type="submit">Add Deck</button>
            </form>
        </div>

    </body>
</html>
