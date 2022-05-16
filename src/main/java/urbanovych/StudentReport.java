package urbanovych;

import java.text.ParseException;

import static urbanovych.DateCalculation.setup;

public class StudentReport extends Student {

    DateCalculation dateCalculation;

    String reportGenerationDate = setup();
    int sumOfCurriculum = returnSumOfCurriculum();
    String endDate = dateCalculation.calculateEndDate(startDate, sumOfCurriculum);

    public StudentReport(String name, String curriculum, String startDate) throws ParseException {
        super(name, curriculum, startDate);
    }

    public void printShortReport() throws Exception {
        System.out.print(super.name + " (" + super.curriculum + ") - ");
        System.out.println(getWorkingTimeBetweenTwoDates());
        System.out.print("\n");
    }

    public void printFullReport() throws Exception {
        System.out.println("Name: " + super.name);
        System.out.println("Working time: 10 from 18");
        System.out.println("Program name: " + super.curriculum);
        System.out.println("Program duration: " + sumOfCurriculum + " Hours");
        System.out.println("Start date: " + super.startDate);
        System.out.println("End Date: " + endDate);
        System.out.println(getWorkingTimeBetweenTwoDates());
        System.out.print("\n");
    }

    public String getWorkingTimeBetweenTwoDates() throws ParseException {
        return DateCalculation.workingTimeBetweenTwoDates(endDate, reportGenerationDate);
    }

    public String getEndDate() {
        return this.endDate;
    }

}
