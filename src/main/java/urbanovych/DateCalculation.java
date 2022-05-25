package urbanovych;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateCalculation {

    protected static String setup() {
        Scanner report = new Scanner(System.in);
        System.out.println("Hello! Print date for generation report (format: dd/mm/yyyy hh:mm): ");
        String reportDate = report.nextLine();
        return reportDate;
    }

    public static String calculateEndDate(String startDate, int workHours) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm");
        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(startDate));
        Calendar end = Calendar.getInstance();
        end.setTime(sdf.parse(startDate));

        for(int i = 0; i <= workHours; i = i + 8) {

            if (workHours % 8 != 0) {
                end.add(Calendar.HOUR_OF_DAY, workHours % 8);
                workHours = workHours - (workHours % 8);
                i = i - (workHours % 8);
            } else if(end.get(Calendar.HOUR_OF_DAY) > 18) {
                end.add(Calendar.DATE, 1);
                end.set(Calendar.HOUR_OF_DAY, (10 + (end.get(Calendar.HOUR_OF_DAY) % 18)));
            } else if(end.get(Calendar.HOUR_OF_DAY) < 10) {
                end.add(Calendar.DATE, 1);
                end.set(Calendar.HOUR_OF_DAY, (10 + (8 % end.get(Calendar.HOUR_OF_DAY))));
            } else if(workHours % 40 == 0) {
                end.add(Calendar.WEEK_OF_YEAR, 1);
                workHours = workHours - 40;
                i = i + 40;
            } else if((end.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && ((end.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
                end.add(Calendar.DATE, 1);
                i = i - 8;
            } else {
                end.add(Calendar.DATE, 1);
                workHours = workHours - 8;
            }
        }

        if(end.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && end.get(Calendar.HOUR_OF_DAY) == 12) {
            end.add(Calendar.DATE, -3);
            end.set(Calendar.HOUR_OF_DAY, 18);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:mm");
        String endDate = dateFormat.format(end.getTime());
        return endDate;
    }

    public static String workingTimeBetweenTwoDates(String endDate, String reportGenerationDate) throws ParseException {

        String timeBetween = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm");

        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(endDate));
        Calendar end = Calendar.getInstance();
        end.setTime(sdf.parse(reportGenerationDate));

        if(start.compareTo(end) > 0) {
            timeBetween = "Training is not finished. " + daysBetween(end, start) + " d " + hoursBetween(start, end) + " hours are left until the end.";
        } else if (start.compareTo(end) < 0) {
            timeBetween = "Training completed. " + daysBetween(start, end) + " d " + hoursBetween(start, end) + " hours have passed since the end.";
        }
        return timeBetween;
    }

    private static long daysBetween(Calendar start, Calendar end) {
        long between = ChronoUnit.DAYS.between(start.toInstant(), end.toInstant());
        return between;
    }

    private static long hoursBetween(Calendar start, Calendar end) {
        long HoursBetween = 0;
        if (start.get(Calendar.HOUR) > end.get(Calendar.HOUR)) {
            HoursBetween = start.get(Calendar.HOUR) - end.get(Calendar.HOUR);
        } else if (start.get(Calendar.HOUR) < end.get(Calendar.HOUR)) {
            HoursBetween = end.get(Calendar.HOUR) - start.get(Calendar.HOUR);
        } else if (start.get(Calendar.HOUR) == end.get(Calendar.HOUR)) {
            HoursBetween = 0;
        }

        return HoursBetween;
    }
}
    