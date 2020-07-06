import java.io.Console;
import java.util.Scanner;
 
public class Main {
 
    private static int fromNto10(int n, String number) {
        int tenth = 0;
        int multiplier = (int) Math.pow(n, number.length());
        if (n == 10) {
            return Integer.parseInt(number);
        } else if (n < 10) {
            for (int i = 0; i < number.length(); ++i) {
                multiplier /= n;
                tenth += Character.getNumericValue(number.charAt(i)) * multiplier;
            }
            return tenth;
        } else {
            String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < number.length(); ++i) {
                multiplier /= n;
                tenth += (alphabet.indexOf(number.charAt(i))) * multiplier;
            }
            return tenth;
        }
    }
 
    private static String from10toN(int n, int number) {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder answer = new StringBuilder();
        while (number > 0) {
            answer.append(alphabet.charAt(number % n));
            number /= n;
        }
        return answer.reverse().toString();
    }
 
    public static String fromAtoB(int a, int b, String number) {
        return from10toN(b, fromNto10(a, number));
    }
 
    public static void main(String[] args) {
 
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter input number system : ");
        String inputSystem = in.nextLine();
        System.out.println("Please enter output number system : ");
        String outputSystem = in.nextLine();
        System.out.println("Please enter input number : ");
        String inputNumber = in.nextLine();
 
        int inpSys = Integer.parseInt(inputSystem);
        int outSys = Integer.parseInt(outputSystem);
        System.out.println(fromAtoB(inpSys, outSys, inputNumber));
    }
}