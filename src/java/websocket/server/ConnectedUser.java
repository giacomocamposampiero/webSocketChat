package websocket.server;

import javax.websocket.Session;

public class ConnectedUser {
    
    private final Session userSession;
    private String username;

    public ConnectedUser(Session userSession) {
        this.userSession = userSession;
        username ="";
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public boolean isThisUser(Session session){
        return session == userSession;
    }

    public void sendMessage(String message){
        userSession.getAsyncRemote().sendText(message);
    }
    
    
    
}
