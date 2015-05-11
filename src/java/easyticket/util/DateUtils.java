/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inet.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author hoàng
 */
public class DateUtils {

    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(cal.getTime());
    }

    public static void main(String arg[]) {
        System.out.println(DateUtils.now("h:mm a"));
    }
}
