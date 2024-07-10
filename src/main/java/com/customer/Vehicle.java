package com.customer;

public class Vehicle {
	
	private  String OwnerName;
	private  String Address;
	private  String Phone;
	private  String ChassisNo;
	private  String VehicleNo;
	private  String RegisterDate;
	private  String Type;
	private int id;
	
	public String getOwnerName() {
		return OwnerName;
	}
	public String getAddress() {
		return Address;
	}
	public String getPhone() {
		return Phone;
	}
	public String getChassisNo() {
		return ChassisNo;
	}
	public String getVehicleNo() {
		return VehicleNo;
	}
	public String getRegisterDate() {
		return RegisterDate;
	}
	public String getType() {
		return Type;
	}
	public int getId() {
		return id;
	}
	public void setOwnerName(String OwnerName) {
		this.OwnerName = OwnerName;
	}
	public void setAddress(String Address) {
		this.Address = Address;
	}
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}
	public void setChassisNo(String ChassisNo) {
		this.ChassisNo = ChassisNo;
	}
	public void setVehicleNo(String VehicleNo) {
		this.VehicleNo = VehicleNo;
	}
	public void setRegisterDate(String RegisterDate) {
		this.RegisterDate = RegisterDate;
	}
	public void setType(String Type) {
		this.Type = Type;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Vehicle [OwnerName=" + OwnerName + ", Address=" + Address + ", Phone=" + Phone + ", ChassisNo="
				+ ChassisNo + ", VehicleNo=" + VehicleNo + ", RegisterDate=" + RegisterDate + ", Type=" + Type + ", id="
				+ id + "]";
	}
	
	
}
