package httpdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpre {

	public static void main(String[] args) {
		pattenM();
	}
	
	private static boolean pattenM() {
		
		Pattern pattern = Pattern.compile("^1[3|4|5|8][0-9]{9}");
		Matcher matcher = pattern.matcher("15574478884");
		boolean yes = matcher.matches();
		System.out.println(yes);
		return yes;
	}
}
