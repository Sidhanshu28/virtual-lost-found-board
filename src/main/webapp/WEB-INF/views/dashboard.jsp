<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>View all feeds</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/styles/css/style.css' />" rel="stylesheet"></link>
<link href="<c:url value='/styles/css/bootstrap.css' />"
	rel="stylesheet"></link>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

</head>
<body style="background-image: linear-gradient(to top,#5d817b,#d1dbcf);">
	<div class="container" style="padding:0 !important;background-image: linear-gradient(#5f813f,#c1c145);">
	<div class="header">
		<h1 align="center"><strong>VIRTUAL BOARD</strong></h1>
	</div>
	<div class="header-line">
		<h4 align="center">Welcome to the Virtual Lost and Found Board</h4>
	</div>
	<div class="container-fluid">
	<div class="boxes">
		<form:form class="form-horizontal">
			<span style="margin-left:75px;color:black"><i>Lost something?</i><a class="lost-link" href="lostentry">Click here!</a></span>
			<div class="lost-list-div list-div blinking-lost-border">
				<div class="lost-list-header list-header blinking-lost"><strong>LOST BOARD</strong></div>
				<ul class="lost-list list">
					<c:forEach var="lost" items="${lost_list}">
						<li>
							<a href="viewentry/${lost.id}"><strong>#${lost.category} </strong> - ${lost.desc}</a>
						</li>
					</c:forEach>
				</ul>
				<span><a href="viewallentries/lost" style="color:black;float:right;margin-right:20px">view all -></a></span>
			</div>
		</form:form>
	</div>
	<div class="boxes">
	<form:form class="form-horizontal">
		<span style="margin-left:75px;color:black">&nbsp;</span>
					<div class="claim-list-div list-div">
				<div class="claim-list-header list-header"><strong>CLAIM BOARD</strong></div>
				<ul class="claim-list list">
					<c:forEach var="claim" items="${claim_list}">
						<li>
							<a href="viewentry/${claim.id}"><strong>#${claim.category} </strong> - ${claim.desc}</a>
						</li>
					</c:forEach>
				</ul>
				<span><a href="viewallentries/claim" style="color:black;float:right;margin-right:20px">view all -></a></span>
			</div>
		</form:form>
	</div>
		
	<div class="boxes">
	<form:form class="form-horizontal">
		<span style="margin-left:75px;color:black"><i>Found something?</i><a class="lost-link" href="foundentry">Click here!</a></span>
			<div class="found-list-div list-div blinking-found-border">
				<div class="found-list-header list-header blinking-found"><strong>FOUND BOARD</strong></div>
				<ul class="found-list list">
					<c:forEach var="found" items="${found_list}">
						<li>
							<a href="viewentry/${found.id}"><strong>#${found.category} </strong> - ${found.desc}</a>
						</li>
					</c:forEach>
				</ul>
				<span><a href="viewallentries/found" style="color:black;float:right;margin-right:20px">view all -></a></span>
			</div>
		</form:form>
	</div>
	</div>
		<br>
	</div>
</body>
</html>
