package io;

import model.classes.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {}

    public static void writeXlsStatistics(List<Statistics> statisticsList, String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = new workbook.createSheet("Статистика");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNum = 0;
        Row headerRow = statisticsSheet.createRow(rowNum++);
        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Профиль");
        profileCellHeader.setCellStyle(headerStyle);
        Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue("Средний балл за экзамены");
        avgScoreCellHeader.setCellStyle(headerStyle);
        Cell numOfStudentsCellHeader = headerRow.createCell(2);
        numOfStudentsCellHeader.setCellValue("Количество студентов");
        numOfStudentsCellHeader.setCellStyle(headerStyle);
        Cell numberOfUniversityCellHeader = headerRow.createCell(3);
        numberOfUniversityCellHeader.setCellValue("Количество университетов");
        numberOfUniversityCellHeader.setCellStyle(headerStyle);
        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Университеты");
        universitiesCellHeader.setCellStyle(headerStyle);

        for (Statistics statistics1 : statisticsList) {
            Row rowData = statisticsSheet.createRow(rowNum++);
            Cell profileCell = rowData.createCell(0);
            profileCell.setCellValue(statistics1.getProfile().getProfileName());
            Cell avgScoreCell = rowData.createCell(1);
            avgScoreCell.setCellValue(statistics1.getAvgExamScore());
            Cell numOfStudentsCell = rowData.createCell(2);
            numOfStudentsCell.setCellValue(statistics1.getNumberOfStudents());
            Cell numberOfUniversityCell = rowData.createCell(3);
            numberOfUniversityCell.setCellValue(statistics1.getNumberofUniversity());
            Cell universitiesCell = rowData.createCell(4);
            universitiesCell.setCellValue(statistics1.getUniversityNames());
        }

        try(FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}
