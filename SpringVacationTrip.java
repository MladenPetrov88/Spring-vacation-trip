import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfTrip = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int groupOfPeople = Integer.parseInt(scanner.nextLine());
        double fuelPerKilometer = Double.parseDouble(scanner.nextLine());
        double foodPerPersonForDay = Double.parseDouble(scanner.nextLine());
        double priceForRoomForOneNight = Double.parseDouble(scanner.nextLine());

        double totalFoodExpense = groupOfPeople * foodPerPersonForDay * daysOfTrip;
        double totalHotelExpense = groupOfPeople * priceForRoomForOneNight * daysOfTrip;

        if (groupOfPeople > 10) {
            totalHotelExpense = totalHotelExpense * 0.75;
        }

        double currentExpense = totalFoodExpense + totalHotelExpense;

        for (int i = 1; i <= daysOfTrip; i++) {
            double numbers = Double.parseDouble(scanner.nextLine());
            currentExpense += numbers * fuelPerKilometer;

            if (i % 3 == 0 || i % 5 == 0) {
                currentExpense += currentExpense * 0.40;
            }

            if (i % 7 == 0) {
                currentExpense -= currentExpense / groupOfPeople;
            }
            if (currentExpense > budget) {
                System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpense - budget);
                return;
            }

        }
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpense);
    }
}
