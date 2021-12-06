package model;
/**
 * The class DataCenter allows the system solve the information and verify the exist of the objects
 */
public class DataCenter {
	//Attributes
	private final static int CORRIER=8;
	private final static int ROOMS_CORRIER=50;
	//Relations
	private MiniRoom [][] miniRooms;
	private Rental [][] rental;
	private Company [][] companies;
	private Server [][] servers;
	private String [][] map;
	
	/**
	 * Method constructor
	 * @param miniRooms
	 * @param alquiler
	 */
	public DataCenter() {
		this.miniRooms = new MiniRoom[CORRIER][ROOMS_CORRIER];
		this.rental = new Rental[CORRIER][ROOMS_CORRIER];
		this.companies = new Company[CORRIER][ROOMS_CORRIER];
		this.servers = new Server[CORRIER][ROOMS_CORRIER];
		this.map = new String[CORRIER][ROOMS_CORRIER];
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(i==0) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(true, j+1, true, false);
					}
				}
				
				if(i==1) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 50+(j+1), true, false);
					}
				}
				
				if(i==2) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 100+(j+1), true, false);
					}
				}
				
				if(i==3) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 150+(j+1), true, false);
					}
				}
				
				if(i==4) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 200+(j+1), true, false);
					}
				}

				if(i==5) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 250+(j+1), true, false);
					}
				}
				
				if(i==6) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 300+(j+1), true, false);
					}
				}
				
				if(i==7) {
					if (miniRooms[i][j]==null) {
						miniRooms[i][j]= new MiniRoom(false, 350+(j+1), true, false);
					}
				}
				if (j==0 || j==49) {
					miniRooms[i][j].setWindow(true);
				}
			}
		}
		
		
	}
	
	/**
	 * Method name: avaliableRooms
	 * the method shows the mini-rooms information
	 * @return message String returns the Mini-rooms information <br>
	 */
	public String avaliableRooms() {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if (miniRooms[i][j].getAvailable()==true) {
					message+="\n"+miniRooms[i][j].toString()+"Corrier: "+(i+1)+"\n";
				}
			}
		}
		return message;
	}
	
	/**
	 * The method rentMiniRoom allows rent a mini_room <br>
	 * @param date
	 * @param nameCompany
	 * @param nitCompany
	 * @param cache
	 * @param processorsNumber
	 * @param proccessorBrand
	 * @param ram
	 * @param diskNumber
	 * @param disksCapacity
	 * @return message String 
	 */
	public String rentMiniRoom(String date, String nameCompany, String nitCompany, int cache, int processorsNumber, String proccessorBrand, int ram, int diskNumber, int disksCapacity, int cont) {
		String message="The rent can´t be created";
		double price=0;
		if (cont<400) {
			for (int i = 0; i < CORRIER; i++) {
				for (int j = 0; j < ROOMS_CORRIER; j++) {
					if (companies[i][j]==null) {
						companies[i][j]=new Company(nameCompany, nitCompany);
					}
					if(servers[i][j]==null) {
						servers[i][j]= new Server(cache, processorsNumber, proccessorBrand, ram, diskNumber, disksCapacity);	
					}
					if (rental[i][j]==null) {
						rental[i][j]=new Rental(date, servers[i][j], companies[i][j]);
						miniRooms[i][j].setAvailable(false);
						miniRooms[i][j].setOn(true);
						if (miniRooms[i][j].getWindow()==true) {
							price=miniRooms[i][j].windowRoom();
						}
						if (i==7) {
							price=miniRooms[i][j].sepCorrier(i);
						}
						if (i>=2 && i<=6) {
							price=miniRooms[i][j].secSixCorrier(i);
						}
						return message="Rent has been created \n"+miniRooms[i][j].toString()+" Price: $"+price+"\n";
					}
					
				}
						
			}
		}
		else if(cont==400)
			message="The Mini-rooms are full";
		
		return message;
	}
	
	
	/**
	 * The 
	 * @param date
	 * @param nameCompany
	 * @param nitCompany
	 * @param proyectNumber
	 * @param cache
	 * @param processorsNumber
	 * @param proccessorMarca
	 * @param ram
	 * @param diskNumber
	 * @param disksCapacity
	 * @param cont
	 * @return String message
	 */
	public String rentProyect(String date, String nameCompany, String nitCompany, int proyectNumber, int cache, int processorsNumber, String proccessorBrand, int ram, int diskNumber, int disksCapacity, int cont) {
		String message="The proyect can´t be created"+cont;
		double price=0;
		if(cont==400)
			return message="The Mini-rooms are full";
		
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if (rental[i][j]==null && companies[i][j]==null) {
					if(servers[i][j]==null) {
						companies[i][j]=new IcesiProyect(nameCompany, nitCompany, proyectNumber);
						servers[i][j]= new Server(cache, processorsNumber, proccessorBrand, ram, diskNumber, disksCapacity);
						rental[i][j]=new Rental(date, servers[i][j], companies[i][j]);
						miniRooms[i][j].setAvailable(false);
						miniRooms[i][j].setOn(true);
						if (miniRooms[i][j].getWindow()==true) {
							price=miniRooms[i][j].windowRoom();
						}
						if (i==7) {
							price=miniRooms[i][j].sepCorrier(i);
						}
						if (i>=2 && i<=6) {
							price=miniRooms[i][j].secSixCorrier(i);
						}
						return message="Rent has been created \n"+miniRooms[i][j].toString()+" Price: $"+price+"\n";
					}
				}
			}
		}
		
		
		return message;
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public String showRent(int search) {
		String message="The rent does not exist";
		int[]aux=searchByRoom(search);
		if (companies[aux[0]][aux[1]]!=null) {
			if (aux[0]!=-1 && aux[1]!=-1) {
				return message=companies[aux[0]][aux[1]].toString();
			}
		}
		else return message;
		return message;
		
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public int[] searchByRoom(int search) {
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if (miniRooms[i][j]!=null && miniRooms[i][j].getUniqueNumber()==search) {
					return new int[]{i,j};
				}
			}
		}
		return new int[] {-1,-1};
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public String deleteByRoom(int search) {
		int[]aux=searchByRoom(search);
		companies[aux[0]][aux[1]]=null;
		rental[aux[0]][aux[1]]=null;
		servers[aux[0]][aux[1]]=null;
		miniRooms[aux[0]][aux[1]].setAvailable(true);
		return "The rent has been deleted";
	}
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public boolean messageDeleteByCompany(String search) {
		int cont=searchByCompany(search);
		boolean exist=false;
		if (cont==0) {
			return exist;
		}
		if (cont!=0) {
			return exist=true;
		}
		return exist;
	}
	
	public String deleteByCompany(String search) {
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if (companies[i][j]!=null && companies[i][j].getName().equalsIgnoreCase(search)) {
					companies[i][j]=null;
					rental[i][j]=null;
					servers[i][j]=null;
					miniRooms[i][j].setAvailable(true);
				}
			}
		}
		return "The rent(s) has been deleted(s)";
	}
	/**
	 * 
	 * @param search
	 * @return
	 */
	public int searchByCompany(String search) {
		int cont=0;
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if (companies[i][j]!=null && companies[i][j].getName().equalsIgnoreCase(search)) {
					cont++;
				}
			}
		}
		return cont;
	}
	/**
	 * 
	 */
	public void fillMap() {
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(map[i][j]!=null)
					map[i][j]=null;
				if (map[i][j]==null) {
					if(miniRooms[i][j].isOn()==true)
						map[i][j]="O";
					if(miniRooms[i][j].isOn()==false)
						map[i][j]="x";
				}
			} 
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public String showMap() {
		fillMap();
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				message+=map[i][j];
			}
			message+="\n";
		}
		return message;
	}
	
	/**
	 * 
	 * @return
	 */
	public String simulateOnMap() {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				message+="O";
			} 
			message+="\n";
		}
		return message;
	}
	
	/**
	 * 
	 * @param option
	 * @return
	 */
	public String simulateOff(String option, int numColCorrier) {
		String message="";
		switch (option) {
			case "l":message=simulateOffL();
				
				break;
			
			case "L":message=simulateOffL();
				
				break;
				
			case "z":message=simulateOffZ();
				
				break;
			
			case "Z":message=simulateOffZ();
				
				break;
			case "h":message=simulateOffH();
						
				break;
				
			case "H":message=simulateOffH();
				
				break;
				
			case "o":message=simulateOffO();
				
				break;
				
			case "O":message=simulateOffO();
				
				break;
				
			case "m":message=simulateOffM(numColCorrier);
				
				break;
				
			case "M":message=simulateOffM(numColCorrier);
				
				break;
				
			case "p":message=simulateOffP(numColCorrier);
				
				break;
				
			case "P":message=simulateOffP(numColCorrier);
				
				break;
		}
		return message;
	}
	
	/**
	 * 
	 * @return
	 */
	public String simulateOffL() {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(i==0 || j==0)
					message+="x";
				else message+="O";
			}
			message+="\n";
		}
		return message;
	}
	
	/**
	 * 
	 * @return
	 */
	public String simulateOffZ() {
		String message="";
		for (int i = 0; i < 50; i++) {
			if (i<8) {
				for (int j = 0; j < ROOMS_CORRIER; j++) {
					if(i==0 || i==7)
						message+="x";
					else if(i==j)
						message+="x";
					else message+="O";
				}
			}
			if(i<8) message+="\n";
		}
		return message;
	}
	
	public String simulateOffH() {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(i%2==0)
					message+="0";
				else message+="x";
			}
			message+="\n";
		}
		return message;
	}
	
	public String simulateOffO() {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(i==0 || j==0 || j==49)
					message+="x";
				else message+="O";
			}
			message+="\n";
		}
		return message;
	}
	
	public String simulateOffM(int column) {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(j==(column-1))
					message+="x";
				else message+="O";
			}
			message+="\n";
		}
		return message;
	}
	
	public String simulateOffP(int corrier) {
		String message="";
		for (int i = 0; i < CORRIER; i++) {
			for (int j = 0; j < ROOMS_CORRIER; j++) {
				if(i==(corrier-1))
					message+="x";
				else message+="O";
			}
			message+="\n";
		}
		return message;
	}
	
}