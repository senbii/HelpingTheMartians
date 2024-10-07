
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] cargoLocation = {0, 0, 311, 0, 17, 385, 0};

            ArrayList<Integer> ans = new ArrayList<>();
            int[] martiansInput = new int[3];
            for (int i = 0; i < 3; i++) {
                martiansInput[i] = sc.nextInt();
            }
            

            for (int i = 0; i < 3; i++) {
                if (cargoLocation[martiansInput[i] - 1] > 0) {
                    ans.add(martiansInput[i]);
                }
            }

            System.out.println(ans);
        }

    }

}
