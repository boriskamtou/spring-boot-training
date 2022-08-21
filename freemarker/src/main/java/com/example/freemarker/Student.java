package com.example.freemarker;

public class Student {
    private Integer Id;
    private String studentName;
    private double grade;


    public Student(Integer id, String studentName, double grade) {
        Id = id;
        this.studentName = studentName;
        this.grade = grade;
    }


    public Integer getId() {
        return Id;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
