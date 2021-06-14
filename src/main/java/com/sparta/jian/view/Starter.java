package com.sparta.jian.view;


import com.sparta.jian.controller.csvToDatabaseWithThread;

import com.sparta.jian.util.Input;
import com.sparta.jian.util.Printer;
import com.sparta.jian.model.EmployeesDAO;

public class Starter {

    public static void start() {
        String csvFile = "";
        String option;
        option = Input.menu();

        if (option.equals("1")){
            csvFile = "resources/employees.csv";
        } else if (option.equals("2")){
            csvFile = "resources/EmployeeRecordsLarge.csv";
        } else{
            Printer.print("Invalid entry setting file to default(small file).");
            csvFile = "resources/employees.csv";
        }

        Printer.print("Reading from csv file...");
        long start = System.nanoTime();
        EmployeesDAO.createTable();
        csvToDatabaseWithThread.csvReaderToDatabaseThread(csvFile);


        long end = System.nanoTime();
        long totalTime = end - start;
        double timeInSeconds = (double) totalTime / 1_000_000_000;
        Printer.print("Time to write in the database " + timeInSeconds + "seconds");


    }
}
