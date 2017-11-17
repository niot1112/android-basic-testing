package cc.somkiat.basicunittesting.validate_class;

public interface TryValidator {
    boolean isValid(String input);
    String getErrMessages();
}
