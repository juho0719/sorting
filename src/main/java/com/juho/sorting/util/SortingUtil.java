package com.juho.sorting.util;

import com.juho.sorting.constant.Ascii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUtil {


    public static String sort(String data) throws Exception {
        // 결과값
        StringBuffer result = new StringBuffer();

        // 영문자 데이터
        List<Character> alphaList = new ArrayList<>();

        // 숫자 데이터
        List<Character> numberList = new ArrayList<>();

        //데이터 추출
        extractData(data, alphaList, numberList);

        // 정렬
        Collections.sort(alphaList);
        Collections.sort(numberList);

        // 영문+숫자 조합 결과값 입력
        setResultData(result, alphaList, numberList);

        return result.toString();
    }

    private static void extractData(String data, List<Character> alphaList, List<Character> numberList) throws Exception {
        for (int i=0;i<data.length();i++) {
            char curChar = data.charAt(i);
            if ((curChar >= Ascii.A.getValue() && curChar <= Ascii.Z.getValue())
                    || (curChar >= Ascii.a.getValue() && curChar <= Ascii.z.getValue())) {

                alphaList.add(curChar);
            } else if((curChar >= Ascii.ZERO.getValue() && curChar <= Ascii.NINE.getValue())) {
                numberList.add(curChar);
            } else {
                throw new Exception("영문자 혹은 숫자외에 다른 문자를 입력할 수 없습니다");
            }
        }
    }

    private static void setResultData(StringBuffer result, List<Character> alphaList, List<Character> numberList) {
        if(alphaList.size() > 0 || numberList.size() > 0) {
            int loopCount = alphaList.size() > numberList.size() ? alphaList.size() : numberList.size();

            for (int i=0;i<loopCount;i++) {
                if (alphaList.size() > i) {
                    result.append(alphaList.get(i));
                }
                if (numberList.size() > i) {
                    result.append(numberList.get(i));
                }
            }
        }
    }
}
