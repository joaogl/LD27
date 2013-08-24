package joaogl.d4rk.ld27.util;

public class Util {
    
    public static String replaceWithSystemFileSeparator(String str, String regex) {
        String returned = str.trim();
        returned.replaceAll(regex, System.getProperty("file.separator"));
        return returned;
    }
}
