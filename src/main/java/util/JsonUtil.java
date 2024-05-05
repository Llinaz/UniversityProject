package util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.classes.Student;
import model.classes.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {}

    public static String StudenttoJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }
    public static Student StudentfromJson(String json) {
        return new Gson().fromJson(json, Student.class);
    }
    public static String StudentListtoJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }
    public static List<Student> StudentListfromJson(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }
    public static String UniversitytoJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }
    public static University UniversityfromJson(String json) {
     return new Gson().fromJson(json, University.class);
    }
    public static String UniversityLIsttoJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }
    public static List<University> UniversityListfromJson(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }
}
