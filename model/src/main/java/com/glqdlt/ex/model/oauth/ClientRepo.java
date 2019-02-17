package com.glqdlt.ex.model.oauth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author glqdlt
 * 2019-02-18
 */
public interface ClientRepo extends JpaRepository<Client,Integer> {
    Optional<Client> findByClientId(String id);
}
