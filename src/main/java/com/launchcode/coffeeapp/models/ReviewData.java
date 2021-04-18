package com.launchcode.coffeeapp.models;

import java.util.ArrayList;


public class ReviewData {

    public static ArrayList<Review> findByColumnAndValue(String column, String value, Iterable<Review> allReviews) {

        ArrayList<Review> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Review>) allReviews;
        }

        if (column.equals("all")){
            results = findByValue(value, allReviews);
            return results;
        }
        for (Review review : allReviews) {

            String aValue = getFieldValue(review, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(review);
            }
        }

        return results;
    }

    public static String getFieldValue(Review review, String fieldName){
        String theValue;
        if (fieldName.equals("summary")){
            theValue = review.getSummary();
        } else if (fieldName.equals("place")){
            theValue = review.getPlace().toString();
        } else {
            theValue = review.getTypes().toString();
        }

        return theValue;
    }


    public static ArrayList<Review> findByValue(String value, Iterable<Review> allReviews) {
        String lower_val = value.toLowerCase();

        ArrayList<Review> results = new ArrayList<>();

        for (Review review : allReviews) {

            if (review.getSummary().toLowerCase().contains(lower_val)) {
                results.add(review);
            } else if (review.getPlace().toString().toLowerCase().contains(lower_val)) {
                results.add(review);
            } else if (review.getTypes().toString().toLowerCase().contains(lower_val)) {
                results.add(review);
            } else if (review.toString().toLowerCase().contains(lower_val)) {
                results.add(review);
            }

        }

        return results;
    }











}
