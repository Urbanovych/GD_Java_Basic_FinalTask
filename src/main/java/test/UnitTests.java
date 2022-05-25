package test;

import org.junit.Before;
import org.junit.Test;
import urbanovych.Curriculum;
import urbanovych.StudentReport;
import urbanovych.Student;
import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UnitTests {

    @Before
    public void getGenerationDate() {
        String reportGenerationDate = "09/06/2020 16:00";
        System.setIn(new ByteArrayInputStream(reportGenerationDate.getBytes()));
    }

    @Test
    public void returnJavaDeveloperSumOfSubjects() throws ParseException {
        // given
        HashMap<String, Integer> JavaDeveloper = Curriculum.getJavaDeveloper();
        // when
        Student Ivanov = new Student("Ivanov Ivan", "Java Developer", "2020/5/12 12:00");
        // then
        assertEquals("Not same integers", 56, Ivanov.returnSumOfCurriculum());
    }

    @Test
    public void returnAQESumOfSubjects() throws ParseException {
        // given
        HashMap<String, Integer> AQE = Curriculum.getAQE();
        // when
        Student Sidorov = new Student("Sidorov Ivan", "AQE", "2020/5/12 12:00");
        // then
        assertEquals("Not same integers", 42, Sidorov.returnSumOfCurriculum());
    }

    @Test
    public void add56WorkHoursToDate() throws ParseException {
        // given
        StudentReport Ivanov;
        // when
        Ivanov = new StudentReport("Ivanov Ivan", "Java Developer", "01/06/2020 12:00");
        String endDate = Ivanov.getEndDate();
        // then
        assertEquals("Dates are not same", "10/06/2020 12:00", endDate);
    }

    @Test
    public void add42WorkHoursToDate() throws ParseException {
        // given
        StudentReport Sidorov;
        // when
        Sidorov = new StudentReport("Sidorov Ivan", "AQE","01/06/2020 12:00");
        String endDate = Sidorov.getEndDate();
        // then
        assertEquals("Dates are not same", "08/06/2020 14:00", endDate);
    }

    @Test
    public void printIvanovDiffenceBetweenTwoDatesCorrect() throws ParseException {
        // given
        StudentReport Ivanov;
        // when
        Ivanov = new StudentReport("Ivanov Ivan", "Java Developer", "01/06/2020 12:00");
        // then
        assertEquals("Output are not same", "Training is not finished. 0 d 4 hours are left until the end.", Ivanov.getWorkingTimeBetweenTwoDates());
    }

    @Test
    public void printSidorovDiffenceBetweenTwoDatesCorrect() throws ParseException {
        // given
        StudentReport Sidorov;
        // when
        Sidorov = new StudentReport("Sidorov Ivan", "AQE","01/06/2020 12:00");
        // then
        assertEquals("Output are not same", "Training completed. 1 d 2 hours have passed since the end.", Sidorov.getWorkingTimeBetweenTwoDates());
    }

}
