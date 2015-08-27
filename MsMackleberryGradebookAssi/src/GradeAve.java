import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import java.text.NumberFormat;
import java.text.DecimalFormat;

/**
 * Servlet implementation class GradeAve
 */
@WebServlet("/GradeAve")
public class GradeAve extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String formattedAve;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeAve() {
        super();
        formattedAve = "";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			//URL of Oracle database server
			String url = "jdbc:oracle:thin:testuser/password@localhost";

			//properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			//creating connection to Oracle database using JDBC
			Connection conn = DriverManager.getConnection(url, props);

			String sql = "SELECT * FROM grades";

			//creating PreparedStatement object to execute query
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			
			double sum = 0.0;
			while (result.next()) {
				sum += Double.parseDouble(result.getString("grade"));
			}
			
			String countSql = "SELECT COUNT(*) FROM grades";
			PreparedStatement countStatement = conn.prepareStatement(countSql);
			ResultSet countResult = countStatement.executeQuery();
			
			double ave = 0.0;
			while (countResult.next()) {
				ave = sum / Integer.parseInt(countResult.getString(1));
			}
			formattedAve = getFormattedAve(ave);
		} catch (SQLException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("formattedAve", formattedAve);
		getServletContext().getRequestDispatcher("/Average.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private String getFormattedAve(double average) {
		NumberFormat formatter = new DecimalFormat("#0.00");
		return formatter.format(average);
	}

}
