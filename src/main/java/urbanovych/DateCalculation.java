package urbanovych;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateCalculation extends Student {

    // String reportGenerationDate = "08/06/2020 15:00";

    public DateCalculation(String name, String curriculum, String startDate) throws ParseException {
        super(name, curriculum, startDate);
    }

    protected String setup() {
        Scanner report = new Scanner(System.in);
        System.out.println("Hello! Print date for generation report (format: dd/mm/yyyy hh:mm): ");
        String reportDate = report.nextLine();
        return reportDate;
    }

    String reportGenerationDate = setup();

    public String calculateEndDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm");
        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(super.startDate));
        Calendar end = Calendar.getInstance();
        end.setTime(sdf.parse(super.startDate));

        int workHours = returnSumOfCurriculumJavaDeveloperOrAQE();

        for(int i = 0; i <= workHours; i = i + 8) {
            int hour = end.get(Calendar.HOUR_OF_DAY);

            if (workHours % 8 != 0) {
                end.add(Calendar.HOUR_OF_DAY, workHours % 8);
                workHours = workHours - (workHours % 8);
                i = i - (workHours % 8);
            } else if(hour > 18) { //
                end.add(Calendar.DATE, 1);
                end.set(Calendar.HOUR_OF_DAY, (10 + (end.get(Calendar.HOUR_OF_DAY) % 18)));
            } else if(hour < 10) { //
                end.add(Calendar.DATE, 1);
                end.set(Calendar.HOUR_OF_DAY, (10 + (8 % end.get(Calendar.HOUR_OF_DAY))));
            } else if(workHours % 40 == 0) {
                end.add(Calendar.WEEK_OF_YEAR, 1);
                workHours = workHours - 40;
                i = i + 40;
            } else if((end.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && ((end.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
                end.add(Calendar.DATE, 1);
                i = i - 8;
            }
            else  {
                end.add(Calendar.DATE, 1);
                workHours = workHours - 8;
            }
        }

        if(end.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY && end.get(Calendar.HOUR_OF_DAY) == 12) {
            end.add(Calendar.DATE, -3);
            end.set(Calendar.HOUR_OF_DAY, 18);
        }

        if(end.get(Calendar.HOUR_OF_DAY) == 12) {
            end.add(Calendar.DATE, -1);
            end.set(Calendar.HOUR_OF_DAY, 18);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy H:mm");
        String endDate = dateFormat.format(end.getTime());
        return endDate;
    }

    public String workingTimeBetweenTwoDates(String endDate) throws ParseException {

        String timeBetween = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm");

        Calendar start = Calendar.getInstance();
        start.setTime(sdf.parse(endDate));
        Calendar end = Calendar.getInstance();
        end.setTime(sdf.parse(reportGenerationDate));

        /*int workingHours = 0;

        if (start.get(Calendar.HOUR) > end.get(Calendar.HOUR)) {
            workingHours = start.get(Calendar.HOUR) - end.get(Calendar.HOUR);
        } else if (start.get(Calendar.HOUR) < end.get(Calendar.HOUR)) {
            workingHours = end.get(Calendar.HOUR) - start.get(Calendar.HOUR);
        } else if (start.get(Calendar.HOUR) == end.get(Calendar.HOUR)) {
            workingHours = 0;
        }*/

        if(start.compareTo(end) > 0) {
            timeBetween = "Training is not finished. " + daysBetween(end, start) + " d " + hoursBetween(start, end) + " hours are left until the end.";
        } else if (start.compareTo(end) < 0) {
            timeBetween = "Training completed. " + daysBetween(start, end) + " d " + hoursBetween(start, end) + " hours have passed since the end.";
        }

        return timeBetween;
        /*System.out.println(DaysBetween(end, start));
        System.out.println("Days: " + workingDays + " Hours: " + workingHours);
        System.out.println(reportGenerationDate);*/
    }

    private long daysBetween(Calendar start, Calendar end) {
        long daysBetween = ChronoUnit.DAYS.between(start.toInstant(), end.toInstant());

        /*Calendar startCal = start;
        Calendar endCal = end;

        int weekend = 0;

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return weekend;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal = end;
            endCal = start;
        }

        do {
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++weekend;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

        daysBetween = daysBetween - weekend;*/
        return daysBetween;
    }

    private long hoursBetween(Calendar start, Calendar end) {
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

    