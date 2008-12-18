<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<title>Evaluacion Impacto Ambiental - Menu Principal</title>
<head>
	<h2>Proyecto</h2>
	<hr/>
</head>
<body>
	<s:form action="doUpdateProject" theme="simple">
		<table align="center" cols="6">
			<tr>
				<td colspan="1"><s:label  name="labelNombre" value= "Nombre: "/></td>
				<td colspan="2" align="left"><s:textfield name="nombre" size="32"/></td>
				<td colspan="1" align="left"><s:label  name="labelTipo" value= "Tipo: " /></td>
				<td colspan="2" align="right"><s:textfield name="tipo"  size="32"/></td>
			</tr>
			<tr>
				<td colspan="1"><s:label  name="labelCompania" value= "Compañia: " /></td>
				<td colspan="2"align="left"><s:textfield name="compania" size="32"/></td>
				<td colspan="1" align="left"><s:label  name="labelAutor" value= "Autor: " /></td>
				<td colspan="2" align="right"><s:textfield name="autor" size="32"/></td>
			</tr>
			<tr>
				<td colspan="1" ><s:label  name="labelPoblacion" value= "Poblacion: "/></td>
				<td colspan="1"><s:textfield name="poblacion" /></td>
				<td colspan="1"><s:label  name="labelProvincia" value= "Provincia: "/></td>
				<td colspan="1"><s:textfield name="provincia" /></td>
				<td colspan="1"><s:label  name="labelRegion" value= "Region: " /></td>
				<td colspan="1" align="right"><s:textfield name="region" /></td>
			</tr>
			<tr>
				<td colspan="1"><s:label  name="labelPais" value= "Pais: "/></td>
				<td colspan="1"><s:textfield name="pais"  /></td>
				<td colspan="1"><s:label  name="labelFecha" value= "Fecha: " /></td>
				<td colspan="1"><s:textfield name="fecha" /></td>
				<td colspan="1"><s:label  name="labelVidaUtil" value= "Vida Util: " /></td>
				<td colspan="1" align="right"><s:textfield name="vidaUtil" /></td>
			</tr>
			<tr>
				<td colspan="1"><s:label  name="labelDesc" value= "Descripcion: " /></td>
				<td  colspan="5"><s:textarea name="descripcion"  rows="2" cols="70"/></td>
			</tr>
			<tr>
				<td colspan="5"> </td>
				<td colspan="1" align="right"><s:submit value="Modificar" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>