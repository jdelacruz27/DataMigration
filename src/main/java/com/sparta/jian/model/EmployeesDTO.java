package com.sparta.jian.model;

import com.sparta.jian.util.DateFormatter;

public class EmployeesDTO {
    private int id;
    private String title;
    private String firstName;
    private String midInitial;
    private String lastName;
    private String gender;
    private String email;
    private String dob;
    private String doj;
    private int salary;

    public EmployeesDTO(int id, String title, String firstName, String midInitial, String lastName, String gender, String email, String dob, String doj, int salary) {

        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.midInitial = midInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = DateFormatter.changeDateFormat(dob);
        this.doj = DateFormatter.changeDateFormat(doj);
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidInitial() {
        return midInitial;
    }

    public void setMidInitial(String midInitial) {
        this.midInitial = midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + firstName + ", " + midInitial + ", " + lastName + ", " + gender + ", " + email + ", " + dob + ", " + doj + ", " + salary;
    }
}
