package com.sparta.jian.util;

import java.util.Scanner;

public class Input {

    public static String menu(){
        String option;
        Printer.print("Please select which file to insert into the database.\n" +
                "---------------------------------------\n" +
                "1. Small employees file\n" +
                "2. Large employees file");
        Scanner scan = new Scanner(System.in);
        option = scan.nextLine();

        return option;
    }
}
