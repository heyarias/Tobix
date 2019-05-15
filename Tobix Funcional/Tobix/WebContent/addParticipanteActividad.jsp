<!DOCTYPE html>
<html lang="en">

<head>
	<title>Tobix Comentarios</title>
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

<form action= "ServletAddParticipanteActividad" method="get">
<div class="wrap-input100 validate-input" data-validate="edition is required">
					<span class="label-input100"> Id Actividad </span>
					<input class="input100" type="number" id="id" name = "id">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" data-validate="Name is required">
					<span class="label-input100">Id Persona </span>
					<input class="input100" type="text" id="idPersona" name = "idPersona" >
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input" id= "tipo" name = "tipo" data-validate="Field is required">
					<span class="label-input100">Confirmar Participacion</span>
					<select name="confirmar" id="confirmar">
  						<option value="SI">Si, confirmo</option>
  						<option value="NO">No, despues confirmo</option>
					</select>
				</div>
				
				<div class="wrap-input100 validate-input" id= "idioma" name = "idioma" data-validate="Field is required">
					<span class="label-input100">Idioma para el mensaje de confirmacion</span>
					<select name="confirmar" id="confirmar">
  						<option value="ingles">Ingles</option>
  						<option value="espaniol">Espaniol</option>
					</select>
				</div>
			<div align= "center"><br><input type="submit" class="button" value="Registrar Participacion" style="width: 154px; "><br></div>
			</form>

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