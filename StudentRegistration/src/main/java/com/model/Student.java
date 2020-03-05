package com.model;
public class Student
{
    public String name;
    public String university;
    public String rollno;
    public Student(String name,String university,String rollno)
    {
        super();
        this.name=name;
        this.university=university;
        this.rollno=rollno;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", rollno=" + rollno +
                '}';
    }
}