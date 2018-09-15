package Date_Structures.String;
/**
 * KMPƒ£ Ω∆•≈‰À„∑®
 */
public class MatchKMP {
    public int matchKMP(String s ,String t ,int post){
        if(s == null || t == null){
            return -1;
        }
        int len1 = s.length();
        int len2 = t.length();
        int i = post;
        int j = 0;
        int[] next = getNext(t);
        while (i < len1 && j < len2) {
            if (j== -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if (j >= len2){
            return i - len2;
        }else{
            return -1;
        }
    }

    private int[] getNext(String t){
        int [] next = new int [t.length()];
        int i = 0;
        int j = -1;
        next[i] = j;
        while (i < t.length() - 1){
            if (j == -1 || t.charAt(i) == t.charAt(j)){
                i++;
                j++;
                next[i] =j;
            }else{
                j = next[j];
            }
        }
        return next;

    }
    public static void main(String[] args) {
        String s ="Star is good man";
        String t =" good";
        MatchKMP matching = new MatchKMP();
        System.out.println(matching.matchKMP(s, t, 0));
        System.out.println(matching.matchKMP(s, t, 8));
    }
}
