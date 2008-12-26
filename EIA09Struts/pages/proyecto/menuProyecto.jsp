<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<link rel="STYLESHEET" type="text/css" href="../../javascript/dhtmlxGrid/codebase/dhtmlxgrid.css">
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>
	<script src="../../javascript/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
	<script>
		var mygrid;
		function doInitGrid(){
			mygrid = new dhtmlXGridObject('gridbox');
			mygrid.setImagePath("../dhtmlxGrid/codebase/imgs/");	
			mygrid.setHeader("Nombre,Valoracion");
			mygrid.setInitWidths("400,*");	
			mygrid.setColAlign("center,center");	
			mygrid.setColTypes("ed,ed");
			mygrid.setSkin("light");	
			mygrid.init();
			mygrid.addRow(1, "Ejemplo1, Ejemplo1",mygrid.getRowsNum());
		}
		function addRow(){
			//A rellenar
		}
		function removeRow(){
			var selId = mygrid.getSelectedId()
			mygrid.deleteRow(selId);
		}
	</script>
</head>
<body  onload="doInitGrid();">
	<div id="infoProyecto">
		<a href="../mainMenu.jsp">Menú Principal</a>
		<jsp:include page="./proyectoInfo.jsp"></jsp:include>
	</div>	
	<h2>Alternativas de realizacion</h2>
	<hr/>
	<div id="gridbox" style="width:600px;height:150px;" align="center">
	</div>
	<div  style="height:10px;"></div>
	<div id="botones" style="width:600px;" align="right">
		<input type="button" value="Añadir"/>
		<input type="button" value="Editar"/>
		<input type="button" value="Eliminar"/>
	</div>	
</body>
</html>