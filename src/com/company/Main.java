package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s = "spo";
        Solution sol = new Solution();
        System.out.println(sol.sortString(s));
    }
}

class Solution {
    public String sortString(String s) {
        char[] str = s.toCharArray();
        char[] result = new char[str.length];
        Arrays.sort(str);
        System.out.println(new String(str));
        int j = 0;
        char min;
        char max;
        while(str.length!=0) {
            min = 0;
            char[] buf;
            for(int i = 0;i<str.length;i++) {
                if(str[i]>min) {
                    min = str[i];
                    result[j] = str[i];
                    j++;
                    buf = new char[str.length-1];
                    System.arraycopy(str,0, buf,0,i);
                    System.arraycopy(str, i+1, buf,i,str.length-i-1);
                    str = new char[str.length-1];
                    str = buf;
                    i--;
                }
            }
            max = 255;
            for(int i = str.length-1;i>=0;i--) {
                if(str[i]<max) {
                    max = str[i];
                    result[j] = str[i];
                    j++;
                    buf = new char[str.length-1];
                    System.arraycopy(str,0,buf,0,i);
                    System.arraycopy(str,i+1,buf,i,str.length-i-1);
                    str = buf;
                }
            }
        }
        String res = new String(result);
        return res;
    }
}
