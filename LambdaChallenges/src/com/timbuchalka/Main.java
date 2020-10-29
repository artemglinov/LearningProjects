package com.timbuchalka;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Main {

    public static void main(String[] args) {
	    Runnable runnable = () -> {
	        String myString = "Let's split this up into an array";
	        String[] parts = myString.split(" ");
	        for (String part : parts){
                System.out.println(part);
            }
        };

        Function<String, String> lambdaFunction = source -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++){
                if(i % 2 == 1){
                    returnVal.append(source.charAt(i));
                }
            }

            return returnVal.toString();
        };

//        System.out.println(lambdaFunction.apply("1234567890"));

        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

//        Supplier<String> iLoveJava = () -> "I love Java!";

        Supplier<String> iLoveJava = () -> { return "I love Java!";};

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        System.out.println("***************");

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

//        Function<List<String>, List<String>> upperCase = list -> {
//            List<String> upperCasedNames = new ArrayList<>();
//            for (String name : list){
//                upperCasedNames.add(name.substring(0, 1).toUpperCase() + name.substring(1));
//            }
//
//            return upperCasedNames;
//        };

//        Consumer<String> printString = System.out::println;
//
//        List<String> upperCasedNames = upperCase.apply(topNames2015);
//        Collections.sort(upperCasedNames);
//        upperCasedNames.forEach(printString);

//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(s ->
//                firstUpperCaseList.add(s.substring(0, 1).toUpperCase() + s.substring(1)));
//        firstUpperCaseList.sort(String::compareTo);
//        firstUpperCaseList.forEach(System.out::println);

        Function<String, String> upperCase = name -> name.substring(0, 1).toUpperCase() + name.substring(1);

//        Predicate<String> predicate = s -> {
//            for (int i = 0; i < s.length(); i++){
//                if(s.toUpperCase().charAt(i) == 'A'){
//                    return true;
//                }
//            }
//
//            return false;
//        };

        List<String> result = topNames2015.stream()
                .map(upperCase)
                .peek(System.out::println)
                .sorted(String::compareTo)
                .collect(Collectors.toList());

//        for (String name : result){
//            System.out.println(name);
//        }

//                .forEach(System.out::println);

//        long count = topNames2015.stream()
//                .map(upperCase)
//                .filter(s -> s.startsWith("A"))
//                .count();
//
//        System.out.println(count);
    }

    private static String everySecondCharacter(Function<String, String> func, String source){
        return func.apply(source);
    }


}
