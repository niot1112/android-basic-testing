package cc.somkiat.basicunittesting.validate_class;

public class TryEmailValidateEmpty implements TryValidator {
    @Override
    public boolean isValid(String input) {
        return input.isEmpty();
    }

    @Override
    public String getErrMessages() {
        return "email must not empty";
    }
}
