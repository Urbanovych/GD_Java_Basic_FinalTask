package urbanovych;

import java.util.HashMap;

public class Curriculum {

    private int JavaDeveloperTotalHours;
    private int AQETotalHours;

    static HashMap<String, Integer> JavaDeveloper;
    static HashMap<String, Integer> AQE;

    public Curriculum() {
        JavaDeveloper = new HashMap<String, Integer>();
        JavaDeveloper.put("Java", 16);
        JavaDeveloper.put("JDBC", 24);
        JavaDeveloper.put("Spring", 16);

        AQE = new HashMap<String, Integer>();
        AQE.put("Test design", 10);
        AQE.put("Page Object", 16);
        AQE.put("Selenium", 16);
    }

    public static HashMap<String, Integer> getJavaDeveloper() {
        return JavaDeveloper;
    }

    public static HashMap<String, Integer> getAQE() {
        return AQE;
    }

    public int JavaDeveloperSumHours() {
        for (int sum : JavaDeveloper.values()) {
            JavaDeveloperTotalHours += sum;
        }
        return JavaDeveloperTotalHours;
    }

    public int AQESumHours() {
        for (int sum : AQE.values()) {
            AQETotalHours += sum;
        }
        return AQETotalHours;
    }

}