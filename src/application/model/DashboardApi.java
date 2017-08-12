package application.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class DashboardApi {

	private final String USER_AGENT = "Mozilla/5.0";
	private Flight flight;
	private Deicing deicing;

	public DashboardApi(Flight flight, Deicing deicing) {

		this.flight = flight;
		this.deicing = deicing;
	}

	// HTTP POST request
	public void PostData() throws Exception {

		String url1 = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
		HttpClient client1 = new DefaultHttpClient();
		HttpPost post1 = new HttpPost(url1);
		post1.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters1 = new ArrayList<NameValuePair>();
		urlParameters1.add(new BasicNameValuePair("tile", "big_value"));
		urlParameters1.add(new BasicNameValuePair("key", flight.getApiTileID()));
		String tileDataString;
		JSONObject tileData = new JSONObject();
		tileData.put("title", "aaaaa");
		tileData.put("description", "");
		tileData.put("big-value", deicing.getFluidType());
		tileData.put("upper-left-label", "A/C type:  ");
		tileData.put("upper-left-value", flight.getAircraftType());
		tileData.put("lower-left-label", "Tail #:  ");
		tileData.put("lower-left-value", flight.getTailNumber());
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", deicing.getStartTime());
		tileData.put("lower-right-label", "22");
		tileData.put("lower-right-value", "22");
		tileDataString = tileData.toString();
		urlParameters1.add(new BasicNameValuePair("data", tileDataString));
		post1.setEntity(new UrlEncodedFormEntity(urlParameters1));
		client1.execute(post1);

	}

	public void PostConf() throws Exception {

		String urlConf = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/"
				+ flight.getApiTileID();
		HttpClient clientConf = new DefaultHttpClient();
		HttpPost postConf = new HttpPost(urlConf);
		postConf.setHeader("User-Agent", USER_AGENT);
		String color = "";
		if (deicing.getFluidType().equalsIgnoreCase("TYPE I")) {
			color = "orange";
		} else if (deicing.getFluidType().equalsIgnoreCase("TYPE IV")) {
			color = "green";
		}
		List<NameValuePair> urlParametersConf = new ArrayList<NameValuePair>();
		String tileConfValueString;
		JSONObject tileConfValue = new JSONObject();
		tileConfValue.put("big_value_color", color);
		tileConfValue.put("fading_background", true);
		tileConfValueString = tileConfValue.toString();
		urlParametersConf.add(new BasicNameValuePair("value", tileConfValueString));
		postConf.setEntity(new UrlEncodedFormEntity(urlParametersConf));
		clientConf.execute(postConf);

	}

	public void ClearData() throws Exception {

		String url = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("tile", "big_value"));
		urlParameters.add(new BasicNameValuePair("key", flight.getApiTileID()));
		String tileDataString;
		JSONObject tileData = new JSONObject();
		tileData.put("title", "available");
		tileData.put("description", "");
		tileData.put("big-value", "");
		tileData.put("upper-left-label", "A/C type:  ");
		tileData.put("upper-left-value", "available");
		tileData.put("lower-left-label", "Tail #:  ");
		tileData.put("lower-left-value", "available");
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", "available");
		tileData.put("lower-right-label", "22");
		tileData.put("lower-right-value", "available");
		tileDataString = tileData.toString();
		urlParameters.add(new BasicNameValuePair("data", tileDataString));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		client.execute(post);

	}

	public void ClearConf() throws Exception {

		String urlConf = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/"
				+ flight.getApiTileID();
		HttpClient clientConf = new DefaultHttpClient();
		HttpPost postConf = new HttpPost(urlConf);
		postConf.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParametersConf = new ArrayList<NameValuePair>();
		String tileConfValueString;
		JSONObject tileConfValue = new JSONObject();
		tileConfValue.put("big_value_color", "#25282d");
		tileConfValue.put("fading_background", false);
		tileConfValueString = tileConfValue.toString();
		urlParametersConf.add(new BasicNameValuePair("value", tileConfValueString));
		postConf.setEntity(new UrlEncodedFormEntity(urlParametersConf));
		clientConf.execute(postConf);

	}

	private void ResetAllConf(String i) throws Exception {

		String urlConf = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/" + i;
		HttpClient clientConf = new DefaultHttpClient();
		HttpPost postConf = new HttpPost(urlConf);
		postConf.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParametersConf = new ArrayList<NameValuePair>();
		String tileConfValueString;
		JSONObject tileConfValue = new JSONObject();
		tileConfValue.put("big_value_color", "#25282d");
		tileConfValue.put("fading_background", false);
		tileConfValueString = tileConfValue.toString();
		urlParametersConf.add(new BasicNameValuePair("value", tileConfValueString));
		postConf.setEntity(new UrlEncodedFormEntity(urlParametersConf));
		clientConf.execute(postConf);

	}

	private void ResetAllData(String i) throws Exception {

		String url = "http://54.213.22.248:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("tile", "big_value"));
		urlParameters.add(new BasicNameValuePair("key", i));
		String tileDataString;
		JSONObject tileData = new JSONObject();
		tileData.put("title", "available");
		tileData.put("description", "");
		tileData.put("big-value", "");
		tileData.put("upper-left-label", "A/C type:  ");
		tileData.put("upper-left-value", "available");
		tileData.put("lower-left-label", "Tail #:  ");
		tileData.put("lower-left-value", "available");
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", "available");
		tileData.put("lower-right-label", "22");
		tileData.put("lower-right-value", "available");
		tileDataString = tileData.toString();
		urlParameters.add(new BasicNameValuePair("data", tileDataString));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		client.execute(post);

	}

	public void ResetDashboard() throws Exception {

		for (int i = 0; i < 4; i++) {
			try {
				ResetAllData(String.valueOf(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				ResetAllConf(String.valueOf(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
