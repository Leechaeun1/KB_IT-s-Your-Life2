package ch12.sec08;

import java.util.*;

public class CalendarExample {
    public static void main(String[] args) {
        // singleton 패턴 : 객체 하나만 생성
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // 0부터 시작하므로 1 더해주기
        int day = now.get(Calendar.DAY_OF_MONTH);

        int week = now.get(Calendar.DAY_OF_WEEK); // 요일 가져오기(숫자로 가져옴, 1: 일요일)
        String strWeek = null;
        switch (week) {
            case Calendar.MONDAY:
                strWeek = "월";
                break;
            case Calendar.TUESDAY:
                strWeek = "화";
                break;
            case Calendar.WEDNESDAY:
                strWeek = "수";
                break;
            case Calendar.THURSDAY:
                strWeek = "목";
                break;
            case Calendar.FRIDAY:
                strWeek = "금";
                break;
            case Calendar.SATURDAY:
                strWeek = "토";
                break;
            default:
                strWeek = "일";

        }
        int amPm = now.get(Calendar.AM_PM); // 오전/오후 정보(0:AM, 1:PM)
        String strAmPm = null;
        if (amPm == Calendar.AM) {
            strAmPm = "오전";

        } else {
            strAmPm = "오후";
        }
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        // 날짜와 시간 출력
        System.out.print(year + "년");
        System.out.print(month + "월");
        System.out.println(day + "일");
        System.out.print(strWeek + "요일");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시");
        System.out.print(minute + "분");
        System.out.println(second + "초");
    }
}
