package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {

	public SuperSmartParkingBoy() {
	}

	public SuperSmartParkingBoy(ParkingLot parkingLot) {
		super(parkingLot);
	}

	public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	@Override
	public ParkingLot getMaxCapacityParkingLot(List<ParkingLot> parkingLots) {
		ParkingLot parkingLot = new ParkingLot();
		double maxCapacityRate = 0;
		for (ParkingLot parkLot : parkingLots) {
			double nowMaxCapacityRate = parkLot.getAvailableParkingPosition() / (parkLot.getCapacity() * 1.0) * 100;
			if (nowMaxCapacityRate > maxCapacityRate) {
				maxCapacityRate = nowMaxCapacityRate;
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
