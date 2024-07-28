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
			boolean success = dbfn.addClassroom(ClassName);
			if (success) {
				System.out.println("Class " + ClassName + " added successfully");
			}

		} catch (ExceptionHandlers.ClassroomCreationException cl) {
			cl.printStackTrace();
		}
	}

	public void removeClass(String ClassName) {
		try {
			boolean success = dbfn.removeClassroom(ClassName);
			if (success) {
				System.out.println("Class " + ClassName + " removed successfully");
			}

		} catch (ExceptionHandlers.ClassroomRemovalException cl) {
			cl.printStackTrace();
		}
	}

	public void addStudent(int ID, String Name, String ClassName) {
		try {
			boolean success = dbfn.enrollStudent(ID, Name, ClassName);
			if (success) {
				System.out.println("Student " + ID + " added to " + ClassName + "successfully");
			}

		} catch (ExceptionHandlers.StudentEnrollmentException cl) {
			cl.printStackTrace();
		}
	}

	public void scheduleAssignment(String ClassName, String Details) {
		try {
			boolean success = dbfn.scheduleAssignment(ClassName, Details);
			if (success) {
				System.out.println("Assignment for" + ClassName + " has been scheduled successfully");
			}

		} catch (ExceptionHandlers.AssignmentSchedulingException cl) {
			cl.printStackTrace();
		}
	}

	public void submit(int ID, String ClassName, String Details) {
		try {
			boolean success = dbfn.submitAssignment(ID, ClassName, Details);
			if (success) {
				System.out.println("Assignment submitted by Student" + ID + " in " + ClassName);
			}

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