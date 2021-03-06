<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WebSocketChat</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="resources/js/util.js"></script>
        <link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/index.css" rel="stylesheet" type="text/css"/>
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css?family=Ubuntu+Mono" rel="stylesheet">
    </head>
    <body onload="connect('${username}');" onunload="disconnect();">
        <div id="main">
            <div class="panel panel-default">
                <div id="container" class="panel-body box">
                    <div class="row message-bubble">
                        <p><b style="color:#66FF00">root@websocketchat</b>:-$</p>
                        <p>Welcome to this chat room! Type -help to have a list of avalaible commands</p> 
                    </div>
                </div>
            </div>
            <div class="panel-footer">
                <input id="messageInput" type="text" class="form-control" placeholder="Write your message here...">
            </div>
        </div>
    </body>
</html>