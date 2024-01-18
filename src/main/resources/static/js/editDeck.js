// Add event listener for submitting the edit form
document.addEventListener('DOMContentLoaded', function() {
    var editDeckForm = document.getElementById('editDeckForm');

    editDeckForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent the default form submission
        var submitBtn = document.getElementById("submitBtn");
        console.log(submitBtn);
        var deckId = submitBtn.getAttribute('data-deck-id');
        editDeck(deckId);
    });
});


function editDeck(deckId){
    var basePath = getBasePath();
    var title = document.getElementById('title').value;
    var description = document.getElementById('description').value;

    var data = {
        id: deckId,
        title: title,
        description: description
    };

    fetch(basePath + '/editDeck', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response;
    })
    .then(data => {
        window.location.href = basePath + '/deck';
        console.log('Deck updated successfully');
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
    });

}


function getBasePath() {
    var protocol = window.location.protocol;
    var host = window.location.host;
    return protocol + '//' + host;
}