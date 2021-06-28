package programmers;

import java.util.Arrays;

public class kakao_2021_신규아이디추천 {
    static String spec = "-_.";
    public static void main(String[] args) {
        String[] new_ids = {"...!@BaT#*..y.abcdefghijklm","z-+.^.","=.=","123_.def","abcdefghijklmn.p"};
        for(int t=0; t<new_ids.length; t++){
            String new_id = new_ids[t];
            new_id = level1(new_id);
//            System.out.println("level1: "+new_id);
            new_id = level2(new_id);
//            System.out.println("level2: "+new_id);
            new_id = level3(new_id);
//            System.out.println("level3: "+new_id);
            new_id = level4(new_id);
//            System.out.println("level4: "+new_id);
            new_id = level5(new_id);
//            System.out.println("level5: "+new_id);
            new_id = level6(new_id);
//            System.out.println("level6: "+new_id);
            new_id = level7(new_id);
//            System.out.println("level7: "+new_id);
            System.out.println(new_id);
        }
        
    }
    static String level1(String id){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<id.length(); i++){
            char c = id.charAt(i);
            if(65 <= c && c <= 90) sb.append((char)(c + 32));
            else   sb.append(c);
        }
        return sb.toString();
    }
    static String level2(String id){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<id.length(); i++){
            char c = id.charAt(i);
            if((97 <= c && c <= 122) || (48 <= c && c <= 57)){
                sb.append(c);
            }else if(spec.contains(Character.toString(c))){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    static String level3(String id){
        StringBuilder sb = new StringBuilder();
        int idx = 0, cnt = 0;
        boolean flag = false;
        for(int i=0; i<id.length(); i++){
            char c = id.charAt(i);
            if(c == '.' && !flag) {
                if(!flag)   sb.append(c);
                flag = true;
            } else if(c != '.' && flag) {
                sb.append(c);
                flag = false;
            } else if(c != '.'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    static String level4(String id){
        StringBuilder sb = new StringBuilder(id);
        if(sb.length() >= 1 && sb.charAt(0) == '.')
            sb.deleteCharAt(0);
        if(sb.length() >= 1 && sb.charAt(sb.length()-1) == '.')
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    static String level5(String id){
        StringBuilder sb = new StringBuilder(id);
        if(id.equals(""))   sb.append('a');
        return sb.toString();
    }
    static String level6(String id){
        StringBuilder sb = new StringBuilder(id);
        if(sb.length() > 15){
            sb.setLength(15);
            while(sb.charAt(sb.length()-1) == '.')
                sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    static String level7(String id){
        StringBuilder sb = new StringBuilder(id);
        if(id.length() == 1){
            char c = sb.charAt(0);
            sb.append(c).append(c);
        }else if(id.length() == 2){
            char c = sb.charAt(1);
            sb.append(c);
        }
        return sb.toString();
    }
}
