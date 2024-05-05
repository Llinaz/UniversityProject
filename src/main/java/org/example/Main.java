package org.example;

import Comparator.UniversityComparator;
import Enum.UniversityCompType;
import Enum.StudentCompType;
import Comparator.StudentComparator;
import IO.XlsReader;
import ModelClass.Student;
import ModelClass.University;
import Util.CompUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = CompUtil.getUniversityComprator(UniversityCompType.ID);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
        List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = CompUtil.getStudentComparator(StudentCompType.AVGEXAMSCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
