package eia.load;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import eia.model.Proyecto;
import eia.util.xml.XMLProyecto;


public class LoadProject extends ActionSupport{
  
	private File upload;//The actual file
	private String uploadContentType; //The content type of the file
	private String uploadFileName; //The uploaded file name
	  
	Proyecto proyecto;
     
    public String execute() throws Exception {
    	try {
    		XMLProyecto xmlProy = new XMLProyecto("plantillas\\proyectoEIA.dtd");
    		proyecto = (Proyecto)xmlProy.leer(upload.getAbsolutePath());
    		//TODO Enviar parametros para que se muestre la info del proyecto.
    		//getServletRequest().setAttribute("proyecto", proyecto);
    		return SUCCESS;
    	} 
    	catch (Exception e){
    		addActionError(e.getMessage());
    		return ERROR;
    	}

    }
	  
    public File getUpload() {
	    return upload;
	}
	  
    public void setUpload(File upload) {
	    this.upload = upload;
	}
	
    public String getUploadContentType() {
	    return uploadContentType;
	}
    
	public void setUploadContentType(String uploadContentType) {
	    this.uploadContentType = uploadContentType;
	}
	  
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getUploadFileName() {
	    return uploadFileName;
	}
	  
	public void setUploadFileName(String uploadFileName) {
	    this.uploadFileName = uploadFileName;
	} 

}
