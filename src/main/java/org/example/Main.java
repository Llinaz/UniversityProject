package org.example;

import comparator.UniversityComparator;
import enums.UniversityCompType;
import enums.StudentCompType;
import comparator.StudentComparator;
import io.XlsReader;
import model.classes.Student;
import model.classes.University;
import util.CompUtil;
import util.JsonUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities = XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = CompUtil.getUniversityComprator(UniversityCompType.ID);
        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.UniversityLIsttoJson(universities);
        System.out.println(universitiesJson);
        List<University> universitiesfromJson = JsonUtil.UniversityListfromJson(universitiesJson);
        System.out.println(universities.size() == universitiesfromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.UniversitytoJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.UniversityfromJson(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = CompUtil.getStudentComparator(StudentCompType.AVGEXAMSCORE);
        students.sort(studentComparator);
        String studentsJson = JsonUtil.StudentListtoJson(students);
        System.out.println(studentsJson);
        List<Student> studentsfromJson = JsonUtil.StudentListfromJson(studentsJson);
        System.out.println(studentsfromJson.size() == students.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.StudenttoJson(student);
            System.out.println(studentJson);
            Student studentfromJson = JsonUtil.StudentfromJson(studentJson);
            System.out.println(studentfromJson);
        });
    }
}
