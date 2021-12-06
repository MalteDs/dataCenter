package model;
public class IcesiProyect extends Company {
	
	private int proyectNumber;
	
	/**
	 * Method constructor
	 * @param name
	 * @param nit
	 * @param proyectNumber
	 */
	public IcesiProyect(String name, String nit, int proyectNumber) {
		super(name, nit);
		this.proyectNumber = proyectNumber;
	}

	public int getProyectNumber() {
		return proyectNumber;
	}

	/**
	 * 
	 * @param proyectNumber
	 */
	public void setProyectNumber(int proyectNumber) {
		this.proyectNumber = proyectNumber;
	}
	
	public String toString() {
		String message=super.toString()+"Proyect number: "+getProyectNumber()+"\n";
		return message;
	}
	
}