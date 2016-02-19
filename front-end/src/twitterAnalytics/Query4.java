package twitterAnalytics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class Query4 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//JDBC driver name and datbase URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/q4";
	
	//Database credentials
	final String USER = "root";
	final String PWD = "123";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//To get the requested info from URL and make the usable in query
		String user_id = request.getParameter("user_id");
		
		//database query
		String sql = "select retweeted_user_id from q4 where user_id=?";
		
		//Tomcat DataSource JNDI
		Context context = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("jdbc/mysql");
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			PrintWriter output = response.getWriter();
			//Set response content type
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			while(resultSet.next()){
				long retweeted_user_id = resultSet.getLong("retweeted_user_id");
				output.println(retweeted_user_id);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				resultSet.close();
				statement.close();
				connection.close();
				context.close();
			} catch(SQLException e){
				System.out.println("Exception in closing DB resources");
			} catch(NamingException e){
				System.out.println("Exception in closing Context");
			}
		}
	}
}