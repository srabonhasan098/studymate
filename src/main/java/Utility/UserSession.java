package Utility;

import java.util.HashSet;
import java.util.Set;

public final class UserSession {

    private static String user_id;

    public UserSession(String u_id){
        user_id = u_id;
    }

    public static String getUser_id() {
        return user_id;
    }

    public void setUser_idNull(){
        user_id = "";
    }
}