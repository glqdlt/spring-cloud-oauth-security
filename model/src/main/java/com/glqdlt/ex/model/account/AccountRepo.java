package com.glqdlt.ex.model.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author glqdlt
 * 2019-02-18
 */
public interface AccountRepo extends JpaRepository<Account,Long> {
    Optional<Account> findById(String id);
}
