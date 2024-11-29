import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        long n;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number to factorize: ");
            n = sc.nextLong();
        }catch(Exception e){
            System.out.println("Invalid input");
            return;
        }
        List<Long> factors = factorization.pollards_rho(n);
        System.out.println("Factors of " + n + " are: " + factors); 
    }
}
