package in.cg.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class SensorData {
	@Id
	@GeneratedValue(strategy=(GenerationType.IDENTITY))
	private int id;
	@Column
	private double speed;
	@Column
	private double engineTemperature;
	@Column
	private int fuelLevel;
	@Column
	private double tirePressure;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getEngineTemperature() {
		return engineTemperature;
	}
	public void setEngineTemperature(double engineTemperature) {
		this.engineTemperature = engineTemperature;
	}
	public int getFuelLevel() {
		return fuelLevel;
	}
	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	public double getTirePressure() {
		return tirePressure;
	}
	public void setTirePressure(double tirePressure) {
		this.tirePressure = tirePressure;
	}
	
	
}
