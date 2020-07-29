<html>
<head>
	<title>signInPage</title>
</head>
<script type="text/javascript">
function validate()
{
	  var username = document.getElementById("uname");
	  var password = document.getElementById("pass");
	  
	 /*  if(username.value.trim() =="" || password.value.trim() ==""){
		  alert("No blank values allowed");
		  return false;
	  }
	  else
		  true; */
		  if(username.value.trim() == "")
		  {
			  alert("Blank Username");
			  username.style.border = "solid 3px red";
			  document.getElementById("error").style.visibility= "visible";
			  return false;
	      }
		  else if(password.value.trim() == "")
			 {
				  alert("Blank Password");
				  return false;
		    }
}
</script>
<body>
	<h3>Sign below</h3>
	<form  onsubmit="return validate()" action="signIn" method="post">

		<input id="uname" type="text" name="loginCredentials" placeholder="username / email">
			<lable id="error" style="color:red ; visibility:hidden;">Invalid</lable>	
			<br><br> 
		<input id ="pass" type="text" name="password" placeholder="password">
		 
			<br><br> 
		<input type="submit" value="sign in">
	</form>
</body>
</html>