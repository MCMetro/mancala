package edu.metrostate.ics425.p5.mc0004.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.metrostate.ics425.p5.mc0004.model.Game;

/**
 * Servlet implementation class MancalaServlet
 */
@WebServlet("/MancalaServlet")
public class MancalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MancalaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log("Beginning of Servlet...");
		// 1. Get information - The game from the session - The pocket to be moved.
		var game = (Game) request.getSession(true).getAttribute("game");
		var pNum = request.getParameter("pNum");
		var newGame = request.getParameter("newGame");
		var numStones = request.getParameter("stoneSelection");
		
		// 2. Validate the move
		
		// 3. "Do it" Get the game 
		if (newGame != null) {
			game.createGameBoard(Integer.parseInt(numStones));
		} else {
			game.setMove(Integer.parseInt(pNum));
		}
		
		// 4. Store info...
		//request.getSession(true).setAttribute("game", game);
		// 5. forward control
		
		request.getRequestDispatcher("/mancala.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
