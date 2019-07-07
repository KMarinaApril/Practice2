package com.company;


import java.util.*;



public class Main {

    public static void main(String[] args) {

        List <Student> listOfStudents = new ArrayList<Student>();
        Collections.addAll(listOfStudents,
                new Student(110, "Tom", "Brown", 10),
                new Student(112, "David", "Bally", 23),
                new Student(111, "Tommy", "Davidson", 7),
                new Student(113, "Dan", "terronte", 10),
                new Student(114, "Genry", "Bont", 15),
                new Student(9, "Gerry", "Brownet", 17),
                new Student(116, "Marry", "Kost", 24),
                new Student(117, "Ban", "Sharon", 22),
                new Student(118, "Betty", "Tarrow", 19),
                new Student(119, "Sonty", "Brod", 20));

        System.out.println("==Sortable list by Age:==");

        listOfStudents.stream()
                .sorted(new StudentsAgeComparator())
                .forEach(st ->st.printStudent());

        System.out.println("==Student(s) with 'T' as a first letter in the LastName:==");

        listOfStudents.stream()
                .filter(st->st.getlName().startsWith("T"))
                .forEach(st ->st.printStudent());
        listOfStudents.stream()
                .filter(st->st.getlName().startsWith("t"))
                .forEach(st ->st.printStudent());

        System.out.println("==Students' Age Average:==");
             int sum = listOfStudents.stream()
                .mapToInt(st->st.getAge())
                .sum();

        System.out.println(sum/10);


listOfStudents.stream()
        .map (st -> "id " + st.getId() + " Student: " + st.getfName() + " " + st.getlName())
        .forEach(st-> System.out.println(st));



    }
}
