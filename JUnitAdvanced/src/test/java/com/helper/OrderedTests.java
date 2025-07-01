package com.helper;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrderedTests {
    @Test
    @Order(1)
    void testLogin() {
        System.out.println("Login test executed");
    }

    @Test
    @Order(2)
    void testDashboardAccess() {
        System.out.println("Dashboard access test executed");
    }

    @Test
    @Order(3)
    void testLogout() {
        System.out.println("Logout test executed");
    }
}
