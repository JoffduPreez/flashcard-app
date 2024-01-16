
// Add event listener to the delete buttons
document.addEventListener('DOMContentLoaded', function() {
    var deleteButtons = document.querySelectorAll('.button-delete');

    // Add an event listener to each button
    deleteButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            var deckId = button.getAttribute('data-deck-id');
            deleteDeckById(deckId);
        });
    });
});

function deleteDeckById(deckId){
    var basePath = getBasePath();

    fetch(basePath + '/deleteDeck?id=' + deckId, {
    method: 'DELETE',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response;
    })
    .then(data => {
        window.location.href = basePath + '/deck';
        console.log('Deck deleted successfully');
    })
    .catch(error => {
        console.error('There has been a problem with your fetch operation:', error);
    });

}

function getBasePath() {
    var protocol = window.location.protocol;
    var host = window.location.host; // This includes hostname and port if the port is included
    return protocol + '//' + host;
}