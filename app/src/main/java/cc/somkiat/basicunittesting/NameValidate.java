package cc.somkiat.basicunittesting;

import java.util.regex.Pattern;

public class NameValidate {
    private String errMessage = "";

    public boolean check(String name) {

        if (isEmpty(name)){
            errMessage = "Name must not empty";
            return false;
        }
        else if (isContainSpace(name)) {
            errMessage = "Name must not have space";
            return false;
        }
        else if (isAlphabet(name)){
            errMessage = "Name must contain only alphabet";
            return false;
        }
        else if (isContainNumber(name)) {
            errMessage = "Name must not have number";
            return false;
        }
        else if (isLessThanTwo(name)) {
            errMessage = "Name must more than 2";
            return false;
        }
        else if (isMoreThanTwenty(name)) {
            errMessage = "Name must less than 20";
            return false;
        }
        return true;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public boolean isEmpty(String name) {
        if(name.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isAlphabet(String name) {
        if(!Pattern.matches("[a-zA-Z0-9]+", name)){
            return true;
        }
        return false;
    }

    public boolean isContainNumber(String name) {
        if (name.matches(".*\\d+.*")){
            return true;
        }
        return false;
    }

    public boolean isContainSpace(String name){
        if (name.contains(" ")){
            return true;
        }
        return false;
    }

    public boolean isLessThanTwo(String name){
        if(name.length() < 2) {
            return true;
        }
        return false;
    }

    public boolean isMoreThanTwenty(String name){
        if(name.length() > 20) {
            return true;
        }
        return false;
    }
}
