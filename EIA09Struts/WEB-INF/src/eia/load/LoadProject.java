package eia.load;

import com.opensymphony.xwork2.ActionSupport;

public class LoadProject extends ActionSupport{
	
	String projectName;

	public String execute() throws Exception {
	    System.out.println("Loading project...");
	    String fileName = getProjectName();
	    //Aqui se procesaria el fichero para cargar la informacion
	    //contenida en el .xml en objetos JAVA
	    return SUCCESS;
	  }
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}	
}
