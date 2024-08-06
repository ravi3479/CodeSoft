package Task_2;

import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Please Enter the number of total subjects: ");
        int numSub = sc.nextInt();
        int[] marks = new int[numSub];
        for (int i=0; i<numSub; i++) {
            System.out.println("-------------------------------------------");
            System.out.print("        Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        
        int totalMarks = Arrays.stream(marks).sum();
        double avgPercentage = (double)totalMarks/numSub;
        char grade = calculateGrade(avgPercentage);

        Result(totalMarks, avgPercentage, grade);
    }
    private static char calculateGrade(double percent) {
        if (percent>=90) {
            return 'A';
        }
        else if (percent>=80)
        {
            return'B';
        }
        else if (percent>=70)
        {
            return'C';
        }
        else if (percent>=60)
        {
            return'D';
        }
        else
        {
            return'F';
        }
    }
    private static void Result(int totalMarks, double avgPercentage, char grade) {
        System.out.println("------------------------------------------------------------");
        System.out.println("      Total Marks: " + totalMarks);
        System.out.println("------------------------------------------------------------");
        System.out.println("      Average Percentage: " + avgPercentage + "%");
        System.out.println("------------------------------------------------------------");
        System.out.println("      Grade: " + " ' " +grade +" ' ");
        System.out.println("------------------------------------------------------------");
    }
}

