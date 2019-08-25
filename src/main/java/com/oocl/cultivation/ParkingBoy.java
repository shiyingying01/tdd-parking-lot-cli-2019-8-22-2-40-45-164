package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;

public class ParkingBoy {

	protected final List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
	protected String lastErrorMessage;

	public ParkingBoy() {
	}

	public ParkingBoy(ParkingLot parkingLot) {
		this.parkingLots.add(parkingLot);
	}

	public ParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots.addAll(parkingLots);
	}

	public ParkingTicket park(Car car) {
		ParkingTicket ticket = new ParkingTicket();
		for (ParkingLot parkingLot : parkingLots) {
			ticket = parkingLot.park(car);
			if (ticket != null) {
				break;
			}
		}
		if (ticket != null) {
			lastErrorMessage = null;
		} else {
			lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}

	public Car fetch(ParkingTicket ticket) {
		if (ticket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		Car car = new Car();
		for (ParkingLot parkingLot : parkingLots) {
			car = parkingLot.fetch(ticket);
		}
		if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
		return car;
	}

	public String getLastErrorMessage() {
		return lastErrorMessage;
	}
}
