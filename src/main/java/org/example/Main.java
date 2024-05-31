package org.example;

import comparator.UniversityComparator;
import enums.UniversityCompType;
import enums.StudentCompType;
import comparator.StudentComparator;
import io.JsonWriter;
import io.XlsReader;
import io.XlsWriter;
import io.XmlWriter;
import model.classes.FullInfo;
import model.classes.Statistics;
import model.classes.Student;
import model.classes.University;
import util.CompUtil;
import util.JsonUtil;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import  static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
    try {
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
    } catch (IOException e) {
        System.err.println("Could not setup logger configuration: " + e.toString());
    }
    logger.log(INFO, "Applcation started, logger configured");

        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                CompUtil.getUniversityComprator(UniversityCompType.YEAROFFOUNDATION);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                CompUtil.getStudentComparator(StudentCompType.AVGEXAMSCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");


        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsLIst(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
}
