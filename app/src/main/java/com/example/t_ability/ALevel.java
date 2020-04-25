package com.example.t_ability;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ALevel extends AppCompatActivity {

    Context context = this;
    EditText etHanjiA, etTailoA, etHuagiA;
    WebView webView;
    String url = "http://zxc11159030.byethost15.com/";
    CookieManager cookeManager;
    String cookieStr;
    ListView LVA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_level);


        //解android.os.NetworkOnMainThreadException問題
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedClosableObjects()
                .detectLeakedSqlLiteObjects()
                .penaltyDeath()
                .penaltyLog()
                .build());

        Wcookie(context);
        Handler myHandler = new Handler();
        myHandler.postDelayed(RunTimerStop, 15000);
        if (cookieStr != null) {
            myHandler.removeCallbacks(RunTimerStop);
        }
        //查詢資料
        Button btFindA=(Button)findViewById(R.id.btIdFindA);
        btFindA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select(etHanjiA.getText().toString());
                select(etHuagiA.getText().toString());
                select(etTailoA.getText().toString());
            }
        });
    }

    private void Wcookie(Context context) {
        CookieSyncManager.createInstance(context);
        cookeManager=CookieManager.getInstance();
        webView = new WebView(context);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                cookeManager.setAcceptCookie(true);
                cookieStr = cookeManager.getCookie(url);
            }
        });
        webView.loadUrl(url);
        webView.clearHistory();
        webView.clearCache(true);

        cookeManager.removeAllCookie();
        cookeManager.removeSessionCookie();
    }

    private Runnable RunTimerStop = new Runnable() {
        @Override
        public void run() {
            select(null);
        }
    };


    //顯示資料
    public void select(String id) {
        try {
            String r=DBphp.DBstring(id,cookieStr,url);
            JSONArray jsonArray=new JSONArray(r);
            List<Map<String,Object>> items=new ArrayList<Map<String, Object>>();

            for (int i =0;i<jsonArray.length();i++){
                JSONObject jsonData=jsonArray.getJSONObject(i);
                Map<String,Object> item=new HashMap<String, Object>();
                item.put("id",jsonData.getString("id"));
                item.put("Word",jsonData.getString("Word"));
                item.put("Pronunciation",jsonData.getString("Pronunciation"));
                item.put("Chinese",jsonData.getString("Chinese"));
                items.add(item); //新增到items
            }
            SimpleAdapter SA=new SimpleAdapter(context,items,R.layout.atansu,new String[]{"id","Word","Pronunciation","Chinese"},new int[]{R.id.tvIdIdA,R.id.tvIdWordA,R.id.tvIdPronunciationA,R.id.tvIdChineseA});
            LVA.setAdapter(SA);

        } catch (Exception e) {

            Log.e("log_tag=", e.toString());
        }
    }
}