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
			  document.getElementById("error")
			  .style.visibility= "visible";
			  return false;
	      }
		  else if(password.value.trim() == "")
			 {
				  alert("Blank Password");
				  return false;
		    }
  }