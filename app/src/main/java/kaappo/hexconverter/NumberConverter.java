package kaappo.hexconverter;

public class NumberConverter {
    public static SetOfNumbers getOthersFromHex (String hex) {
        String dec, bin, oct;
        dec = RawConverter.rawHexToInt(hex);
        bin = RawConverter.rawIntToBin(RawConverter.rawHexToInt(hex));
        oct = RawConverter.rawIntToOct(RawConverter.rawHexToInt(hex));

        return new SetOfNumbers(null, oct, dec, bin, 0);
    }

    public static SetOfNumbers getOthersFromBin (String bin) {
        String dec, oct, hex;
        dec = RawConverter.rawBinToInt(bin);
        oct = RawConverter.rawIntToOct(RawConverter.rawBinToInt(bin));
        hex = RawConverter.rawIntToHex(RawConverter.rawBinToInt(bin));

        return new SetOfNumbers(hex, oct, dec, null, 3);
    }

    public static SetOfNumbers getOthersFromDec (String dec) {
        String oct, bin, hex;
        oct = RawConverter.rawIntToOct(dec);
        bin = RawConverter.rawIntToBin(dec);
        hex = RawConverter.rawIntToHex(dec);

        return new SetOfNumbers(hex, oct, null, bin, 2);
    }

    public static SetOfNumbers getOthersFromOct (String oct) {
        String dec, bin, hex;
        dec = RawConverter.rawOctToInt(oct);
        bin = RawConverter.rawIntToBin(RawConverter.rawOctToInt(oct));
        hex = RawConverter.rawIntToHex(RawConverter.rawOctToInt(oct));

        return new SetOfNumbers(hex, null, dec, bin, 1);
    }
}
