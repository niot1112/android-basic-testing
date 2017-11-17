package cc.somkiat.basicunittesting.validate_class;

public class TryEmailValidatePattern implements TryValidator{
    @Override
    public boolean isValid(String input) {
        return !countchar(input);
    }

    private boolean countchar(String input) {
        int counter = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == '@'){
                counter++;
            }
        }
        return counter==1;
    }

    @Override
    public String getErrMessages() {
        return "email must has one @";
    }
}
