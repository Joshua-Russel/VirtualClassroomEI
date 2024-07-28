import Factory.VirtualClassroomManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/virtualclass";
	private static final String JDBC_USER = "joshua";
	private static final String JDBC_PASSWORD = "joshua";
	private static final String DRIVER = "org.postgresql.Driver";

	public static void main(String[] args) {
		try (Connection conn = VirtualClassroomManager.createConnection(DRIVER, JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
			VirtualClassroomManager vcm = new VirtualClassroomManager(conn);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("Enter command: ");
//				System.out.println("list of commands: ");

				String a[] = br.readLine().split(" ");
				if (a.length == 0) {
					continue;
				}
				switch (a[0]) {
					case "add_classroom":
						if (a.length > 1) {
							vcm.addClass(a[1]);
						} else {
							System.out.println("command: add_classroom [class_name]");
						}
						break;
					case "list_classrooms":
						vcm.listClassrooms();
						break;
					case "remove_classroom":
						if (a.length > 1) {
							vcm.removeClass(a[1]);
						} else {
							System.out.println("command: remove_classroom [class_name]");
						}
						break;
					case "add_student":
						if (a.length > 3) {
							vcm.addStudent(Integer.parseInt(a[1]), a[2], a[3]);
						} else {
							System.out.println("command: add_student [Student_id] [stu_name] [class_name]");
						}
						break;
					case "schedule_assignment":
						if (a.length > 2) {
							vcm.scheduleAssignment(a[1], a[2]);
						} else {
							System.out.println("command: schedule_assignment [Class_name] [assignment_details]");
						}
						break;
					case "submit_assignment":
						if (a.length > 3) {
							vcm.submit(Integer.parseInt(a[1]), a[2], a[3]);
						} else {
							System.out.println("command: submit_assignment [student_id] [Class_name] [assignment_details]");
						}
						break;
					case "list_students":
						if (a.length > 1) {
							vcm.listStudents(a[1]);
						} else {
							System.out.println("command: list_students [class_name]");
						}
						break;
					case "exit":
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						System.exit(0);
						break;
					default:
						System.out.println("Invalid command");
						break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


