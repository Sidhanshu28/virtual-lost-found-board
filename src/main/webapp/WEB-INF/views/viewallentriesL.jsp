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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">

</head>
<body style="background-image: linear-gradient(to top,#5d817b,#d1dbcf);">
	<div class="container" style="padding:0 !important;background-image: linear-gradient(#5f813f,#c1c145);">
	<div class="header">
		<h1 align="center"><strong>VIRTUAL BOARD</strong></h1>
	</div>
	<div class="header-line">
		<h4 align="center">Welcome to the Virtual Lost and Found Board</h4>
	</div>
	<div class="back-link">
		<h5><a href="/rssfeeds/dashboard" style="float:right;margin-right:50px;"> Dashboard</a><i style="float:right" class="material-icons">dashboard</i></h5>
	</div>
		<div class="container-fluid" style="text-align:center;">
		Lost Entries
			<ul class="entries-list list" style="padding:70px 0 60px 0 !important;margin:auto;width:75%;">
					<c:forEach var="entry" items="${entries_list}">
						<li>
							<a href="viewentry/lost/${entry.id}"><strong>#${entry.category} </strong> - ${entry.desc} </a> reported on date - ${entry.date} at <strong>${entry.location}</strong>
						</li>
					</c:forEach>
				</ul>
		</div>
	</div>


</body>
</html>