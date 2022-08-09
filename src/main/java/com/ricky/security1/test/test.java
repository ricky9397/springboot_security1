package com.ricky.security1.test;

public class test {
    public static void main(String[] args) {

        int num = 0;
        int sum = 0;

        for(int i = 4; i >= 0; i--){
            num = 0;
            for(int j = 0; j < i+1; j++){
                num = num + j + 1;
                System.out.print(j + 1);
                System.out.print("       각열 더한값 = " + num);
                System.out.print("       각열 나머지 = " + sum);
            }
            System.out.println();
            sum = (num%10) + sum;
        }
        System.out.println(sum);

    }
}
