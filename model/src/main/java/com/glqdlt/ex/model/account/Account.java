package com.glqdlt.ex.model.account;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * @author glqdlt
 * 2019-02-18
 */
@Data
@Entity
public class Account {

    private Long no;
    private String id;
    private String password;
    private String email;
    private String name;

    private String role;
    private boolean activate;

    private Date regDate;

    public static Account valueOf(String id, String password, String email, String name, List<String> roles){
        Account account = new Account();
        account.setId(id);
        account.setPassword(password);
        account.setName(name);
        account.setEmail(email);
        account.setRole(StringUtils.collectionToCommaDelimitedString(roles));
        account.setRegDate(new Date());
        account.setActivate(true);
        return account;
    }
}
