package com.zing.vchat.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class AuthorizationUtils {

    public static String makeToken(String str) {
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + str;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        System.out.println(AuthorizationUtils.makeToken("1213"));
    }
}
