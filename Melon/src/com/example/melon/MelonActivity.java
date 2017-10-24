package com.example.melon;
/*
 * 
 */
import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.skp.openplatform.android.sdk.api.APIRequest;
import com.skp.openplatform.android.sdk.common.BaseActivity;
import com.skp.openplatform.android.sdk.common.PlanetXSDKConstants.CONTENT_TYPE;
import com.skp.openplatform.android.sdk.common.PlanetXSDKConstants.HttpMethod;
import com.skp.openplatform.android.sdk.common.PlanetXSDKException;
import com.skp.openplatform.android.sdk.common.RequestBundle;
import com.skp.openplatform.android.sdk.common.RequestListener;
import com.skp.openplatform.android.sdk.common.ResponseMessage;

public class MelonActivity extends BaseActivity {

	//API Call
	APIRequest api;
	RequestBundle requestBundle;
	
	// Comm Data
	String URL = "http://apis.skplanetx.com/melon/newreleases/songs";
	String AppKey="407cecc5-dacd-316e-bf86-1d1c0170c344";
	
	Map<String, Object> param;
	
	//UI
	TextView tvResult;
	Button button1;
	
	String resultString;
	Handler msgHandler = new Handler(){
		public void dispatchMessage(Message msg) {
			setResult(resultString);
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_melon);
		
		tvResult=(TextView)findViewById(R.id.text);
		button1=(Button)findViewById(R.id.btn1);
		ClickListener click = new ClickListener();
		button1.setOnClickListener(click);
		
		APIRequest.setAppKey(AppKey);
		
		api = new APIRequest();
		initRequestBundle();
	}
	
	private class ClickListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			setResult("skdltm");
			resultSync();
		}
	}
	
	public void initRequestBundle()
	{
		param = new HashMap<String, Object>();
		param.put("version", 1);
		param.put("page", 1);
		param.put("count", 1);
		
		requestBundle = new RequestBundle();
		requestBundle.setUrl(URL);
		requestBundle.setParameters(param);
		requestBundle.setHttpMethod(HttpMethod.GET);
		requestBundle.setResponseType(CONTENT_TYPE.XML);
	}
	
	public void resultSync()
	{
		api = new APIRequest();
		initRequestBundle();
		
		ResponseMessage result = new ResponseMessage();
		try {
			result = api.request(requestBundle);
			resultString = result.getStatusCode() + "\n" + result.toString() + "\n";
			
			setResult(resultString);
		} catch (PlanetXSDKException e) {
			setResult(e.toString());
		}
	}
	
	public void setResult(String result)
	{
		tvResult.setText(result);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.melon, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
