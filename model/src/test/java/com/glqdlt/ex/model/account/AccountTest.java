package com.glqdlt.ex.model.account;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author glqdlt
 * 2019-02-18
 */
public class AccountTest {

    @Test
    public void 신규_계정을_생성() throws Exception {
        final String _id = "apple";
        final String _pw = "apple1234";
        final String _name = "jhun";
        final String _email = "jhun@apple.apple";
        final List<String> _roles = Arrays.asList("ADMIN","USER");
        final String _rolesComma = StringUtils.collectionToCommaDelimitedString(_roles);

        Account apple = Account.valueOf(_id, _pw, _email, _name, _roles);

        Assert.assertEquals(_id,apple.getId());
        Assert.assertEquals(_pw,apple.getPassword());
        Assert.assertEquals(_name,apple.getName());
        Assert.assertEquals(_email,apple.getEmail());
        Assert.assertEquals(_rolesComma,apple.getRole());
    }
}