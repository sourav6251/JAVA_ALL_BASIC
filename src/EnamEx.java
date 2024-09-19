import java.util.*;

public class EnamEx {

    public enum Day{
        SUNDAY("WEEKEND"),
        MONDAY("WEEKDAY"),
        TUESDAY("WEEKDAY"),
        WEDNESDAY("WEEKDAY"),
        THURSDAY("WEEKDAY"),
        FRIDAY("WEEKDAY"),
        SATERDAY("WEEKDAY");

        private final String type;

        private Day(String day){
            this.type=day;
        }
    }

    public static void main(String[] args) {

        System.out.print("Enter Day name: ");
        Scanner scan=new Scanner(System.in);
        String Day_Name=scan.next().toUpperCase();

        try{
            Day Day= EnamEx.Day.valueOf(Day_Name);
            System.out.println(Day_Name+" is "+Day.type);

        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid day entered. Please enter a valid day of the week.");
        }

    }
}






























//import java.util.Scanner;
//
//public class EnamEx {
//
//    public enum Day {
//        SUNDAY("Weekend"),
//        MONDAY("Weekday"),
//        TUESDAY("Weekday"),
//        WEDNESDAY("Weekday"),
//        THURSDAY("Weekday"),
//        FRIDAY("Weekday"),
//        SATURDAY("Weekend");
//
//        private final String type;
//
//        private Day(String type) {
//            this.type = type;
//        }
//
//        public String getType() {
//            return type;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter a day of the week (e.g., MONDAY): ");
//        String input = scanner.nextLine().toUpperCase();
//
//        try {
//            Day day = Day.valueOf(input);
//            System.out.println(day + " is a " + day.getType());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid day entered. Please enter a valid day of the week.");
//        }
//
//        scanner.close();
//    }
//}
