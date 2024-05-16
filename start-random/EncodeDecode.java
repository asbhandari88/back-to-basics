import java.io.*;

public class EncodeDecode {

    public static String encode(int input, int base) {
        if (input < base) {
            return Integer.toString(input);
        } else {
            int quotient = input / base;
            int remainder = input % base;
            return encode(quotient, base) + Integer.toString(remainder);
        }

    }

    public static int decode(String input, int base) {
        return decodeHelper(input, base, 0);
    }

    public static int decodeHelper(String input, int base, int index) {
        if (index == input.length()) {
            return 0;
        } else {
            int digitChar = input.charAt(index);
            int digitValue = Character.digit(digitChar, base);
            int positionValue = (int) Math.pow(base, input.length() - index - 1);
            return digitValue * positionValue + decodeHelper(input, base, index + 1);
        }
    }

    public static void main(String[] args) {
        int inputNumber, baseNumber;
        int funcChoice = 0;
        String encodedNumber;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println("Enter your choice:");
                System.out.println("1. Encode Function");
                System.out.println("2. Decode Function");
                System.out.println("3. Exit");
                funcChoice = Integer.parseInt(reader.readLine());
                switch (funcChoice) {
                    case 1:
                        System.out.println("Enter the input number ");
                        inputNumber = Integer.parseInt(reader.readLine());
                        System.out.println("Enter the base number ");
                        baseNumber = Integer.parseInt(reader.readLine());
                        System.out.println("Output:" + encode(inputNumber, baseNumber));
                        break;
                    case 2:
                        System.out.println("Enter the input number ");
                        encodedNumber = reader.readLine();
                        System.out.println("Enter the base number ");
                        baseNumber = Integer.parseInt(reader.readLine());
                        System.out.println("Output:" + decode(encodedNumber, baseNumber));
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Exception " + e);
            }
        } while (funcChoice < 3);

    }

}