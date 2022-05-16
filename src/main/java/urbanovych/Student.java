package urbanovych;

import java.text.ParseException;

public class Student {

    Curriculum curriculumClass = new Curriculum();

    protected String name;
    protected String curriculum;
    protected String startDate;

    public Student(String name, String curriculum, String startDate) throws ParseException {
        this.name = name;
        this.curriculum = curriculum;
        this.startDate = startDate;
    }

    public int returnSumOfCurriculum() {
        int sumOfCurriculum = 0;
        if (curriculum.equals("Java Developer")) {
            sumOfCurriculum = curriculumClass.javaDeveloperSumHours();
        } else if (curriculum.equals("AQE")) {
            sumOfCurriculum = curriculumClass.aqeSumHours();
        }
        return sumOfCurriculum;
    }
}