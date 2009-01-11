<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>File Upload Example</title>
		<link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
	</head>

	<body>
		<s:actionerror />
		<s:fielderror />
		<s:form action="doLoadProject" method="POST" enctype="multipart/form-data">
			<tr>
				<td colspan="2"><h2>Cargar Proyecto</h2></td>
			</tr>
			<s:file name="upload" label="File"/>
			<s:submit  value="Cargar"/>
		</s:form>
	</body>
</html>