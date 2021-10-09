<%-- 
    Document   : editnote
    Created on : 5-Oct-2021, 6:47:14 PM
    Author     : adamw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Simple Note Keeper</title>
        <link rel="stylesheet" href="Style/main.css" type="text/css"/>    
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <div>
            <form action="note" method="POST">
                <h2>Edit Note</h2>

                <h3>Title:</h3>
                <input type="text" name="EDIT_TITLE" value="${CONTENTS.title}">
                <h3>Contents:</h3>
                <input type="text" name="EDIT_CONTENTS" value="${CONTENTS.contents}" style="height:100px; width:300px;">

                <input type="submit" value="Save">     
                </div>
                </body>
                </html>
