package eia.model;

/**
 * 
 * @author 
 *
 */
public class Accion {

	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	public Accion(){
		id = "";
	}
	
	/**
	 * 
	 * @param id
	 */
	public Accion(String id){
		this.id = id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getId(){
		return id;
	}
}
