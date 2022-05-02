package urbanovych;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Scanner;

public class Student {

    Curriculum curriculumClass = new Curriculum();
    HashMap<String, Integer> AQE = Curriculum.getAQE();
    HashMap<String, Integer> JavaDeveloper = Curriculum.getJavaDeveloper();

    protected String name;
    protected String curriculum;
    protected String startDate;

    public Student(String name, String curriculum, String startDate) throws ParseException {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
    }

    public int returnSumOfCurriculumJavaDeveloperOrAQE() {
        if (curriculum == "Java Developer") {
            return curriculumClass.JavaDeveloperSumHours();
        } else {
            return curriculumClass.AQESumHours();
        }
    }
}