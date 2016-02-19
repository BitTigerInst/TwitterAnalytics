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

public class Query2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	//JDBC driver name and datbase URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/q2";
	
	//Database credentials
	final String USER = "root";
	final String PWD = "123";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//To get the requested info from URL and make the usable in query
		String time = request.getParameter("created_at");
		
		//database query
		String sql = "select tweet_id, text from q2 where time=?";
		
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
				long tweet_id = resultSet.getLong("tweet_id");
				String text = resultSet.getString("text");
				output.print(tweet_id + ":" + text);
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
