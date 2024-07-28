package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import exceptions.ExceptionHandlers;
import postgres.dbfunctions;

public class VirtualClassroomManager {
	private Connection connection;
	private dbfunctions dbfn;
	private List<String> list;

	public VirtualClassroomManager(Connection conn) {
		this.connection = conn;
		this.dbfn = new dbfunctions(connection);
	}


	public static Connection createConnection(String DRIVER, String URL, String USER, String PASSWORD) {
		Connection connection = null;
		try {
			// Load the MySQL JDBC driver
			Class.forName(DRIVER);
			// Create the database connection
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}


	public void addClass(String ClassName) {
		try {
			dbfn.addClassroom(ClassName);

		} catch (ExceptionHandlers.ClassroomCreationException cl) {
			cl.printStackTrace();
		}
	}

	public void removeClass(String ClassName) {
		try {
			dbfn.removeClassroom(ClassName);

		} catch (ExceptionHandlers.ClassroomRemovalException cl) {
			cl.printStackTrace();
		}
	}

	public void addStudent(int ID, String Name, String ClassName) {
		try {
			dbfn.enrollStudent(ID, Name, ClassName);

		} catch (ExceptionHandlers.StudentEnrollmentException cl) {
			cl.printStackTrace();
		}
	}

	public void scheduleAssignment(String ClassName, String Details) {
		try {
			dbfn.scheduleAssignment(ClassName, Details);

		} catch (ExceptionHandlers.AssignmentSchedulingException cl) {
			cl.printStackTrace();
		}
	}

	public void submit(int ID, String ClassName, String Details) {
		try {
			dbfn.submitAssignment(ID, ClassName, Details);

		} catch (ExceptionHandlers.AssignmentSubmissionException cl) {
			cl.printStackTrace();
		}
	}

	public void listStudents(String ClassName) {
		list = dbfn.listStudents(ClassName);
		for (String Students : list) {
			System.out.println(Students);
		}

	}

	public void listClassrooms() {

		list = dbfn.listClassrooms();
		for (String Classroom : list) {
			System.out.println(Classroom);
		}

	}


}