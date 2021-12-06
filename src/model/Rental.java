package model;
public class Rental {

	private String date;
	private Server servers;
	private Company companies;
	

	public Rental(String date, Server servers, Company companies) {
		super();
		this.date = date;
		this.servers = servers;
		this.companies = companies;
	}

	public String getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	public Server getServers() {
		return this.servers;
	}

	/**
	 * 
	 * @param servers
	 */
	public void setServers(Server servers) {
		this.servers = servers;
	}

	public Company getCompanies() {
		return this.companies;
	}

	/**
	 * 
	 * @param companies
	 */
	public void setCompanies(Company companies) {
		this.companies = companies;
	}
	
	public String toString() {
		String message="Rent date: "+getDate()+"\n"+companies.toString()+"\n"+servers.toString();
		return message;
	}

}