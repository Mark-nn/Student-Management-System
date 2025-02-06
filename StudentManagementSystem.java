import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<GPAStudent> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static final String INSTRUCTOR_USERNAME = "admin";
    private static final String INSTRUCTOR_PASSWORD = "1234";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Student Management System");
            System.out.println("1. Instructor Login");
            System.out.println("2. Student Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    instructorLogin();
                    break;
                case 2:
                    studentLogin();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void instructorLogin() {
        System.out.print("Enter Instructor Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (username.equals(INSTRUCTOR_USERNAME) && password.equals(INSTRUCTOR_PASSWORD)) {
            System.out.println("Instructor logged in successfully!");
            instructorMenu();
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void instructorMenu() {
        while (true) {
            System.out.println("\nInstructor Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Add Subject & Grade");
            System.out.println("5. Manage Curriculum");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    addSubjectAndGrade();
                    break;
                case 5:
                    manageCurriculum();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        students.add(new GPAStudent(id, name, age, username, password));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nList of Students:");
            for (GPAStudent s : students) {
                System.out.println(s);
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (GPAStudent s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void addSubjectAndGrade() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (GPAStudent s : students) {
            if (s.getId() == id) {
                System.out.print("Enter Subject Name: ");
                String subject = scanner.nextLine();
                System.out.print("Enter Grade: ");
                double grade = scanner.nextDouble();
                scanner.nextLine();
                s.addGrade(subject, grade);
                System.out.println("Subject and grade added successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void manageCurriculum() {
        while (true) {
            System.out.println("\nCurriculum Management:");
            System.out.println("1. Add Subject");
            System.out.println("2. Remove Subject");
            System.out.println("3. View Subjects");
            System.out.println("4. Go Back");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Subject Name: ");
                    String subject = scanner.nextLine();
                    Curriculum.addSubject(subject);
                    break;
                case 2:
                    System.out.print("Enter Subject Name to Remove: ");
                    String removeSubject = scanner.nextLine();
                    Curriculum.removeSubject(removeSubject);
                    break;
                case 3:
                    Curriculum.viewSubjects();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void studentLogin() {
        System.out.print("Enter Student Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (GPAStudent student : students) {
            if (student.login(username, password)) {
                System.out.println("Student logged in successfully!");
                studentMenu(student);
                return;
            }
        }
        System.out.println("Incorrect credentials or student not found.");
    }

    private static void studentMenu(GPAStudent student) {
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View GPA");
            System.out.println("2. Enroll in a Subject");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(student);
                    break;
                case 2:
                    Curriculum.viewSubjects();
                    System.out.print("Enter Subject Name: ");
                    String subject = scanner.nextLine();
                    student.chooseSubject(subject);
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}