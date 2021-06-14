package com.sparta.jian.controller;

import com.sparta.jian.model.EmployeesDAO;
import com.sparta.jian.model.EmployeesDTO;
import com.sparta.jian.util.Printer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class csvToDatabase {


    public static void csvReaderToDatabase(String csvFile) {
        String line;
        int numberOfDuplicates = 0;
        List<EmployeesDTO> duplicateValues = new ArrayList<>();
        try (BufferedReader csv = new BufferedReader(new FileReader(csvFile))) {
            HashSet<String> checkDuplicates = new HashSet<>();
            List<EmployeesDTO> employeeList = new ArrayList<>();
            csv.readLine();
            Printer.print("Inserting into Database..");
            while ((line = csv.readLine()) != null) {
                String[] lineSplit = line.split(",");

                if (checkDuplicates.add(lineSplit[0])) {
                    employeeList.add(new EmployeesDTO(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8], Integer.parseInt(lineSplit[9])));


                } else {
                    duplicateValues.add(new EmployeesDTO(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4], lineSplit[5], lineSplit[6], lineSplit[7], lineSplit[8], Integer.parseInt(lineSplit[9])));
                    numberOfDuplicates++;
                }
            }
            EmployeesDAO employeesDAO = new EmployeesDAO();
            employeesDAO.setInsertEmployees(employeeList);

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
