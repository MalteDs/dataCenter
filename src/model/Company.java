package model;
public class Company {

	private String name;
	private String nit;

	/**
	 * @param name
	 * @param nit
	 */
	public Company(String name, String nit) {
		this.name = name;
		this.nit = nit;
	}
	
	
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	/**
	 * 
	 * @param nit
	 */
	public void setNit(String nit) {
		this.nit = nit;
	}

	public String toString() {
		String message="\n Company name: "+getName()+"\n nit: "+getNit()+"\n";
		return message;
	}

}