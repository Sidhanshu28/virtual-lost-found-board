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
		<h5><a href=".././dashboard" style="float:right;margin-right:50px;color:yellow"> Dashboard</a><i style="float:right" class="material-icons">dashboard</i></h5>
	</div> 
			<div class="container-fluid" style="text-align:center;">
		LOGIN
	
		<div class="formBox">
		<c:if test="${not empty error}">
		<form:form method="POST" class="form-form" name="loginform" modelAttribute="login-entries" action=".././loginCheck" onsubmit="return validate(event);">
    				<p>${error}</p>
				<div class="form-group row justify-content-md-center">
					<label for="userName" class="col-lg-2 col-form-label text-md-right">
						<strong>Username :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="userName" path="userName" id="userName"
							class="form-control" placeholder="username" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="password" class="col-lg-2 col-form-label text-md-right">
											<strong>Password :</strong></label>
					<div class="col-lg-4">
						<form:input type="password" name="password" path="password" id="password"
							class="form-control" placeholder="*********" />
					</div>
				</div>


				<div class="form-group row justify-content-md-center">
					<div class="col-lg-2">
						<input type="submit" value="Login" class="btn btn-primary" >
					</div>
				</div>



			</form:form>
				</c:if>
				<c:if test="${empty error}">
		<form:form method="POST" class="form-form" name="loginform" modelAttribute="login-entries" action="./loginCheck" onsubmit="return validate(event);">
    				<p>${error}</p>
				<div class="form-group row justify-content-md-center">
					<label for="userName" class="col-lg-2 col-form-label text-md-right">
						<strong>Username :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="userName" path="userName" id="userName"
							class="form-control" placeholder="username" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="password" class="col-lg-2 col-form-label text-md-right">
											<strong>Password :</strong></label>
					<div class="col-lg-4">
						<form:input type="password" name="password" path="password" id="password"
							class="form-control" placeholder="*********" />
					</div>
				</div>


				<div class="form-group row justify-content-md-center">
					<div class="col-lg-2">
						<input type="submit" value="Login" class="btn btn-primary" >
					</div>
				</div>



			</form:form>
				</c:if>
			</div>
	</div>
	</div>
<script type="text/javascript" async>
            function validate(e)
            {
            	 e.preventDefault(); // this will prevent the submit event.
            	/*  var category = document.entryform.category.value; */
            	 var uname = document.loginform.userName.value;
            	 var pass = document.loginform.password.value;
            	 
		    //if username is empty
            	    
            	    if(uname=="")
            	    {
              	      alert("Username can not be left blank");
              	      document.loginform.userName.focus();
              	      return false;
              	    }
            	    else if(pass=="")
            	    {
            	      alert("Password can not be left blank");
            	      document.loginform.password.focus();
            	      return false;
            	    }
		    
		    //if inputs gets validated-  will trigger submit event
            	    else {
            	        document.loginform.submit(); // fire submit event
            	    }
            	    
            };
</script>

</body>
</html>