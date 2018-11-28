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
		<h4 align="center">Welcome to the Virtual  and Found Board</h4>
	</div>
	<div class="back-link">
		<h5><a href="/rssfeeds/dashboard" style="float:right;margin-right:50px;"> Dashboard</a><i style="float:right" class="material-icons">dashboard</i></h5>
	</div>
		<div class="formBox">
		<form:form method="POST" class="form-form" name="loginform" modelAttribute="lost-entries" action="save-lost-entry">

				<div class="form-group row justify-content-md-center">
					<label for="FeedName" class="col-lg-2 col-form-label text-md-right">
						<strong>Category :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" path="category" name="category" id="category"
							class="form-control" placeholder="enter category" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											<strong>Description :</strong></label>
					<div class="col-lg-4">
						<form:input type="textbox" name="desc" path="desc" id="desc"
							class="form-control" placeholder="write description here : color, shape, structure" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											<strong>Location :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="location" path="location" id="location"
							class="form-control" placeholder="where did you  it?" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											<strong>Date :</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="date" path="date" id="date"
							class="form-control" placeholder="when did you  it?" />
					</div>
				</div>

				<div class="form-group row justify-content-md-center">
					<label for="feedUrl" class="col-lg-2 col-form-label text-md-right">
											<strong>Bounty (in dollars):</strong></label>
					<div class="col-lg-4">
						<form:input type="text" name="prize" path="prize" id="prize"
							class="form-control" placeholder="Is is really important? Add bounty." />
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
            	 var feedname = document.loginform.FeedName.value;
            	 var feedurl = document.loginform.feedUrl.value;
            	 var regexQuery = "^(https?://)?(www\\.)?([-a-z0-9]{1,63}\\.)*?[a-z0-9][-a-z0-9]{0,61}[a-z0-9]\\.[a-z]{2,6}(/[-\\w@\\+\\.~#\\?&/=%]*)?$";
            	 var url = new RegExp(regexQuery,"i");
            	 var isUrl = url.test(feedurl);
            	 var flag = true;
            	 try{
                	 var isValid = new URL(feedurl);
            	 }
            	 catch(e){
            		flag = false;
            	 }
            	 
		    //if username is empty
            	    if(feedname=="")
            	    {
            	      alert("Feed Name can not be left blank");
            	      document.loginform.FeedName.focus();
            	      return false;
            	    }
		    //added validation rule for username should carry letters only
		     else if(feedname != "" && !/^[a-zA-Z-,]+(\s{0,1}[a-zA-Z-, ])*$/.test(feedname)){
            	    	alert("Only letters are accepted/First ");
              	      document.loginform.FeedName.focus();
              	      return false;
            	    }
		    //if feedurl is empty
            	    else if(feedurl=="")
            	    {
            	      alert("Feed Url can not be left blank");
            	      document.loginform.feedUrl.focus();
            	      return false;
            	    }
		    //if url is not valid
            	    else if(!isUrl || !flag){
                    	 alert("Invalid url/no response");
                	      document.loginform.feedUrl.focus();
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