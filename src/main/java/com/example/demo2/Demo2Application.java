package com.example.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);

        String new_id = "...!@BaT#*..y.abcdefghijklm";


        String answer = solution(new_id);


        System.out.println("answer : " + answer);
    }

    public static String solution(String new_id) {
        String answer = "";

        answer = getChangeStartEnd(deleteDot(new_id.toLowerCase(Locale.ROOT).replaceAll("[^-_.a-z0-9]", "")), 0);
        answer = checkLengthToShort(checkLengthToLong(checkEmpty(answer)));

        return answer;
    }

    public static String checkEmpty(String new_id) {
        if (new_id.isEmpty() == true) {
            new_id = "a";
        }
        return new_id;
    }

    public static String checkLengthToLong(String new_id) {
        if (new_id.length() >= 16) {
            new_id = getChangeStartEnd(new_id.substring(0, 15), 1);
        }
        return new_id;
    }


    public static String deleteDot(String new_id){
        while(true){
            if(new_id.contains("..")){
                new_id = new_id.replace("..",".");
            }else{
                break;
            }
        }
        return new_id;
    }

    public static String checkLengthToShort(String new_id) {
        while (new_id.length() < 3) {
            new_id += new_id.charAt(new_id.length() - 1);
        }
        return new_id;
    }

    public static String getChangeStartEnd(String new_id, int num) {
        StringBuilder builder = new StringBuilder(new_id);

        if (num == 0) {
            if (new_id.charAt(0) == '.') {
                builder.setCharAt(0, ' '); //2는 index , Z는 char값
            }
            if (new_id.charAt(new_id.length() - 1) == '.') {
                builder.setCharAt(new_id.length() - 1, ' '); //2는 index , Z는 char값
            }
        } else if (num == 1) {
            if (new_id.charAt(new_id.length() - 1) == '.') {
                builder.setCharAt(new_id.length() - 1, ' '); //2는 index , Z는 char값
            }
        } else {
            System.out.println("예기치 못한 오류.");
        }

        return builder.toString().replace(" ", "");
    }
}