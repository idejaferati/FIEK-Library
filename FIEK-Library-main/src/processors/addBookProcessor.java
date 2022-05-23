package processors;

public class addBookProcessor {
	 public static boolean onlyDigits(String str, int n) {
	        for (int i = 1; i < n; i++) {

	            if (Character.isDigit(str.charAt(i))) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	        return false;
	    }
}
