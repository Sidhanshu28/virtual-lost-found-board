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
		<h5><a href=".././dashboard" style="float:right;margin-right:50px;color:yellow"> Dashboard</a><i style="float:right" class="material-icons">dashboard</i>&nbsp;<a href=".././logout" style="float:right;margin-right:50px;color:yellow"> Logout</a><i style="float:right" class="material-icons">logout</i></h5>
	</div>
		<div class="formBox">
		<form:form method="POST" class="form-form" name="entryform" modelAttribute="lost-claim-entries" action="../submit-claim-lost/${id}" onsubmit="return validate(event);">

				<div class="form-group row justify-content-md-center">
					<label for="name" class="col-lg-2 col-form-label text-md-right">
						<strong>Name :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="name" path="name" id="name"
							class="form-control" placeholder="your name" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="email" class="col-lg-2 col-form-label text-md-right">
											<strong>Email :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="email" path="email" id="email"
							class="form-control" placeholder="yourmail@example.com" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="contact" class="col-lg-2 col-form-label text-md-right">
											<strong>Contact :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="contact" path="contact" id="contact"
							class="form-control" placeholder="14*******3" />
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
<script type="text/javascript" async>
            function validate(e)
            {
            	 e.preventDefault(); // this will prevent the submit event.
            	/*  var category = document.entryform.category.value; */
            	 var name = document.entryform.name.value;
            	 var email = document.entryform.email.value;
            	 var contact = document.entryform.contact.value;
            	 
		    //if username is empty
            	    if(name=="")
            	    {
            	      alert("Name can not be left blank");
            	      document.entryform.name.focus();
            	      return false;
            	    }
            	    else if(email=="")
            	    {
            	      alert("Email can not be left blank");
            	      document.entryform.email.focus();
            	      return false;
            	    }
            	    else if(contact=="")
            	    {
            	      alert("Contact can not be left blank");
            	      document.entryform.contact.focus();
            	      return false;
            	    }
		    
		    //if inputs gets validated-  will trigger submit event
            	    else {
            	        document.entryform.submit(); // fire submit event
            	    }
            	    
            };
</script>

</body>
</html>