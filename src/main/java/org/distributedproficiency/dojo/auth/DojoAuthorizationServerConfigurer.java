package org.distributedproficiency.dojo.auth;


import org.distributedproficiency.dojo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Component;

@Configuration
@EnableAuthorizationServer
//@EnableOAuth2Client - is this a shortcut?
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DojoAuthorizationServerConfigurer implements AuthorizationServerConfigurer {

    @Autowired
    private UserService userService;

    @Autowired
    private ClientDetailsService clientDetailsService;

    // already fulfilled by the framework
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Bean
    public ClientDetailsService getClientDetailsService() throws Exception {
        return new InMemoryClientDetailsServiceBuilder()
                .withClient("web")
                .authorizedGrantTypes("password")
                .scopes("read", "write").resourceIds("kata", "kata-attempt", "users")

                .accessTokenValiditySeconds(3600).and().build();
    }
}