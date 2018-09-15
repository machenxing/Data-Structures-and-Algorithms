package Date_Structures.String;
/**
 * 朴素的模式匹配算法
 */
public class Match {
    public int match(String s , String t , int post){
        if(s == null || t == null){
            return -1;
        }
        int len1 = s.length();
        int len2 = t.length();
        int i = post;
        int j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= len2){
            return i - len2;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        String s ="Star is good man";
        String t =" good";
        Match matching = new Match();
        System.out.println(matching.match(s, t, 0));
        System.out.println(matching.match(s, t, 8));
    }
}
