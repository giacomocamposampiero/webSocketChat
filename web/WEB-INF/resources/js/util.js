var endPointURL = "ws://" + window.location.host + "/server";
var chatClient = null;
var user = null;
var registered = false;

function connect(username) {
    user = username;
    document.getElementById("messageInput").addEventListener("keyup", function (event) {
        event.preventDefault();
        if (event.keyCode === 13)
            sendMessage();
    });
    chatClient = new WebSocket(endPointURL);
    chatClient.onmessage = function (event) {
        var messageContainer = document.getElementById("container");
        var jsonObj = JSON.parse(event.data);
        messageContainer.innerHTML = messageContainer.innerHTML + '<div class="row message-bubble"><p><b style="color:#66FF00;">' + jsonObj.user + '@websocketchat</b>:-$' + '</p><p>' + jsonObj.message + '</p> </div>';
        messageContainer.scrollTop = messageContainer.scrollHeight;
    };
    document.getElementById("messageInput").focus();
}

function disconnect() {
    chatClient.close();
}

function sendMessage() {
    var inputElement = document.getElementById("messageInput");
    var message = inputElement.value.trim();
    if(!registered) {
        var jsonObj = {"user": user, "message": "-register"};
        chatClient.send(JSON.stringify(jsonObj));
        registered = true;
    }
    if (message !== "") {
        var jsonObj = {"user": user, "message": message};
        chatClient.send(JSON.stringify(jsonObj));
        inputElement.value = "";
        var messageContainer = document.getElementById("container");
        messageContainer.innerHTML = messageContainer.innerHTML + '<div class="row message-bubble" style="text-align: right;"><p><b style="color:#66FF00">me@websocketchat</b>:-$' + '</p><p>' + message + '</p> </div>';
        messageContainer.scrollTop = messageContainer.scrollHeight;
    }
    inputElement.focus();
}