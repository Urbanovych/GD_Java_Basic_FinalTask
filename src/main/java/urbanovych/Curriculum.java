package urbanovych;

import java.util.HashMap;

public class Curriculum {

    private int javaDeveloperTotalHours;
    private int aqeTotalHours;

    static HashMap<String, Integer> javaDeveloper;
    static HashMap<String, Integer> aqe;

    public Curriculum() {
        javaDeveloper = new HashMap<String, Integer>();
        javaDeveloper.put("Java", 16);
        javaDeveloper.put("JDBC", 24);
        javaDeveloper.put("Spring", 16);

        aqe = new HashMap<String, Integer>();
        aqe.put("Test design", 10);
        aqe.put("Page Object", 16);
        aqe.put("Selenium", 16);
    }

    public static HashMap<String, Integer> getJavaDeveloper() {
        return javaDeveloper;
    }

    public static HashMap<String, Integer> getAQE() {
        return aqe;
    }

    public int javaDeveloperSumHours() {
        for (int sum : javaDeveloper.values()) {
            javaDeveloperTotalHours += sum;
        }
        return javaDeveloperTotalHours;
    }

    public int aqeSumHours() {
        for (int sum : aqe.values()) {
            aqeTotalHours += sum;
        }
        return aqeTotalHours;
    }

}