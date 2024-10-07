
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] cargoLocation = {0, 0, 311, 0, 17, 385, 0};
            System.out.println("Do you want to enter cargo box locations by hand?"
                    + "If so, please enter 1, otherwise 0");
            int flag = sc.nextInt();
            if (flag == 1)
                newCargoLocation(cargoLocation);

            ArrayList<Integer> ans = new ArrayList<>();
            int[] martiansInput = new int[3];
            for (int i = 0; i < 3; i++) {
                martiansInput[i] = sc.nextInt();
            }

            for (int i = 0; i < 3; i++) {
                if (cargoLocation[martiansInput[i] - 1] > 0) {
                    for (int j = 0; j < 7; j++) {
                        if (cargoLocation[j] != 0) {
                            for (int k = 0; k < 7; k++) {
                                if (cargoLocation[k] == 0) {
                                    cargoLocation[j] = cargoLocation[martiansInput[i] - 1];
                                    cargoLocation[martiansInput[i] - 1] = 0;
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(ans);
        }

    }

    public static void newCargoLocation(int[] cargoLocation) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 7; i++) {
                cargoLocation[i] = sc.nextInt();
            }
        }
    }

}
