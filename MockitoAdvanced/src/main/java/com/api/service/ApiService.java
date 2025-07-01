package com.api.service;

import com.api.rest.RestClient;

public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String fetchData() {
        return "Fetched " + restClient.getResponse();
    }
}
