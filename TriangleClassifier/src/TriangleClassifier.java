import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the lengths of the triangle's sides:");
        System.out.print("Side 1: ");
        int side1 = scanner.nextInt();
        System.out.print("Side 2: ");
        int side2 = scanner.nextInt();
        System.out.print("Side 3: ");
        int side3 = scanner.nextInt();

        String triangleType = classifyTriangle(side1, side2, side3);
        System.out.println("Triangle type: " + triangleType);

        scanner.close();
    }

    public static String classifyTriangle(int side1, int side2, int side3) {
        if (isValidTriangle(side1, side2, side3)) {
            if (side1 == side2 && side2 == side3) {
                return "Equilateral";
            } else if (side1 == side2 || side1 == side3 || side2 == side3) {
                return "Isosceles";
            } else {
                return "Scalene";
            }
        } else {
            return "NotATriangle";
        }
    }

    public static boolean isValidTriangle(int side1, int side2, int side3) {
        return (side1 + side2 > side3) && (side1 + side3 > side2) && (side2 + side3 > side1);
    }
}
