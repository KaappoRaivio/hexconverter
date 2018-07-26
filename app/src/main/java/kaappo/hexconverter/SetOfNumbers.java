package kaappo.hexconverter;

public class SetOfNumbers {
    private String hex;
    private String oc;
    private String dec;
    private String bin;
    private int whichEmpty;

    public SetOfNumbers (String hex, String oc, String dec, String bin, int whichEmpty) {
        this.hex = hex;
        this.oc = oc;
        this.dec = dec;
        this.bin = bin;
        this.whichEmpty = whichEmpty;

    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getOct() {
        return oc;
    }

    public void setOct(String oc) {
        this.oc = oc;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public int getWhichEmpty() {
        return whichEmpty;
    }

    public void setWhichEmpty(int whichEmpty) {
        this.whichEmpty = whichEmpty;
    }
}
