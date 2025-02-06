import java.util.ArrayList;

    class GPAStudent extends Student {
        private String username;
        private String password;
        private ArrayList<String> enrolledSubjects;
        private ArrayList<Double> grades = new ArrayList<>();

        public double calculateGPA() {
            if (grades.isEmpty()) return 0.0;
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.size();
        }

        public GPAStudent(int id, String name, int age, String username, String password) {
            super(id, name, age);
            this.username = username;
            this.password = password;
            this.enrolledSubjects = new ArrayList<>();
            this.grades = new ArrayList<>();
        }

        public boolean login(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }

        public void chooseSubject(String subject) {
            if (Curriculum.subjectExists(subject) && !enrolledSubjects.contains(subject)) {
                enrolledSubjects.add(subject);
                grades.add(0.0);  // Default grade
                System.out.println("Subject enrolled successfully!");
            } else {
                System.out.println("Invalid subject or already enrolled.");
            }
        }

        public void addGrade(String subject, double grade) {
            int index = enrolledSubjects.indexOf(subject);
            if (index != -1) {
                grades.set(index, grade);
            }
        }

        @Override
        public String toString() {
            return super.toString() + ", GPA: " + calculateGPA();
        }

    }
