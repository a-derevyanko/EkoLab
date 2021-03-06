package org.ecolab.server.service;

import org.ecolab.server.AbstractTestWithUser;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * Created by 777Al on 28.03.2017.
 */
@EnableAutoConfiguration(exclude = {ManagementWebSecurityAutoConfiguration.class})
public class SecurityServicesTest extends AbstractTestWithUser {
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Test
    public void testPersistentTokenRepository() throws Exception {
        var token = new PersistentRememberMeToken(USERNAME, "series", "tokenValue", new Date());
        persistentTokenRepository.createNewToken(token);

        Assert.assertTrue(new ReflectionEquals(persistentTokenRepository.getTokenForSeries("series")).matches(token));
        persistentTokenRepository.updateToken( "series", "tokenValueModified", new Date());
        Assert.assertEquals("tokenValueModified", persistentTokenRepository.getTokenForSeries("series").getTokenValue());
        persistentTokenRepository.removeUserTokens( USERNAME);
        Assert.assertNull(persistentTokenRepository.getTokenForSeries("series"));
    }
}