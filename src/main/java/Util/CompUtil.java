package Util;

import Comparator.*;
import Enum.StudentCompType;
import Enum.UniversityCompType;

public class CompUtil {
    private CompUtil() {}
    public static StudentComparator getStudentComparator(StudentCompType studentCompType) {
       switch (studentCompType) {
           case FULLNAME -> {
               return new StudentFullNameComp();
           }
           case AVGEXAMSCORE -> {
               return new StudentAvgExamScoreComp();
           }
           case CURRENTCOURS -> {
               return new StudentCurrentCourseNumberComp();
           }
           case UNIVERSITYID -> {
               return new StudentUniversityIdComp();
           }
           default -> {
               return new StudentFullNameComp();
           }
       }
    }
    public static UniversityComparator getUniversityComprator(UniversityCompType universityCompType) {
        switch(universityCompType) {
            case FULLNAME -> {
                return new UniversityFullNameComp();
            }
            case ID -> {
                return new UniversityIDComp();
            }
            case SHORTNAME -> {
                return new UniversityShortNameComp();
            }
            case PROFILE -> {
                return new UniversityProfileComp();
            }
            case YEAROFFOUNDATION -> {
                return new UniversityYearOfFoundationComp();
            }
            default -> {
                return new UniversityFullNameComp();
            }
        }
    }

}
