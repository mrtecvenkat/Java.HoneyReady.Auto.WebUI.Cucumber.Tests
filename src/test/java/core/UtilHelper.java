package core;

import java.util.Calendar;

public class UtilHelper {
    public String getCURRENT_TIME_STAMP() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH)+":"+cal.get(Calendar.DATE)+":"+cal.get(Calendar.YEAR)+":"+cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND)+":"+cal.get(Calendar.MILLISECOND);
    }



}
