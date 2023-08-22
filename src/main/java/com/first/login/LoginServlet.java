package com.first.login;

import java.io.IOException;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.first.dbHandler.DBHandler;
import com.first.dbHandler.Validator;

@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		System.out.println("Hai");
		String email=req.getParameter("email");
		String pass = req.getParameter("password");
		boolean result=Validator.validate(email, pass);
		if(result == true)
		{
			System.out.println("Login Success");
		}
		else {
			System.out.println("Try again");
		}
	}
}
