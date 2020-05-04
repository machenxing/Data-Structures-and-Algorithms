package Algorithms.interview.kuaiShou;

/**
 * 两个纯数字的字符串相加，长度不超过150
 */
public class BigAddOpt {
    private static String EMPTY_STRING = "";
    private static Integer MAX_SIZE = 150;
    public static void main(String[] args) {
        String a = "1111";
        String b = "9999999999999999999";
        BigAddOpt addOpt = new BigAddOpt();
        String c = addOpt.addString(a, b);
        System.out.println(c);
    }

    private String addString(String e, String f) {
        String[] a1 = getStringArray(e);
        String[] b1 = getStringArray(f);
        String[] c = new String[MAX_SIZE];
        int j = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (EMPTY_STRING.equals(a1[i]) && EMPTY_STRING.equals(b1[i]) && j == 0) {
                c[i] = EMPTY_STRING;
                continue;
            }
            int a = stringToInt(a1[i]);
            int b = stringToInt(b1[i]);
            int d = a + b + j;
            j = d > 9 ? 1 : 0;
            d = d % 10;
            String m = String.valueOf(d);
            c[i] = m;
        }
        StringBuilder result = new StringBuilder();
        for (int i = MAX_SIZE - 1; i >= 0; i--) {
            if (EMPTY_STRING.equals(c[i])) {
                continue;
            }
            result.append(c[i]);
        }
        return result.toString();
    }

    private int stringToInt(String a) {
        if (EMPTY_STRING.equals(a)) {
            return 0;
        }
        return Integer.valueOf(a);
    }

    private String[] getStringArray(String a) {
        String[] a1 = new String[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            if(a.length() > i) {
                a1[i] = a.substring(i, i + 1);
            } else {
                a1[i] = EMPTY_STRING;
            }
        }
        return a1;
    }
}
