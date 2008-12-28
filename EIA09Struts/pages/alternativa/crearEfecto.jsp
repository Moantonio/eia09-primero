<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<title>Evaluacion Impacto Ambiental - Nuevo Efecto</title>
<head>
	<link href="../../css/efecto.css" rel="stylesheet" type="text/css">
</head>
<body>
	<s:form action="doCreateEffect" theme="simple">
		<div id="contenedor">
				<div id="top">
					<s:label name="labelAccion" value= "Accion: "/><s:textfield name="accion" size="25"/>
					<s:label name="labelAccion" value= "Factor: "/><s:textfield name="factor" size="25"/>
				</div>
				<div id="titulo">
					<h3>Crear Efecto</h3>
					<hr></hr>
				</div>
				<div style="height:20px;"></div>
				<div id="efectoInfo">
					<s:label  name="labelNombre" value="Nombre: "/><s:textfield name="nombre" size="75"/><br/><br/>
					<s:label  name="labelDesc" value="Descripcion: "/><s:textarea name="descripcion"  rows="2" cols="55"/><br/><br/>
					<s:label name="labelValJuicio" value= "Simple Enjuiciamiento: " />
					<s:select name="valSimpEnj" label="Simple Enjuiciamiento:" headerValue="--- Seleccione un valor ---"
						headerKey="1" list="{'Especial','Despreciable','Impredecible','Significativo'}" /><br/><br/>
					<s:submit value="Aceptar" />
				</div>
		</div>
	</s:form>
</body>
</html>