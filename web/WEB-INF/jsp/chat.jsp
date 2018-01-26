<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Chat Room</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <script src="resources/js/chat.js"></script>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body onload="connect('${username}');" onunload="disconnect();">
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading"><h1>Chat room</h1></div>
                    <div class="panel-body">
                        <div id="container" class="box">
                        </div>
                        <div class="panel-footer">
                            <div class="input-group">
                                <input id="messageInput" type="text" class="form-control">
                                <span class="input-group-btn">
                                    <button class="btn btn-default"  id="send" type="button" onclick="sendMessage();">Invia</button>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a href ="/">Indietro </a>
        </div>
    </body>
</html>