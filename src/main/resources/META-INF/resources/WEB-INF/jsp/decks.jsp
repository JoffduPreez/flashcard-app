<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>To-Do List</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/decks.css"/>
    </head>
    <body>
        <div class="container">
            <h1>To-Do List</h1>
            <button class="button">Add To-Do</button>
            <div id="todo-container">
                <!-- Example To-Do -->
                <div class="todo-item">
                    <p class="todo-text">Learn HTML and CSS</p>
                    <div class="actions">
                        <button class="button button-delete">Delete</button>
                        <button class="button button-edit">Edit</button>
                    </div>
                </div>
                <!-- More To-Dos -->
            </div>
        </div>

    </body>
</html>
