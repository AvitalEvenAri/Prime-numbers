

/*
//ID:325310142
my_explain:
isPrime method:First, I created a function to check if a number is prime so that I can use it in different parts of
the code and avoid doing the same work twice. The function checks if a number is prime like this: if the number is
less than 2, it’s definitely not prime, so the function returns “false.” If the number is 2 or higher, we go through
each number from 2 up to the square root of the number. (We start from 2 because a number can’t divide by zero, and
we only need to go up to the square root to find factors if they exist.)For each number in this range, we check if it
divides evenly into the original number. If it does, that means the number isn’t prime, so we return “false.” But if we
check all these numbers and don’t find any that divide evenly, that means the number is prime, and we return “true.”
pesoudo_code:
Function isPrime(n):
    If n is less than 2:
        return false (the number is not prime)

    For i from 2 to sqrt(n):
        If n is divisible by i with no remainder:
            return false (the number is not prime)

    return true (the number is prime)

my_explain solutionA:
In part A, I was asked to find two prime numbers whose sum equals n (an even number greater than 4, following Goldbach's
conjecture). I will go through all numbers from 3 up to N / 2 (starting at 3 because 0 and 1 are not prime, and if one
factor of the sum is 2, the other factor would have to be even since N is even. The only even prime number is 2, and
since n is supposed to be greater than 4, there is no case where both factors are 2. Therefore, we can start checking
from 3). We only check up to n / 2 because it is sufficient to find the factors.After each check, we increment by 2
because we only want to examine odd numbers (which have the potential to be prime). Each time, we check if the current
number is prime and if the number that complements it to n is also prime. Once we find such a pair, we print them.
pesoudo_code:
Function solutionA(n):
    For i from 3 to n / 2, incrementing by 2:
        If i is prime and (n - i) is prime:
            Print n as the sum of i and (n - i)


my_explain solutionB:
In part B, I was asked to find two prime numbers such that their difference equals n. We will go through all numbers
starting from n+3, incrementing by 2 (as explained in part A) until we find a solution. Each time, we check if the
number is prime and if N plus this number is also prime. As long as both conditions are not met, we continue checking
until we find a pair that satisfies them, and then we print the result.
pesoudo_code:
Function solutionB(n):
    Set i to 3
    While (n + i) is not prime or i is not prime:
        Increment i by 2

    Print n as (n + i) - i

my_explain solutionC:
In part C, I was asked to check how many prime numbers there are between 2 and n, including 2. First, we define a
variable count and set it to 1(because i know that 2 is prime for sure). Next, we go through all numbers from 3 up to n
 (in jump of 2 because we only want to examine odd numbers-which have the potential to be prime)and use the function
 I created to check if each number is prime. If it’s prime, we increase the value of count by 1. Finally, after going
 through all numbers greater than or equal to 2 and less than n, we print the value of count to see how many prime
 numbers exist in this range.
pesoudo_code:
Function solutionC(n):
    Set count to 1
    For each number i from 3 to n-1:
        If isPrime(i) is true:
            Increment count by 1

    Print count and display "prime numbers in [2, n)"

my_explain solutionD:
At this stage, I was asked to break down N into its prime factors. We’ll go through all numbers from 2 up to N and check
if N is divisible by each number without a remainder and if the number is prime. Only if both conditions are met, we
print the number and update N to the result of N divided by that factor. If N is greater than one, we print * to ensure
there is a multiplication sign between each factor in the output.
pesoudo_code:
Function solutionD(n):
    Print "d) n ="

    For each number i from 2 to n:
        While n is divisible by i and i is prime:
            Print i
            Set n to n divided by i
            If n is greater than 1:
                Print "*"

    Print a newline

my_explain e):
In this section, I was asked to print the runtime of the program in seconds. First, I defined a variable startTime and
stored the exact time when the code started running using a time function. Next, I defined a variable endTime and stored
the time at this point in the code. Finally, I subtracted the start time from the end time, divided by 1000 to convert
it to seconds, and printed the result.

pesoudo_code:
    Set startTime to current time in milliseconds

     Run the program

    Set endTime to current time in milliseconds

    Set runtimeInSeconds to (endTime - startTime) / 1000

    Print runtimeInSeconds

my_explain f):
In this section, I was asked to print my ID number. I stored my ID number in a long variable and then printed it.
pesoudo_code:
    Set my_ID to your ID number (as a long integer)

    Print my_ID

 */


import java.util.*;

public class Ex0 {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }return true;
            }


    public static void solutionA(int n){

        for (int i = 3; i < n/2; i += 2) {
            if (isPrime(i) && isPrime(n - i)) {
                System.out.println("a) "+ n + "=" + (n - i) + "+" + i);
                return;
            }
        }
    }

    public static void solutionB(int n) {
        int i=3;
        while(!(isPrime(n+i)&&isPrime(i))){
            i += 2;
        }
        System.out.println("b) " + n + "=" + (n + i) + "-"+i);
        return;
    }

    public static void solutionC(int n){
        int count=1;
        for (int i=3;i<n;i+=2) {
            if (isPrime(i)){
                count++;}
            }
        System.out.println("c) " + count+" prime numbers in"+"[2,"+n+")");
        return;
    }

    public static void solutionD(int n){
        System.out.print("d) "+n+"=");
        for (int i=2;i<=n;i++){
            while (n%i==0 && isPrime(i)){
                System.out.print(i);
                n=n/i;
                if (n>1){
                    System.out.print("*");}

            }

        }System.out.println();
       return;
    }


 public static void main(String[] args) {
     Scanner s = new Scanner(System.in);
     System.out.println("Enter a natural even number (n>4):");


     int n = s.nextInt();
     double startTime=System.currentTimeMillis();
     if (n % 2 != 0 || n <= 4 || n > 100000000) {
         System.out.println("error,your number is less then 4/not even/bigger then 100000000");
         return;
     }
     solutionA(n);
     solutionB(n);
     solutionC(n);
     solutionD(n);

     long my_ID=325310142;//e)
     System.out.println("e) "+my_ID);//e)
     double endTime=System.currentTimeMillis();
     double runtimeInSeconds=(endTime-startTime)/1000.0;
     System.out.println("f) "+runtimeInSeconds +" seconds, the program runtime ");





 }




}






