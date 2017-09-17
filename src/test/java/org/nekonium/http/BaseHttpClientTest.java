package org.nekonium.http;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BaseHttpClientTest {

	@Test
	public void test() throws IOException {
		String body = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_getBalance\",\"params\":[\"0x481Dac54c531c186bDF9d021A95f2c414065e000\", \"latest\"],\"id\":2}";
		BaseHttpClient httpClient = new BaseHttpClient("http://127.0.0.1:8293");
		String result = httpClient.postTextContents("http://127.0.0.1:8293",
				"UTF-8", null, body);
		result.startsWith("{\"jsonrpc\":\"2.0\"");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidEncode() throws IOException {
		String body = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_getBalance\",\"params\":[\"0x481Dac54c531c186bDF9d021A95f2c414065e000\", \"latest\"],\"id\":2}";
		BaseHttpClient httpClient = new BaseHttpClient("http://127.0.0.1:8293");
		httpClient.postTextContents("http://127.0.0.1:8293",
				"UTF-invalid", null, body);
	}

}