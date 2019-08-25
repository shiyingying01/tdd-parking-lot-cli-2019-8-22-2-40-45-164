package com.oocl.cultivation;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy() {
	}

	public SmartParkingBoy(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	public ParkingLot getMaxCapacityParkingLot(List<ParkingLot> parkingLots) {
		ParkingLot parkingLot = new ParkingLot();
		int maxCapacity = 0;
		for (ParkingLot parkLot : parkingLots) {
			if (parkLot.getAvailableParkingPosition() > maxCapacity) {
				maxCapacity = parkLot.getAvailableParkingPosition();
				parkingLot = parkLot;
			}
		}
		return parkingLot;
	}

	@Override
	public ParkingTicket park(Car car) {
		ParkingLot parkingLot = getMaxCapacityParkingLot(super.parkingLots);
		ParkingTicket ticket = parkingLot.park(car);
		if (ticket != null) {
			lastErrorMessage = null;
		} else {
			lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}
	
	public ParkingTicket park(ParkingLot parkingLot,Car car) {
		ParkingTicket ticket = parkingLot.park(car);
		if (ticket != null) {
			lastErrorMessage = null;
		} else {
			lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}
}
