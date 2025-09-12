package projects.TaxiBookingSystem;

public class Booking {
	private int customerId;
	private int bookingId;
	private char pickupLocation;
	private char dropLocation;
	private int pickupTime;
	private int dropTime;
	private Taxi assignedTaxi;
	private int amount;
	
	public Booking(int customerId, int bookingId, char pickupLocation, char dropLocation, int pickupTime) {
		this.customerId = customerId;
		this.bookingId = bookingId;
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.pickupTime = pickupTime;
		System.out.println("booking assigned");
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public char getPickupLocation() {
		return pickupLocation;
	}

	public char getDropLocation() {
		return dropLocation;
	}

	public int getPickupTime() {
		return pickupTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public Taxi getAssignedTaxi() {
		return assignedTaxi;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void assingedTaxi(Taxi taxi) {
		this.assignedTaxi = taxi;
		int distance = Math.abs(pickupLocation - dropLocation) * 15; 
		this.dropTime = this.pickupTime + (distance / 15); 
		this.amount =  (100 + (distance - 5) * 10);
		taxi.assignedBooking(this);
		System.out.println("Taxi ASSIGNED");
		
//		int distanceInKm = Math.abs(pickupLocation - dropLocation) * 15;
//		this.dropTime = this.pickupTime + (distanceInKm / 15); // each 15 km = 1 hr
//		this.amount = 100 + (distanceInKm - 5) * 10; 

	}
	
	@Override
	public String toString() {
		return "Booking [customerId: " + customerId + "| bookingId: " + bookingId + "| pickupLocation: " + pickupLocation
				+ "| dropLocation: " + dropLocation + "| pickupTime: " + pickupTime + "| dropTime: " + dropTime
				+ "| assignedTaxi: " + assignedTaxi.getTaxiId() + "| amount: " + amount + "]\n";
	}
	
	
}
