package org.arb.ecart.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.arb.ecart.Products.ProductHomeActivity;
import org.arb.ecart.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tv_register = findViewById(R.id.tv_register);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_register:
                startActivity(new Intent(RegisterActivity.this, ProductHomeActivity.class));
                break;
            default:
                break;
        }
    }
}
