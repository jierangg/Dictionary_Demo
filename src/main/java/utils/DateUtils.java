package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
    public static List<Date> getReviewDate(Date date){
        int[] reviewInterval = {-2,-4,-7,-11,-15,-30,-60,-90,-180,-360};
        List<Date> reviewDateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();// get calendar
        for (int i:reviewInterval
        ) {
            calendar.setTime(date);
            calendar.add(Calendar.DATE,i+1);
            reviewDateList.add(calendar.getTime());
        }
        return reviewDateList;
    }
}
