package pl.com.harehounds.harehounds.GameActivitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.GameActivitis.RunnerActivities.RunnerActivity;
import pl.com.harehounds.harehounds.GameActivitis.SeekerActivities.SeekerActivity;

/**
 * created by klata on 11.12.2017.
 */

class LobbyResponseListener implements Response.Listener<String> {

	private TextView mRunnerTextView;
	private TextView mSeekerTextView;
	private AppCompatActivity activity;
	private Boolean host;
	private Integer gameId;
	
	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);
			Log.d("jsoresp", response);
			JSONArray jsonArray = jsonResponse.getJSONArray("players");
			Log.d("jsoarr", jsonArray.toString());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Log.d("jsobject", jsonObject.toString());
				if (jsonObject.getBoolean("isPursuiting")) {
					mSeekerTextView.setText(jsonObject.getString("login"));
				} else {
					mRunnerTextView.setText(jsonObject.getString("login"));
				}
			}
			
			Boolean startGame = jsonResponse.getBoolean("ready");
			
			if(startGame) {
				Intent intent;

				if (host) {
					intent = new Intent(activity, RunnerActivity.class);
				} else {
					intent = new Intent(activity, SeekerActivity.class);
				}

				intent.putExtra("gameId", gameId.toString());

				activity.startActivity(intent);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	LobbyResponseListener(AppCompatActivity activity, TextView mRunnerTextView, TextView mSeekerTextView, Integer gameId, Boolean host) {
		this.mRunnerTextView = mRunnerTextView;
		this.mSeekerTextView = mSeekerTextView;
		this.activity = activity;
		this.host = host;
		this.gameId = gameId;
	}
}
