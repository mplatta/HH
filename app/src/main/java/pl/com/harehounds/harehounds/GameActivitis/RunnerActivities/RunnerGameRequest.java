package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 11.12.2017.
 */

public class RunnerGameRequest extends StringRequest {
	private Map<String, String> params;

	RunnerGameRequest(Double latitude, Double longitude, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.GET_CHECKPOINT_POSITION, listener, null);

		params = new HashMap<>();
		params.put("latitude", latitude.toString());
		params.put("longitude", longitude.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
