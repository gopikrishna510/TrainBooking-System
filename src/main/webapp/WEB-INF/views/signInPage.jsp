<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
       "http://www.w3.org/TR/html4/loose.dtd">
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
				  password.style.border = "solid 3px red";
				  document.getElementById("error1").style.visibility= "visible";
				  return false;
		    }
}
</script>
<body>
	  <form  onsubmit="return validate()" action="signIn" method="post" >
        <table align="center"> 
        <thead>
           <th><h3>Login_form</h3></th>
        </thead>
        <tbody>
        <tr>
            <td>Username</td>
			<td>
			  <input id="uname" type="text" name="loginCredentials" placeholder="username / email">
			        <lable id="error" style="color:red ; visibility:hidden;">Invalid</lable>
			</td>
		</tr>
		<tr>
		  <td>Password</td>
		  <td>	
		     <input id="pass" type="password" name="password" placeholder="password">
		       <lable id="error1" style="color:red ; visibility:hidden;">Invalid</lable>
		  </td>
		</tr>    
		<tr>
		  <td style="width: 150; height: 50;">
		      <input type= "submit" value="sign in">
		  </td>
		</tr>
		</tbody>
		</table>
	</form>
</body>
</html>