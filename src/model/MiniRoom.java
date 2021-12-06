package model;
public class MiniRoom implements PriceMiniRoom {
	//Attributes
	private final static double PRICE=250;
	private boolean window;
	private int uniqueNumber;
	private boolean available;
	private boolean on;
	
	
	/**
	 * @param window
	 * @param uniqueNumber
	 * @param available
	 */
	public MiniRoom(boolean window, int uniqueNumber, boolean available, boolean on) {
		super();
		this.window = window;
		this.uniqueNumber = uniqueNumber;
		this.available = available;
		this.on=on;
	}

	public boolean getWindow() {
		return this.window;
	}

	/**
	 * 
	 * @param window
	 */
	public void setWindow(boolean window) {
		this.window = window;
	}

	public int getUniqueNumber() {
		return uniqueNumber;
	}

	/**
	 * 
	 * @param uniqueNumber
	 */
	public void setUniqueNumber(int uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}

	/**
	 * @return the available
	 */
	public boolean getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	/**
	 * @return the on
	 */
	public boolean isOn() {
		return on;
	}

	/**
	 * @param on the on to set
	 */
	public void setOn(boolean on) {
		this.on = on;
	}

	public String toString() {
		String message="";
		message+="Unique number: "+getUniqueNumber()+"\n";
		message+="In front of window: "+getWindow()+"\n";
		message+="Available: "+getAvailable()+"\n";
		message+="On: "+isOn()+"\n";
		return message;
	}

	@Override
	public double windowRoom() {
		double finalPrice=250;
		if (getWindow()==true) {
			finalPrice=PRICE-((PRICE*10)/100);
		}
		return finalPrice;
	}

	@Override
	public double sepCorrier(int corrier) {
		double finalPrice=250;
		if (corrier==7) {
			finalPrice=PRICE-((PRICE*15)/100);
		}
		return finalPrice;
	}

	@Override
	public double secSixCorrier(int corrier) {
		double finalPrice=250;
		if (corrier>=2 && corrier<=6) {
			finalPrice=PRICE+((PRICE*15)/100);
		}
		return finalPrice;
	}

}