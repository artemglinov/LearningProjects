package com.timbuchalka;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	    String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        String regExp = "I want a \\w+.";
        System.out.println(challenge1.matches(regExp));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regExp));

        Pattern pattern = Pattern.compile("I want a \\w+.");
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("a{3}bc{8}d{3}ef{3}g"));

        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge7 = "abcd.135";
        String regExpPer = "^[A-z]+\\.[0-9]+$";
        System.out.println(challenge7.matches(regExpPer));

        String copyRegExpPer = "[A-Za-z]+\\.(\\d+)";
        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern perPattern = Pattern.compile(copyRegExpPer);
        Matcher perMatcher = perPattern.matcher(challenge8);

        while (perMatcher.find()){
            System.out.println(perMatcher.group(1));
        }

        System.out.println("***************************");

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        perPattern = Pattern.compile("[A-Za-z]+\\.(\\d+)\\s");
        perMatcher = perPattern.matcher(challenge9);

//        while (perMatcher.find()){
//            System.out.println(perMatcher.group(1));
//        }

        while (perMatcher.find()){
            System.out.println(perMatcher.start(1) + " to " + (perMatcher.end(1)-1));
        }

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern pattern11 = Pattern.compile("(\\{)(\\d+, \\d+)(})");
        Matcher matcher11 = pattern11.matcher(challenge11);

        while (matcher11.find()){
            System.out.println(matcher11.group(2) + " ");
        }

        String regZip = "^\\d{5}$";
        String challenge12 = "11111";
        System.out.println(challenge12.matches(regZip));

        regZip = "^\\d{5}-\\d{4}$";
        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches(regZip));

        System.out.println("****************");

        regZip = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge12.matches(regZip));
        System.out.println(challenge13.matches(regZip));

//        System.out.println("abcd".matches("abcd?"));
    }
}
