package com.company;


import java.util.Comparator;
import java.util.List;


public class Student {


    private int id;
    private String fName;
    private String lName;
    private int age;

    public Student(int id, String firstName, String lastName, int ageFull) {
        this.id = id;
        this.fName = firstName;
        this.lName = lastName;
        this.age = ageFull;
    }

    public void printStudent() {
        System.out.println("id\tFirst Name\tLast Name\tAge");
        System.out.println(id + "\t" + fName + "\t" + lName + "\t" + age);
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }


    public int getAge() {
        return age;
    }

    public boolean studNameContains() {
        String firstLetter = getlName();
        boolean contains = false;
        if (firstLetter.startsWith("T") || firstLetter.startsWith("t")) {
            contains = true;
        } else contains = false;
        return contains;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }


}


class StudentsAgeComparator implements Comparator<Student> {

    int id;
    String fName;
    String lName;
    int age;

    public Student st(int id, String fName, String lName, int age) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        return st(id, fName, lName, age);
    }

    @Override
    public String toString() {
        return "StudentsNameComparator{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compare(Student a, Student b) {

        if (a.getAge() > b.getAge())
            return 1;
        else if (a.getAge() < b.getAge())
            return -1;
        else
            return 0;
    }


    public int ageMath(List<Student> st) {
        int math = 0;
        for (Student studs : st) {
            math = math + studs.getAge();
        }
        int average = math / 10;
        System.out.println(average);
        return average;
    }
}
