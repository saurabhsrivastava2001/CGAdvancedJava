package in.cg.entity;

public class Address {
	private String streetName;
	private String city;
	private int pincode;
	private String country;
	
	public Address(String streetName, String city, int pincode, String country) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
