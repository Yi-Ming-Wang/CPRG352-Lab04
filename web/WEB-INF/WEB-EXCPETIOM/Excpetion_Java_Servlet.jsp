<%-- 
    Document   : Excpetion_Java_Servlet
    Created on : 23-Sep-2021, 8:41:45 PM
    Author     : adamw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--ref textbook Ch.5 how to gracefully handle Java internal exception-->
        <h1>Java Error</h1>
        <p>Sorry, Java has thrown an exception.</p>
        <p>To continue, click the Back button.</p>

        <h2>Details</h2>
        <!--ref textbook Ch.5 how to gracefully handle Java internal exception. If any Exception occurred in Java. 
            return the exception object. and toString() from hushcode to readble message -->
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.message}</p>
    </body>
</html>
