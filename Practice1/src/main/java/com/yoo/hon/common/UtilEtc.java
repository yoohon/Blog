package com.yoo.hon.common;

import java.io.UnsupportedEncodingException;

public class UtilEtc {
    /**
     * 한글 문자열 자르기 (VO에서 호출)
     */
    public static String getShortString(String str, Integer len) {
        try {
            if (str.getBytes("UTF-8").length > len) {
                str = strCut(str, len) + "...";
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException: getShortString()");
        } 

        return str;
    }
    
    /**
     * 한글 문자열 자르기 (실제 처리)
     */
    private static String strCut(String text, int nlength) {      
      int offset = 0;
      int length = 0;
      try {
          byte[] bytes = text.getBytes("UTF-8"); // 바이트로 보관
          // x부터 y길이만큼 잘라낸다. 한글안깨지게.
          int jcount = 0;
          
          jcount = offset;
          // UTF-8에서 한글은 3바이트 나머지는 1바이트
          while (jcount < bytes.length) {
              if ((bytes[jcount] & 0x80) != 0) {
                  length += 3;
                  jcount += 3;
               } else {
                  ++length;
                  ++jcount;
                 }
          }
          text = new String(bytes, offset, length, "UTF-8"); // charset 옵션
         } catch (UnsupportedEncodingException ex) {
          System.out.println("UnsupportedEncodingException: strCut()");
         } catch (Exception e) {
          System.out.println(e.getMessage());
         }
      return text;
     }
}