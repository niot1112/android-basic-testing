package cc.somkiat.basicunittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private EditText nameText, emailText;
    private TextView nameErr, emailErr;
    private String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.userNameInput);
        emailText = findViewById(R.id.emailInput);
        nameErr = findViewById(R.id.nameError);
        emailErr = findViewById(R.id.emailError);
    }

    public void onSaveClick(View view) {
        name = nameText.getText().toString();
        email = emailText.getText().toString();

        NameValidate nameValidate = new NameValidate();
        EmailValidate emailValidate = new EmailValidate();

        nameValidate.check(name);
        if(!nameValidate.check(name)){
            nameErr.setText(nameValidate.getErrMessage());
            nameErr.setVisibility(View.VISIBLE);
        }else {
            nameErr.setVisibility(View.GONE);
        }

        emailValidate.check(email);
        if(!emailValidate.check(email)){
            emailErr.setText(emailValidate.getErrMessage());
            emailErr.setVisibility(View.VISIBLE);
        }else {
            emailErr.setVisibility(View.GONE);
        }
    }

    public void onRevertClick(View view) {
        nameText.setText("");
        emailText.setText("");
        nameErr.setVisibility(View.GONE);
        emailErr.setVisibility(View.GONE);
    }
}
