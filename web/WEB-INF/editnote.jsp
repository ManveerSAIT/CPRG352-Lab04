
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <div>
            <form method="POST" action="note">
                <label>Title: </label>
                <input type="text" name="title" value="${note.title}">
                <br>
                <label>Contents: </label>
                <input type="textarea" name="contents" value="${note.contents}">
                <br>
                <input type="submit" name="submitbutton" value="Save">
            </form>
        </div>
    </body>
</html>
