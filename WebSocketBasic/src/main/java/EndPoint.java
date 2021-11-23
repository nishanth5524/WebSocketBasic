import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;


@ServerEndpoint("/end-point")
public class EndPoint {

	@OnClose
	public void onClose(Session session)
	{
		System.out.println("Close Session " + session.getId());
	}
	
	@OnOpen
	public void onOpen(Session session) throws IOException
	{
		System.out.println("Open Session " + session.getId());
		session.getBasicRemote().sendText("Hi from java" + "(session = " + session.getId()+")");
	}
	
	@OnError
	public void onError(Throwable t)
	{
		System.out.println("Error");
		System.out.println(t.getMessage());
	}
	
	@OnMessage
	public void onMessage(String message, Session session)
	{
         System.out.println("Message - > "+message);		
	}
	
}
