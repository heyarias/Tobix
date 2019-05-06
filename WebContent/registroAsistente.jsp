<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html lang="en">

<head>
	<title>Sign Up</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>

<body>


	<div class="container-contact100">
		<div class="wrap-contact100">
		<form action= "ServletRegistroAsistente" method="get">
				<span class="contact100-form-title">
					Tobix Sign up!
				</span>

				<div class="wrap-input100 validate-input" data-validate="ID is required">
					<span class="label-input100">Id</span>
					<input class="input100" type="number" id="Identificacion" name = "Identificacion" placeholder="Enter your ID">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Name</span>
					<input class="input100" type="text" id="Nombre" name = "Nombre" placeholder="Enter your name">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Last Name</span>
					<input class="input100" type="text" id="ap1" name = "ap1" placeholder="Enter your last name here">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Second Last Name </span>
					<input class="input100" type="text" id="ap2" name = "ap2" placeholder="Enter your last name here">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
					<span class="label-input100">Email</span>
					<input class="input100" type="email" id="email" name = "email" placeholder="Enter your email address">
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input"  data-validate="Field is required">
					<span class="label-input100">Kind</span>
					<select id= "Genero" id = "entidad" name = "entidad" >
  						<option value="ITCR">ITCR</option>
  						<option value="UCR">UCR</option>
  						<option value="UNA">UNA</option>
  						<option value="UTN">UTN</option>
					</select>
				</div>

				<div class="wrap-input100 validate-input"  data-validate="Field is required">
					<span class="label-input100">Gender</span>
					<select id= "Genero" name = "Genero">
  						<option value="Prefiero no decir">Prefiero no decir</option>
  						<option value="Femenino">F</option>
  						<option value="Masculino">M</option>
					</select>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Password is required">
					<span class="label-input100">Password</span>
					<input type="password" class="input100" id="password" name = "password" placeholder=""></input>
					<span class="focus-input100"></span>
				</div>	
				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<span> Accept
						<div align= "center"><br><input type="submit" class="button" style="width: 154px; "><br></div>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="dropDownSelect1"></div>
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".selection-2").select2({
			minimumResultsForSearch: 20,
			dropdownParent: $('#dropDownSelect1')
		});
	</script>

	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>

	<script src="vendor/countdowntime/countdowntime.js"></script>

	<script src="js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	
</body>

</html>