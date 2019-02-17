package com.glqdlt.ex.oauthauthserver;

import com.glqdlt.ex.model.account.AccountRepo;
import com.glqdlt.ex.model.oauth.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author glqdlt
 * 2019-02-18
 */
@Configuration
public class OauthConfiguration {

    @Bean
    UserDetailsService userDetailsService(@Autowired final AccountRepo accountRepo){
        return userIdParam -> {
            Optional<UserDetails> account = accountRepo.findById(userIdParam)
                    .map(_a ->
                            User.withUsername(_a.getId())
                            .roles(_a.getRole())
                            .password(_a.getPassword())
                            .build()
                    );
            return account.orElseThrow(() -> new UsernameNotFoundException(String.format("'%s' NotFoundUser!", userIdParam)));
        };
    }

    @Bean
    ClientDetailsService clientDetailsService(@Autowired final ClientRepo clientRepo){
        return clientIdParam -> {
            Optional<BaseClientDetails> detailsOptional = clientRepo.findByClientId(clientIdParam)
                    .map(_c -> new BaseClientDetails(
                            _c.getClientId(),
                            null,
                            _c.getScope(),
                            StringUtils.collectionToCommaDelimitedString(_c.getGrantTypes().stream().map(Enum::name).collect(Collectors.toList())),
                            _c.getAuthorities()));
            return detailsOptional.orElseThrow(() -> new ClientRegistrationException(String.format("'%s' NotRegistrationClient", clientIdParam)));
        };
    }
}
