package kaappo.hexconverter;

public class RawConverter {
    public static String rawIntToHex (String decimal) {
        return Integer.toHexString(Integer.parseInt(decimal));
    }

    public static String rawIntToBin (String decimal) {
        return Integer.toBinaryString(Integer.parseInt(decimal));
    }

    public static String rawIntToOct (String decimal) {
        return Integer.toOctalString(Integer.parseInt(decimal));
    }

    public static String rawHexToInt (String hexadecimal) {
        return String.valueOf(Integer.parseInt(hexadecimal, 16));
    }

    public static String rawBinToInt (String binary) {
        return String.valueOf(Integer.parseInt(binary, 2));
    }

    public static String rawOctToInt (String octal) {
        return String.valueOf(Integer.parseInt(octal, 8));
    }

}
