package org.example;

import comparator.UniversityComparator;
import enums.UniversityCompType;
import enums.StudentCompType;
import comparator.StudentComparator;
import io.XlsReader;
import io.XlsWriter;
import model.classes.Statistics;
import model.classes.Student;
import model.classes.University;
import util.CompUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import  static java.util.logging.Level.INFO;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {
    try {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
    } catch (IOException e) {
        System.err.println("Could not setup logger configuration: " + e.toString());
    }
    logger.log(INFO, "Applcation started, logger configured");

        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                CompUtil.getUniversityComprator(UniversityCompType.ID);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                CompUtil.getStudentComparator(StudentCompType.AVGEXAMSCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        logger.log(INFO, "Application finished");
    }
}
