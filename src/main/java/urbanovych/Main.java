package urbanovych;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        StudentReport ivanov = new StudentReport("Ivanov Ivan", "Java Developer", "01/06/2020 12:00");
        StudentReport sidorov = new StudentReport("Sidorov Ivan", "AQE","01/06/2020 12:00");

        Scanner userInput = new Scanner(System.in);

        System.out.println("You want to print short or full report?");
        System.out.println("If you want print short report: 0 or Space + Enter");
        System.out.println("If you want print full report: enter whatever you want :)");
        String userChoose = userInput.nextLine();

        if (userChoose.equals("0") || userChoose.equals(" ")) {
            ivanov.printShortReport();
            sidorov.printShortReport();
        } else {
            ivanov.printFullReport();
            sidorov.printFullReport();
        }
    }

}