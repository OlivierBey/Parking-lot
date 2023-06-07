package parking.models;

import java.time.LocalDateTime;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
/**
 * Tabel Booking bevat alle actieve bookings dwz enkel de bookings die niet afgesloten zijn
 * Waar er nog een auto op een parkeerplaats staat
 * Bij sluiten van de booking wordt deze verwijderd
 * @author olivi
 *
 */
@Entity
@Table(name = "tblBooking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "parkingSpace_id")
	private ParkingSpace parkingSpace;

	private String vehiclePlate;
	private LocalDateTime startTime;
	private LocalDateTime stopTime;

	@Nullable
	private double totalPrice;

	public Booking() {
	}

	public Booking(String name, LocalDateTime startTime) {
		this.vehiclePlate = name;
		this.startTime = startTime;
	}

	public Booking(String name, LocalDateTime startTime, ParkingSpace selectedParkingSpace) {
		this.vehiclePlate = name;
		this.startTime = startTime;
		this.parkingSpace = selectedParkingSpace;
	}

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public LocalDateTime getStarTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public String getVehiclePlate() {
		return vehiclePlate;
	}

	public void setVehiclePlate(String vehiclePlate) {
		this.vehiclePlate = vehiclePlate;
	}

}
