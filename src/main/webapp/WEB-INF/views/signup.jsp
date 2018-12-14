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
		<form:form method="POST" class="form-form" name="signupform" modelAttribute="signup-entries" action="./signupentry" onsubmit="return validate(event);">

				<div class="form-group row justify-content-md-center">
					<label for="firstname" class="col-lg-2 col-form-label text-md-right">
						<strong>First Name :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="firstName" path="firstName" id="firstName"
							class="form-control" placeholder="your first name" />
					</div>
				</div>
				
				<div class="form-group row justify-content-md-center">
					<label for="lastname" class="col-lg-2 col-form-label text-md-right">
						<strong>Last Name :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="lastName" path="lastName" id="lastName"
							class="form-control" placeholder="your last name" />
					</div>
				</div>
				
				<div class="form-group row justify-content-md-center">
					<label for="username" class="col-lg-2 col-form-label text-md-right">
						<strong>Username :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="userName" path="userName" id="userName"
							class="form-control" placeholder="username" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="useremail" class="col-lg-2 col-form-label text-md-right">
											<strong>User Email :</strong></label>
					<div class="col-lg-4">
						<form:input type="email" name="userEmail" path="userEmail" id="userEmail"
							class="form-control" placeholder="yourmail@example.com" />
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
						<input type="submit" value="Signup" class="btn btn-primary" >
					</div>
				</div>



			</form:form>
			</div>
	</div>
	</div>
<script type="text/javascript" async>
            function validate(e)
            {
            	 e.preventDefault(); // this will prevent the submit event.
            	/*  var category = document.entryform.category.value; */
            	 var fname = document.signupform.firstName.value;
            	 var lname = document.signupform.lastName.value;
            	 var uname = document.signupform.userName.value;
            	 var email = document.signupform.userEmail.value;
            	 var pass = document.signupform.password.value;
            	 
		    //if username is empty
            	    if(fname=="")
            	    {
            	      alert("First name can not be left blank");
            	      document.signupform.firstName.focus();
            	      return false;
            	    }
            	    else  if(lname=="")
            	    {
              	      alert("Last name can not be left blank");
              	      document.signupform.lastName.focus();
              	      return false;
              	    }
            	    else  if(uname=="")
            	    {
              	      alert("Username can not be left blank");
              	      document.signupform.userName.focus();
              	      return false;
              	    }
            	    else if(email=="")
            	    {
            	      alert("User email can not be left blank");
            	      document.signupform.userEmail.focus();
            	      return false;
            	    }
            	    else if(pass=="")
            	    {
            	      alert("Password can not be left blank");
            	      document.signupform.password.focus();
            	      return false;
            	    }
		    
		    //if inputs gets validated-  will trigger submit event
            	    else {
            	        document.signupform.submit(); // fire submit event
            	    }
            	    
            };
</script>

</body>
</html>