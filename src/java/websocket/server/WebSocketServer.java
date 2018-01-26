package websocket.server;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat")
public class  WebSocketServer  {
    
    private static final Set<Session> userSessions = Collections.synchronizedSet(new HashSet<>());

    /**
     * Metodo invocato all'apertura della connessione di un client
     * @param userSession   sessione del client
     */
    @OnOpen
    public void onOpen(Session userSession) {
        userSessions.add(userSession);
    }//onOpen
     
    /**
     * Metodo invocato alla chiusura della connessione di un client
     * @param userSession   sessione del client
     */
    @OnClose
    public void onClose(Session userSession) {
        userSessions.remove(userSession);
    }//onClose
     
    /**
     * Metodo invocato quando un client manda un messaggio
     * @param message testo del messaggio
     * @param userSession sessione del client mittente
     */
    @OnMessage
    public void onMessage(String message, Session userSession) {
        for (Session session : userSessions) session.getAsyncRemote().sendText(message);
    }//onMessage

    @OnError
    public void onError(Throwable t) {
    }
    
}