package com.example.firstandroid;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mUsername;
    private EditText mKey;
    private Button mLogIn;
    private Button mSignIn;
    private ImageView mViewHead;
    private CheckBox mReKey;
    private SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("login");
        initView();
        initEvent();
    }

    private void initView(){
        mViewHead=findViewById(R.id.imageView);
        mUsername=findViewById(R.id.et_main_username);
        mKey=findViewById(R.id.et_main_password);
        mLogIn=findViewById(R.id.button_login);
        mSignIn=findViewById(R.id.button_signin);
        mReKey=(CheckBox) findViewById(R.id.et_main_remember);
    }
    private void initEvent(){
        mLogIn.setOnClickListener(this);
        mSignIn.setOnClickListener(this);
        mReKey.setOnClickListener(this);

    }
    private void login(){
        String username=mUsername.getText().toString();
        String password=mKey.getText().toString();
        if(username.equals("12345")&&password.equals("67890")){
            loginSuccess(username,password);
        }else loginFailure();
    }
    private void signin(){
        SignInActivity.startActivity(this);
    }


    @SuppressLint("WorldWriteableFiles")
    private void remember() {
// 会崩溃，所以注释掉了
//        sp=getSharedPreferences("keys", Context.MODE_WORLD_WRITEABLE);
//        SharedPreferences.Editor edit = sp.edit();
//        edit.putString("value",mKey.getText().toString().trim());
//        edit.commit();
//        String value = sp.getString("value","Null");
//        mKey.setText(value);

    }
    private void loginSuccess(String username,String password){
        Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();
        ContentActivity.startActivity(this,username,password);
    }

    private void loginFailure(){
        Toast.makeText(this,"账号或密码错误！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:
                login();
                break;
            case R.id.button_signin:
                signin();
                break;
            case R.id.et_main_remember:
                remember();
                break;

        }
    }


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LogInActivity.class);
        context.startActivity(intent);
    }

    private long mExitTime = 0L;
    /**
     * 以下为连按两次才能退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}