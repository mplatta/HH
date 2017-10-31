package pl.com.harehounds.harehounds;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Michał on 31.10.2017.
 */

public class RegisterRequest extends StringRequest {
	// TODO: 31.10.2017 change server address
	private static final String LOGIN_REQUEST_URL = "http://klata.cba.pl/testapp3.php";
	private Map<String, String> params;

	public RegisterRequest(String email, String nickName, String password, Response.Listener<String> listener) {
		super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
		params = new HashMap<>();
		params.put("email", email);
		params.put("nickName", nickName);
		params.put("password", password);
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}