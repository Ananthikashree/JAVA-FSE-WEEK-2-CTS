package com.api;

public interface IExternalApi {
    String getData();
    void sendData(String data);
    void dangerousAction() throws Exception;
}
