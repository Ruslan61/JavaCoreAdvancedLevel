package lesson2.dayOfWeek;

public class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }

    public static String getWorkingHours(DayOfWeek day){
        int hours = 0;
        if (day.getWorkingHours() != 0){
            DayOfWeek[] week = DayOfWeek.values();
            for (int i = day.ordinal(); i < week.length; i++){
                hours += week[i].getWorkingHours();
            }
        }else{
            return "Сегодня выходной";
        }
        return "До выходных осталось отработать " + hours + " часов";
    }
}
