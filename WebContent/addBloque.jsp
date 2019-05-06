<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html lang="en">

<head>
	<title>Section</title>
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
	<link rel="stylesheet" typbloquee="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

</head>

<body>


	<div class="container-contact100">
		<div class="wrap-contact100">
			<form action= "ServletRBloque" method="get">
				<span class="contact100-form-title">
					Add Section!
				</span>

				<div class="wrap-input100 validate-input" data-validate="edition is required">
					<span class="label-input100">Edicion </span>
					<input class="input100" type="number" id="edicion" name = "edicion">
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input100 validate-input" data-validate="Date is required">
					<span class="label-input100">Fecha</span>
					<input class="input100" type="date" id="date" name="date" placeholder="Fecha de la Actividad">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" id= "franja" name = "franja" data-validate="Field is required">
					<span class="label-input100">Franja Horario</span>
					<select id= "franja" name = "franja" >
  						<option value="Matutina">Matutina</option>
  						<option value="Mañana">Mañana</option>
  						<option value="Tarde">Tarde</option>
					</select>
				</div>	
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Tematica</span>
					<input class="input100" type="text" id="tematica" name = "tematica" >
					<span class="focus-input100"></span>
				</div>


				<div class="wrap-input100 validate-input" data-validate="la hora es requerido">
					<span class="label-input100">Descripcion</span>
					<input class="input100" type="text" id="descripcion" name = "descripcion" placeholder="">
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<div class="wrap-contact100-form-btn">
						<div class="contact100-form-bgbtn"></div>
						<button class="contact100-form-btn" type="button" onclick="postUser()">
							<span>
								Accept
								<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
							</span>
						</button>
					</div>
				</div>

				<div align="center">
				<div >
			<div align= "center"><br><input type="submit" class="button" value="Registrar Bloque" style="width: 154px; "><br></div>
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