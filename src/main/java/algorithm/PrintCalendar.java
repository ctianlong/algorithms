package algorithm;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

/**
 * 打印某月份的日历
 * @author tianlong
 *
 */
public class PrintCalendar {

	public static void main(String[] args) {
		String yearString = JOptionPane.showInputDialog("Enter full year (e.g. 2001):");
		int year = Integer.parseInt(yearString);
		String monthString = JOptionPane.showInputDialog("Enter month as number between 1 and 12:");
		int month = Integer.parseInt(monthString);
		printMonth(year, month);
	}

	public static void printMonth(int year, int month) {
		printMonthTitle(year, month);
		printMonthBody(year, month);
	}

	public static void printMonthTitle(int year, int month) {
		System.out.println("        " + getMonthName(month) + " " + year);
		System.out.println("------------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}

	public static String getMonthName(int month) {
		String monthName = null;
		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "Marth";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		default:
			break;
		}
		return monthName;
	}

	public static void printMonthBody(int year, int month) {
		int startDay = getStartDay(year, month);
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
		for (int i = 0; i < startDay - 1; i++) {
			System.out.print("    ");
		}
		for (int i = 1; i <= numberOfDaysInMonth; i++) {
			System.out.printf("%4d", i);
			if ((i + startDay - 1) % 7 == 0)
				System.out.println();
		}
		System.out.println();
	}

	public static int getStartDay(int year, int month) {
		Calendar calendar = new GregorianCalendar(year, month - 1, 1);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static int getNumberOfDaysInMonth(int year, int month) {
		Calendar calendar = new GregorianCalendar(year, month - 1, 1);
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
