import java.util.Scanner;

public class Main {

    // FactorialCalculator class
    private static class FactorialCalculator {
        public static int factorial(int n) {
            if (n < 0) {
                System.out.print("Number must be Positive.");
                return -1; // Returning -1 to indicate an error.
            }
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }

    // PalindromeChecker class
    private static class PalindromeChecker {
        public static int isPalindrome(String s, int len) {
            if (len <= 1) {
                return 1;
            }
            if (s.charAt(0) != s.charAt(len - 1)) {
                return 0;
            }
            return isPalindrome(s.substring(1, len - 1), len - 2);
        }
    }

    // DigitCounter class
    private static class DigitCounter {
        public static int countDigit(int n, int digit) {
            if (n == 0) {
                return 0;
            }
            int lastDigit = n % 10;
            int count = (lastDigit == digit) ? 1 : 0;
            return count + countDigit(n / 10, digit);
        }
    }

    // HandshakeCounter class
    private static class HandshakeCounter {
        public static int handshake(int n) {
            if (n <= 1) {
                return 0;
            } else {
                return handshake(n - 1) + (n - 1);
            }
        }
    }

    // GCDCalculator class
    private static class GCDCalculator {
        public static int gcd(int x, int y) {
            if (y == 0) {
                return x;
            } else {
                return gcd(y, x % y);
            }
        }
    }

    // PowerCalculator class
    private static class PowerCalculator {
        public static int power(int base, int exponent) {
            if (exponent == 1) {
                return base;
            } else {
                return base * power(base, exponent - 1);
            }
        }
    }

    // StringReverser class
    private static class StringReverser {
        public static String reverse(String str, int length) {
            if (length <= 1) {
                return str;
            } else {
                return str.charAt(length - 1) + reverse(str.substring(0, length - 1), length - 1);
            }
        }
    }

    // MinNonZeroProduct class
    private static class MinNonZeroProduct {
        private static final long MOD = 1000000007;

        public static long minNonZeroProduct(int p) {
            long maxVal = (1L << p) - 1; // 2^p - 1
            long pairVal = maxVal - 1;
            long power = (1L << (p - 1)) - 1;
            long partProduct = modExp(pairVal, power, MOD);
            long minProduct = (partProduct * maxVal) % MOD;

            return minProduct;
        }

        private static long modExp(long base, long exp, long mod) {
            long result = 1;
            while (exp > 0) {
                if ((exp & 1) == 1) {
                    result = (result * base) % mod;
                }
                base = (base * base) % mod;
                exp >>= 1;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display menu
            System.out.println("\nMenu:");
            System.out.println("1. Calculate Factorial");
            System.out.println("2. Check Palindrome");
            System.out.println("3. Count Digit in Number");
            System.out.println("4. Count Handshakes");
            System.out.println("5. Calculate GCD");
            System.out.println("6. Calculate Power");
            System.out.println("7. Reverse String");
            System.out.println("8. Min Non-Zero Product");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Factorial Calculator
                    System.out.print("Enter a number to calculate its factorial: ");
                    int number = scanner.nextInt();
                    int factorialResult = FactorialCalculator.factorial(number);
                    System.out.println("Factorial of " + number + " is: " + factorialResult);
                    break;

                case 2:
                    // Palindrome Checker
                    System.out.print("Enter a string: ");
                    String str = scanner.next();
                    str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                    int palindromeResult = PalindromeChecker.isPalindrome(str, str.length());
                    if (palindromeResult == 1) {
                        System.out.println("The string is a palindrome.");
                    } else {
                        System.out.println("The string is not a palindrome.");
                    }
                    break;

                case 3:
                    // Digit Counter
                    System.out.print("Enter a number: ");
                    number = scanner.nextInt();
                    System.out.print("Enter the digit to count: ");
                    int digit = scanner.nextInt();
                    int digitCountResult = DigitCounter.countDigit(number, digit);
                    System.out.println("The digit " + digit + " appears " + digitCountResult + " times in the number " + number + ".");
                    break;

                case 4:
                    // Handshake Counter
                    System.out.print("Enter the number of people in the room: ");
                    int numberOfPeople = scanner.nextInt();
                    int handshakeResult = HandshakeCounter.handshake(numberOfPeople);
                    System.out.println("The total number of handshakes is: " + handshakeResult);
                    break;

                case 5:
                    // GCD Calculator
                    System.out.print("Enter the first number: ");
                    int x = scanner.nextInt();
                    System.out.print("Enter the second number: ");
                    int y = scanner.nextInt();
                    int gcdResult = GCDCalculator.gcd(x, y);
                    System.out.println("The greatest common divisor of " + x + " and " + y + " is: " + gcdResult);
                    break;

                case 6:
                    // Power Calculator
                    System.out.print("Enter the base: ");
                    int base = scanner.nextInt();
                    System.out.print("Enter the exponent: ");
                    int exponent = scanner.nextInt();
                    int powerResult = PowerCalculator.power(base, exponent);
                    System.out.println(base + " raised to the power of " + exponent + " is " + powerResult);
                    break;

                case 7:
                    // String Reverser
                    System.out.print("Enter a string: ");
                    String inputString = scanner.next();
                    int length = inputString.length();
                    String reversedString = StringReverser.reverse(inputString, length);
                    System.out.println("Reversed string: " + reversedString);
                    break;

                case 8:
                    // Min Non-Zero Product
                    System.out.print("Enter the value of p: ");
                    int p = scanner.nextInt();
                    long minProduct = MinNonZeroProduct.minNonZeroProduct(p);
                    System.out.println("Min Non-Zero Product for p=" + p + ": " + minProduct);
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
    }
}
