package terminal_menu;

public class Validacion {
	public static boolean isInt(String str) {
		return str != null && str.matches("[0-9-]+");
	}
	public static boolean isUnsignedInt(String str) {
		return str != null && str.matches("[0-9]+");
	}
	public static boolean isDouble(String str) {
		return str != null && str.matches("[0-9.-]+");
	}
	public static int toInt(String str) {
		if(!isInt(str))
			return 0;
		return Integer.parseInt(str);
	}
	public static int toUnsignedInt(String str) {
		if(!isUnsignedInt(str))
			return 0;
		return Integer.parseInt(str);
	}
	public static float toFloat(String str) {
		if(!isDouble(str))
			return 0;
		return Float.parseFloat(str);
	}
	public static long toLong(String str) {
		if(!isInt(str))
			return 0;
		return Long.parseLong(str);
	}
	public static double toDouble(String str) {
		if(!isDouble(str))
			return 0;
		return Double.parseDouble(str);
	}
}
