public class Hamming {

    public static void main(String[] args) {

        if (args.length > 0) {
            char[] argAsCharArray = args[0].toCharArray();
            if (argumentOk(argAsCharArray))
                System.out.println("Your input '" + args[0] + "' as Hamming(7,4) encoded is '" + encodeHamming(argAsCharArray) + "'");
            else
                System.out.println("Argument was invalid. It should contain four (4) digits of 1's or 0's");
        }
        else {
            System.out.println("Please specify an argument containing four (4) digits of 1's or 0's.");
            System.out.println("For example: '1011'");
        }
    }

    private static boolean argumentOk(char[] argAsCharArray) {
        // Check if argument is four digit long and contains only ones and zeros
        if (argAsCharArray.length == 4) {
            for (char c : argAsCharArray)
                if (c != '1' && c != '0')
                    return false;
            return true;
        }
        return false;
    }

    private static String encodeHamming(char[] argAsCharArray) {
        // Do the Hamming(7,4)-encoding
        char d1 = argAsCharArray[0];
        char d2 = argAsCharArray[1];
        char d3 = argAsCharArray[2];
        char d4 = argAsCharArray[3];
        char p1, p2, p3;
        p1 = isEven(d1, d2, d4) ? '0' : '1';
        p2 = isEven(d1, d3, d4) ? '0' : '1';
        p3 = isEven(d2, d3, d4) ? '0' : '1';

        char[] encodedFinal = {p1, p2, d1, p3, d2, d3, d4};

        return new String(encodedFinal);
    }

    private static boolean isEven(char a, char b, char c) {
        // Check if chars a, b and c has even amount of 1's
        boolean even = true;
        even = (a == '1') ? false : true;
        even = (b == '1') ? !even : even;
        even = (c == '1') ? !even : even;
        return even;
    }
}
