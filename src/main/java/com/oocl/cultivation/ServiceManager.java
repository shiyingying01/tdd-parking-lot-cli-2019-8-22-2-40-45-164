package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;

public class ServiceManager extends ParkingBoy {

	private ParkingLot parkingLot;

	private List<ParkingBoy> parkingBoys = new ArrayList<>();

	private List<SmartParkingBoy> smartParkingBoys = new ArrayList<>();

	private List<SuperSmartParkingBoy> superSmartParkingBoys = new ArrayList<>();

	public ServiceManager(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ParkingTicket park(ParkingLot parkingLot, Car car) {
		if (parkingLot != this.parkingLot) {
			lastErrorMessage = "This parking lot dont belong with you";
			return null;
		}
		ParkingTicket ticket = parkingLot.park(car);
		if (ticket != null) {
			lastErrorMessage = null;
		} else {
			lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}

	public Car fetch(ParkingLot parkingLot, ParkingTicket ticket) {
		if (parkingLot != this.parkingLot) {
			lastErrorMessage = "This parking lot dont belong with you";
			return null;
		}
		if (ticket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		Car car = parkingLot.fetch(ticket);
		if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
		return car;
	}

	public ParkingTicket callParkingBoyPark(ParkingBoy parkingBoy, Car car) {
		parkingBoy = getParkingBoy(parkingBoy);
		if (parkingBoy == null) {
			lastErrorMessage = "This parking boy dont belong with you";
			return null;
		}
		return park(parkingLot,car);
	}

	public ParkingTicket callSmartParkingBoyPark(SmartParkingBoy smartParkingBoy, Car car) {
		smartParkingBoy = getSmartParkingBoy(smartParkingBoy);
		if (smartParkingBoy == null) {
			lastErrorMessage = "This smart parking boy dont belong with you";
			return null;
		}
		return park(parkingLot,car);
	}

	public ParkingTicket callSuperSmartParkingBoyPark(SuperSmartParkingBoy superSmartParkingBoy, Car car) {
		superSmartParkingBoy = getSuperSmartParkingBoy(superSmartParkingBoy);
		if (superSmartParkingBoy == null) {
			lastErrorMessage = "This super smart parking boy dont belong with you";
			return null;
		}
		return park(parkingLot,car);
	}

	public Car callParkingBoyFetch(ParkingBoy parkingBoy, ParkingTicket parkingTicket) {
		if (parkingTicket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		parkingBoy = getParkingBoy(parkingBoy);
		if (parkingBoy == null) {
			lastErrorMessage = "This parking boy dont belong with you";
			return null;
		}
		Car car =  parkingLot.fetch(parkingTicket); 
    	if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
    	return car;
	}

	public Car callSmartParkingBoyFetch(SmartParkingBoy smartParkingBoy, ParkingTicket parkingTicket) {
		if (parkingTicket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		smartParkingBoy = getSmartParkingBoy(smartParkingBoy);
		if (smartParkingBoy == null) {
			lastErrorMessage = "This smart parking boy dont belong with you";
			return null;
		}
		Car car =  parkingLot.fetch(parkingTicket); 
    	if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
    	return car;
	}

	public Car callSuperSmartParkingBoyFetch(SuperSmartParkingBoy superSmartParkingBoy, ParkingTicket parkingTicket) {
		if (parkingTicket == null) {
			lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		superSmartParkingBoy = getSuperSmartParkingBoy(superSmartParkingBoy);
		if (superSmartParkingBoy == null) {
			lastErrorMessage = "This super smart parking boy dont belong with you";
			return null;
		}
		Car car =  parkingLot.fetch(parkingTicket); 
    	if (car == null) {
			lastErrorMessage = "Unrecognized parking ticket.";
		}
    	return car;
	}

	public ParkingBoy getParkingBoy(ParkingBoy parkingBoy) {
		for (ParkingBoy parkBoy : parkingBoys) {
			if (parkBoy == parkingBoy) {
				return parkingBoy;
			}
		}
		return null;
	}

	public void setParkingBoys(ParkingBoy parkingBoy) {
		this.parkingBoys.add(parkingBoy);
	}

	public SmartParkingBoy getSmartParkingBoy(SmartParkingBoy smartParkingBoy) {
		for (SmartParkingBoy smartParkBoy : smartParkingBoys) {
			if (smartParkBoy == smartParkingBoy) {
				return smartParkBoy;
			}
		}
		return null;
	}

	public void setSmartParkingBoys(SmartParkingBoy smartParkingBoy) {
		this.smartParkingBoys.add(smartParkingBoy);
	}

	public SuperSmartParkingBoy getSuperSmartParkingBoy(SuperSmartParkingBoy superSmartParkingBoy) {
		for (SuperSmartParkingBoy superSmartParkBoy : superSmartParkingBoys) {
			if (superSmartParkBoy == superSmartParkingBoy) {
				return superSmartParkingBoy;
			}
		}
		return null;
	}

	public void setSuperSmartParkingBoys(SuperSmartParkingBoy superSmartParkingBoy) {
		this.superSmartParkingBoys.add(superSmartParkingBoy);
	}

}
