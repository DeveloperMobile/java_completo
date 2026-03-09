package application;

import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Program3 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d = Date.from(Instant.parse("2025-01-22T15:41:07Z"));

        System.out.println(sdf.format(d));

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int minutes = cal.get(Calendar.MINUTE);
        int month = 1 + cal.get(Calendar.MONTH);

        System.out.println("Minutes: " + minutes);
        System.out.println("Month: " + month);
    }
}
