package projects.TaxiBookingSystem;
import java.util.*;

import practice.Taxiii;
public class Main {
	private static List<Taxi> taxis = new ArrayList<Taxi>();
	private static List<Booking> allbookings = new ArrayList<Booking>();
	private static int bookingNo = 1;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int taxiLimit = 4;
		for(int i=taxis.size(); i<taxiLimit; i++) {
			taxis.add(new Taxi(i+1));
		}
		
		boolean running = true;
		System.out.println("Welcomt to our Taxi Booking Dashboard");
		while(running) {
			System.out.println(" Choose Any One :\n\t 1. Book Taxi\n\t 2. Taxi Detail \n\t 3. Booking Detail \n\t 4. Exit \n");
            System.out.print("Choose Any One : ");
			try {
				int option = input.nextInt();
				input.nextLine();
				switch(option) {
				case 1:
					booking();
					break;
				case 2:
					showTaxiDetails();
					break;
				case 3:
					showAllBookings();
					break;
				default:
					System.out.println("Thank you for coming See U !");
					running =false;
					input.close();
					break;
				}
			}catch(Exception e) {
				System.err.println("Error occured at : "+e.getMessage());
			}
			}

	}
	
	private static void showAllBookings() {
		for(Booking t : allbookings) {
			System.out.println(t);
		}
	
	}
	
	private static void showTaxiDetails() {
//		System.out.printf("Booking %d | Customer %d | Taxi %d | From %c -> %c | Time %d-%d | Fare %d%n",
//			    bookingId, customerId, assignedTaxi.getTaxiId(), pickupLocation, dropLocation, pickupTime, dropTime, amount);

		for(Taxi t : taxis) {
			System.out.println(t);
			for(Booking b : t.getTrips()) {
				System.out.println(b);
			}
		}
	}
	
	private static void booking() {
		System.out.print("Enter Pickup Location [A-F]: ");
		char pickupLocation = input.nextLine().toUpperCase().charAt(0);
		System.out.print("Enter Drop Location [A-F]: ");
		char dropLocation = input.nextLine().toUpperCase().charAt(0);
		System.out.print("Enter Pickup Time (in Hours): ");
		int pickupTime = Integer.parseInt(input.next());
		
		if(pickupLocation < 'A' || pickupLocation > 'F' || dropLocation < 'A' || dropLocation > 'F') {
			System.out.println("Invalid Location . Location must be [A to F]");
		}
		
		int customerId = (int) (Math.random() * 100);
		Booking booking = new Booking(customerId, bookingNo++,pickupLocation, dropLocation, pickupTime);
		Taxi avaliableTaxi = findBestTaxi(pickupLocation, pickupTime);
		if(avaliableTaxi != null) {
			System.out.println("Taxi Assiigns");
			booking.assingedTaxi(avaliableTaxi);
			allbookings.add(booking);
			System.out.println("Booking successful :"+ booking);
		}else {
			System.out.println("Sorry There is no taxis are avaliable at this moment !");
			return;
		}
	}
	
	private static Taxi findBestTaxi(char pickupLocation, int pickupTime) {
		Taxi bestTaxi = null;
		int minDistance = Integer.MAX_VALUE;
		for(Taxi t : taxis) {
			int distance = Math.abs(pickupLocation - t.getCurrentLocation()) * 15;
			if(t.getFreeTime() <= pickupTime && distance < minDistance) {
				minDistance = distance;
				bestTaxi = t;
			}else if(t.getFreeTime() <= pickupTime && distance == minDistance) {
				if(t.getEarnings() < (bestTaxi != null ? bestTaxi.getEarnings() : Integer.MAX_VALUE)) {
					bestTaxi = t;
				}
			}
		}
		return bestTaxi;
	}
}

