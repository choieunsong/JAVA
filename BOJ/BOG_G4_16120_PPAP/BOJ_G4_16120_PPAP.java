package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_16120_PPAP {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();

        int cnt = 0;    //p개수 세어줌
        for(int i=0, end=s.length; i<end; i++){
            if(s[i] == 'P'){
                cnt++;
                continue;
            }
            if(cnt >= 2 && i+1 <end && s[i+1] == 'P'){
                cnt--;
                i++;
            }
            // 불가능
            else{
                System.out.println("NP");
                return;
            }
        }
        System.out.println(cnt == 1 ? "PPAP" : "NP");
    }
}
