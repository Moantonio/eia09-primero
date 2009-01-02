<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Evaluacion Impacto Ambiental - Valoracion Cualitativa</title>
		<link href="../../css/valoracion.css" rel="stylesheet" type="text/css">
	</head>
    <body>
		<s:form action="doValoracionCuantitativa" theme="simple" method="post">
			<div id="contenedor">
				<div id="top">
					<s:label  name="labelNombreEfecto" value="Efecto: "/><s:textfield name="nombreEfecto" size="75" label="Efecto "/><br/><br/>
					<s:label  name="labelDesc" value="Descripcion: "/><s:textarea name="descripcion"  rows="2" cols="50" label="Descripcion "/><br/>
					<h3>Valoracion Cuantitativa</h3><hr></hr>					
				</div>
				<div id="contValIzq" class="contIzq">
					<s:label  name="labelIndicador" value="Indicador: "/><s:textfield name="indicador" size="15"/><br/><br/>
					<s:label  name="labelValorMax" value="Valor maximo indicador: "/><s:textfield name="valorMax" size="15"/><br/><br/>
					<s:label  name="labelValorMin" value="Valor minimo indicador: "/><s:textfield name="valorMin" size="15"/><br/><br/>					
				</div>
				<div id="contValDer" style="right:250;" class="contDer">
					<br/><br/>
					<s:submit value="Calcular" />
				</div>
				<div id="contAsistente">
					<s:label  name="labelFuncion" value="Funcion de transformacion: "/>
					<s:select name="funcion" headerValue="--- Seleccione un valor ---" headerKey="-1" 
						list="#{'01':'Lineal creciente','02':'Lineal decreciente','03':'Parabolica creciente I','04':'Parabolica decreciente I',
								  '05':'Parabolica creciente II', '06':'Parabolica decreciente II', '07':'Parabolica doble creciente I',
								  '08':'Parabolica doble decreciente I','09':'Parabolica doble creciente II','10':'Parabolica dobledecreciente II',
								  '11':'Maximo intermedio','12':'Minimo intermedio','13':'Umral creciente','14':'Umbral decreciente'}" value="" />
					<input type="button" id="asistente" value="Asistente"/><br/><br/>
					<h4>Magnitud</h4><s:textfield name="magnitud" size="25"/><br/><br/>	
					<input type="button" id="aceptar" value="Aceptar"/><br/><br/>				
				</div>
			</div>
		</s:form>
	</body>
</html>