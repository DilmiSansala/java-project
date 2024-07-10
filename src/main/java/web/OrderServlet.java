package web;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Order;
import Model.Vehicle;
import dao.VehicleDao;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VehicleDao dao;
	Connection connection;
    
    public OrderServlet() {
        super();
        dao = new VehicleDao();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String action = request.getParameter("action");
		@SuppressWarnings("unused")
		String forward="";
		
		if(action==null) {
			action = "default";
		}
		
		switch (action) {
			case "delete":
								
				int id = Integer.parseInt(request.getParameter("orderid"));
				dao.deleteVehicle(id);
				
				RequestDispatcher dis = request.getRequestDispatcher("updatesample.jsp");
				request.setAttribute("orders", dao.getVehicles());
				dis.forward(request, response);
				forward = "/view.jsp";
				
				break;
				
			case "update":
			
				RequestDispatcher dis2 = request.getRequestDispatcher("Vehicle.jsp");

				id = Integer.parseInt(request.getParameter("orderid"));
				
				Vehicle order = dao.getVehiclebyId(id);
				request.setAttribute("vehicle", order);
				
				dis2.forward(request, response);
					
				break;
				
		
			default:
				RequestDispatcher dis3 = request.getRequestDispatcher("updatesample.jsp");
				request.setAttribute("orders", dao.getVehicles());
				dis3.forward(request, response);
				break;
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setType(request.getParameter("type"));
		vehicle.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		vehicle.setName(request.getParameter("Fname"));
		vehicle.setAddress(request.getParameter("no"));
		vehicle.setPhoneNo(request.getParameter("email"));
		vehicle.setChassisNo(request.getParameter("notes"));
		vehicle.setVehicleNo(request.getParameter("pick"));
		vehicle.setRegisterDate(request.getParameter("deliver"));
		
		String orderid = request.getParameter("orderid");
		
		if(orderid==null || orderid.isEmpty()) {
			
			dao.addVehicle(vehicle);
		}
		else{
			vehicle.setId(Integer.parseInt(orderid));
			dao.updateVehicle(vehicle);	
		}
		
		RequestDispatcher dis4 = request.getRequestDispatcher("updatesample.jsp");
		request.setAttribute("orders", dao.getVehicles());
		dis4.forward(request, response);
	}
}
