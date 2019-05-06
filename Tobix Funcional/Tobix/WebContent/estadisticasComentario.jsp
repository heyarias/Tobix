<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>TOBIX</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->


    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/mai.css" rel="stylesheet" media="all">
</head>

<body>
    <div class="page-wrapper bg-gra-01 p-t-180 p-b-100 font-poppins">
        <div class="wrapper wrapper--w780">
            <div class="card card-3">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Consultas Administrador </h2>
                    <form action="ServletEstadisticasXAdmi" method="post">	
                        <div class="input-group">
                            <input class="input--style-3" type="text" placeholder="Id Actividad " name="idAct">
                        </div>
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="consultaAdmi" id= "consultaAdmi">
                                    <option disabled="disabled" selected="selected">Posibles Consultas</option>
                                    <option value = "UsuariosConfirmados">Usuarios Confirmadidos por Actividad</option>
                                    <option value = "UsuariosParticipantes">Usuarios Participantes por Actividad</option>
                                    <option value = "Cantidad de Comentarios por Actividad">Cantidad de Usuarios por Actividad</option>
                                    <option value = "Act x Felicidad">Cantidad de Comentarios Felices por Actividad</option>
                                    <option value = "Act x Enojo">Cantidad de Comentarios de Enojo por Actividad</option>
                                     <option value = "Sentimientos">Analisis de Sentimientos</option>
    
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>

                        <div class="p-t-10">
						<br><div><br><div align= "right"><br><input type="submit" class="button" value="Enviar Consulta" style="width: 154px; "><br></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->