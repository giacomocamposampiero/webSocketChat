<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="resources/css/register.css">
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <title> Sign up</title>
    </head>

       <div id="fullscreen_bg" class="fullscreen_bg"/>

        <div class="container">
            <form:form class="form-signin" modelAttribute="user" name="formReg" action="/add" method="post" >
                <h1 class="form-signin-heading text-muted">Registrati!</h1>
                <form:input  type="text" path="username" id="username" maxlength="15" class="form-control" placeholder="Username" required="" autofocus=""/>
                <form:input type="email" path="mail" id="mail" class="form-control" maxlength="50" placeholder="Email" required=""/>
                <form:input type="password" path="passwd" id="passwd" class="form-control" maxlength="25" placeholder="Password" required=""/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Registrati</button>
                <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
                <c:if test = "${ErrMsg!=null}"><div id="err"  style="color:red;"> ${ErrMsg}</div></c:if>
            </form:form>
        </div>
       </div>
    <script type="text/javascript" src="resources/js/bootstrap.js"></script> 
</body>

</html>
