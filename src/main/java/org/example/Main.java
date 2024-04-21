package org.example;

import ModelClass.Student;
import ModelClass.University;
import Enum.StudyProfile;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Мушкин Александр Сергеевич");
        student.setAvgExamScore((float) 4.0);
        student.setCurrentCourseNumber(4);
        student.setUniversityId("0010");
        System.out.println(student);

        University university = new University();
        university.setId("0010");
        university.setFullName("Russian Scientific University");
        university.setShortName("RSU");
        university.setYearOfFoundation(1906);
        university.setMainProfile(StudyProfile.BIOLOGY);
        System.out.println(university);

    }
}
