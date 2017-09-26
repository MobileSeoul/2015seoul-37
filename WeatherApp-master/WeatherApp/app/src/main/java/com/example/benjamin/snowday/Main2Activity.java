package com.example.benjamin.snowday;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.ui.view.OAuthLoginButton;

public class Main2Activity extends FragmentActivity {
    boolean m_close_flag = false;
    Handler m_close_handler = new Handler() {
        public void handleMessage(Message msg) {
            m_close_flag = false;
        }
    };

    private static final String TAG = "OAuthSampleActivity";
 private static  boolean check ;
    ImageButton imageButton;
    Button button;
    private static String at=null;
    private static String url= null;
    Button logout ;
    /**
     * client �젙蹂대�� �꽔�뼱以��떎.
     */
    private static String OAUTH_CLIENT_ID = "Kze6C6wCjvzndc0dhHEU";
    private static String OAUTH_CLIENT_SECRET = "TBED680yvZ";
    private static String OAUTH_CLIENT_NAME = "NaverOAuthSample";

    private static String accessToken=null;
    protected static OAuthLogin mOAuthLoginInstance;
    protected static Context mContext;
    private static boolean success;
    /** UI �슂�냼�뱾 */
    protected TextView mApiResultText;
    protected static TextView mOauthAT;
    protected static TextView mOauthRT;
    protected static TextView mOauthExpires;
    protected static TextView mOauthTokenType;
    protected static TextView mOAuthState;
    protected static TextView Login;

    protected static OAuthLoginButton mOAuthLoginButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* startActivity(new Intent(this, Splash.class));*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        logout = (Button)findViewById(R.id.buttonOAuthLogout);

        OAuthLoginDefine.DEVELOPER_VERSION = true;

        mContext = this;



        initData();
        initView();

        this.setTitle("OAuthLoginSample Ver." + OAuthLogin.getVersion());
        logout.setVisibility(View.GONE);

    }


    private void initData() {
        mOAuthLoginInstance = OAuthLogin.getInstance();

        mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME);
		/*
		 * 2015�뀈 8�썡 �씠�쟾�뿉 �벑濡앺븯怨� �빋 �젙蹂� 媛깆떊�쓣 �븞�븳 寃쎌슦 湲곗〈�뿉 �꽕�젙�빐以� callback intent url �쓣 �꽔�뼱以섏빞 濡쒓렇�씤�븯�뒗�뜲 臾몄젣媛� �븞�깮湲대떎.
		 * 2015�뀈 8�썡 �씠�썑�뿉 �벑濡앺뻽嫄곕굹 洹� �뮘�뿉 �빋 �젙蹂� 媛깆떊�쓣 �븯硫댁꽌 package name �쓣 �꽔�뼱以� 寃쎌슦 callback intent url �쓣 �깮�왂�빐�룄 �맂�떎.
		 */
        //mOAuthLoginInstance.init(mContext, OAUTH_CLIENT_ID, OAUTH_CLIENT_SECRET, OAUTH_CLIENT_NAME, OAUTH_callback_intent_url);
    }

    private void initView() {
        mApiResultText = (TextView) findViewById(R.id.api_result_text);

        mOauthAT = (TextView) findViewById(R.id.oauth_access_token);
        mOauthRT = (TextView) findViewById(R.id.oauth_refresh_token);
        mOauthExpires = (TextView) findViewById(R.id.oauth_expires);
        mOauthTokenType = (TextView) findViewById(R.id.oauth_type);
        mOAuthState = (TextView) findViewById(R.id.oauth_state);

        mOAuthLoginButton = (OAuthLoginButton) findViewById(R.id.buttonOAuthLoginImg);
        mOAuthLoginButton.setOAuthLoginHandler(mOAuthLoginHandler);

        updateView();
    }


    private void updateView() {
        mOauthAT.setText(mOAuthLoginInstance.getAccessToken(mContext));
        mOauthRT.setText(mOAuthLoginInstance.getRefreshToken(mContext));
        mOauthExpires.setText(String.valueOf(mOAuthLoginInstance.getExpiresAt(mContext)));
        mOauthTokenType.setText(mOAuthLoginInstance.getTokenType(mContext));
        mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
    }

    @Override
    protected void onResume() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onResume();
       //if(check == true) {

        if(check==true) {
            imageButton = (ImageButton) findViewById(R.id.buttonOAuthLoginImg);
            imageButton.setVisibility(View.GONE);
           /* button = (Button) findViewById(R.id.button);
            button.setVisibility(View.VISIBLE);
            logout.setVisibility(View.VISIBLE);
            Animation translate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate);




            button.startAnimation(translate);
*/
            Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다." , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Main2Activity.this, MainActivity1.class);
            startActivity(intent);

            check = false;







        }
        }


    public void button(View v){
        Intent intent = new Intent(Main2Activity.this, MainActivity1.class);
        startActivity(intent);

    }
    /**
     * startOAuthLoginActivity() �샇異쒖떆 �씤�옄濡� �꽆湲곌굅�굹, OAuthLoginButton �뿉 �벑濡앺빐二쇰㈃ �씤利앹씠 醫낅즺�릺�뒗 嫄� �븣 �닔 �엳�떎.
     */
    static protected OAuthLoginHandler mOAuthLoginHandler = new OAuthLoginHandler() {
        @Override
        public void run(boolean success) {
            if (success) {
                accessToken = mOAuthLoginInstance.getAccessToken(mContext);
                String refreshToken = mOAuthLoginInstance.getRefreshToken(mContext);
                long expiresAt = mOAuthLoginInstance.getExpiresAt(mContext);
                String tokenType = mOAuthLoginInstance.getTokenType(mContext);
                mOauthAT.setText(accessToken);
                mOauthRT.setText(refreshToken);
                mOauthExpires.setText(String.valueOf(expiresAt));
                mOauthTokenType.setText(tokenType);
                mOAuthState.setText(mOAuthLoginInstance.getState(mContext).toString());
                check = true;


            } else {
                String errorCode = mOAuthLoginInstance.getLastErrorCode(mContext).getCode();
                String errorDesc = mOAuthLoginInstance.getLastErrorDesc(mContext);
                Toast.makeText(mContext, "errorCode:" + errorCode + ", errorDesc:" + errorDesc, Toast.LENGTH_SHORT).show();
            }
        };
    };

    public void onButtonClick(View v) throws Throwable {

        switch (v.getId()) {
            case R.id.buttonOAuth: {
                mOAuthLoginInstance.startOauthLoginActivity(Main2Activity.this, mOAuthLoginHandler);
               /* imageButton = (ImageButton) findViewById(R.id.buttonOAuthLoginImg);
                imageButton.setVisibility(View.GONE);
                button = (Button) findViewById(R.id.button);
                button.setVisibility(View.VISIBLE);
                logout.setVisibility(View.VISIBLE);*/
                updateView();

                break;



            }

            case R.id.buttonOAuthLogout: {
                mOAuthLoginInstance.logout(mContext);
                updateView();
                imageButton.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                logout.setVisibility(View.GONE);
                button.clearAnimation();

                break;
            }

            default:
                break;
        }
    }


    private class DeleteTokenTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            boolean isSuccessDeleteToken = mOAuthLoginInstance.logoutAndDeleteToken(mContext);

            if (!isSuccessDeleteToken) {
                // �꽌踰꾩뿉�꽌 token �궘�젣�뿉 �떎�뙣�뻽�뼱�룄 �겢�씪�씠�뼵�듃�뿉 �엳�뒗 token �� �궘�젣�릺�뼱 濡쒓렇�븘�썐�맂 �긽�깭�씠�떎
                // �떎�뙣�뻽�뼱�룄 �겢�씪�씠�뼵�듃 �긽�뿉 token �젙蹂닿� �뾾湲� �븣臾몄뿉 異붽��쟻�쑝濡� �빐以� �닔 �엳�뒗 寃껋� �뾾�쓬
                Log.d(TAG, "errorCode:" + mOAuthLoginInstance.getLastErrorCode(mContext));
                Log.d(TAG, "errorDesc:" + mOAuthLoginInstance.getLastErrorDesc(mContext));
            }

            return null;
        }
        protected void onPostExecute(Void v) {
        updateView();
    }
}

    private class RequestApiTask extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            mApiResultText.setText((String) "");
        }
        @Override
        protected String doInBackground(Void... params) {
          url = "https://openapi.naver.com/v1/nid/getUserProfile.xml";
     at = mOAuthLoginInstance.getAccessToken(mContext);
            return mOAuthLoginInstance.requestApi(mContext, at, url);
        }
        protected void onPostExecute(String content) {
            mApiResultText.setText((String) content);
        }
    }

    private class RefreshTokenTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return mOAuthLoginInstance.refreshAccessToken(mContext);
        }
        protected void onPostExecute(String res) {
            updateView();
        }
    }

    public void onBackPressed ()
    {
        // m_close_flag 가 false 이면 첫번째로 키가 눌린 것이다.
        if(m_close_flag == false) { // Back 키가 첫번째로 눌린 경우

            // 안내 메세지를 토스트로 출력한다.
            Toast.makeText(this, "한번 더 누르시면 앱이 종료됩니다.", Toast.LENGTH_LONG).show();

            // 상태값 변경
            m_close_flag = true;

            // 핸들러를 이용하여 3초 후에 0번 메세지를 전송하도록 설정한다.
            m_close_handler.sendEmptyMessageDelayed(0, 3000);

        } else { // Back 키가 3초 내에 연달아서 두번 눌린 경우

            // 액티비티를 종료하는 상위 클래스의 onBackPressed 메소드를 호출한다.
            super.onBackPressed();
        }
    }

    protected void onStop()
    {
        super.onStop();

        // 핸드러에 등록된 0번 메세지를 모두 지운다.
        m_close_handler.removeMessages(0);
    }
}
