<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<title>Evaluacion Impacto Ambiental - Nueva Alternativa</title>
<head>
	<link href="../../css/alternativa.css" rel="stylesheet" type="text/css">
	<link rel="STYLESHEET" type="text/css" href="../../javascript/dhtmlxGrid/codebase/dhtmlxgrid.css">
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
	<script>
		var gridAcciones;
		var gridFactores;
		var gridEfectos;
		
		function doInitGridAcciones(){
			gridAcciones = new dhtmlXGridObject('gridacciones');
			gridAcciones.setImagePath("../dhtmlxGrid/codebase/imgs/");	
			gridAcciones.setHeader("Lista de acciones");
			gridAcciones.setInitWidths("*");	
			gridAcciones.setColAlign("center");	
			gridAcciones.setColTypes("ed");
			gridAcciones.setSkin("light");	
			gridAcciones.init();
			gridAcciones.addRow(1, "Accion1",gridAcciones.getRowsNum());
		}
		
		function doInitGridFactores(){
			gridFactores = new dhtmlXGridObject('gridfactores');
			gridFactores.setImagePath("../dhtmlxGrid/codebase/imgs/");	
			gridFactores.setHeader("Lista de factores");
			gridFactores.setInitWidths("*");	
			gridFactores.setColAlign("center");	
			gridFactores.setColTypes("ro");
			gridFactores.setSkin("light");	
			gridFactores.init();
			gridFactores.addRow(1, "Factor1",gridFactores.getRowsNum());
		}
		
		function doInitGridEfectos(){
			gridEfectos = new dhtmlXGridObject('gridefectos');
			gridEfectos.setImagePath("../dhtmlxGrid/codebase/imgs/");
			gridEfectos.setHeader("Nombre,Juicio,Val. Cuantitativa, Val. Cualitativa, Total, Caracter");	
			gridEfectos.setInitWidths("125,*,*,*,*,*");	
			gridEfectos.setColAlign("center,center,center,center,center,center");	
			gridEfectos.setColTypes("ro,ro,ro,ro,ro,ro");
			gridEfectos.setSkin("light");	
			gridEfectos.init();
			gridEfectos.addRow(1, "Efecto1,valjuicio1,valcuant1,valcual1,total1,caracter1",gridEfectos.getRowsNum());
	}
	
	function abrirVentana (pagina, w, h, t, l) {
		var opciones1="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=";
		var opciones2 = w + ", height=" + h + ", top=" + t + ", left=" + l;
		window.open(pagina,"",opciones1 + opciones2);
	}

	</script>
</head>
<body onload="doInitGridAcciones(); doInitGridFactores();doInitGridEfectos();">
	<s:form action="doUpdateAlternative" theme="simple">
		<div id="top">
			<s:label name="labelNombreAlt" value= "Alternativa de realizacion: "/><s:textfield name="nombreAlt" size="75"/>
		</div>
		<div id="contenedorAcciones">
			<div id="gridacciones"/>		
		</div>
		<div  style="height:10px;"></div>
		<div id="botonesAccion">
			<input type="button" value="Añadir" onclick=""/>
			<input type="button" value="Editar" onclick=""/>
			<input type="button" value="Eliminar" onclick=""/>
		</div>	
		<div id="headEfectos">
			<h3>Efectos</h3>
		</div>
		<div id="contenedorEfectos">
			<div id="gridefectos"/>
		</div>
		<div id="botonesEfectos">
			<input type="button" value="Editar" onclick="abrirVentana('../../pages/alternativa/efectoInfo.jsp',850,500,85,140)"/>
			<input type="button" value="Eliminar" onclick=""/>
		</div>
		<div id="boxValTotal">
			<s:label name="labelValTotal" value="Valoracion Total: "/>
			<s:textfield name="valTotal" size="40"/>
		</div>	
		<div id="boxAceptar">
			<input type="button" value="Aceptar"/>
			<input type="button" value="Cancelar"/>
		</div>
		<div id="contenedorBoton">
			<a href="javascript:abrirVentana('../../pages/alternativa/crearEfecto.jsp',700,325,85,140)">Crear Efecto</a>
		</div>
		<div id="contenedorFactores">
			<div id="gridfactores"/>			
		</div>	
	</s:form>
</body>
</html>