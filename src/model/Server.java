package model;
public class Server {

	private int cache;
	private int processorsNumber;
	private String proccessorMarca;
	private int ram;
	private int diskNumber;
	private int disksCapacity;

	
	/**
	 * @param cache
	 * @param processorsNumber
	 * @param proccessorMarca
	 * @param ram
	 * @param diskNumber
	 * @param disksCapacity
	 */
	public Server(int cache, int processorsNumber, String proccessorMarca, int ram, int diskNumber, int disksCapacity) {
		super();
		this.cache = cache;
		this.processorsNumber = processorsNumber;
		this.proccessorMarca = proccessorMarca;
		this.ram = ram;
		this.diskNumber = diskNumber;
		this.disksCapacity = disksCapacity;
	}

	public int getCache() {
		return this.cache;
	}

	/**
	 * 
	 * @param cache
	 */
	public void setCache(int cache) {
		this.cache = cache;
	}

	public int getProcessorsNumber() {
		return this.processorsNumber;
	}

	/**
	 * 
	 * @param processorsNumber
	 */
	public void setProcessorsNumber(int processorsNumber) {
		this.processorsNumber = processorsNumber;
	}

	public String getProccessorMarca() {
		return this.proccessorMarca;
	}

	/**
	 * 
	 * @param proccessorMarca
	 */
	public void setProccessorMarca(String proccessorMarca) {
		this.proccessorMarca = proccessorMarca;
	}

	public int getRam() {
		return ram;
	}

	/**
	 * 
	 * @param ram
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getDiskNumber() {
		return diskNumber;
	}

	/**
	 * 
	 * @param diskNumber
	 */
	public void setDiskNumber(int diskNumber) {
		this.diskNumber = diskNumber;
	}

	public int getDisksCapacity() {
		return disksCapacity;
	}

	/**
	 * 
	 * @param disksCapacity
	 */
	public void setDisksCapacity(int disksCapacity) {
		this.disksCapacity = disksCapacity;
	}
	
	/**
	 * 
	 */
	public String toString() {
		String message="Cache: "+getCache()+"\n Processors number: "+getProcessorsNumber()+"\n Processors brand: "+getProccessorMarca()+"\n Ram: "+getRam()+"\n Disc number: "+getDiskNumber()+"\n Disc capacity: "+getDisksCapacity()+"\n";
		return message;
	}
	
}