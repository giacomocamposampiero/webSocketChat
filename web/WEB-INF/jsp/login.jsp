<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link href="resources/css/formUtil.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu+Mono" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <form class="form-signin" name="formLog" action="/check" method="post" >
                <h1 class="form-signin-heading text-muted">Sign in!</h1>
                <c:if test = "${ErrMsg!=null}"><div id="err" style="color:red;"> ${ErrMsg}</div></c:if>
                <input type="text"  name="user" class="form-control" maxlength="15" placeholder="Username" required="" autofocus="">
                <input type="password" name="pass" class="form-control"  maxlength="25" placeholder="Password" required="">
                <div class="button-group">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                    <a href="<c:url value='/register' />"><button class="btn btn-lg btn-primary btn-block" type="button">Sign up now!</button></a>                
                </div>
            </form>
        </div>
    </body>
</html>