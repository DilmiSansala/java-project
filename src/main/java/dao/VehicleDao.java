package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Order;
import Model.Vehicle;
import db.DbConnect;

public class VehicleDao {
		
		Connection connection;
		
		public void addVehicle(Vehicle vehicle) {
		    try {
		        connection = DbConnect.getConnection();
		        PreparedStatement pst = connection.prepareStatement("insert into vehicle (type, quantity, full_name, address, phoneNo, chassisNo, vehicleNo, registerDate) " +
		                "values (?, ?, ?, ?, ?, ?, ?, ?)");

		        pst.setString(1, vehicle.getType());
		        pst.setInt(2, vehicle.getQuantity());
		        pst.setString(3, vehicle.getName()); 
		        pst.setString(4, vehicle.getAddress());
		        pst.setString(5, vehicle.getPhoneNo());
		        pst.setString(6, vehicle.getChassisNo());
		        pst.setString(7, vehicle.getVehicleNo());
		        pst.setString(8, vehicle.getRegisterDate());

		        pst.executeUpdate();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public List<Vehicle> getVehicles() {
			
			List<Vehicle> vehicles = new ArrayList<Vehicle>();
			
			try {
				connection = DbConnect.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select id,type,quantity,full_name,address,phoneNo,chassisNo,vehicleNo,registerDate from vehicle");

				while(rs.next()) {
					
					Vehicle vehicle = new Vehicle();
	                
					vehicle.setId(rs.getInt("id"));
					vehicle.setType(rs.getString("type"));
					vehicle.setQuantity(rs.getInt("quantity"));
					vehicle.setName(rs.getString("full_name"));
					vehicle.setAddress(rs.getString("address"));
					vehicle.setPhoneNo(rs.getString("phoneNo")); 
					vehicle.setChassisNo(rs.getString("chassisNo"));
					vehicle.setVehicleNo(rs.getString("vehicleNo"));
					vehicle.setRegisterDate(rs.getString("registerDate"));

	                vehicles.add(vehicle);
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return vehicles;
			
		}
		
		public void deleteVehicle(int id) {
			
			try {
				connection = DbConnect.getConnection();
				
				PreparedStatement pst = connection.prepareStatement("delete from vehicle where id = ? ");
				pst.setInt(1, id);
				
				pst.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public Vehicle getVehiclebyId(int id) {
			
			Vehicle vehicle = new Vehicle();
			
			try {
				connection = DbConnect.getConnection();
				
				PreparedStatement pst = connection.prepareStatement("select id,type,quantity,full_name,address,phoneNo,chassisNo,vehicleNo,registerDate from vehicle where id=?");
				pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();
	            
	            while(rs.next()) {
	            	
	            	vehicle.setType(rs.getString("type"));
					vehicle.setQuantity(rs.getInt("quantity"));
					vehicle.setName(rs.getString("full_name"));
					vehicle.setAddress(rs.getString("address"));
					vehicle.setPhoneNo(rs.getString("phoneNo")); 
					vehicle.setChassisNo(rs.getString("chassisNo"));
					vehicle.setVehicleNo(rs.getString("vehicleNo"));
					vehicle.setRegisterDate(rs.getString("registerDate"));
	            }
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return vehicle;
		}
		
		public void updateVehicle(Vehicle vehicle) {
		    try {
		        connection = DbConnect.getConnection();
		        PreparedStatement pst = connection.prepareStatement("UPDATE vehicle "
		                + "SET type=?, quantity=?, full_name=?, address=?, phoneNo=?,  chassisNo=?, vehicleNo=?, registerDate=? "
		                + "WHERE id=?");

		        pst.setString(1, vehicle.getType());
				pst.setInt(2, vehicle.getQuantity());
				pst.setString(3, vehicle.getName());
				pst.setString(4, vehicle.getAddress());
				pst.setString(5, vehicle.getPhoneNo());
				pst.setString(6, vehicle.getChassisNo());
				pst.setString(7, vehicle.getVehicleNo());
				pst.setString(8, vehicle.getRegisterDate());
		        pst.setInt(9, vehicle.getId());

		        int rowsAffected = pst.executeUpdate();
		        if (rowsAffected > 0) {
		            System.out.println("Registration Updated");
		        } else {
		            System.out.println("Registration Not Updated");
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

