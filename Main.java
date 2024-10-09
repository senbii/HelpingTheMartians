
import java.util.Scanner;

public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cargoLocation = {0, 0, 311, 0, 17, 385, 0};
        System.out.println("Do you want to enter cargo box locations by hand?"
                + "If so, please enter 1, otherwise, any other number");
        int flag = sc.nextInt();
        if (flag == 1) {
            newCargoLocation(cargoLocation);
        }

        int[] martiansInput = new int[3];
        for (int i = 0; i < 3; i++) {
            martiansInput[i] = sc.nextInt();
        }
        int count = correctGuessCount(cargoLocation, martiansInput);
        System.out.println(count);
        while (count < 3) {
            for (int i = 0; i < 3; i++) {
                martiansInput[i] = sc.nextInt();
            }
            count = correctGuessCount(cargoLocation, martiansInput);
            System.out.println(count);
        }

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

    public static void newCargoLocation(int[] cargoLocation) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 7; i++) {
                cargoLocation[i] = sc.nextInt();
            }
        }
    }

}
