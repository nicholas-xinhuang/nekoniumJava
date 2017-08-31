package org.nekonium.http;

import java.io.*;
import java.net.*;

public class BaseHttpClient {

	protected String userAgent = null;
	protected String cookie = null;
	private int lastStatusCode;

	public String postTextContents(String url, String i_charset,
			String[][] i_additional_header, String i_body) throws IOException {
		HttpURLConnection con = this.makeConnection(url, "POST");
		con.setDoOutput(true);
		// 送信
		if (i_additional_header != null) {
			for (String[] i : i_additional_header) {
				con.addRequestProperty(i[0], i[1]);
			}
		}
		con.connect();
		con.getOutputStream().write(i_body.getBytes());
		this.lastStatusCode = con.getResponseCode();
		switch (this.lastStatusCode) {
		case 200:
		case 201:
			break;
		default:
			return null;
		}
		String ret = this.getResponse(con, i_charset);
		con.disconnect();
		return ret;

	}

	protected HttpURLConnection makeConnection(String endpoint, String method)
			throws IOException {
		URL url = new URL(endpoint);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod(method);
		con.setInstanceFollowRedirects(true);
		con.setRequestProperty("Host", url.getHost()
				+ (url.getPort() == 80 ? "" : ":" + url.getPort()));
		if (this.userAgent != null) {
			con.setRequestProperty("User-Agent", this.userAgent);
		}
		con.setRequestProperty("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.7");
		con.setRequestProperty("Accept-Language", "ja,en-us;q=0.7,en;q=0.3");
		con.setRequestProperty("Connection", "keep-alive");
		if (this.cookie != null) {
			con.setRequestProperty("Cookie", this.cookie);

		}
		return con;
	}

	protected String getResponse(HttpURLConnection con, String i_char_set)
			throws IOException {
		// body部の文字コード取得
		String contentType = con.getHeaderField("Content-Type");
		if (contentType == null) {
			return null;
		}
		for (String elm : contentType.replace(" ", "").split(";")) {
			if (elm.startsWith("charset=")) {
				i_char_set = elm.substring(8);
				break;
			}
		}
		StringBuffer b = new StringBuffer();
		// body部受信
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), i_char_set));
		} catch (UnsupportedEncodingException e) {
			//throw new NyanSatRuntimeException(e);
		}
		char[] cbuf = new char[4096];
		int l = br.read(cbuf);
		while (l > 0) {
			b.append(cbuf, 0, l);
			l = br.read(cbuf);
		}
		br.close();
		return b.toString();
	}

	public void main() {
		try {
			HttpURLConnection url = makeConnection("http://127.0.0.1:8293",
					"POST");

			String body = "{\"jsonrpc\":\"2.0\",\"method\":\"eth_getBalance\",\"params\":[\"0x481Dac54c531c186bDF9d021A95f2c414065e000\", \"latest\"],\"id\":2}";

			System.out.println(postTextContents("http://127.0.0.1:8293", "UTF-8", null, body));
			//System.out.println(url.getResponseCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
