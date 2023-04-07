public class Utils {
    public static String generateRandomIBAN() {
        String result = "RO";
        String number = "";
        int digitSum = 0;
        for(int i = 1; i <= 16; i++) {
            int digit = (int)(Math.random() * 10);
            digitSum = digitSum + digit;
            number += Integer.toString(digit);
        }
        digitSum = digitSum + 'R' + 'O' + 'S' + 'I' + 'M' + 'B' - 6 * 'A';
        result = result + digitSum + "SIMB" + number;
        return result;
    }
    public static String generateRandomCardNumber() {
        String result = "";
        for(int i = 1; i <= 16; i++) {
            int digit = (int)(Math.random() * 10);
            result += digit;
            if(i == 4 || i == 8 || i == 12)
                result += " ";
        }
        return result;
    }
    public static int generateRandomCVV() {
        int result = 100 + (int)(Math.random() * 900);
        return result;
    }
}
