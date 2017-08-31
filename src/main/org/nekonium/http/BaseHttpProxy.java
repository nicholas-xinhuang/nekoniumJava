package org.nekonium.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;

/**
 * @author oldbeyond
 */
public class BaseHttpProxy implements InvocationHandler {
	BaseHttpClient client;

	public BaseHttpProxy(BaseHttpClient client) {
		this.client = client;
	}

	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {

		StringBuilder jsonBody = new StringBuilder();
		jsonBody.append("{\"jsonrpc\":\"2.0\",\"method\":\"");
		jsonBody.append(m.getName());
		jsonBody.append("\",\"params\":[");
		for (int i = 0; i < args.length; i++) {
			if (i > 0)
				jsonBody.append(",");
			if (args[i] instanceof String)
				jsonBody.append("\"" + args[i] + "\"");
			else
				jsonBody.append(args[i]);
		}
		jsonBody.append("],\"id\":\"1\"}");

		JSONObject result = null;
		try {
			// Do something before the method is called ...
			// result = m.invoke(obj, args);
			result = new JSONObject(client.postTextContents("http://127.0.0.1:8293", "UTF-8",
					null, jsonBody.toString()));
			return result.get("result");
		} catch (Exception eBj) {
			System.out.println(eBj);
		} finally {
			// Do something after the method is called ...
		}
		return result;
	}
}
