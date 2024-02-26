package guru.springframework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import guru.springframework.services.CargoBookingMode;

@Entity
@Table(name = "air_booking")
public class AirBooking extends CargoBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "air_booking_id")
	Integer id;

	@Column(name = "cargo", length = 50, nullable = false)
	String cargo;

	@Column(name = "airport_of_loading", length = 50, nullable = false)
	String loading;

	@Column(name = "airport_of_discharge", length = 50, nullable = false)
	String discharge;

	@CreationTimestamp
	@Column(name = "created_time")
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
	
	public AirBooking() {
		setMode(CargoBookingMode.AIR);
	}
	
}
