package Comparator;

import ModelClass.Student;

public class StudentCurrentCourseNumberComp implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
    return String.valueOf(o1.getCurrentCourseNumber()).compareTo(String.valueOf(o2.getCurrentCourseNumber()));
    }
}
