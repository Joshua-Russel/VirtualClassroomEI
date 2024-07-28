package exceptions;

public class ExceptionHandlers {
    public static class ClassroomCreationException extends Exception {

        private static final long serialVersionUID = 1L;

        public ClassroomCreationException(String message) {
            super(message);
        }
    }

    public static class ClassroomRemovalException extends Exception {

        private static final long serialVersionUID = 1L;

        public ClassroomRemovalException(String message) {
            super(message);
        }
    }
    public static class AssignmentSchedulingException extends Exception {

        private static final long serialVersionUID = 1L;

        public AssignmentSchedulingException(String message) {
            super(message);
        }
    }
    public static class AssignmentSubmissionException extends Exception {

        private static final long serialVersionUID = 1L;

        public AssignmentSubmissionException(String message) {
            super(message);
        }
    }

    public static class StudentEnrollmentException extends Exception {

        private static final long serialVersionUID = 1L;

        public StudentEnrollmentException(String message) {
            super(message);
        }
    }

}