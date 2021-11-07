package org.arb.ecart.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.arb.ecart.R;

public class UserTypeActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout rl_wholesaler, rl_retailer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);

        rl_wholesaler = findViewById(R.id.rl_wholesaler);
        rl_retailer = findViewById(R.id.rl_retailer);

        rl_wholesaler.setOnClickListener(this);
        rl_retailer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_wholesaler:
                startActivity(new Intent(UserTypeActivity.this,RegisterActivity.class));
                break;
            case R.id.rl_retailer:
                startActivity(new Intent(UserTypeActivity.this,RegisterActivity.class));
                break;
            default:
                break;
        }
    }
}
