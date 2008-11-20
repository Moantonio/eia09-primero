/**
 * 
 */
package eia.model;

/**
 * @author 
 *
 */
public class Factor {
	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	private int peso;
	
	
	/**
	 * 
	 */
	public Factor(){
		id = "";
		peso = 0;
	}
	
	/**
	 * 
	 * @param id
	 * @param peso
	 */
	public Factor(String id, int peso){
		this.id = id;
		this.peso = peso;
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
	
	/**
	 * 
	 * @param peso
	 */
	public void setPeso(int peso){
		this.peso = peso;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPeso(){
		return peso;
	}
}
