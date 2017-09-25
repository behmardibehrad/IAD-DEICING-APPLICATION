

package application.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import javafx.scene.input.DataFormat;

public class DashboardApi {

	private final String USER_AGENT = "Mozilla/5.0";
	private Flight flight;
	private Deicing deicing;
	private Spot spot;

	public DashboardApi(Flight flight, Deicing deicing, Spot spot) {

		this.flight = flight;
		this.deicing = deicing;
		this.spot = spot;
	}

	// HTTP POST request
	public void PostData() throws Exception {

		String url1 = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
		HttpClient client1 = new DefaultHttpClient();
		HttpPost post1 = new HttpPost(url1);
		post1.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters1 = new ArrayList<NameValuePair>();
		urlParameters1.add(new BasicNameValuePair("tile", "big_value"));
		urlParameters1.add(new BasicNameValuePair("key", spot.getApiTileID()));
		String tileDataString;
		JSONObject tileData = new JSONObject();
		tileData.put("title", flight.getCarrier().toUpperCase() + "  " + flight.getFlightNumber().replace("\n", "").replace("\r", ""));
		tileData.put("description", "Arrived at pad on : " + setTime1());
		tileData.put("big-value", flight.getCarrier().toUpperCase() + flight.getFlightNumber().replace("\n", "").replace("\r", ""));
		tileData.put("upper-left-label", "carrier:  ");
		tileData.put("upper-left-value", flight.getCarrier().toUpperCase().replace("\n", "").replace("\r", ""));
		tileData.put("second-upper-left-label", "A/C :  ");
		tileData.put("second-upper-left-value", flight.getAircraftType().toUpperCase().replace("\n", "").replace("\r", ""));
		tileData.put("lower-left-label", "Flight#:  ");
		tileData.put("lower-left-value", flight.getFlightNumber().replace("\n", "").replace("\r", ""));
		tileData.put("second-lower-left-label", "Tail #:  ");
		tileData.put("second-lower-left-value", flight.getTailNumber().toUpperCase().replace("\n", "").replace("\r", ""));
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", deicing.getStartTime());
		tileData.put("lower-right-label", "Fluid:  ");
		tileData.put("lower-right-value", deicing.getFluidType());
		tileDataString = tileData.toString();
		urlParameters1.add(new BasicNameValuePair("data", tileDataString));
		post1.setEntity(new UrlEncodedFormEntity(urlParameters1));
		client1.execute(post1);
		post1.abort();

	}

	public void PostConf() throws Exception {

		String urlConf = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/"
				+ spot.getApiTileID();
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
		postConf.abort();

	}

	public void ClearData() throws Exception {

		String url = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("tile", "big_value"));
		urlParameters.add(new BasicNameValuePair("key", spot.getApiTileID()));
		String tileDataString;
		JSONObject tileData = new JSONObject();
		tileData.put("title", "available");
		tileData.put("description", "");
		tileData.put("big-value", "");
		tileData.put("upper-left-label", "carrier:  ");
		tileData.put("upper-left-value", "");
		tileData.put("second-upper-left-label", "A/C :  ");
		tileData.put("second-upper-left-value", "");
		tileData.put("lower-left-label", "Flight#:  ");
		tileData.put("lower-left-value", "");
		tileData.put("second-lower-left-label", "Tail #:  ");
		tileData.put("second-lower-left-value", "");
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", "");
		tileData.put("lower-right-label", "Fluid:  ");
		tileData.put("lower-right-value", "");
		tileDataString = tileData.toString();
		urlParameters.add(new BasicNameValuePair("data", tileDataString));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		client.execute(post);
		post.abort();

	}

	public void ClearConf() throws Exception {

		String urlConf = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/"
				+ spot.getApiTileID();
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
		postConf.abort();

	}

	private void ResetAllConf(String i) throws Exception {

		String urlConf = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/tileconfig/" + i;
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
		postConf.abort();

	}

	private void ResetAllData(String i) throws Exception {

		String url = "http://52.35.148.5:7272/api/v0.1/d4c4119ab1a849b0b1b0cdd81e5739ac/push";
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
		tileData.put("upper-left-label", "carrier:  ");
		tileData.put("upper-left-value", "");
		tileData.put("second-upper-left-label", "A/C :  ");
		tileData.put("second-upper-left-value", "");
		tileData.put("lower-left-label", "Flight#:  ");
		tileData.put("lower-left-value", "");
		tileData.put("second-lower-left-label", "Tail #:  ");
		tileData.put("second-lower-left-value", "");
		tileData.put("upper-right-label", "start time:  ");
		tileData.put("upper-right-value", "");
		tileData.put("lower-right-label", "Fluid:  ");
		tileData.put("lower-right-value", "");
		tileDataString = tileData.toString();
		urlParameters.add(new BasicNameValuePair("data", tileDataString));
		post.setEntity(new UrlEncodedFormEntity(urlParameters));
		client.execute(post);
		post.abort();

	}

	public String setTime1() {
		String time = "";
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Calendar cal = Calendar.getInstance();
		time = dateFormat.format(cal.getTime());
		return time;

	}

	public void ResetDashboard() throws Exception {

		for (int i = 1; i < 11; i++) {
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