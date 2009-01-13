<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<title>Evaluacion Impacto Ambiental - Menu Principal</title>
<head>
	<link href="../css/menu.css" rel="stylesheet" type="text/css">
	<script src="../javascript/menu.js"></script>
</head>
<body>
	<jsp:include page="head.html"></jsp:include>
	<div  id="dhtmlgoodies_menu">
		<ul>
			<!-- Creamos la primer pestaña del menú: Proyectos -->
			<!-- Metemos la primera opción -->
			<li><a href="">Proyectos</a>
				<ul>
					<!--Ahora un submenu nivel 1 para Proyectos con sus opciones -->
					<li><a href="">Nuevo</a></li>
						<ul>
							<!-- Ponemos un submenu nivel 2 para Nuevo -->
							<li><a href=""> Autovia</a></li>
							<li><a href=""> Presa</a></li>
							<li><a href=""> Puerto Deportivo</a></li>
							<li><a href=""> Vertedero</a></li>
							<li><a href=""> Otro</a></li>
						</ul>
					<li><a href="eia/showUpload.action">Abrir </a></li>
					<li><a href="eia/saveProject.action">Guardar </a></li>
					<li><a href="eia/saveProjectAs.action">Guardar como... </a></li>
					<li><a href="eia/showProjectDescription.action">Descripcion </a></li>
					<li><a href="">Salir </a></li>		 
				</ul>
			</li>
			<!-- Ponemos una segunda pestaña en el menú con la opción Alternativas -->
		    <li><a href=""> Alternativas</a>
			   <ul>
					<!--Ahora un submenu nivel 1 para Alternativas con sus opciones -->
					<li><a href="eia/showAlternativaInfo.action">Añadir</a></li>
					<li><a href="">Modificar </a></li>
					<ul>
							<!-- Ponemos un submenu nivel 2 para Modificar -->
							<li><a href=""> Lista de alternativas existente</a></li>
					</ul>
					<li><a href="">Eliminar </a></li> 
					<ul>
						<!-- Ponemos un submenu nivel 2 para Eliminar -->
						<li><a href=""> Lista de alternativas existente</a></li>
					</ul>
				</ul>
			</li>
			<!-- Ponemos una segunda pestaña en el menú con la opción Factores -->
			<li><a href=""> Factores</a>
				<ul>
					<!--Ahora un submenu nivel 1 para Factores con sus opciones -->
					<li><a href="">Ver listado</a></li>
					<li><a href="">Modificar pesos</a></li>
				</ul>
			</li>
			<!-- Ponemos una segunda pestaña en el menú con la opción Valoracion -->
			<li><a href=""> Valoracion</a>
				<ul>
					<!--Ahora un submenu nivel 1 para Valoracion con sus opciones -->
					<li><a href="">Valorar</a></li>
					<li><a href="">Ver resultados</a></li>
				</ul>
			</li>
			<!-- Ponemos una segunda pestaña en el menú con la opción Informes -->
			<li><a href=""> Informes</a>
				<ul>
					<!--Ahora un submenu nivel 1 para Informe con sus opciones -->
					<li><a href="">Ver Informe</a></li>
				</ul>
			</li>
			<!-- Ponemos una segunda pestaña en el menú con la opción Ayuda -->
			<li><a href=""> Ayuda</a>
				<ul>
					<!--Ahora un submenu nivel 1 para Ayuda con sus opciones -->
					<li><a href="">Funcionamiento</a></li>
					<li><a href="">Legislacion</a></li>
					<li><a href="">Acerca de EIA09</a></li>
				</ul>
			</li>
		</ul>
	</div>
	<!--<div id="contenido">
		<!-- Se incluye el jsp de la opcion seleccionada 
		<jsp:include page="proyecto/menuProyecto.jsp"></jsp:include>	
	</div>-->
</body>
</html>