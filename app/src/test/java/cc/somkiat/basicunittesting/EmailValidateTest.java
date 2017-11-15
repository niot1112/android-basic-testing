package cc.somkiat.basicunittesting;


import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class EmailValidateTest {
    @Test
    public void NormalEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = emailValidateTest.check("email@email.com");
        assertTrue("Not pass", result);
    }

    @Test
    public void EmptyEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = !emailValidateTest.check("");//remove ! to get fail test
        assertTrue("Email is empty", result);
    }

    @Test
    public void SpaceInEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = !emailValidateTest.check("email @email.com");//remove ! to get fail test
        assertTrue("Email has space", result);
    }

    @Test
    public void PatternEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = !emailValidateTest.check("email.com");//remove ! to get fail test
        assertTrue("Email is not in pattern", result);
    }

    @Test
    public void ErrMessage(){
        EmailValidate emailValidateTest = new EmailValidate();

        emailValidateTest.check("email@email.com");//change "email@email.com" to get different ErrMessage here

        boolean result = emailValidateTest.getErrMessage().isEmpty();
        assertTrue(emailValidateTest.getErrMessage(), result);
    }
}
