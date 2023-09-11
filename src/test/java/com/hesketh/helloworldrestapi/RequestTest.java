package com.hesketh.helloworldrestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    XmlMapper mapper = new XmlMapper();
    Request request = new Request("10");

    @Test
    void xml() throws JsonProcessingException {
        String xml = mapper.writeValueAsString(request);
        System.out.println(xml);
        assertEquals("<Request><id>10</id></Request>", xml);
    }
}