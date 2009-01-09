<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>Evaluacion Impacto Ambiental - Informacion Efecto</title>
	<link href="../../css/infoEfecto.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		function abrirVentana (pagina, w, h, t, l) {
		var opciones1="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=";
		var opciones2 = w + ", height=" + h + ", top=" + t + ", left=" + l;
		window.open(pagina,"",opciones1 + opciones2);
	}
	</script>
</head>
<body>
	<s:form action="doUpdateEffect" theme="simple">
		<div id="contenedor">
			<div id="top">
			     <h3>Efecto</h3><hr/>
				<s:label  name="labelNombre" value="Efecto: "/><s:textfield name="nombre" size="75" label="Efecto "/><br/><br/>
				<s:label name="labelAccion" value= "Accion: "/><s:textfield name="accion" size="25"/>
				<s:label name="labelAccion" value= "Factor: "/><s:textfield name="factor" size="25"/><br/><br/>
				<s:label  name="labelDesc" value="Descripcion: "/><s:textarea name="descripcion"  rows="2" cols="50"/>
				<p>Simple Enjuiciamiento</p>
				<s:select name="valSimpEnj" label="Simple Enjuiciamiento:" headerValue="--- Seleccione un valor ---"
					headerKey="-1" list="#{'01':'Especial','02':'Despreciable','03':'Impredecible','04':'Significativo'}" value=""/><br/><br/>
			</div>
			<div id="contValCual" class="contIzq">
				<p>Valoracion Cualitativa</p>
				<s:textfield name="valCual" size="30"/>
				<input type="button" id="valCualButton" value="Valorar" class="boton" onclick="			abrirVentana('../../pages/valoracion/valoracionCualitativa.jsp',850,500,85,140)"/>
			</div>	
			<div id="contValCuan" class="contDer">
				<p>Valoracion Cuantitativa</p>
				<s:textfield name="valCuan" size="30"/><input type="button" id="valCuanButton" value="Valorar" class="boton" onclick="			abrirVentana('../../pages/valoracion/valoracionCuantitativa.jsp',850,500,85,140)"/>
			</div>			
			<div id="boxValTotal">
				<p>Valoracion Total <s:textfield name="valTotal" size="40"/></p>
			</div>
			<div id="contCaracter" style="position:relative; top:80px;" class="contIzq">
				<p>Caracter </p>
				<s:textfield name="caracter" size="30"/><input type="button" id="editCaracter" value="Editar" class="boton"/>
			</div>
			<div id="contBoton" style="margin-top:50px;" class="contDer">				
				<s:submit value="Aceptar" />
				<input type="button" id="cancel" value="Cancelar" class="boton"/>
			</div>
		</div>
	</s:form>
</body>
</html>