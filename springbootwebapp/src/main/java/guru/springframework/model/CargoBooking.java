package guru.springframework.model;

import java.util.Date;

import guru.springframework.services.CargoBookingMode;

public abstract class CargoBooking {
	
	Integer id;
	CargoBookingMode mode;
	String cargo;
	String loading;
	String discharge;
	Date createdTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getLoading() {
		return loading;
	}
	public void setLoading(String loading) {
		this.loading = loading;
	}
	public String getDischarge() {
		return discharge;
	}
	public void setDischarge(String discharge) {
		this.discharge = discharge;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public CargoBookingMode getMode() {
		return mode;
	}
	public void setMode(CargoBookingMode mode) {
		this.mode = mode;
	}
	
}
