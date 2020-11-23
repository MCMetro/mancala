<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<title>Play Mancala</title>

</head>
<body>
	<form method="get" action="MancalaServlet">
		<br> <br>
		<div class="jumbotron text-center">
			<h1>Play Mancala</h1>
		</div>
		<div class="container" style="width: 500px;">
			<div class="h-100 row align-items-center">
				<br>
				<p style="font-weight: bold; text-align: left;">
					Current Player:
					<c:if test="${game.player == 1 || game.player == 2}">
						<c:if test="${game.player == 1}">
							<span style="color: #007bff">${game.player }</span>
						</c:if>
						<c:if test="${game.player == 2}">
							<span style="color: #ffc107">${game.player }</span>
						</c:if>
					</c:if>
				</p>

				<table>
					<thead>
						<tr>
							<th rowspan="2"><button type="submit"
									class="btn btn-primary" name="pNum" value="7"
									style="height: 78px;" disabled>
									<span style="font-weight: bold;">P1 ${game.gameBoard[7]}</span>
								</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="6" style="width: 50px;">${game.gameBoard[6]}</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="5" style="width: 50px;">${game.gameBoard[5]}</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="4" style="width: 50px;">${game.gameBoard[4]}</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="3" style="width: 50px;">${game.gameBoard[3]}</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="2" style="width: 50px;">${game.gameBoard[2]}</button></th>
							<th><button type="submit" class="btn btn-primary"
									name="pNum" value="1" style="width: 50px;">${game.gameBoard[1]}</button></th>

							<th rowspan="2"><button type="submit"
									class="btn btn-warning" name="pNum" value="0"
									style="height: 78px;" disabled>
									<span style="font-weight: bold;">${game.gameBoard[0]} P2</span>
								</button></th>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="8" style="width: 50px;">${game.gameBoard[8]}</button></td>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="9" style="width: 50px;">${game.gameBoard[9]}</button></td>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="10" style="width: 50px;">${game.gameBoard[10]}</button></td>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="11" style="width: 50px;">${game.gameBoard[11]}</button></td>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="12" style="width: 50px;">${game.gameBoard[12]}</button></td>
							<td><button type="submit" class="btn btn-warning"
									name="pNum" value="13" style="width: 50px;">${game.gameBoard[13]}</button></td>
						</tr>
					</thead>
				</table>
			</div>
			<p style="font-weight: bold; text-align: center; line-height: 100%;">
				<c:if test="${game.winner != 0 }">Player ${game.winner } has won!</c:if>
			</p>
		</div>


		<div class="container" style="width: 500px;">

			<div class="h-100 row align-items-center">
				<button type="submit" class="btn btn-success" name="newGame" style="margin-right:20px;">New
					Game</button>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="stoneSelection"
						id="4stones" value="4" checked="checked"> <label
						class="form-check-label" for="inlineRadio1">4 Stones</label>
				</div>
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="stoneSelection"
						id="5stones" value="5"> <label class="form-check-label"
						for="inlineRadio2">5 Stones</label>
				</div>

			</div>


			<div class="h-100 row align-items-center">
				<a class="btn btn-primary" data-toggle="collapse"
					href="#collapseExample" role="button" aria-expanded="false"
					aria-controls="collapseExample" style="margin-top: 10px;"> Rules </a>
				<div class="collapse" id="collapseExample">
					<div class="card card-body">
						<ul class="list-group">
							<li class="list-group-item">The game begins with one player
								picking up all of the pieces in any one of the pockets on
								his/her side.</li>
							<li class="list-group-item">Moving counter-clockwise, the
								player deposits one of the stones in each pocket until the
								stones run out.</li>
							<li class="list-group-item">If you run into your own Mancala
								(store), deposit one piece in it. If you run into your
								opponent's Mancala, skip it and continue moving to the next
								pocket.</li>
							<li class="list-group-item">If the last piece you drop is in
								your own Mancala, you take another turn.</li>
							<li class="list-group-item">If the last piece you drop is in
								an empty pocket on your side, you capture that piece and any
								pieces in the pocket directly opposite.</li>
							<li class="list-group-item">Always place all captured pieces
								in your Mancala (store).</li>
							<li class="list-group-item">The game ends when all six
								pockets on one side of the Mancala board are empty</li>
							<li class="list-group-item">The player who still has pieces
								on his/her side of the board when the game ends captures all of
								those pieces.</li>
							<li class="list-group-item">Count all the pieces in each
								Mancala. The winner is the player with the most pieces.</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</form>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>
</html>