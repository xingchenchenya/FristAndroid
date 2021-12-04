package com.example.firstandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        context.startActivity(intent);
    }
    private TextView username;
    private TextView password;
    private TextView surePassword;
    private TextView number;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username =findViewById(R.id.et_sign_username);
        password =findViewById(R.id.et_sign_password);
        surePassword=findViewById(R.id.et_sign_password_again);
        number =findViewById(R.id.et_sign_number);
        signIn =findViewById(R.id.button_sign);
        getSupportActionBar().setTitle("sign in");
        signIn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String name= username.getText().toString();
        String pass= password.getText().toString();
        String supass= surePassword.getText().toString();
        String phone= number.getText().toString();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(SignInActivity.this,"用户名不能为空" ,Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(pass)){
            Toast.makeText(SignInActivity.this,"密码不能为空" ,Toast.LENGTH_SHORT).show();
            return;
        }if(TextUtils.isEmpty(phone)){
            Toast.makeText(SignInActivity.this,"电话不能为空" ,Toast.LENGTH_SHORT).show();
            return;
        }if(!TextUtils.equals(pass,supass)){
            Toast.makeText(this,"密码不一致，请重新输入",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pass)&&!TextUtils.isEmpty(phone)&&TextUtils.equals(pass,supass)){
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            LogInActivity.startActivity(this);
        }


    }



}