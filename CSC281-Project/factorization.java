import java.util.ArrayList;
import java.util.List;

public class factorization{

    public static long gcd(long a, long b){ // Euclidean algorithm
        while(b != 0){ 
            long t = b; 
            b = a % b; // remainder
            a = t; 
        }
        return a;
    }

    private static long func(long x, long c, long n){
        return (x * x + c) % n; // f(x) = x^2 + c mod n
    }
    public static boolean isPrime(long n){
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;
        for(long i = 5; i * i <= n; i += 6){
            if(n % i == 0 || n % (i + 2) == 0) 
            return false;
        }
        return true;
    }

    public static List<Long> pollards_rho(long n){
        List<Long> factors = new ArrayList<>();
        if(n == 1) return factors;
        if(isPrime(n)){
            factors.add(n);
            return factors;
        }
        long x = 2, y = 2, d = 1, c = 1;
        while(d == 1){
            x = func(x, c, n); //tortoise
            y = func(func(y, c, n), c, n); //hare
            d = gcd(Math.abs(x - y), n); 

            if(d == n){ //no factors found
                c++; //increment constant
                x = y = 2; //reset
                d = 1;
            }
        }
        if(isPrime(d)){
            factors.add(d);
        }else{
            factors.addAll(pollards_rho(d)); 
        }

        factors.addAll(pollards_rho(n / d)); //find other factors
        return factors;
    }
}