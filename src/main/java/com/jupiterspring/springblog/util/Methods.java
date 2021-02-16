package com.jupiterspring.springblog.util;

import org.mindrot.jbcrypt.BCrypt;

public class Methods {

    public String cap(String in){
        return in.substring(0, 1).toUpperCase()+in.substring(1);
    }

    public String hash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public boolean check(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }

}
