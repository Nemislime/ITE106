import java.util.Scanner;

public class Testcase01 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        
        String[] studentNames = new String[numStudents];
        double[] grades = new double[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
            System.out.print("Enter grade for " + studentNames[i] + ": ");
            grades[i] = scanner.nextDouble();
            scanner.nextLine();
        }
        
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < numStudents; i++) {
            String gradeCategory;
            if (grades[i] >= 90) {
                gradeCategory = "A";
            } else if (grades[i] >= 80) {
                gradeCategory = "B";
            } else if (grades[i] >= 70) {
                gradeCategory = "C";
            } else if (grades[i] >= 60) {
                gradeCategory = "D";
            } else {
                gradeCategory = "F";
            }
            System.out.println(studentNames[i] + ": " + grades[i] + " (" + gradeCategory + ")");
        }
        
        scanner.close();
    }
}
