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
	
	<div  style= "width:30%;display:inline-block;margin:1.5%;">
		<form:form class="form-horizontal">
			<span style="margin-left:75px;color:black"><i>Lost something?</i><a class="lost-link" href="">Click here!</a></span>
			<div class="lost-list-div list-div blinking-lost-border">
				<div class="lost-list-header list-header blinking-lost"><strong>LOST BOARD</strong></div>
				<ul class="lost-list list">
					<c:forEach var="lost" items="${list}">
						<li>
							<strong>${lost.lostCategory} </strong> - ${lost.lostDesc}
						</li>
					</c:forEach>
				</ul>
			</div>
		</form:form>
	</div>
	<div style= "width:30%;display:inline-block;margin:1.5%;">
	<form:form class="form-horizontal">
					<div class="claim-list-div list-div">
				<div class="claim-list-header list-header"><strong>CLAIM BOARD</strong></div>
				<ul class="claim-list list">
					<c:forEach var="lost" items="${list}">
						<li>
							<strong>${lost.lostCategory} </strong> - ${lost.lostDesc}
						</li>
					</c:forEach>
				</ul>
			</div>
		</form:form>
	</div>
		
	<div style= "width:30%;display:inline-block;margin:1.5%;">
	<form:form class="form-horizontal">
		<span style="margin-left:75px;color:black"><i>Found something?</i><a class="lost-link" href="">Click here!</a></span>
			<div class="found-list-div list-div blinking-found-border">
				<div class="found-list-header list-header blinking-found"><strong>FOUND BOARD</strong></div>
				<ul class="found-list list">
					<c:forEach var="lost" items="${list}">
						<li>
							<strong>${lost.lostCategory} </strong> - ${lost.lostDesc}
						</li>
					</c:forEach>
				</ul>
			</div>
		</form:form>
	</div>
		<br>
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
