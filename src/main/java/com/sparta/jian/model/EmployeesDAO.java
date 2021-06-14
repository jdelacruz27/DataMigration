package com.sparta.jian.model;

import com.sparta.jian.util.Logging;
import com.sparta.jian.util.Printer;

import java.sql.*;
import java.util.List;

public class EmployeesDAO {

    private final static String URL = "jdbc:mysql://localhost:3306/datamigration?serverTimezone=GMT";
    private static final String CREATE_TABLE = "CREATE TABLE employees ( EmpId INT(6) UNSIGNED PRIMARY KEY, namePrefix VARCHAR(5) NOT NULL, firstName VARCHAR(30) NOT NULL, middleInitial VARCHAR(5), lastName VARCHAR(30),gender VARCHAR (10), email VARCHAR(50),dateOfBirth DATE, dateOfJoining DATE,salary INT (10) );";

    private static String dropTable = "DROP TABLE IF EXISTS employees";
    private final String insertEmployees = "INSERT INTO employees (empId, namePrefix, firstName, middleInitial, lastName, gender, email, dateOfBirth, dateOfJoining, salary) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static Connection connection;


    private static Connection connectToDatabase() {
        try {
            connection = DriverManager.getConnection(URL, System.getenv("java_username"), System.getenv("java_password"));

        } catch (SQLException e) {
            Logging.logger.error(e.getMessage(), e);
        } catch (Exception e) {
            Logging.logger.error(e.getMessage(), e);
        }
        return connection;
    }

    public static void createTable() {
        Printer.print("Creating a Table...");
        try {
            Statement statement = connectToDatabase().createStatement();
            statement.execute(dropTable);
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            Logging.logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }


    public void setInsertEmployees(List<EmployeesDTO> employeesList) {
            try (PreparedStatement preparedStatement = connectToDatabase().prepareStatement(insertEmployees)) {
                for (EmployeesDTO employee : employeesList) {
                    preparedStatement.setInt(1, employee.getId());
                    preparedStatement.setString(2, employee.getTitle());
                    preparedStatement.setString(3, employee.getFirstName());
                    preparedStatement.setString(4, employee.getMidInitial());
                    preparedStatement.setString(5, employee.getLastName());
                    preparedStatement.setString(6, employee.getGender());
                    preparedStatement.setString(7, employee.getEmail());
                    preparedStatement.setDate(8, Date.valueOf(employee.getDob()));
                    preparedStatement.setDate(9, Date.valueOf(employee.getDoj()));
                    preparedStatement.setInt(10, employee.getSalary());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
            } catch (SQLException e) {
                Logging.logger.error(e.getMessage());
            }
    }
}
