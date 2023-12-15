package db.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//날짜 변환하는 기능을 가진 클래스
public class MyConverDateUtil {
	public static Timestamp convertLocalDateTimeToTimestamp(LocalDateTime ldt) {
		return Timestamp.valueOf(ldt);
	}
	
	public static LocalDateTime convertTimestampToLocalDateTime(Timestamp ts) {
		return ts.toLocalDateTime();
	}
	
	public static String convertLocalDateTimeToStringYMD(LocalDateTime ldt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String result = ldt.format(dtf);
		return result;
	}
	
	public static String convertLocalDateTimeToStringYMD2(LocalDateTime ldt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String result = ldt.format(dtf);
		return result;
	}
	
	public static String convertLocalDateTimeToStringYMDHDS(LocalDateTime ldt) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String result = ldt.format(dtf);
		return result;
	}
	
	public static LocalDate convertStringToLocalDate(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ld = LocalDate.parse(str,dtf);
		return ld;
	}
	
	public static LocalDateTime convertStringToLocalDateTime(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		LocalDate ld = LocalDate.parse(str,dtf);
		
		LocalDateTime ldt = ld.atStartOfDay();
		
		return ldt;
	}
	
	
	public static LocalDateTime convertStringToLocalDateTime2(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		LocalDate ld = LocalDate.parse(str,dtf);
		
		LocalDateTime ldt = ld.atStartOfDay();
		
		return ldt;
	}
	
	
	public static LocalDateTime convertStringToLocalDateTime3(String str) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		LocalDate ld = LocalDate.parse(str,dtf);
		
		LocalDateTime ldt = ld.atStartOfDay();
		
		return ldt;
	}
}
