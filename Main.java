
import java.util.Scanner;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cargoLocation = {0, 0, 311, 0, 17, 385, 0};
        System.out.println("Do you want to enter cargo box locations by hand? "
                + "If so, please enter 1, otherwise, any other number.");
        int flag = sc.nextInt();
        if (flag == 1) {
            newCargoLocation(cargoLocation);
        }

        System.out.println("Enter the guessing numbers:");
        int[] martiansInput = new int[3];
        for (int i = 0; i < 3; i++) {
            martiansInput[i] = sc.nextInt();
        }
        int count = correctGuessCount(cargoLocation, martiansInput);
        System.out.println("The number of correct guesses: \n" + count);
        int attempts = 1;
        while (count < 3) {
            System.out.println("Enter the guessing numbers:");
            for (int i = 0; i < 3; i++) {
                martiansInput[i] = sc.nextInt();
            }
            count = correctGuessCount(cargoLocation, martiansInput);
            System.out.println("The number of correct guesses: \n" + count);
            attempts++;
            if (attempts == 5) {
                attempts = 0;
                cargoLocation = newCargoLocation(cargoLocation);
                System.out.println("The cargo locations shuffled.");
            }
        }

        System.out.println("The locations of the cargo:");
        for (int i = 0; i < 3; i++) {
            System.out.print(martiansInput[i] + " ");
        }
    }

    public static int correctGuessCount(int[] cargoLocation, int[] martiansInput) {
        int[] cargoLocation1 = new int[7];
        System.arraycopy(cargoLocation, 0, cargoLocation1, 0, 7);
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (cargoLocation1[martiansInput[i] - 1] > 0) {
                count++;
                cargoLocation1[martiansInput[i] - 1] = 0;
            }
        }
        return count;
    }

    public static int[] newCargoLocation(int[] cargoLocation) {
        int[] cargoLocation1 = new int[7];
        System.arraycopy(cargoLocation, 0, cargoLocation1, 0, 7);
        for (int i = 0; i < 7; i++) {
            if (cargoLocation[i] > 0) {
                boolean fl = false;
                for (int j = i; j < 7; j++) {
                    if (cargoLocation[j] == 0 && cargoLocation1[j] == 0) {
                        cargoLocation1[j] = cargoLocation[i];
                        cargoLocation1[i] = 0;
                        fl = true;
                        break;
                    }
                }
                if (!fl) {
                    for (int j = 0; j < i; j++) {
                        if (cargoLocation[j] == 0 && cargoLocation1[j] == 0) {
                            cargoLocation1[j] = cargoLocation[i];
                            cargoLocation1[i] = 0;
                            break;
                        }
                    }
                }
            }
        }
        return cargoLocation1;
    }

}
