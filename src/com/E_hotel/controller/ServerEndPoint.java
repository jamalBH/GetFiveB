package com.E_hotel.controller;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.metier.ChambreCategorieMetier;
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.CompteMetier;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@ServerEndpoint(value="/ff/{clientId}" )
public class ServerEndPoint {
	
	@Autowired
	ImpdaoUser impdaouser ;
	
	@Autowired
	Hotel hot ;
	
	
    private volatile String clientId; 
	private  Session session ;
	public static Map<String,Session> sessions = new ConcurrentHashMap<String, Session>(); ;
	


	@OnOpen
	    public void open(@PathParam("clientId") String clientId,Session session ) throws IOException {
        this.clientId = clientId;
		 this.session=session ;
		 System.out.println("session =" + session);
		 sessions.put(this.clientId,session) ;
		 		 
	    }

	 @OnClose
	    public void close(Session session )  {
		 
		 this.session=null ;
		 sessions.put(clientId,null) ;

		 System.out.println("closed ....!");
	        
	    }

	
    
	 @OnError
	    public void onError(Throwable error) {
		 System.out.println("error ....!");
	    //    Logger.getLogger(ServerEndPoint.class.getName()).log(Level.SEVERE, null, error);
	    }  
	 
	    @OnMessage
	    public void handleMessage(String message) {

			 
			 JsonParser parser = new JsonParser();
			 JsonObject json = (JsonObject) parser.parse(message);
			 

			 sessions.get(json.get("id").getAsString()).getAsyncRemote().sendText(json.get("message").getAsString()) ;


	        
    }
	    
	    
	    @RequestMapping(value="/toto")
	   	public String toto(Model model,String message,HttpServletRequest request){
			hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 

			model.addAttribute("f", hot.getId_hotel());

	    return "tt"; 
	   	}
}
