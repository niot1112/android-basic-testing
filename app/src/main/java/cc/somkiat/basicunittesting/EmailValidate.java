package cc.somkiat.basicunittesting;


public class EmailValidate {
    private String errMessage = "";

    public boolean check(String email) {
        if (isEmpty(email)){
            errMessage = "email must not empty";
            return false;
        }
        else if (isContainSpace(email)) {
            errMessage = "Name must not have space";
            return false;
        }
        else if(isInemailPattern(email)){
            errMessage = "email must have @";
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
        if (!name.contains("@")){
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
