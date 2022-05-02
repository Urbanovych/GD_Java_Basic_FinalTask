package test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import urbanovych.Curriculum;
import urbanovych.DateCalculation;
import urbanovych.Report;
import urbanovych.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UnitTests {

    @Before
    public void getGenerationDate() {
        String reportGenerationDate = "08/06/2020 15:00";
        System.setIn(new ByteArrayInputStream(reportGenerationDate.getBytes()));
    }

    @Test
    public void returnJavaDeveloperSumOfSubjects() throws ParseException {
        // given
        HashMap<String, Integer> JavaDeveloper = Curriculum.getJavaDeveloper();
        // when
        Student Ivanov = new Student("Ivanov Ivan", "Java Developer", "2020/5/12 12:00");
        // then
        assertEquals("Not same integers", 56, Ivanov.returnSumOfCurriculumJavaDeveloperOrAQE());
    }

    @Test
    public void returnAQESumOfSubjects() throws ParseException {
        // given
        HashMap<String, Integer> AQE = Curriculum.getAQE();
        // when
        Student Sidorov = new Student("Sidorov Ivan", "AQE", "2020/5/12 12:00");
        // then
        assertEquals("Not same integers", 42, Sidorov.returnSumOfCurriculumJavaDeveloperOrAQE());
    }

    @Test
    public void add56WorkHoursToDate() throws ParseException {
        // given
        Report Ivanov;
        // when
        Ivanov = new Report("Ivanov Ivan", "Java Developer", "01/06/2020 12:00");
        String endDate = Ivanov.getEndDate();
        // then
        assertEquals("Dates are not same", "09/06/2020 18:00", endDate);
    }

    @Test
    public void add42WorkHoursToDate() throws ParseException {
        // given
        Report Sidorov;
        // when
        Sidorov = new Report("Sidorov Ivan", "AQE","01/06/2020 12:00");
        String endDate = Sidorov.getEndDate();
        // then
        assertEquals("Dates are not same", "08/06/2020 14:00", endDate);
    }

    @Test
    public void printIvanovDiffenceBetweenTwoDatesCorrect() throws ParseException {
        // given
        Report Ivanov;
        // when
        Ivanov = new Report("Ivanov Ivan", "Java Developer", "01/06/2020 12:00");
        String endDate = Ivanov.getEndDate();
        // then
        assertEquals("Output are not same", "Training is not finished. 1 d 3 hours are left until the end.", Ivanov.getWorkingTimeBetweenTwoDates());
    }

    @Test
    public void printSidorovDiffenceBetweenTwoDatesCorrect() throws ParseException {
        // given
        Report Sidorov;
        // when
        Sidorov = new Report("Sidorov Ivan", "AQE","01/06/2020 12:00");
        String endDate = Sidorov.getEndDate();
        // then
        assertEquals("Output are not same", "Training completed. 0 d 1 hours have passed since the end.", Sidorov.getWorkingTimeBetweenTwoDates());
    }

}
