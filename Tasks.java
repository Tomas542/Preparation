import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
        System.out.println(narcis(153));
        System.out.println(range(19, 22));
        System.out.println(longestWord("Margaret's toy is a pretty doll"));
        System.out.println(returnUniq(new String[] {"John", "Taylor", "John"}));
        System.out.println(moonMath(357, 288));
        System.out.println(maxMin("48 256 0"));
        System.out.println(reverse(153424));
        System.out.println(NeChet(1526));
        System.out.println(videoLen("01:55"));
        System.out.println(matrix(0));
    }

    //Число является нарциссичным, если его цифры в степени длины числа равны самому числу
    public static boolean narcis (int n) {
        String str = String.valueOf(n);
        int num = 0;

        for(int i = 0; i < str.length(); i++) {
            //int a = str.charAt(i) - 48; //ASCII
            int a = Character.getNumericValue(str.charAt(i)); //Просто перевод
            num += Math.pow(a, str.length());
        }
        return n == num;
    }

    //Сумма цифр чисел в диапозоне
    public static int range(int a, int b) {
        String str;
        int res = 0;

        for(int i = a; i <= b; i++) {
            str = String.valueOf(i);
            for(int j = 0; j < str.length(); j++) {
                res += str.charAt(j) - 48; //ASCII
                //res += Character.getNumericValue(str.charAt(i)); //Просто перевод
            }
        }
        return res;
    }

    //Самое длинное слово
    public static String longestWord (String str) {
        String[] strByWords = str.split(" ");
        int maxLen = 0;
        String longest = "";

        for (int i = 0; i < strByWords.length; i++) {
            if (maxLen < strByWords[i].length()) {
                longest = strByWords[i];
                maxLen = strByWords[i].length();
            }
        }
        return longest;
    }

    //Уникальные слова в массиве
    public static String returnUniq (String[] str) {
        String[] strUniq = new String[str.length];
        strUniq[0] = str[0];
        int count = 1;

        for(int i = 1; i < str.length; i++) {
            boolean check = true;

            for(int j = 0; j < str.length; j++) {
                if (str[i].equals(strUniq[j])){
                    check = false;
                    break;
                }
            }

            if (check){
                strUniq[count] = str[i];
                count ++;
            }
        }
        String[] res = new String[count];
        for(int i = 0; i < count; i++) {
            res[i] = strUniq[i];
        }
        return Arrays.toString(res);
    }

    public static int moonMath (int a, int b) {
        String str1 = String.valueOf(a);
        String str2 = String.valueOf(b);
        a /= Math.pow(10, str1.length()-1);
        b /= Math.pow(10, str1.length());
        int res = Integer.max(a,b);
        res *= 10;
        for (int i = 0; i < str1.length() - 1; i++) {
            res += Integer.max(str1.charAt(str1.length() - i - 1), str2.charAt(str1.length() - i - 1)) - 48;
            res *= 10;
        }
        return res/10;
    }

    //Макс и мин числа строки
    public static String maxMin (String str) {
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        int max = -2147483647; //мин размер int32
        int min = 2147483647; //макс размер int32
        for(int i = 0; i < strArr.length; i++) {
            if (Integer.parseInt(strArr[i]) > max){
                max = Integer.parseInt(strArr[i]);
            }
            if (Integer.parseInt(strArr[i]) < min){
                min = Integer.parseInt(strArr[i]);
            }
        }
        return max + " " + min;
    }

    //обратное число
    public static String reverse (int a) {
        String str = String.valueOf(a);
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            res.append(str.charAt(str.length() - i - 1));
        }
        return String.valueOf(res);
    }

    //сумма чёт или нечет больше
    public static String NeChet (int a) {
        int sumChet = 0;
        int sumNeCh = 0;
        String str = String.valueOf(a);
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) % 2 == 0) {sumChet += str.charAt(i) - 48;}
            else {sumNeCh += str.charAt(i) - 48;}
        }
        if (sumChet > sumNeCh) {return "Чётных сумма больше";}
        if (sumChet < sumNeCh) {return "Нечётных сумма больше";}
        return "Суммы равны";
    }

    //Преобразовать длинну видео
    public static int videoLen (String a) {
        String[] str = a.split(":");
        int res = 0;
        for(int i = 0; i < str.length; i++) {
            res += Integer.parseInt(str[i]);
            res *= 60;
        }
        return res / 60;
    }

    public static String matrix (int a){
        int [][] mat = new int[a][a];
        if (a == 0)
            return "[]";
        for(int i = 0; i < a; i++) {
            for(int j = 0; j < a; j++) {
                mat[i][j] = a;
            }
        }
        return Arrays.deepToString(mat);
    }
}
