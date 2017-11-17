package cc.somkiat.basicunittesting;


import java.util.ArrayList;
import java.util.List;

import cc.somkiat.basicunittesting.validate_class.TryEmailValidateEmpty;
import cc.somkiat.basicunittesting.validate_class.TryEmailValidatePattern;
import cc.somkiat.basicunittesting.validate_class.TryEmailValidateSpace;
import cc.somkiat.basicunittesting.validate_class.TryValidator;

public class EmailValidate {
    private String errMessage = "";

    public String checks(String email){
        List<TryValidator> tryValidators = new ArrayList<>();
        tryValidators.add(new TryEmailValidateEmpty());
        tryValidators.add(new TryEmailValidateSpace());
        tryValidators.add(new TryEmailValidatePattern());
        for(TryValidator tryValidator:tryValidators){
            if(tryValidator.isValid(email)){
                return tryValidator.getErrMessages();
            }
        }
        return "pass";
    }

    public boolean check(String email) {
        if (isEmpty(email)){
            errMessage = "email must not empty";
            return false;
        }
        else if (isContainSpace(email)) {
            errMessage = "email must not have space";
            return false;
        }
        else if(isInemailPattern(email)){
            errMessage = "email must has one @";
            return false;
        }
        return true;
    }

    public boolean isEmpty(String name) {
        if(name.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isInemailPattern(String name) {
        if (!countChar(name)){
            return true;
        }
        return false;
    }

    private boolean countChar(String name) {
        int counter = 0;
        for(int i=0;i<name.length();i++){
            if(name.charAt(i) == '@'){
                counter++;
            }
        }
        if (counter == 1){
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

    public String getErrMessage() {
        return errMessage;
    }
}
