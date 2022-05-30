package repos;

public class SQLConn {
    private static String url = "jdbc:mysql://localhost:3306/pao";
    private static String username = "AlexM";
    private static String password = "1234";

    public static String getUrl() { return url; }
    public static String getUserName() { return username; }
    public static String getPassword() { return password; }
}

