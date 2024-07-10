package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("Confirm_Password");
        String email = request.getParameter("email");

        
        if(!password.equals(confirmPassword)) {
        	request.setAttribute("errorMessage", "Password Do Not Match." );
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
        	dispatcher.forward(request, response);
        }
        
        else if (password.length() != 8 || !containsLetter(password)) {
            request.setAttribute("errorMessage", "Password must be exactly 8 characters long and contain at least one letter.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
        	try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","1234");

                String sql = "INSERT INTO user (username, password,confirm_password,email) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                
                
                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, confirmPassword);
                statement.setString(4, email);
               

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                	request.setAttribute("errorMessage", "SignUp Successful!." );
                	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                	dispatcher.forward(request, response);
                }

                statement.close();
                con.close();
    		}catch (Exception e) {
                e.printStackTrace();
            }
    		finally {
                out.close();
            }
            
        }
    
	}
	
	private boolean containsLetter(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }

}
