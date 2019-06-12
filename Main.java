package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        List<Student> listOfStudents = new ArrayList();
        listOfStudents = addStudentsToList();
        compareListOfStudents(listOfStudents);
        getStudentsNames(listOfStudents);
        getAverage(listOfStudents);

        printMap(listOfStudents);
        getIdMap(listOfStudents);
    }

    public static List<Student> addStudentsToList() {


        List<Student> listOfStudents = new ArrayList<Student>();
        listOfStudents.add(new Student(110, "Tom", "Brown", 10));
        listOfStudents.add(new Student(112, "David", "Bally", 23));
        listOfStudents.add(new Student(111, "Tommy", "Davidson", 7));
        listOfStudents.add(new Student(113, "Dan", "Terronte", 10));
        listOfStudents.add(new Student(114, "Genry", "Bont", 15));
        listOfStudents.add(new Student(9, "Gerry", "Brownet", 17));
        listOfStudents.add(new Student(116, "Marry", "Kost", 24));
        listOfStudents.add(new Student(117, "Ban", "Sharon", 22));
        listOfStudents.add(new Student(118, "Betty", "Barrow", 19));
        listOfStudents.add(new Student(119, "Sonty", "Brod", 20));

        printListOfStudents(listOfStudents);
        return listOfStudents;
    }

    public static void printListOfStudents(List<Student> list) {

        System.out.println("The list has the following items:");
        for (Student student : list) {
            //student.printStudent();
            System.out.println(student.toString());
        }
    }

    public static List<Student> compareListOfStudents(List<Student> listOfStudents) {
        Comparator<Student> studCompare = new StudentsAgeComparator().thenComparing(new StudentsAgeComparator());
        listOfStudents.sort(studCompare);

        System.out.println("The list of students after comparison:");
        for (Student student : listOfStudents) {
            student.printStudent();
        }


        return listOfStudents;
    }

    public static List<Student> getStudentsNames(List<Student> listOfStudents) {
        List<Student> selectedByName = new ArrayList<>();

        System.out.println("The list of students with letter <T>:");
        for (Student student : listOfStudents) {
            if (student.studNameContains()) {
                selectedByName.add(student);

            }

        }
        printListOfStudents(selectedByName);
        return selectedByName;
    }

    public static int getAverage(List<Student> studentList) {
        int ageMathAverage = 0;
        for (Student stud : studentList) {
            ageMathAverage = ageMathAverage + stud.getAge();
        }
        System.out.println("Age Average =" + ageMathAverage / studentList.size());
        return ageMathAverage;
    }

    public static Map<Integer, Student> printMap(List<Student> list) {
        Map<Integer, Student> mapStudents = new HashMap<Integer, Student>();

        for (Student student : list) {
            mapStudents.put(student.getId(), student);


        }

        for (Map.Entry<Integer, Student> mapStudent : mapStudents.entrySet()) {
            System.out.println("Map has the following k => V:");
            System.out.printf("Key: %s  Value: %s \n", mapStudent.getKey(), mapStudent.getValue());
        }

        return mapStudents;


    }

    public static Map<Integer, Student> getIdMap(List<Student> list) {
        Map<Integer, Student> mapStudents = new HashMap<Integer, Student>();

        for (Student student : list) {
            if (student.getId() < 100) {
                mapStudents.put(student.getId(), student);
            }

        }

        if (!mapStudents.isEmpty()) {
            System.out.println("Map has the following students where id < 100");
            for (Map.Entry<Integer, Student> mapStudent : mapStudents.entrySet()) {

                System.out.printf("Key: %s  Value: %s \n", mapStudent.getKey(), mapStudent.getValue());
            }
        }
        else
            System.out.println("There are no students with id <100.");


        return mapStudents;
    }
}