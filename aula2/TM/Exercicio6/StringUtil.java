package andreepdiasmeli.Exercicio6;

public class StringUtil {

    public static String lpad(String s, char c, int n){
        return (n > 0) ? lpad(c + s, c, n - 1) : s;

    }

    public static String rpad(String s, char c, int n){
        return (n > 0) ? rpad(s + c, c, n - 1) : s;
    }

    public static String ltrim(String s){
        while(s.length() > 0 && s.charAt(0) == ' '){
            s = s.substring(1);
        }
        return s;
    }

    public static String rtrim(String s){
        int index = s.length() - 1;
        while(index > 0 && s.charAt(index) == ' '){
            s = s.substring(0, index);
            index--;
        }
        return s;
    }

    public static String trim(String s){
        return rtrim(ltrim(s));
    }

    public static int indexOfN(String s, char c, int n){
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) == c){
                n--;
                if(n == 0) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "7";
        s1 = lpad(s1, '0', 2);
        System.out.println(s1);

        String s2 = "2";
        s2 = rpad(s2, '0', 3);
        System.out.println(s2);

        String s3 = "   André";
        s3 = ltrim(s3);
        System.out.println(s3);

        String s4 = "Dias   ";
        s4 = rtrim(s4);
        System.out.println(s4 + ".");

        String s5 = "   André Dias   ";
        s5 = trim(s5);
        System.out.println("-" + s5 + "-");

        String s6 = "André Eduardo Pacheco Dias";
        System.out.println(indexOfN(s6, ' ', 1));
        System.out.println(indexOfN(s6, ' ', 2));
        System.out.println(indexOfN(s6, ' ', 3));
        System.out.println(indexOfN(s6, ' ', 4));
    }
}
