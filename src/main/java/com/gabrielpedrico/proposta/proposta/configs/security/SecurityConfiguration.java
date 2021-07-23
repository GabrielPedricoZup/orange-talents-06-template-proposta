package com.gabrielpedrico.proposta.proposta.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers(HttpMethod.GET, "/proposta/**").hasAuthority("SCOPE_proposta:read")
                .antMatchers(HttpMethod.GET, "/cartoes/**").hasAuthority("SCOPE_proposta:read")
                .antMatchers(HttpMethod.POST, "/cartoes/**").hasAuthority("SCOPE_proposta:write")
                .antMatchers(HttpMethod.POST, "/avisoviagem/**").hasAuthority("SCOPE_proposta:write")
                .antMatchers(HttpMethod.POST, "/proposta/**").hasAuthority("SCOPE_proposta:write")
                .antMatchers(HttpMethod.GET, "/actuator/prometheus").hasAuthority("SCOPE_proposta:read")
                .antMatchers(HttpMethod.GET, "/actuator/**").hasAuthority("SCOPE_proposta:read")
                .anyRequest().authenticated()
        ).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
