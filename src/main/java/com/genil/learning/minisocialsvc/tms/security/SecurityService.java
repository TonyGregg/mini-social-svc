package com.genil.learning.minisocialsvc.tms.security;

/**
 * Created by Antony Genil Gregory on 1/8/2020 5:04 AM
 * For project : mini-social-svc
 **/
public interface SecurityService {
    String createToken(String subject, long ttlMillis);
    String getSubject(String token);
}
