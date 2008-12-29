package eia.model;

/**
 * @author SI: EIA'09
 * 		   Vicente Cruz Mínguez.
 *         Enrique Gallego Martín.
 *         Luis González de Paula.
 */

/**
 * Clase que implementa una acción ambiental.
 */
public class Accion implements Cloneable {

	/**
	 * Nombre de la acción ambiental.
	 */
	private String id;

	/**
	 * Constructor por defecto.
	 */
	public Accion(){
		id = "";
	}

	/**
	 *  Constructor por parámetros.
	 * @param id Nombre de la acción ambiental.
	 */
	public Accion(String id){
		this.id = id;
	}

	/**
	 * Mutador para el atributo 'id'.
	 * @param id Nombre a asignar a la acción ambiental.
	 */
	public void setId(String id){
		this.id = id;
	}

	/**
	 * Accesor para el atributo 'id'.
	 * @return Nombre de la acción ambiental.
	 */
	public String getId(){
		return id;
	}

	/**
	 * Vuelca sobre un String la información sobre la acción.
	 * @return Cadena de caracteres con información sobre la acción.
	 */
	public String toString(){
		return id;
	}

    public Object clone(){
        Object copia = null;
        try{
            copia = super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println("Imposible duplicar");
        }
        ((Accion)copia).id = new String(id);
        return copia;
    }

}
