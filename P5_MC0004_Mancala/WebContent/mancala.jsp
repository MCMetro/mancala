<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Play Mancala</title>

</head>
<body>
${game.gameBoard}
	<button type=submit value="newGame">New Game</button>
	<br> 
	Player1: ${game.gameBoard[0].stones} - Player 2:
	${game.gameBoard[7]}
	<br>
	<table>
		<c:forEach items="${game.gameBoard }" var="pocket" varNum="num">
			<tr>
				<button type="submit" name="pNum" value="${pocket }">${num }</button>
			</tr>
		</c:forEach>
	</table>
</body>
</html>