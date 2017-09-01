package org.nekonium.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * @author oldbeyond
 */
public class BaseHttpProxy implements InvocationHandler {
	private BaseHttpClient client;

	public BaseHttpProxy(final BaseHttpClient client) {
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

		result = new JSONObject(client.postTextContents("UTF-8", null,
				rpcCallBody.toString()));
		if (result.has("result"))
			return result.get("result");
		else {
			JSONObject error = (JSONObject) result.get("error");
			throw new Exception(error.get("message").toString());
		}
	}
}
