package com.first.register;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.first.dbHandler.DBHandler;

@WebServlet("/reg")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		String email=req.getParameter("email");
		String pass = req.getParameter("pass");
		String gender=req.getParameter("gender");
		String address=req.getParameter("address");
		
		System.out.println("email "+email+" "+pass+" "+gender+" "+address);
		DBHandler.insertData(email, pass, gender, address);
	}
}
