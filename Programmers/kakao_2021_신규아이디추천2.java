package programmers;

import java.util.Locale;

public class kakao_2021_신규아이디추천2 {
    static String spec = "-_.";

    public static void main(String[] args) {
        String[] new_ids = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        for (int t = 0; t < new_ids.length; t++) {
            String new_id = new_ids[t];
            //level1
            String temp = new_id.toLowerCase();
            //level2
            temp = temp.replaceAll("[^-_.a-z0-9]","");
            //level3
            temp = temp.replaceAll("[.]{2,}", ".");
            //level4
            temp = temp.replaceAll("^[.]|[.]$", "");
            //level5
            if(temp.equals("")) temp += "a";
            //level6
            if(temp.length() >= 16){
                temp = temp.substring(0,15);
                temp = temp.replaceAll("^[.]|[.]$", "");
            }
            //level7
            if(temp.length() <= 2){
                while(temp.length() < 3)
                    temp += temp.charAt(temp.length()-1);
            }
            System.out.println(temp);
        }

    }
}