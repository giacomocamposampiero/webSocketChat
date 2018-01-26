<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Socket Chat</title>
        <link href="resources/css/login.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="fullscreen_bg" class="fullscreen_bg"/>

        <div class="container">

            <form class="form-signin" name="formLog" action="/check" method="post" >
                <h1 class="form-signin-heading text-muted">Esegui l'accesso</h1>
                <c:if test = "${ErrMsg!=null}"><div id="err" style="color:red;"> ${ErrMsg}</div></c:if>
                <input type="text"  name="user" class="form-control" maxlength="15" placeholder="Username" required="" autofocus="">
                <input type="password" name="pass" class="form-control"  maxlength="25" placeholder="Password" required="">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
            </form>
        </div>
        <span>
            New User?   <a href="<c:url value='/register' />">Register Here</a>
        </span>
    </div>

</body>
</html>
