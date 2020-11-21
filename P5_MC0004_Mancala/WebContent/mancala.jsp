<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Play Mancala</title>

</head>
<body>
	<form method="get" action="MancalaServlet">
		<button type=submit name="newGame">New Game</button>
		<br>
		<table border="1">
			<tr>
				<td colspan="2">SCORE</td>
			</tr>
			<tr>
				<td>Player 1</td>
				<td>Player 2</td>
			</tr>
			<tr>
				<td>${game.gameBoard[0] }</td>
				<td>${game.gameBoard[7] }</td>
			</tr>
		</table>
		<br>
		Current Player: <c:if test="${game.player == 1 || game.player == 2}">${game.player}	</c:if>
		Current Turn: ${game.turn }
		<br>
		<table border="1">
			
				<tr>
					<c:forEach items="${game.gameBoard}" var="pocket" varStatus="state">
						<c:if test="${state.index != 0 && state.index != 7}">
							<td>
								<button type="submit" name="pNum" value="${state.index}">${pocket}</button>
							</td>
						</c:if>
						<c:if test="${state.count % 7 == 0 }">
							<tr>
						</c:if>
					</c:forEach>
				</tr>
			<c:if test="${game.winner != 0 }">Player ${game.winner } wins!</c:if>
		</table>
	</form>
</body>
</html>