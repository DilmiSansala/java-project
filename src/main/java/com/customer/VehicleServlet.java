package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VehicleDao dao;
	Connection connection;
	
    public VehicleServlet() {
        super();
        dao = new VehicleDao();    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		@SuppressWarnings("unused")
		String forward = "";

		if (action == null) {
			action = "default";
		}

		switch (action) {
		case "delete":

			int vehicleid = Integer.parseInt(request.getParameter("id"));
			dao.deleteVehicle(vehicleid);

			RequestDispatcher dis = request.getRequestDispatcher("updatesample.jsp");
			request.setAttribute("vehicles", dao.getvehicles());
			dis.forward(request, response);
			forward = "/view.jsp";

			break;

		case "update":

			RequestDispatcher dis2 = request.getRequestDispatcher("Vehicle.jsp");

			vehicleid = Integer.parseInt(request.getParameter("id"));

			Vehicle vehicle = dao.getVehiclebyId(vehicleid);
			request.setAttribute("vehicle", vehicle);

			dis2.forward(request, response);

			break;

		default:
			RequestDispatcher dis3 = request.getRequestDispatcher("updatesample.jsp");
			request.setAttribute("vehicles", dao.getvehicles());
			dis3.forward(request, response);
			break;
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vehicle vehicle = new Vehicle();

		vehicle.setOwnerName(request.getParameter("name"));
		vehicle.setAddress(request.getParameter("address"));
		vehicle.setPhone(request.getParameter("phone"));
		vehicle.setChassisNo(request.getParameter("ChassisNo"));
		vehicle.setVehicleNo(request.getParameter("VehicleNo"));
		vehicle.setRegisterDate(request.getParameter("RegisterDate"));
		vehicle.setType(request.getParameter("Type"));

		String id = request.getParameter("id");

		if (id == null || id.isEmpty()) {
			dao.addVehicle(vehicle);

		} else {
			vehicle.setId(Integer.parseInt(id));
			dao.updateVehicle(vehicle);
		}

		RequestDispatcher dis4 = request.getRequestDispatcher("updatesample.jsp");
		request.setAttribute("vehicles", dao.getvehicles());
		dis4.forward(request, response);
	}

}


