package urbanovych;

import java.text.ParseException;
import java.util.Scanner;

public class Report extends Student {

    DateCalculation dateCalculation = new DateCalculation(super.name, super.curriculum, super.startDate);
    String endDate = dateCalculation.calculateEndDate();

    public Report(String name, String curriculum, String startDate) throws ParseException {
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
        System.out.println("Program duration: " + returnSumOfCurriculumJavaDeveloperOrAQE() + " Hours");
        System.out.println("Start date: " + super.startDate);
        System.out.println("End Date: " + endDate);
        System.out.println(getWorkingTimeBetweenTwoDates());

        System.out.print("\n");
    }

    public String getCalculateEndDate() throws ParseException {
        return dateCalculation.calculateEndDate();
    }

    public String getWorkingTimeBetweenTwoDates() throws ParseException {
        return dateCalculation.workingTimeBetweenTwoDates(endDate);
    }

    public String getEndDate() {
        return this.endDate;
    }

}
