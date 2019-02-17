package com.glqdlt.ex.model.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * @author glqdlt
 * 2019-02-18
 */
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer no;
    private String clientId;
    private String secret;

    private String scope;
    private List<GrantTypes> grantTypes;
    private String authorities;

    private String appScope;
}
