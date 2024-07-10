package Model;

public class Vehicle {
	
	private String type;
	private int quantity;
	private String name;
	private String address;
	private String phoneNo;
	private String chassisNo;
	private String vehicleNo;
	private String registerDate;
	private int id;
	
	
	public String getType() {
		return type;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public int getId() {
		return id;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Vehicle [type=" + type + ", quantity=" + quantity + ", name=" + name + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", chassisNo=" + chassisNo + ", vehicleNo=" + vehicleNo + ", registerDate="
				+ registerDate + ", id=" + id + "]";
	}
	
	
}
