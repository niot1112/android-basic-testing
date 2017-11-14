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
        boolean result = !emailValidateTest.check("");
        assertTrue("Email is empty", result);
    }

    @Test
    public void SpaceInEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = !emailValidateTest.check("email @email.com");
        assertTrue("Email has space", result);
    }

    @Test
    public void PatternEmail(){
        EmailValidate emailValidateTest = new EmailValidate();
        boolean result = !emailValidateTest.check("email.com");
        assertTrue("Email is not in pattern", result);
    }

    @Test
    public void ErrMessage(){
        EmailValidate emailValidateTest = new EmailValidate();

        emailValidateTest.check("email@email.com");//change to get different ErrMessage here

        boolean result = emailValidateTest.getErrMessage().isEmpty();
        assertTrue(emailValidateTest.getErrMessage(), result);
    }
}
