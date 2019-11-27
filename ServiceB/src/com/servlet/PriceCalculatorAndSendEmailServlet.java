package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utility.ReadMessageFromQueue;

@WebServlet("/sendEmail")
public class PriceCalculatorAndSendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 
		 ReadMessageFromQueue messageQueueReaderObject = new ReadMessageFromQueue();
		 try {
			 // Read Message from Queue and send Email
			 messageQueueReaderObject.readMessage();
			 
			 // Print hard coded text to screen.
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 out.println("<html>");
			 out.println("<head>");
			 out.println("<title>Hello World!</title>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>Message Read from Rabbit MQ Queue And Email Sent to the recipient.</h1>");
			 out.println("</body>");
			 out.println("</html>");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		 
		 
	}

}
