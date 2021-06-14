package com.sparta.jian.controller;


import com.sparta.jian.model.EmployeesDAO;
import com.sparta.jian.model.EmployeesDTO;

import java.util.List;

public class DatabaseThread implements Runnable {

    private List<EmployeesDTO> employeesBatch;

    public DatabaseThread(List<EmployeesDTO> employeesBatch) {
        this.employeesBatch = employeesBatch;
    }

    @Override
    public void run() {

        EmployeesDAO employeesDAO = new EmployeesDAO();
        employeesDAO.setInsertEmployees(employeesBatch);

    }

}
