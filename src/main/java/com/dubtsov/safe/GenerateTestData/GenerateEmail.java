package com.dubtsov.safe.GenerateTestData;

import java.io.*;
import java.util.Random;

/**
 * Created by user on 27.10.17.
 */
public class GenerateEmail {

    public static String emailStatic;
    public static String emailWithoutPostfixStatic;

    public static String getGeneratedEmail() throws IOException {
        Random random = new Random();
        int count = random.nextInt(1000000);
        String generatedEmail = "ui_test" + count + "@p33.org";
        emailWithoutPostfixStatic = "ui_test" + count;
        emailStatic = generatedEmail;
        System.out.println("Generated email " + emailStatic);
        return generatedEmail;
    }
}
