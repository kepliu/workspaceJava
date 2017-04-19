import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NumberOfDays {

	public static void main(String[] args) {
     Calendar now = new GregorianCalendar(2016, 1, 29);
     long time = now.getTimeInMillis();
     int yr  = now.get(Calendar.YEAR) - 3;
     int month = now.get(Calendar.MONTH);
     int day = now.get(Calendar.DAY_OF_MONTH);
     Calendar then = new GregorianCalendar(yr, month, day);
     System.out.println("year: " + then.get(Calendar.YEAR) + " month: " + then.get(Calendar.MONTH) + " day: "  + then.get(Calendar.DAY_OF_MONTH));
     long time1 = new Date().getTime();
     
     System.out.println("time: " + time);
     System.out.println("time1: " + time1);

	}

}
