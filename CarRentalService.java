import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalService {
    private List<Car> cars;
    private Scanner scanner;

    public CarRentalService() {
        cars = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeCars();
    }

    private void initializeCars() {
        cars.add(new Car("1", "Toyota", "Camry"));
        cars.add(new Car("2", "Honda", "Civic"));
        cars.add(new Car("3", "Ford", "Focus"));
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listAvailableCars();
                    break;
                case 2:
                    rentCar();
                    break;
                case 3:
                    returnCar();
                    break;
                case 4:
                    addCar();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Car Rental Management System");
        System.out.println("1. List Available Cars");
        System.out.println("2. Rent a Car");
        System.out.println("3. Return a Car");
        System.out.println("4. Add a Car");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void listAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (!car.isRented()) {
                System.out.println(car);
            }
        }
    }

    private void rentCar() {
        System.out.print("Enter car ID to rent: ");
        String carId = scanner.nextLine();
        Car car = findCarById(carId);

        if (car != null && !car.isRented()) {
            car.rent();
            System.out.println("Car rented successfully.");
        } else {
            System.out.println("Car not available.");
        }
    }

    private void returnCar() {
        System.out.print("Enter car ID to return: ");
        String carId = scanner.nextLine();
        Car car = findCarById(carId);

        if (car != null && car.isRented()) {
            car.returnCar();
            System.out.println("Car returned successfully.");
        } else {
            System.out.println("Car not found or not rented.");
        }
    }

    private void addCar() {
        System.out.print("Enter car ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter car make: ");
        String make = scanner.nextLine();
        System.out.print("Enter car model: ");
        String model = scanner.nextLine();

        cars.add(new Car(id, make, model));
        System.out.println("Car added successfully.");
    }

    private Car findCarById(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }
}
