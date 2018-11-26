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
<body>
	<div class="container">
		<div class="addfeed">
			<form:form method="POST" name="loginform" modelAttribute="entries" action="save">

				<div class="form-group row justify-content-md-center">
					<label for="FeedName" class="col-lg-2 col-form-label text-md-right">
						Category :</label>
					<div class="col-lg-4">
						<form:input type="text" path="lostCategory" name="lostcategory" id="lostCategory"
							class="form-control" placeholder="Enter Category" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											Desc :</label>
					<div class="col-lg-4">
						<form:input type="text" name="lostdesc" path="lostDesc" id="lostDesc"
							class="form-control" placeholder="https://www.example.com" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											Location :</label>
					<div class="col-lg-4">
						<form:input type="text" name="lostlocation" path="lostLocation" id="lostLocation"
							class="form-control" placeholder="https://www.example.com" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											Date :</label>
					<div class="col-lg-4">
						<form:input type="text" name="lostdate" path="lostDate" id="lostDate"
							class="form-control" placeholder="https://www.example.com" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											Prize :</label>
					<div class="col-lg-4">
						<form:input type="text" name="lostprize" path="lostPrize" id="lostPrize"
							class="form-control" placeholder="https://www.example.com" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<div class="col-lg-2">
						<input type="submit" value="Add Entry" class="btn btn-primary" >
					</div>
				</div>



			</form:form>
		</div>
	</div>
</body>
</html>
