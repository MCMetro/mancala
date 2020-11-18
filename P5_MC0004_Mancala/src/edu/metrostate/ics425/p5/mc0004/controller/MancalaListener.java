package edu.metrostate.ics425.p5.mc0004.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import edu.metrostate.ics425.p5.mc0004.model.Game;

/**
 * Application Lifecycle Listener implementation class MancalaListener
 *
 */
@WebListener
public class MancalaListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MancalaListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Beginning of the Listener...");
        se.getSession().setAttribute("game", new Game()); 
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

}
