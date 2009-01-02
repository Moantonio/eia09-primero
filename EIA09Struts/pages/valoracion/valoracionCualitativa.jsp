<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>Evaluacion Impacto Ambiental - Valoracion Cualitativa</title>
		<link href="../../css/valoracion.css" rel="stylesheet" type="text/css">
	</head>
    <body>
		<s:form action="doValoracionCualitativa" theme="simple" method="post">
			<div id="contenedor">
				<div id="top">
					<s:label  name="labelNombreEfecto" value="Efecto: "/><s:textfield name="nombreEfecto" size="75" label="Efecto "/><br/><br/>
					<s:label  name="labelDesc" value="Descripcion: "/><s:textarea name="descripcion"  rows="2" cols="50" label="Descripcion "/><br/>
					<h3>Valoracion Cualitativa</h3><hr></hr>
				</div>
				<div id="contValIzq" class="contIzq">
					<s:label  name="labelSigno" value="Signo: "/>
					<s:select name="signo" headerValue="--- Seleccione un valor ---"
						headerKey="-1" list="#{'01':'Positivo','02':'Negativo'}" value=""/><br/><br/>
																	
					<s:label  name="labelExtension" value="Extension: "/>
					<s:select name="extension" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Puntual','03':'Parcial','04':'Extenso','05':'Total'}" value="" /><br/><br/>
						
					<s:label  name="labelIntensidad" value="Intensidad: "/>
					<s:select name="intensidad" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Baja','03':'Media','04':'Alta','05':'Muy alta', '06':'No asignar'}" value="" /><br/><br/>	
					
					<s:label  name="labelReversibilidad" value="Reversibilidad: "/>
					<s:select name="reversibilidad" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Corto plazo','03':'Medio plazo','04':'Largo plazo','05':'Irreversible'}" value="" /><br/><br/>
						
					<s:label  name="labelPeriodicidad" value="Periodicidad: "/>
					<s:select name="periodicidad" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Discontinuo','03':'Periodico','04':'Continuo'}" value="" /><br/><br/>
						
					<s:label  name="labelMomento" value="Momento: "/>
					<s:select name="momento" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Inmediato','03':'Medio plazo','04':'Largo plazo'}" value="" /><br/><br/>
				</div>
				<div id="contValDer" class="contDer">
					<s:label  name="labelAcumulacion" value="Acumulacion: "/>
					<s:select name="acumulacion" headerValue="--- Seleccione un valor ---" 
						headerKey="-1" list="#{'01':'No asignar','02':'Simple','03':'Acumulativo','04':'Sinergico'}" value="" /><br/><br/>
					
					<p><s:label  name="labelExtCritica" value="¿Critica?: "/><s:checkbox name="extCritica" /></p>
					
					<s:label  name="labelPersistencia" value="Persistencia: "/>
						<s:select name="persistencia" headerValue="--- Seleccione un valor ---" 
							headerKey="-1" list="#{'01':'No asignar','02':'Fugaz','03':'Temporal','04':'Permanente'}" value="" /><br/><br/>	
							
					<s:label  name="labelEfecto" value="Efecto: "/>
						<s:select name="efecto" headerValue="--- Seleccione un valor ---" 
							headerKey="-1" list="#{'01':'No asignar','02':'Directo','03':'Indirecto secundario','04':'Indirecto terciario'}" value="" /><br/><br/>
							
					<s:label  name="labelRecuperabilidad" value="Recuperabilidad: "/>
						<s:select name="recuperabilidad" headerValue="--- Seleccione un valor ---" headerKey="-1" 
							list="#{'01':'No asignar','02':'Inmediata','03':'Medio plazo','04':'Mitigable','05':'Largo plazo', '06':'Irrecuprable'}" value="" /><br/><br/>
							
						<p><s:label  name="labelMomCritico" value="¿Critico?: "/><s:checkbox name="momCritico" /></p><br/>
						
						<s:submit value="Aceptar" />
						<input type="button" id="cancel" value="Cancelar" class="boton"/>
				</div>
				<div id="contIncidencia" style="position:relative; top:270px;" class="contIzq">
					<s:label  name="labelIncidencia" value="Incidencia: "/>
					<s:textfield name="incidencia" size="30"/>
				</div>	
			</div>
		</s:form>
    </body>
 </html>