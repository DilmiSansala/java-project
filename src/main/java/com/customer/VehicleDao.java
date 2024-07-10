package com.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VehicleDao {
	
	Connection connection;
	
public void addVehicle(Vehicle vehicle){
		
		try {
			connection = VehicleRegisterDB.getConnection();
			PreparedStatement pst = connection.prepareStatement("insert into vehicle (OwnerName,Address,Phone,ChassisNo,VehicleNo,RegisterDate,Type) " + 
					"values (?,?,?,?,?,?,?)");
			
			pst.setString(1, vehicle.getOwnerName());
			pst.setString(2, vehicle.getAddress());
			pst.setString(3, vehicle.getPhone());
			pst.setString(4, vehicle.getChassisNo());
			pst.setString(5, vehicle.getVehicleNo());
			pst.setString(6, vehicle.getRegisterDate());
			pst.setString(7, vehicle.getType());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Vehicle> getvehicles() {
		
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		try {
			connection = VehicleRegisterDB.getConnection();
			
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from vehicle");

			
			while(rs.next()) {
				
				Vehicle vehicle = new Vehicle();
                
				vehicle.setId(rs.getInt("id"));
				vehicle.setOwnerName(rs.getString("OwnerName"));
				vehicle.setAddress(rs.getString("Address"));
				vehicle.setPhone(rs.getString("Phone"));
				vehicle.setChassisNo(rs.getString("ChassisNo")); 
				vehicle.setVehicleNo(rs.getString("VehicleNo"));
				vehicle.setRegisterDate(rs.getString("RegisterDate"));
				vehicle.setType(rs.getString("Type"));

                
				vehicles.add(vehicle);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vehicles;
		
	}
	
	public void deleteVehicle(int id) {
		
		try {
			connection = VehicleRegisterDB.getConnection();
			
			PreparedStatement pst = connection.prepareStatement("delete from vehicle where id = ? ");
			pst.setInt(1, id);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Vehicle getVehiclebyId(int id) {
		
		Vehicle vehicle1 = new Vehicle();
		
		try {
			connection = VehicleRegisterDB.getConnection();
			
			PreparedStatement pst = connection.prepareStatement("select * from vehicle where id=?");
			pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()) {
            	
            	vehicle1.setId(rs.getInt("id"));
				vehicle1.setOwnerName(rs.getString("OwnerName"));
				vehicle1.setAddress(rs.getString("Address"));
				vehicle1.setPhone(rs.getString("Phone"));
				vehicle1.setChassisNo(rs.getString("ChassisNo")); 
				vehicle1.setVehicleNo(rs.getString("VehicleNo"));
				vehicle1.setRegisterDate(rs.getString("RegisterDate"));
				vehicle1.setType(rs.getString("Type"));
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vehicle1;
	}
	
	public void updateVehicle(Vehicle vehicle) {
	    try {
	        connection =  VehicleRegisterDB.getConnection();
	        PreparedStatement pst = connection.prepareStatement("UPDATE vehicle "
	                + "SET OwnerName=?, Address=?, Phone=?, ChassisNo=?, VehicleNo=?, RegisterDate=?, Type=? "
	                + "WHERE id=?");

	        pst.setString(1, vehicle.getOwnerName());
			pst.setString(2, vehicle.getAddress());
			pst.setString(3, vehicle.getPhone());
			pst.setString(4, vehicle.getChassisNo());
			pst.setString(5, vehicle.getVehicleNo());
			pst.setString(6, vehicle.getRegisterDate());
			pst.setString(7, vehicle.getType());
	        pst.setInt(8, vehicle.getId());;

	        int rowsAffected = pst.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Vehicle Updated");
	        } else {
	            System.out.println("Vehicle Not Updated");
	        }
	    } catch (SQLException e) {
	        System.err.println("SQL Exception: " + e.getMessage());
	        System.err.println("SQL State: " + e.getSQLState());
	        System.err.println("Error Code: " + e.getErrorCode());
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	}

}
