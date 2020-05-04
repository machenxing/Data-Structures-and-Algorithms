package Algorithms.interview.kuaiShou;

/**
 * 两个纯数字的字符串相加，长度不超过150
 */
public class BigAdd {
    public static void main(String[] args) {
        String a = "1111";
        String b = "9999999999999999999";
        String c = addString(a, b);
        System.out.println(c);
    }

    private static String addString(String e, String f) {
        String[] a1 = getStringArray(e);
        String[] b1 = getStringArray(f);
        String[] c = new String[17];
        int j = 0;
        for (int i = 0; i < 17; i++) {
            if (a1[i].equals("") && b1[i].equals("")) {
                c[i] = "";
                continue;
            }
            int a = stringToInt(a1[i]);
            int b = stringToInt(b1[i]);
            int d = a + b + j;
            j = d > 999999999 ? 1 : 0;
            d = d % 1000000000;
            String m = String.valueOf(d);
            while (m.length() < 9) {
                m = "0" + m;
            }
            c[i] = m;
        }
        String result = "";
        for (String s : c) {
            result = s + result;
        }
        while (result.startsWith("0")){
            result = result.substring(1);
        }
        return result;
    }
    private static int stringToInt(String a) {
        if ("".equals(a)) {
            return 0;
        }
        return Integer.valueOf(a);
    }
    private static String[] getStringArray(String a) {
        String[] a1 = new String[17];
        for (int i = 0; i < 17; i++) {
            if(a.length() > 9*i + 9) {
                a1[i] = a.substring(9*i, 9*i + 9);
            }
            if(9*i < a.length() && a.length() < 9*i+9) {
                a1[i] = a.substring(9*i);
            }
            if (a.length() < 9*i) {
                a1[i] = "";
            }
        }
        return a1;
    }
}
