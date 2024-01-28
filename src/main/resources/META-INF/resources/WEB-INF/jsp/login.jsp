<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FlashFocus</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login-register.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Itim&display=swap" rel="stylesheet">
</head>
<body>
    <main>
        <header>
            <p class="title">Flash Focus</p>
            <button id="switch-login-register" class="button">Sign Up</button>
        </header>

        <section id="content">
            <div id="column-1" class="column">
                <div id="text-content">
                    <p class="sub-title">Login</p>
                    <p>Hey, welcome back!</p>
                </div>

                <form action="/login" method="post">
                    <div class="group">      
                        <input type="text" required>
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <label>Username</label>
                    </div>
                        
                    <div class="group">
                        <input type="password" required>
                        <span class="highlight"></span>
                        <span class="bar"></span>
                        <label>Password</label>
                    </div>

                    <input type="submit" value="Login" class="button">
                </form>

            </div>
            <div id="column-2" class="column">
                <img src="${pageContext.request.contextPath}/images/learning-cropped.png" alt="Learning image">
            </div>
        </section>
    </main>
</body>
</html>