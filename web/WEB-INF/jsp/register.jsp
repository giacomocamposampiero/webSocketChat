<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script type="text/javascript" src="resources/js/bootstrap.js"></script> 
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/css/formUtil.css">
        <link href="https://fonts.googleapis.com/css?family=Ubuntu+Mono" rel="stylesheet">
        <title>Sign up</title>
    </head>
    <body>
        <div class="container">
            <form:form class="form-signin" modelAttribute="user" name="formReg" action="/add" method="post" >
                <h1 class="form-signin-heading text-muted">Sign up now!</h1>
                <form:input type="text" path="username" id="username" maxlength="15" class="form-control" placeholder="Username" required="" autofocus=""/>
                <form:input type="email" path="mail" id="mail" class="form-control" maxlength="50" placeholder="Email" required=""/>
                <form:input type="password" path="passwd" id="passwd" class="form-control" maxlength="25" placeholder="Password" required=""/>
                <div class="button-group">
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
                    <button class="btn btn-lg btn-primary btn-block" type="reset">Reset fields</button>
                    <a href="/"><button class="btn btn-lg btn-primary btn-block" type="button">Back to login</button></a>
                </div>
                <c:if test = "${ErrMsg!=null}"><div id="err"  style="color:red;"> ${ErrMsg}</div></c:if>
            </form:form>
        </div>
    </body>
</html>
