<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
    JSP page:
    This page acts as the View in our Spring MVC application.

    Data is received from the Controller through the Model.
    Example:
        model.addAttribute("message", "Enter your name");

    That value can be displayed using:
        ${message}
--%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Spring MVC JSP Demo</title>

    <%--
        Loads the CSS file from the /assets/ location.

        /assets/** is configured in WebConfig using
        addResourceHandlers().
    --%>
    <link rel="stylesheet" href="/assets/style.css">
</head>

<body>

<div class="container">

    <h1>Spring MVC JSP Demo</h1>

    <%--
        ${message} is Expression Language (EL).

        It reads the "message" attribute that was added
        to the Model by the Controller.

        Example:
            model.addAttribute("message", "Enter your name");
    --%>
    <p>${message}</p>


    <%--
        Form submission:

        action="/greet"
        ----------------
        The form sends the request to /greet.

        method="post"
        -------------
        The request is sent using HTTP POST.

        The input field has:
            name="name"

        This name matches the parameter expected by:

            @RequestParam String name

        in the Controller.
    --%>
    <form action="/greet" method="post">

        <input type="text"
               name="name"
               placeholder="Enter your name"
               required>

        <button type="submit">Submit</button>
    </form>

</div>

</body>
</html>