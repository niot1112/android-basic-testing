package cc.somkiat.basicunittesting;


import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class NameValidateTest {
    @Test
    public void NormalName(){
        NameValidate nameValidate = new NameValidate();
        boolean result = nameValidate.check("Nice");
        assertTrue("NOT PASS", result);
    }

    @Test
    public void NameEmpty(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("");
        assertTrue("Name is empty.", result);
    }

    @Test
    public void NameAlpha(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("!@#a9");
        assertTrue("Name is not alphabet.", result);
    }

    @Test
    public void NameInteger(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("1234");
        assertTrue("Name is number.", result);
    }

    @Test
    public void NameSpace(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("Ni ce");
        assertTrue("Name have space.", result);
    }

    @Test
    public void NameLessThanTwo(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("N");
        assertTrue("Name is less than 2.", result);
    }

    @Test
    public void NameMoreThanTwenty(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("NiceNiceNiceNiceNiceNiceNice");
        assertTrue("Name are more than 20.", result);
    }

    @Test
    public void ErrMessage(){
        NameValidate nameValidate = new NameValidate();

        nameValidate.check("Nice");//change to get different ErrMessage here

        boolean result = nameValidate.getErrMessage().isEmpty();
        assertTrue(nameValidate.getErrMessage(), result);
    }

}
