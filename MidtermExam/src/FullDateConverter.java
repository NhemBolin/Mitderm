import java.util.Scanner;

public class FullDateConverter {

    public static void main(String[] args) {
        // Ask the user to enter a short date
        try (Scanner scanner = new Scanner(System.in)) {
            // Ask the user to enter a short date
            System.out.print("Enter a short date (YYYY-MM-DD): ");
            String shortDate = scanner.nextLine();

            // Extract year, month, and day
            int year = Integer.parseInt(shortDate.substring(0, 4));
            int month = Integer.parseInt(shortDate.substring(5, 7));
            int day = Integer.parseInt(shortDate.substring(8, 10));

            // Convert month number to month name
            String monthName = getMonthName(month);

            // Get day of the week
            String dayOfWeek = getDayOfWeek(year, month, day);

            // Display the full date representation
            System.out.println("Full date representation: " + dayOfWeek + ", " + monthName + " " + day + ", " + year);
        }
    }

    private static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        // Check if the month number is within valid range
        if (month >= 1 && month <= 12) {
            return monthNames[month - 1];
        } else {
            return "Invalid Month";
        }
    }

    private static String getDayOfWeek(int year, int month, int day) {
        // Create a date object
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, day);

        // Get the day of the week as an integer (Sunday is 1, Monday is 2, ..., Saturday is 7)
        int dayOfWeekInt = calendar.get(java.util.Calendar.DAY_OF_WEEK);

        // Convert the integer to the corresponding day name
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return dayNames[dayOfWeekInt - 1];
    }
}