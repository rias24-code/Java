package projects.TaxiBookingSystem;

import java.util.*;

public class Taxi {
	private int taxiId;
	private char currentLocation;
	private int earnings;
	private int freeTime;
	private List<Booking> trips;

	public Taxi(int taxiId) {
		System.out.println("Taxi crated");
		this.taxiId = taxiId;
		this.currentLocation = 'A';
		this.freeTime = 1;
		this.earnings = 0;
		this.trips = new ArrayList<>();
	}

	public int getTaxiId() {
		return taxiId;
	}

	public char getCurrentLocation() {
		return currentLocation;
	}

	public int getEarnings() {
		return earnings;
	}

	public int getFreeTime() {
		return freeTime;
	}

	public List<Booking> getTrips() {
		return trips;
	}


	public void assignedBooking(Booking booking) {
		this.freeTime = booking.getDropTime();
		this.earnings += booking.getAmount();
		this.currentLocation = booking.getDropLocation();
		this.trips.add(booking);
		System.out.println("Trip added");
	}

	@Override
	public String toString() {
		return "Taxi [taxiId=" + taxiId + ", currentLocation=" + currentLocation + ", earnings=" + earnings
				+ ", freeTime=" + freeTime + ", trips=" + trips + "]\n";
	}
}
