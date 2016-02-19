package twitterAnalytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Query1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		PrintWriter output = response.getWriter();
		//Set response content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timeStamp);
		
		output.println(time);
	}
}