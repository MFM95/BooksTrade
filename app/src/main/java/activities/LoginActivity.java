package activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mohamedfawzy.bookstrade.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button login_button = (Button) findViewById(R.id.b_login);
        Button facebook_button = (Button) findViewById(R.id.b_facebook);
        TextView signUp_link = (TextView) findViewById(R.id.tv_signupLink);


        signUp_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, signup_activity.class);
                startActivity(signUpIntent);
                finish();
                overridePendingTransition(R.anim.go_in, R.anim.go_out);
            }
        });

        assert login_button != null;
        login_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent signUpIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(signUpIntent);
        finish();
        overridePendingTransition(R.anim.go_in, R.anim.go_out);
    }
});

    }



}
