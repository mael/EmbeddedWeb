package info.mael.ew;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity
{
	private WebView wv;
	//The url  loaded 
	private static String url = "https://m.meneame.net";


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.main);
				
		wv = (WebView)findViewById(R.id.webkit);
		wv.setWebViewClient(new MyWebViewClient());
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setBuiltInZoomControls(true);

		wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		openUrl(url);
	}

	public void openUrl(String url)
	{
		wv.setInitialScale(100);
		wv.loadUrl(url);
	}

	private class MyWebViewClient extends WebViewClient 
	{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) 
		{
			view.loadUrl(url);
			return true;
		}
	}
}