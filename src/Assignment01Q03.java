public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]); // TODO: Read the first string argument (replace this line)
        System.out.println("The first " + x + " Fibonacci numbers are:");

        ////////////////////////////////////////////////////////////////
        // TODO: Replace this code with the correct Fibonacci sequence
        ////////////////////////////////////////////////////////////////
        int numOdd = 0;
        int prev1 = 1; 
        int prev2 = 1; 
        
        for (int i = 0; i < x; i++) {
            int currentFibo;
            
            if (i == 0) {
                currentFibo = prev1;
            } else if (i == 1) {
                currentFibo = prev2;
            } else {
                currentFibo = prev1 + prev2;
                prev1 = prev2;
                prev2 = currentFibo;
            }

            System.out.print(currentFibo);
            
            if (i < x - 1) {
                System.out.print(" "); // Make sure we don't print a trailing space
            }
            
            if (currentFibo % 2 != 0) {
                numOdd++;
            }
        }
        System.out.println();
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
