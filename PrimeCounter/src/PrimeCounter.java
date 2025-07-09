//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PrimeCounter {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        if (n < 0) {
            System.out.println("Please provide a non-negative integer for n.");
            return;
        }

        if (n == 0 || n == 1) {
            System.out.println("Number of primes less than or equal to " + n + ": 0");
            return;
        }

        // 2. Sieve of Eratosthenes implementation
        // Create a boolean array `isPrime` of size `n + 1`.
        // `isPrime[i]` will be true if `i` is prime, false otherwise.
        boolean[] isPrime = new boolean[n + 1];

        // Initialize all entries to true. A number is assumed prime until proven otherwise.
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        // 0 and 1 are not prime numbers.
        isPrime[0] = false;
        isPrime[1] = false;

        // Start the Sieve. We only need to iterate up to sqrt(n) because if a number 'k'
        // has a prime factor greater than sqrt(k), it must also have a prime factor
        // less than sqrt(k).
        for (int p = 2; p * p <= n; p++) {
            // If isPrime[p] is true, then it is a prime number.
            if (isPrime[p]) {
                // Mark all multiples of p (starting from p*p) as not prime.
                // Multiples less than p*p would have already been marked by smaller prime factors.
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        // 3. Count primes
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        // 4. Print the count
        System.out.println("Number of primes less than or equal to " + n + ": " + count);
    }
}