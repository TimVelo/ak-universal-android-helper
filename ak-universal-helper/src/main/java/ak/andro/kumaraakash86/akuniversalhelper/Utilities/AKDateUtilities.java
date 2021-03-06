package ak.andro.kumaraakash86.akuniversalhelper.Utilities;

import android.content.Context;
import android.text.format.DateUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AAKASH on 08-12-2016.
 */
public class AKDateUtilities {

    /***
     * CONVERT DATE IN STRING TO DESIRED FORMAT
     * USER HAVE TO PAST CURRENT FORMAT OF DATE
     *
     * @param date
     * @param currentFormat
     * @param convertToFormat
     * @return
     */
    public static String convertDate(String date, String currentFormat, String convertToFormat) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(currentFormat);
            Date d = format.parse(date);
            SimpleDateFormat serverFormat = new SimpleDateFormat(convertToFormat);
            return serverFormat.format(d);
        } catch (Exception e) {
            Log.e("AKDate convertDate","Exception : "+ e.toString());
        }
        return "";
    }

    /***
     * CONVERT STRING TO DATE
     * USER HAVE TO PASS CURRENT FORMAT OF STRING
     * @param date
     * @param currentFormat
     * @return
     */
    public static Date stringToDate(String date,String currentFormat) {

        SimpleDateFormat sdf =  new SimpleDateFormat(currentFormat);

        //Convert a String to Date
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            Log.e("AKDate stringToDate","ParseException : "+ e.toString());
            throw new IllegalArgumentException("String '"+date+"' is not in valide date format");
        }
//        return null;
    }

    /***
     *  GET DAYS FROM CURRENT DATE
     * @param date1
     * @return
     */
    public static String DaysFromNow(Date date1)
    {
        long timeOne = new Date().getTime();
        long timeTwo = date1.getTime();
        long oneDay = 1000 * 60 * 60 * 24;
        long delta = (timeTwo - timeOne) / oneDay;
        return (delta > 9) ? String.valueOf(delta) : ((delta < 0) ? String.valueOf(delta) : "0" +String.valueOf(delta));
    }

    /***
     *  GET DAYS FROM CURRENT DATE
     *  USER CAN ADD CUSTOM DAYS TO DATE
     * @param date1
     * @return
     */
    public static String DaysFromNow(Date date1, int addDays)
    {
        long timeOne = new Date().getTime();
        long timeTwo = date1.getTime();
        long oneDay = 1000 * 60 * 60 * 24;
        long delta = (timeTwo - timeOne) / oneDay;
        delta = delta+addDays;
        return (delta > 9) ? String.valueOf(delta) : ((delta < 0) ? String.valueOf(delta) : "0" +String.valueOf(delta));
    }

    /***
     * CONVERT TO READABLE DATE
     *
     * @param context
     * @param date
     * @param currentFormat
     * @return
     */
    public static String convertToReadableDate(Context context, String date, String currentFormat) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(currentFormat);
            Date d = format.parse(date);
            return (DateUtils.getRelativeTimeSpanString(d.getTime(), System.currentTimeMillis(), DateUtils.DAY_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE)).toString();
        } catch (Exception e) {
            Log.e("AKDate convertToReadble","Exception : "+ e.toString());
        }
        return "";
    }
    public static String getDateFromMillies(long milliSeconds, String dateFormat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }
}
