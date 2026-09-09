<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring MVC JSP Demo</title>
    <link rel="stylesheet" href="/assets/style.css">
</head>
<body>

<div class="container">

    <h1>Spring MVC JSP Demo</h1>

    <p>${message}</p>

    <form action="/greet" method="post">
        <input type="text" name="name" placeholder="Enter your name" required>
        <button type="submit">Submit</button>
    </form>

</div>

</body>
</html>