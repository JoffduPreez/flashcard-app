// Add event listener for submitting the edit form
document.addEventListener('DOMContentLoaded', function() {
    var reVerifyButton = document.getElementById('reVerify');

    reVerifyButton.addEventListener('click', function(event) {
        reVerifyEmail();
    });
});

function reVerifyEmail() {
    // Retrieve CSRF token from meta tags
    var token = document.querySelector('meta[name="_csrf"]').getAttribute('content');
    var header = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

    // Make a POST request to /verify
    fetch('/verify', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            [header]: token, // Include CSRF token in the request header
        }
    })
    .then(function(response) {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json;
    })
    .then(function(data) {
        // Handle the response data
        console.log(data);
        if (data.status = 200) {
            alert('Verification email resent successfully!');
        } else {
            alert('There was an error resending the verification email.');
        }
    })
    .catch(function(error) {
        // Handle any errors that occurred during the fetch
        console.error('Error:', error);
        alert('There was an error resending the verification email.');
    });
}