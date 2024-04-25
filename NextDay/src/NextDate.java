
import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {
        // Test the NextDate function
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the date to check (format: day month year):");
        System.out.print("Day: ");
        int day = scanner.nextInt();
        System.out.print("Month: ");
        int month = scanner.nextInt();
        System.out.print("Year: ");
        int year = scanner.nextInt();

        String nextDate = getNextDate(day, month, year);
        System.out.println("Next date: " + nextDate);

        scanner.close();
    }

    public static String getNextDate(int day, int month, int year) {
        // Check if the input date is valid
        if (!isValidDate(day, month, year)) {
            return "Invalid date";
        }

        // Calculate the next day
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        // Handle end of month
        if (nextDay > daysInMonth(month, year)) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }

        return nextDay + "/" + nextMonth + "/" + nextYear;
    }

    public static boolean isValidDate(int day, int month, int year) {
        return (day >= 1 && day <= 31) && (month >= 1 && month <= 12) && (year >= 1812 && year <= 2012);
    }

    public static int daysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
