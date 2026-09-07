import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<String, Station> stationMap = new HashMap<>();
	private static Map<String, TrainLine>trainLinesMap=new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadingStationInfo();
		loadingTrainLineInfo();
		loadingLineStations();
		loadingTrainServices();
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println("Wellington Train Information System, please input number");
			System.out.println("1. print all stations");
	        System.out.println("2. print all train lines");
	        System.out.println("3. List the train lines that go through a given station");
	        System.out.println("4. List the stations along a given train line");
	        System.out.println("5. Find Direct Line");
	        System.out.println("6. Find next train services at a station");
	        System.out.println("7. Find Trip Between Stations");
	        System.out.println("8. Calculate Travel Time Between Stations");
	        System.out.println("0. Exit system");
	       
	        String choice = scanner.nextLine().trim();
	        
	        switch(choice) {
	        case "1"://print all stations
	    		
	    		System.out.println("The number of stations is  "+stationMap.size());
	    		for (Station sta : stationMap.values()) {
	    			System.out.println(sta.getName());
	    			
	    		}
	    		System.out.println();
	    		break;		
	        case "2"://打印所有线路信息 print all train lines
	        	
	    		System.out.println("The number of train lines is "+trainLinesMap.size());
	    		for(TrainLine tl:trainLinesMap.values()) {
	    			System.out.println(tl.getName());
	    		}
	    		System.out.println();
	    		break;	
	        case"3"://List the train lines that go through a given station
	        	
	        	Scanner scan = new Scanner(System.in);
	    		System.out.print("Please input the station name");
	    		String input = scan.nextLine().trim();
	    		Station sta = stationMap.get(input);
	    		System.out.println("The number of trains passing through this station is: " + sta.getTrainLines().size());
	    		for(TrainLine line : sta.getTrainLines()) {
	    			System.out.println(line.getName());	
	    		}
	    		System.out.println();  
	    		break;	
	        case"4"://查询经过这条线路的所有车站
	        	
	        	System.out.print("Please input the train line name (e.g. Wellington_Melling): ");
	    		String station = scanner.nextLine().trim();
	        	listStationsForLine(station);
	    		System.out.println();
	    		break;	
	        case"5"://find direct line
	    		findDirectLine();
	    		System.out.println();
	    		break;	
	        case"6":
	        	findNextServicesAtStation();
	        	System.out.println();
                break;
	        case"7":
	        	findTripBetweenStations();
                System.out.println();   
                break;
	        case"8":
	        	calculateTravelTime();
	        	System.out.println();   
                break;
	        case "0":
	            running = false;
	            System.out.println("Thank you!");
	            break;
	        default:
	        	System.out.println("Invalid choice! Please enter the correct number");
	        }
	        
	        if (running) {
	            System.out.println("Press Enter to continue...");
	            scanner.nextLine();
	        }
		}scanner.close();
		
	}
	//读取车站名，票价，距离 List all the stations in the region
	public static void loadingStationInfo() {
		String filePath = "lib/Train network data/stations.data";
		
		try {
			Scanner scan= new Scanner(new File(filePath));
			while(scan.hasNextLine()) {
				String line = scan.nextLine().trim();
				if(line.isEmpty()) {continue;}
				
				String[] parts = line.split("\\s+");
				if(parts.length>=3) {

					String staName=parts[0];
					int fareZone=Integer.parseInt(parts[1]);
					double distance=Double.parseDouble(parts[2]);
					Station sta=new Station(staName,fareZone,distance);
					stationMap.put(staName, sta);
				}	
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//加载线路 List all the train lines in the region
	public static void loadingTrainLineInfo() {
		String filePath = "lib/Train network data/train-lines.data";
		try {
			
			Scanner scan=new Scanner(new File(filePath));
			while(scan.hasNextLine()) {
				String lineName=scan.nextLine().trim();
				if(lineName.isEmpty()) {continue;}
				TrainLine trainLine=new TrainLine(lineName);
				trainLinesMap.put(lineName, trainLine);
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//List the train lines that go through a given station
	//Bind the relationship between the station and the line
	public static void loadingLineStations() {
		for(TrainLine line: trainLinesMap.values()) {
			String filePath="lib/Train network data/" + line.getName() + "-stations.data";
			try {
				Scanner scan=new Scanner(new File(filePath));
				while(scan.hasNextLine()) {
					String staName=scan.nextLine().trim();
					if(staName.isEmpty()) {continue;}
					Station sta=stationMap.get(staName);
					if(sta!=null) {
						line.addStation(sta);
						sta.addTrainLine(line);
					}
				}
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//List the stations along a given train line
	public static void listStationsForLine(String lineName) {
		TrainLine l=trainLinesMap.get(lineName.trim());
		
		if(l==null) {
			System.out.println("not found line");
			return;
		}
		List<Station> s=l.getStations();
		for (int i=0; i<s.size(); i++) {
			Station sta=s.get(i);
			System.out.println(sta.getName());
		}
		System.out.println();		
	}
	
	//Print the name of a train line that goes from a station to a destination station
	public static TrainLine findDirectLine() {
		//接受用户输入
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the start station ");
		String startInput = scanner.nextLine().trim();
		System.out.print("Please input the destination station ");
		String destInput = scanner.nextLine().trim();
		Station startSta= stationMap.get(startInput);
        Station destSta= stationMap.get(destInput);
        
        if(startSta==null||destSta==null) {
        	System.out.println("Wrong station");
        	return null;
        }        
        
        for (TrainLine line: trainLinesMap.values()) {
        	boolean foundStart = false;
        	for (Station sta: line.getStations()) {
        		if(sta.equals(startSta)) {
        			foundStart = true;
        		}
        		else if (foundStart && sta.getName().equalsIgnoreCase(destSta.getName())) {
        			System.out.println("Direct line: " + line.getName());
        			return line;
        		}
        	}
        }
        System.out.println("not found direct line");     
		return null;
	}
	
	//loading all services
	public static void loadingTrainServices() {
		for(TrainLine line: trainLinesMap.values()) {
			String filePath="lib/Train network data/" + line.getName() + "-services.data";
			try {
				Scanner scan=new Scanner(new File(filePath));
				while(scan.hasNextLine()) {
					String lineData = scan.nextLine().trim();
                    if (lineData.isEmpty()) continue;
                    TrainService service = new TrainService(line);
                    Scanner lineScan = new Scanner(lineData);
                    boolean isFirstStop = true;
                    while (lineScan.hasNextInt()) {
                    	int time = lineScan.nextInt();
                        service.addTime(time, isFirstStop);
                        isFirstStop = false;
                    }
                    lineScan.close();
                    line.addTrainService(service);
				}
				scan.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//find the next train
	public static void findNextServicesAtStation() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the station name ");
		String staInput = scanner.nextLine().trim();
		Station sta=stationMap.get(staInput);
		if(sta==null) {
			System.out.println("Wrong station name");
			return;
		}
		System.out.print("Please input the time(e.g. 1020) ");
		int inputTime=scanner.nextInt();
		
		for (TrainLine line : sta.getTrainLines()) {
			TrainService todayNextService = null;
	        int todayEarliest = Integer.MAX_VALUE;
	        TrainService firstServiceNextDay = null;
	        int tomorrowEarliest = Integer.MAX_VALUE;
	        
	        for (TrainService service : line.getTrainServices()) {
	        	int departureTime = service.getStopTimeForStation(service, sta);
	        	if (departureTime == -1) continue;
	        	
	        	if(departureTime>=inputTime){
	        		if (departureTime < todayEarliest) {
	        			todayEarliest = departureTime;
	                    todayNextService = service;
	        		}
	        	}
	        	else {
	        		if (departureTime < tomorrowEarliest) {
	        			tomorrowEarliest = departureTime;
	        			firstServiceNextDay = service;
	        		}
	        	}
	        }
	        
	        if (todayNextService != null) {
	        	System.out.println("The earliest train is "+ line.getName()+" at "+todayEarliest);
	        }else if(firstServiceNextDay != null) {
	        	System.out.println("The earliest train is "+line.getName()+" at "+tomorrowEarliest);
	        }
		}
		
		
	}
	
	public static void findTripBetweenStations() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the start station ");
		String startInput = scanner.nextLine().trim();
		Station sta=stationMap.get(startInput);
		System.out.print("Please input the destination station ");
		String destInput = scanner.nextLine().trim();
		
		Station startSta= stationMap.get(startInput);
        Station destSta= stationMap.get(destInput);
        
        if(startSta==null||destSta==null) {
        	System.out.println("Wrong station");
        	return;
        }  
        
        System.out.print("Please input the time(e.g. 1020) ");
		int inputTime=scanner.nextInt();
		
		TrainLine directLine = null;
        for (TrainLine line: trainLinesMap.values()) {
        	boolean foundStart = false;
        	for (Station s: line.getStations()) {
        		if(s.equals(startSta)) {
        			foundStart = true;
        		}
        		else if (foundStart && s.getName().equalsIgnoreCase(destSta.getName())) {
        			directLine = line;
        			//System.out.println("Direct line: " + line.getName());
        			break;
        		}
        	}
        	if (directLine != null) break;
        }
        if (directLine == null) {
            System.out.println("Not found");
            return;
        }
        
		
		int earliestDepTime = Integer.MAX_VALUE;
	    int arrivalTime = -1;

	    for (TrainService service : directLine.getTrainServices()) {
	    	int depTime = TrainService.getStopTimeForStation(service, startSta);
	    	int arrTime = TrainService.getStopTimeForStation(service, destSta);

	        // 起点终点都停靠，且发车时间 >= 输入时间
	        if (depTime != -1 && arrTime != -1 && depTime >= inputTime) {
	            // 挑出时间最早的那班
	            if (depTime < earliestDepTime) {
	                earliestDepTime = depTime;
	                arrivalTime = arrTime;
	            }
	        }
	    }
	    if (earliestDepTime != Integer.MAX_VALUE) {
	    	int zonesPassed = Math.abs(destSta.getZone() - startSta.getZone()) + 1;
	    	System.out.println("Train Line: " + directLine.getName());
	    	System.out.println("Departure from " + startSta.getName() + ": " + earliestDepTime);
	    	System.out.println("Arrival at " + destSta.getName() + ": " + arrivalTime);
	        System.out.println("Fare Zones Passed: " + zonesPassed);
	    }
	    else {
	    	System.out.println("Not found");
	    }   
	}
	
	private static int toTotalMinutes(int time) {
	    return (time / 100) * 60 + (time % 100);
	}
	
	public static void calculateTravelTime() {
		Scanner scanner = new Scanner(System.in);

	    System.out.print("Please input the start station ");
	    String startInput = scanner.nextLine().trim();

	    System.out.print("Please input the destination station ");
	    String destInput = scanner.nextLine().trim();

	    Station startSta = stationMap.get(startInput);
	    Station destSta = stationMap.get(destInput);

	    if (startSta == null || destSta == null) {
	        System.out.println("Wrong station");
	        return;
	    }
	    
	    TrainLine directLine = null;
	    for (TrainLine line : trainLinesMap.values()) {
	        List<Station> stations = line.getStations();
	        int startIdx = stations.indexOf(startSta);
	        int destIdx = stations.indexOf(destSta);

	        if (startIdx != -1 && destIdx != -1 && startIdx < destIdx) {
	            directLine = line;
	            break;
	        }
	    }
	    if (directLine == null) {
            System.out.println("Not found");
            return;
        }
	    for (TrainService service : directLine.getTrainServices()) {
	    	int depTime = TrainService.getStopTimeForStation(service, startSta);
	        int arrTime = TrainService.getStopTimeForStation(service, destSta);
	        if (depTime != -1 && arrTime != -1) {
	        	int depMins = toTotalMinutes(depTime);
	            int arrMins = toTotalMinutes(arrTime);
	        	if (arrMins <= depMins) {
	                arrMins += 1440; // 跨夜补24小时
	            }
	        	
	        	int duration = arrMins - depMins;
	        	System.out.println("Travel time from " + startSta.getName() + " to " + destSta.getName() + " is: " + duration + " minutes");
	        	return;
	        }
	        
	    }
	    System.out.println("Could not calculate the time.");
	    
	}

}
