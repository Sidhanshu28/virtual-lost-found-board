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
		<h1 align="center">Feeds List</h1>

		<form:form class="form-horizontal">
			<table
				class="table table-bordered table-hovered table-striped viewfeeds"
				style="text-align:center">
				<thead>
					<tr>
						<th>Id</th>
						<th>Lost Item Category</th>
						<th>Lost Item Desc</th>
						<th>Location</th>
						<th>Date</th>
						<th>Prize</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="lost" items="${list}">
						<tr>
							<td>${lost.lostId}</td>
							<td>${lost.lostCategory}</td>
							<td>${lost.lostDesc}</td>
							<td>${lost.lostLocation}</td>
							<td>${lost.lostDate}</td>
							<td>${lost.lostPrize}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<br />


		</form:form>
		<br>
		<br>
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
	
<script type="text/javascript">
//script to make responsive design and resizing table by adding/removing class
	(function($) {
    var $window = $(window),
        $html = $('html');

    $window.resize(function resize(){
    	console.log($window.width(),$('.viewfeeds').width());
        if ($window.width() < 768) {
        	
            return $('.viewfeeds').addClass('table-responsive');
        }

        $('.viewfeeds').removeClass('table-responsive');
    }).trigger('resize');
})(jQuery);
</script>
</body>
</html>
