package cc.somkiat.basicunittesting.validate_class;

public class TryEmailValidateSpace implements TryValidator{
    @Override
    public boolean isValid(String input) {
        return input.contains(" ");
    }

    @Override
    public String getErrMessages() {
        return "email must not have space";
    }
}
