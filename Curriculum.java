import java.util.ArrayList;

class Curriculum {
    private static ArrayList<String> subjects = new ArrayList<>();

    public static void addSubject(String subject) {
        if (!subjects.contains(subject)) {
            subjects.add(subject);
            System.out.println("Subject added successfully!");
        } else {
            System.out.println("Subject already exists.");
        }
    }

    public static void removeSubject(String subject) {
        if (subjects.contains(subject)) {
            subjects.remove(subject);
            System.out.println("Subject removed successfully!");
        } else {
            System.out.println("Subject not found.");
        }
    }

    public static void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects available.");
        } else {
            System.out.println("\nAvailable Subjects:");
            for (String subject : subjects) {
                System.out.println("- " + subject);
            }
        }
    }

    public static boolean subjectExists(String subject) {
        return subjects.contains(subject);
    }
}
