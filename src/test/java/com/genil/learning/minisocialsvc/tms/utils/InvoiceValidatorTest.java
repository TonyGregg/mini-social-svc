package com.genil.learning.minisocialsvc.tms.utils;

import com.genil.learning.minisocialsvc.tms.adapter.validator.InvoiceValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Antony Genil on 1/8/20 at 19 48 for mini-social-svc
 **/
@RunWith(SpringJUnit4ClassRunner.class)
public class InvoiceValidatorTest {
    @InjectMocks
    InvoiceValidator invoiceValidator;

    @Test
    public void isValid() {
        Assert.assertTrue(invoiceValidator.isValid("UDIN232",null));
    }
}