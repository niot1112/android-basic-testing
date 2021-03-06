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
        boolean result = !nameValidate.check("");//remove ! to get fail test
        assertTrue("Name is empty.", result);
    }

    @Test
    public void NameAlpha(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("&@#a9");//remove ! to get fail test
        assertTrue("Name is not alphabet.", result);
    }

    @Test
    public void NameInteger(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("Nice1234");//remove ! to get fail test
        assertTrue("Name is number.", result);
    }

    @Test
    public void NameSpace(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("Ni ce");//remove ! to get fail test
        assertTrue("Name have space.", result);
    }

    @Test
    public void NameLessThanTwo(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("N");
        assertTrue("Name is less than 2.", result);//remove ! to get fail test
    }

    @Test
    public void NameMoreThanTwenty(){
        NameValidate nameValidate = new NameValidate();
        boolean result = !nameValidate.check("NiceNiceNiceNiceNiceNiceNice");//remove ! to get fail test
        assertTrue("Name are more than 20.", result);
    }

    @Test
    public void ErrMessage(){
        NameValidate nameValidate = new NameValidate();

        nameValidate.check("Nice");//change "Nice" to get different ErrMessage here

        boolean result = nameValidate.getErrMessage().isEmpty();
        assertTrue(nameValidate.getErrMessage(), result);
    }

}
