package framework;

public class Auth {

    public static String invalidUserEmail() {
        String invUserEmail = "kduerksen@betabreakers.co";
        return invUserEmail;
    }

    public static String invalidUserPassword() {
        String invUserPassword = "invalidps";
        return invUserPassword;
    }

    public static String mainUserPassword() {
        String testUserPassword = "password7373";
        return testUserPassword;
    }

    public static String mainUserEmail() {
        String testUserEmail = "carlos.r@vshred.com";
        return testUserEmail;
    }

    public static String validAdminUserEmail() {
        String valAdminUserEmail = "kduerksen@betabreakers.com";
        return valAdminUserEmail;
    }

    public static String validAdminUserPassword() {
        String valAdminUserPassword = "Password1!";
        return valAdminUserPassword;
    }

    public static String validMemberUserName() {
        String valAdminUserEmail = "Kurt Duerksen";
        return valAdminUserEmail;
    }

    public static String validMemberUserEmail() {
        String valAdminUserEmail = "kduerksen+vshred001@betabreakersbugs.com";
        return valAdminUserEmail;
    }

    public static String validMemberUserPassword() {
        String valAdminUserPassword = "Password1!";
        return valAdminUserPassword;
    }
}