package com.sparta.jian.controller;

import com.sparta.jian.util.Logging;
import com.sparta.jian.util.Printer;
import com.sparta.jian.model.EmployeesDTO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;


public class csvToDatabaseWithThread {


    public static void csvReaderToDatabaseThread(String csvFile) {
        String line;
        int numberOfDuplicates = 0;
        List<EmployeesDTO> duplicateValues = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        int threadCount = 0;


        try (BufferedReader csv = new BufferedReader(new FileReader(csvFile))) {
            HashSet<String> checkDuplicates = new HashSet<>();
            List<EmployeesDTO> employeeList = new ArrayList<>();
            csv.readLine();
            Printer.print("Inserting into Database..");
            while ((line = csv.readLine()) != null) {
                String[] lineSplit = line.split(",");

                if (checkDuplicates.add(lineSplit[0])) {
                    employeeList.add(new EmployeesDTO(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8], Integer.parseInt(lineSplit[9])));

                    if (employeeList.size() > 999) {
                        List<EmployeesDTO> batchArray = new ArrayList<>(employeeList);
                        threadList.add(new Thread(new DatabaseThread(batchArray)));
                        threadList.get(threadCount++).start();
                        employeeList.clear();
                    }

                } else {
                    duplicateValues.add(new EmployeesDTO(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8], Integer.parseInt(lineSplit[9])));
                    numberOfDuplicates++;
                }
            }
            threadList.add(new Thread(new DatabaseThread(employeeList)));
            threadList.get(threadList.size()-1).start();

            for( Thread thread : threadList)
            {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    Logging.logger.error(e.getMessage());
                }
            }

        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Printer.print("Number of duplicates found = " + numberOfDuplicates);
//        for (EmployeesDTO duplicate: duplicateValues) {
//            Printer.print(duplicate.toString());
//        }
    }
}
