package villariasa;

import java.util.Scanner;

public class StudentGradingSystem {
    
    public static void main(String[] args) {
        // Input student name
        try (Scanner scanner = new Scanner(System.in)) {
            // Input student name
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            // Input marks for each subject
            System.out.print("Enter marks in Science: ");
            int science = scanner.nextInt();
            
            System.out.print("Enter marks in History: ");
            int history = scanner.nextInt();
            
            System.out.print("Enter marks in Math: ");
            int math = scanner.nextInt();
            
            System.out.print("Enter marks in Soc: ");
            int soc = scanner.nextInt();
            
            System.out.print("Enter marks in Arts: ");
            int arts = scanner.nextInt();
            
            // Calculate total marks and percentage
            int totalMarks = science + history + math + soc + arts;
            double totalPercentage = (double) totalMarks / 5; // 5 subjects, each out of 100
            
            // Determine grade and remarks
            String grade = getGrade(totalPercentage);
            String remarks = getRemarks(totalPercentage);
            String message = getMessage(totalPercentage, name);
            
            // Display output
            System.out.println("\n" + repeatString("=", 50));
            System.out.println("                    Output");
            System.out.println(repeatString("=", 50));
            
            System.out.printf("Enter name: %s%n", name);
            System.out.printf("Enter marks in Science: %d%n", science);
            System.out.printf("Enter marks in History: %d%n", history);
            System.out.printf("Enter marks in Math: %d%n", math);
            System.out.printf("Enter marks in Soc: %d%n", soc);
            System.out.printf("Enter marks in Arts: %d%n", arts);
            System.out.println();
            
            System.out.printf("Total Marks: %d%n", totalMarks);
            System.out.printf("Total percentage: %.2f%n", totalPercentage);
            System.out.printf("Remarks: %s%n", remarks);
            System.out.println();
            
            System.out.println(message);
            
        
        }
    }
    
    /**
     * Helper method to repeat a string - Java 8 compatible
     */
    private static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    /**
     * Determines the grade based on percentage
     */
    private static String getGrade(double percentage) {
        if (percentage < 70) {
            return "Fail";
        } else if (percentage >= 71 && percentage <= 75) {
            return "Poor";
        } else if (percentage >= 76 && percentage <= 80) {
            return "Fair";
        } else if (percentage >= 81 && percentage <= 85) {
            return "Good";
        } else if (percentage >= 86 && percentage <= 90) {
            return "Very Good";
        } else if (percentage >= 91 && percentage <= 100) {
            return "Excellent";
        } else {
            return "Invalid";
        }
    }
    
    /**
     * Determines remarks based on percentage
     */
    private static String getRemarks(double percentage) {
        if (percentage < 70) {
            return "Fail";
        } else {
            return getGrade(percentage);
        }
    }
    
    /**
     * Generates appropriate message based on performance
     */
    private static String getMessage(double percentage, String name) {
        if (percentage < 70) {
            return "Try Again " + name + ".";
        } else {
            return "Congrats " + name + " you Passed.";
        }
    }
}