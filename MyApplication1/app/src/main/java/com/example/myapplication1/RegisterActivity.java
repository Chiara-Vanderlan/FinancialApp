package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextRegisterFullName, editTextRegisterEmail, editTextRegisterDOB, editTextRegisterMobile, editTextRegisterPwd, editTextRegisterConfirmPwd;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");

        Toast.makeText(RegisterActivity.this,"You can Register now", Toast.LENGTH_LONG).show();

        editTextRegisterFullName = findViewById(R.id.editText_register_full_name);
        editTextRegisterEmail = findViewById(R.id.editText_register_email);
        editTextRegisterDOB = findViewById(R.id.editText_register_dob);
        editTextRegisterMobile = findViewById(R.id.editText_register_mobile);
        editTextRegisterPwd = findViewById(R.id.editText_register_password);
        editTextRegisterConfirmPwd = findViewById(R.id.editText_register_confirm_password);


        //radiobutton for gender
        radioGroupRegisterGender = findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //obtain the entered data

                String textFullName = editTextRegisterFullName.getText().toString();
                String textEmail =editTextRegisterEmail.getText().toString();
                String textDoB = editTextRegisterDOB.getText().toString();
                String textMobile = editTextRegisterMobile.getText().toString();
                String textPwd = editTextRegisterPwd.getText().toString();
                String textConfirmPwd = editTextRegisterConfirmPwd.getText().toString();

                String textGender;  //cant obtain the value befor verifying if any button was selected or not

                if (TextUtils.isEmpty(textFullName)){
                    Toast.makeText(RegisterActivity.this,"Please enter your full name", Toast.LENGTH_LONG).show();
                    editTextRegisterFullName.setError("Full Name is required");
                    editTextRegisterFullName.requestFocus();
                }else if (TextUtils.isEmpty(textEmail)){
                    Toast.makeText(RegisterActivity.this,"Please enter your email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Email is required");
                    editTextRegisterEmail.requestFocus();
                }else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(RegisterActivity.this,"Please re-enter your email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Valid Email is required");
                    editTextRegisterEmail.requestFocus();
                }else if (TextUtils.isEmpty(textDoB)){
                    Toast.makeText(RegisterActivity.this,"Please enter your Date of Birth", Toast.LENGTH_LONG).show();
                    editTextRegisterDOB.setError("Date of Birth is required");
                    editTextRegisterDOB.requestFocus();
                } else if (radioGroupRegisterGender.getCheckedRadioButtonId() ==-1) {
                    Toast.makeText(RegisterActivity.this,"Please Select your Gender", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gender is required");
                    radioButtonRegisterGenderSelected.requestFocus();
                }else if (TextUtils.isEmpty(textMobile)){
                    Toast.makeText(RegisterActivity.this,"Please enter your mobile no", Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile no. is required");
                    editTextRegisterMobile.requestFocus();
                }else if (textMobile.length() != 10){
                    Toast.makeText(RegisterActivity.this,"Please re-enter your mobile no", Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile no. should be 10 digits");
                    editTextRegisterMobile.requestFocus();
                }else if (TextUtils.isEmpty(textPwd)){
                    Toast.makeText(RegisterActivity.this,"Please Enter your Password", Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.setError("Password is Required ");
                    editTextRegisterPwd.requestFocus();
                }else if (textPwd.length() < 6){
                    Toast.makeText(RegisterActivity.this,"Password should be at least 6 digits", Toast.LENGTH_LONG).show();
                    editTextRegisterPwd.setError("Password is weak ");
                    editTextRegisterPwd.requestFocus();
                }else if (TextUtils.isEmpty(textConfirmPwd)){
                    Toast.makeText(RegisterActivity.this,"Please Enter your confirm Password", Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPwd.setError("Confirm Password is Required ");
                    editTextRegisterConfirmPwd.requestFocus();
                } else if (!textPwd.equals((textConfirmPwd))) {
                    Toast.makeText(RegisterActivity.this,"Please Enter same Password", Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPwd.setError("Password confirmation is Required ");
                    editTextRegisterConfirmPwd.requestFocus();
                    //Clear the entered passwords
                    editTextRegisterPwd.clearComposingText();
                    editTextRegisterConfirmPwd.clearComposingText();
                }else {
                    textGender = radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(textFullName, textEmail, textDoB, textGender, textMobile, textPwd);
                }
            }
        });
    }
    // Register user using the credentials given
    private void registerUser(String textFullName, String textEmail, String textDoB, String textGender, String textMobile, String textPwd) {
    }
}