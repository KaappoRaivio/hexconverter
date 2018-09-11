package kaappo.hexconverter;

public class RawConverter {
    public static String rawIntToHex (String decimal) {
        try {
            return Integer.toHexString(Integer.parseInt(decimal));
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String rawIntToBin (String decimal) {
        try {
            return Integer.toBinaryString(Integer.parseInt(decimal));
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String rawIntToOct (String decimal) {
        try {
            return Integer.toOctalString(Integer.parseInt(decimal));
        } catch (NumberFormatException e) {
            return "";
        }
    }
    public static String rawHexToInt (String hexadecimal) {
        try {
            return String.valueOf(Integer.parseInt(hexadecimal, 16));
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String rawBinToInt (String binary) {
        try {
            return String.valueOf(Integer.parseInt(binary, 2));
        } catch (NumberFormatException e) {
            return "";
        }
    }

    public static String rawOctToInt (String octal) {
        try {
            return String.valueOf(Integer.parseInt(octal, 8));
        } catch (NumberFormatException e) {
            return "";
        }
    }

}
