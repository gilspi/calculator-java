public enum Roman {
    I("I", 1), II("II", 2), III("III", 3), IV("IV", 4), V("V", 5),
    VI("VI", 6), VII("VII", 7), VIII("VIII", 8), IX("IX", 9), X("X", 10),
    XI("XI", 11), XII("XII", 12), XIII("XIII", 13), XIV("XIV", 14),
    XV("XV" , 15), XVI("XVI", 16), XVII("XVII", 17), XVIII("XVIII", 18),
    XIX("XIX", 19), XX("XX", 20), XXI("XXI", 21), XXIV("XXIV", 24),
    XXV("XXV", 25), XXVII("XXVII", 27), XXVIII("XXVIII", 28), XXIX("XXIX", 29),
    XXX("XXX", 30), XXXII("XXXII", 32), XXXV("XXXV", 35), XXXVI("XXXVI", 36),
    XL("XL", 40), XLII("XLII", 42), XLV("XLV", 45), XLVIII("XLVIII", 48),
    XLIX("XLIX", 49), L("L", 50), LIV("LIV", 54), LVI("LVI", 56), LX("LX", 60),
    LXIII("LXIII", 63), LXIV("LXIV", 64), LXX("LXX", 70), LXXX("LXXX", 80),
    LXXXI("LXXXI", 81), XC("XC", 90), C("C", 100);

    private final String key;
    private final int name;

    Roman(String key, int name) {
        this.key = key;
        this.name = name;
    }

    public int getNumber() { return name; }

    public String getName() { return key; }

}
