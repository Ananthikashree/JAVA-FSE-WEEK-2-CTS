package com.api;

public class ApiService {
    private final IExternalApi externalApi;

    public ApiService(IExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void submitData(String data) {
        externalApi.sendData(data);
    }

    public void performDangerousAction() throws Exception {
        externalApi.dangerousAction();
    }
}
