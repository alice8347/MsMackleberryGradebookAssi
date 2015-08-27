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

/**
 * Servlet implementation class GradeOutput
 */
@WebServlet("/GradeOutput")
public class GradeOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	private String assi;
	private double grade;
	private String message;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeOutput() {
        super();
        id = 0;
        assi = "";
        grade = 0.0;
        message = "";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		message = "";
		String tBody = getGrades();
		message += "<table class=\"table table-striped\"><thead><tr><th>id</th><th>Assignment</th><th>Grade</th></tr></thead><tbody>" + tBody + "</tbody></table>";
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher("/GradeBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	public static String getGrades() {
		String content = "";
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
			
			while (result.next()) {
				content += "<tr><td>" + Integer.parseInt(result.getString("id")) + "</td><td>" + result.getString("assignment") + "</td><td>" + Double.parseDouble(result.getString("grade")) + "</td></tr>";
			}
		} catch (SQLException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return content;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAssi() {
		return assi;
	}

	public void setAssi(String assi) {
		this.assi = assi;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
}
