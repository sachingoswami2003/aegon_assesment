package com.aegon.exception;


import java.util.Collections;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class RemoteServiceExceptionUnitTest {

    @Test
    public void constructor() throws Exception {
        Exception cause = mock(Exception.class);
        List<String> errors = Collections.singletonList("errors");
        RemoteServiceException exception = new RemoteServiceException("Message", errors, cause);

        assertEquals(exception.getLocalizedMessage(), "Message");
        assertEquals(exception.getErrors(), errors);
        assertEquals(exception.getCause(), cause);
    }

    @Test
    public void constructorWithNullErrors() throws Exception {
        Exception cause = mock(Exception.class);
        RemoteServiceException exception = new RemoteServiceException("Message", null, cause);

        assertEquals(exception.getLocalizedMessage(), "Message");
        assertTrue(exception.getErrors().isEmpty());
        assertEquals(exception.getCause(), cause);
    }

    @Test
    public void constructorWithNoErrors() throws Exception {
        Exception cause = mock(Exception.class);
        RemoteServiceException exception = new RemoteServiceException("Message", cause);

        assertEquals(exception.getLocalizedMessage(), "Message");
        assertTrue(exception.getErrors().isEmpty());
        assertEquals(exception.getCause(), cause);
    }
}

