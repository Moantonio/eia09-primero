<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<title>Evaluacion Impacto Ambiental - Menu Principal</title>
<head>
</head>
<body>
<h1><center>Menú principal</center></h1>
	<b>Cargar proyecto</b>
	<s:form action="doLoadProject">
		<s:file name="projectName" accept="*text/*" />
		<s:submit value="Cargar" />
	</s:form>
</body>
</html>