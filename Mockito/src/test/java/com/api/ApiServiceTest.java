package com.api;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApiServiceTest {
    @Test
    public void testMockingAndStubbing() {
        IExternalApi mockApi = mock(IExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        ApiService service = new ApiService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        IExternalApi mockApi = mock(IExternalApi.class);
        ApiService service = new ApiService(mockApi);

        service.fetchData();
        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        IExternalApi mockApi = mock(IExternalApi.class);
        ApiService service = new ApiService(mockApi);

        service.submitData("Hello");
        verify(mockApi).sendData(eq("Hello"));
    }

    @Test
    public void testVoidMethodStubbing() {
        IExternalApi mockApi = mock(IExternalApi.class);
        doNothing().when(mockApi).sendData(anyString());

        ApiService service = new ApiService(mockApi);
        service.submitData("Anything");

        verify(mockApi).sendData("Anything");
    }

    @Test
    public void testMultipleReturns() {
        IExternalApi mockApi = mock(IExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");

        ApiService service = new ApiService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    public void testInteractionOrder() {
        IExternalApi mockApi = mock(IExternalApi.class);
        ApiService service = new ApiService(mockApi);

        service.submitData("Data1");
        service.fetchData();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).sendData("Data1");
        inOrder.verify(mockApi).getData();
    }

    @Test
    public void testVoidMethodThrowsException() throws Exception {
        IExternalApi mockApi = mock(IExternalApi.class);
        doThrow(new RuntimeException("Failure")).when(mockApi).dangerousAction();

        ApiService service = new ApiService(mockApi);

        assertThrows(RuntimeException.class, service::performDangerousAction);
        verify(mockApi).dangerousAction();
    }
}
