<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Activity</title>
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
			<form action= "ServletRActividad" method="get">
				<span class="contact100-form-title">
					Add Activity!
				</span>
				
				<div class="wrap-input100 validate-input" data-validate="ID is required">
					<span class="label-input100">Id Bloque</span>
					<input class="input100" type="number" id="idBloque" name = "idBloque" placeholder="Enter your ID">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" id= "tipo" name = "tipo" data-validate="Field is required">
					<span class="label-input100">Activity's Kind</span>
					<select name="tipo" id="tipo">
  						<option value="Small Talk">Small Talk</option>
  						<option value="Story Telling">Story Telling</option>
  						<option value="Conversatorio">Conversatorio</option>
					</select>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Name</span>
					<input class="input100" type="text" id="nombre" name="nombre" >
					<span class="focus-input100"></span>
				</div>

			

				<div class="wrap-input100 validate-input" data-validate="la hora es requerido">
					<span class="label-input100">Start Time</span>
					<input class="input100" type="time" id="horaIncio" name="horaInicio" placeholder="Hora de Inicio de la Actividad">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="la hora es requerido">
					<span class="label-input100">Ending Time</span>
					<input class="input100" type="time" id="horaFinal" name="horaFinal" placeholder="Hora de finalización">
					<span class="focus-input100"></span>
				</div>


				<div class="wrap-input100 validate-input" data-validate="la Descrpcion es requerido">
					<span class="label-input100">Description</span>
					<input class="input100" type="text" id="description" name="description" placeholder="">
					<span class="focus-input100"></span>
				</div>

				
				<div class="container-contact100-form-btn">
						<div class="wrap-contact100-form-btn">
							<div class="contact100-form-bgbtn"></div>
							<div align= "center"><br><input type="submit" class="button" value="Accept" style="width: 154px; "><br></div>
								
							
						</div>
					</div>

				<div class="container-contact100-form-btn">
						<div class="wrap-contact100-form-btn">
							<div class="contact100-form-bgbtn"></div>
							<button class="contact100-form-btn" type="button" onclick="window.location.href='./login.html'">
								<span>
									Cancel
									<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
								</span>
							</button>
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