import java.util.Scanner;

public class Ponegal_Q1 {

    static final int UNIT_FEE = 1000;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] responses = get_student_details(input);
        int number_of_units = get_number_of_units(input);
        
        if (number_of_units > 10) {
            System.out.println("The maximum number of units is 10.");
            return;
        }

        int total_fee = calculate_total_fee(number_of_units);
        print_enrollment_details(responses, number_of_units, total_fee);
        
        handle_payment(input, total_fee);
        input.close();
    }

    // Method to get student details
    private static String[] get_student_details(Scanner input) {
        String[] texts = {"Enter Student Name: ", "Enter Course: ", "Enter Course Code: "};
        String[] responses = new String[3];

        // Loop to get all necessary inputs except number of units
        for (int i = 0; i < responses.length; i++) {
            System.out.print(texts[i]);
            responses[i] = input.nextLine();
        }
        return responses;
    }

    // Method to get the number of units
    private static int get_number_of_units(Scanner input) {
        System.out.print("Enter Number of Units (Max 10): ");
        return input.nextInt();
    }

    // Method to calculate the total fee
    private static int calculate_total_fee(int number_of_units) {
        return number_of_units * UNIT_FEE;
    }

    // Method to print enrollment details
    private static void print_enrollment_details(String[] responses, int number_of_units, int total_fee) {
        System.out.printf("\n--- Enrollment Details ---\nStudent Name: %s\nCourse: %s\nCourse Code: %s\nNumber of Units: %d\nTotal Enrollment Fee: %d\n", 
                          responses[0], responses[1], responses[2], number_of_units, total_fee);
    }

    // Method to handle payment
    private static void handle_payment(Scanner input, int total_fee) {
        System.out.print("\nEnter Payment Amount: ");
        int payment_amount = input.nextInt();

        System.out.println("\n--- Receipt ---");
        if (payment_amount == total_fee) {
            System.out.println("Fully Paid");
        } else if (payment_amount < total_fee) {
            System.out.printf("Partial Payment. You paid: %d\nRemaining balance: %d\n", payment_amount, total_fee - payment_amount);
        } else {
            System.out.printf("Overpaid. Your change: %d\n", payment_amount - total_fee);
        }
    }
}