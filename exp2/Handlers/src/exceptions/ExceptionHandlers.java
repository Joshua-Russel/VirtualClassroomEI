package exceptions;

public class ExceptionHandlers {
	public static class ClassroomCreationException extends Exception {


		public ClassroomCreationException(String message) {
			super(message);
		}
	}

	public static class ClassroomRemovalException extends Exception {


		public ClassroomRemovalException(String message) {
			super(message);
		}
	}

	public static class AssignmentSchedulingException extends Exception {


		public AssignmentSchedulingException(String message) {
			super(message);
		}
	}

	public static class AssignmentSubmissionException extends Exception {


		public AssignmentSubmissionException(String message) {
			super(message);
		}
	}

	public static class StudentEnrollmentException extends Exception {


		public StudentEnrollmentException(String message) {
			super(message);
		}
	}

}