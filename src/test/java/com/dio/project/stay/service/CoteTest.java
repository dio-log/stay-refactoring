package com.dio.project.stay.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class CoteTest {
    @Disabled
    @Test
    void test() {
        int[] numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "right"; //or left
        int[][] lastHand = {{3,0},{3,2}}; //index 0 은 left, 1은 right
        int[][] intArr = {{},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{},{3,1}};

        String answer="";

        for(int i:numbers) {
            if (i == 0) i = 11;

            if (i%3==1) {
                answer += "L";
                lastHand[0] = intArr[i];
            } else if (i%3==0) {
                answer += "R";
                lastHand[1] = intArr[i];
            } else {
                double left = Math.pow(intArr[i][0] - lastHand[0][0], 2) + Math.pow(intArr[i][1] - lastHand[0][1], 2);
                double right = Math.pow(intArr[i][0] - lastHand[1][0], 2) + Math.pow(intArr[i][1] - lastHand[1][1], 2);
                if (left == right) {
                    if (hand.charAt(0) == 'r') {
                        answer+="R";
                        lastHand[1]=intArr[i];
                    }else{
                        answer+="L";
                        lastHand[0]=intArr[i];
                    }
                } else if (left > right) {
                        answer += "R";
                        lastHand[1] = intArr[i];
                } else {
                        answer += "L";
                        lastHand[0] = intArr[i];
                }
            }
            //System.out.println(lastHand[0][0]+","+lastHand[0][1]+"/"+lastHand[1][0]+","+lastHand[1][1]);
            //System.out.println(answer);
        }
        System.out.println(answer);
    }

    @Test
    void test2(){
        //1,6,8,10,15,17,60,82,86,600,647

            //1의자리 수부터 순차적으로 조회 해서 집어 넣어야함
            int[] numbers = {3,30,34,5,347,9,8,93,94,947,955};
            //10으로 나눴을때 몫이 i=9 랑 같고 1<=j<=3 (자릿수) 일떄
            ArrayList<String> strArr = new ArrayList<>();

            String answer = null;
            for(int i:numbers){
                strArr.add(""+i);
            }
        Collections.sort(strArr);
        System.out.println("dd"+strArr);

        for(int i=9;i>0;i--){
            ArrayList<String> arr = new ArrayList<>();



            for(int z=0;z<numbers.length;z++ ){
                if(strArr.get(z).charAt(0)==i+48){
                    arr.add(strArr.get(z));
                }
            }
            for(int j=1;j<=3;j++) {
                if(arr.get)
                answer +=
            }
            System.out.println(""+arr);
        }



            for(int i=0; i<numbers.length-1;i++){
              // answer += sort(strArr.get(i),strArr.get(i+1));
            }
        }



        String comparator(String a,String b){
            String answer = null;
            int idx = Math.min(a.length(), b.length());

            for(int i=0;i<idx;i++){
                if(a.charAt(i)==b.charAt(i)){
                    answer = a;
                }
                else if(a.charAt(i)>b.charAt(i)){
                    answer = a;
                }else{
                    answer = b;
                }
            }
            return answer;
        }



}
