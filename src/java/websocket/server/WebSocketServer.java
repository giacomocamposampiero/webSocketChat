package websocket.server;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@ServerEndpoint(value = "/server")
public class WebSocketServer {

    private static final Set<ConnectedUser> users = Collections.synchronizedSet(new HashSet<>());
    private static final String HELP = "Avalaible commands:<ul><li>-help     shows avalaible commands</li><li>-userlist    shows users connected</li></ul>";
    private static final String ERROR = "Error! Selected command doesn't exist!";

    /**
     * Metodo invocato all'apertura della connessione di un client
     *
     * @param userSession sessione del client
     */
    @OnOpen
    public void onOpen(Session userSession) {
        users.add(new ConnectedUser(userSession));
    }//onOpen

    /**
     * Metodo invocato alla chiusura della connessione di un client
     *
     * @param userSession sessione del client
     */
    @OnClose
    public void onClose(Session userSession) {
        for (ConnectedUser tmp : users) {
            if (tmp.isThisUser(userSession)) {
                users.remove(tmp);
                break;
            }
        }
    }//onClose

    /**
     * Metodo invocato quando un client manda un messaggio
     *
     * @param message testo del messaggio
     * @param userSession sessione del client mittente
     */
    @OnMessage
    public void onMessage(String message, Session userSession) {
        String decoded = getMessage(message);
        if (decoded.charAt(0)=='-'){
            String command = decoded.substring(1);
            switch (command) {
                case "help":
                    userSession.getAsyncRemote().sendText(createMessage(HELP));
                    break;
                case "userlist":
                    String list = "Connected users:<ul>";
                    for (ConnectedUser tmp : users) {
                        list += "<li>" + tmp.getUsername() + "</li>";
                    }
                    list += "</ul>";
                    userSession.getAsyncRemote().sendText(createMessage(list));
                    break;
                case "register":
                    String user = getUsername(message);
                    for (ConnectedUser tmp : users) {
                        if (tmp.isThisUser(userSession) && tmp.getUsername().equals("")) {
                            tmp.setUsername(user);
                            break;
                        }
                    }
                    break;
                case "como":
                    userSession.getAsyncRemote().sendText(createMessage("&#9773&#9773Hasta siempre capitano&#9773&#9773"));;
                    break;
                default:
                    userSession.getAsyncRemote().sendText(createMessage(ERROR));
                    break;
            }
        } else {
            for (ConnectedUser tmp : users) {
                if (!tmp.isThisUser(userSession)) {
                    tmp.sendMessage(message);
                }
            }
        }
    }//onMessage

    @OnError
    public void onError(Throwable t) {
    }

    private String createMessage(String message) {
        JSONObject obj = new JSONObject();
        obj.put("user", "root");
        obj.put("message", message);
        StringWriter out = new StringWriter();
        try {
            obj.writeJSONString(out);
        } catch (IOException ex) {}
        return out.toString();
    }

    private String getUsername(String message) {
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(message);
        } catch (ParseException pe) {
        }
        return (String) obj.get("user");
    }

    private String getMessage(String message) {
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(message);
        } catch (ParseException pe) {
        }
        return (String) obj.get("message");
    }
}
