package org.nekonium.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;
import org.json.JSONArray;

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
		JSONObject rpcCallBody = new JSONObject();
		rpcCallBody.put("jsonrpc", "2.0");
		rpcCallBody.put("method", m.getName());
		if (args != null) {
			JSONArray rpcCallArgs = new JSONArray();
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof Integer || args[i] instanceof String)
					rpcCallArgs.put(args[i]);
				else
					rpcCallArgs.put(new JSONObject(args[i]));
			}
			rpcCallBody.put("params", rpcCallArgs);
		}
		rpcCallBody.put("id", "1");

		JSONObject result = null;
		try {
			// Do something before the method is called ...
			// result = m.invoke(obj, args);
			result = new JSONObject(client.postTextContents(
					"http://127.0.0.1:8293", "UTF-8", null,
					rpcCallBody.toString()));
			return result.get("result");

		} catch (Exception eBj) {
			System.out.println(eBj);
		} finally {
			// Do something after the method is called ...
		}
		return result;
	}
}
