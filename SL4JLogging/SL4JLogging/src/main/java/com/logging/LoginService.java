package com.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public void login(String username, String ipAddress) {
        logger.info("User '{}' is attempting to login from {}", username, ipAddress);

        if ("admin".equals(username)) {
            logger.info("Admin access detected for user '{}'", username);
        }

        // simulate login result
        boolean success = true;
        if (success) {
            logger.info("Login successful for user '{}'", username);
        } else {
            logger.error("Login failed for user '{}'", username);
        }
    }

    public static void main(String[] args) {
        LoginService loginService = new LoginService();
        loginService.login("john_doe", "192.168.1.10");
        loginService.login("admin", "10.0.0.1");
    }
}