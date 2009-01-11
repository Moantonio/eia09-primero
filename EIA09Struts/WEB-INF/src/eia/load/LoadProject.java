package eia.load;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;

import eia.model.Proyecto;
import eia.util.xml.XMLProyecto;


public class LoadProject extends ActionSupport {
  
	private File upload;//The actual file
	private String uploadContentType; //The content type of the file
	private String uploadFileName; //The uploaded file name
    
    public String execute() throws Exception {
    	try {
    		XMLProyecto xmlProy = new XMLProyecto("plantillas\\proyectoEIA.dtd");
    		Proyecto proyecto = (Proyecto)xmlProy.leer(upload.getAbsolutePath());
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
	  
	public String getUploadFileName() {
	    return uploadFileName;
	}
	  
	public void setUploadFileName(String uploadFileName) {
	    this.uploadFileName = uploadFileName;
	}  
}
