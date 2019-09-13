package com.payzug.payzug;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    EditText name, course, semester, year;
    TextView resultDisplay;
    Button buttonPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        course = findViewById(R.id.course);
        semester = findViewById(R.id.semester);
        year = findViewById(R.id.year);
        resultDisplay = findViewById(R.id.resultDisplay);

        buttonPay = findViewById(R.id.buttonPay);

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String StrName = name.getText().toString().trim();
                 String StrCourse = course.getText().toString().trim();
                 String StrSemester = semester.getText().toString().trim();
                 String StrYear = year.getText().toString().trim();
                 Integer responseCode = 1;

               // generating the reference
               //int random = (int)(Math.random() * 99999 + 1);
               // String reference1 = Integer.toString(random);

                String name1 = "name=" + StrName;
                String course1 = "&course=" + StrCourse;
                String semester1 = "&semester=" + StrName;
                String year1 = "&year=" + StrYear;

                // End point address where to post the data
                // String url = "https://www.easypay.co.ug/api/"
                 String url = "https://smsvibe.com/iuea/easy.php?";

                 if(TextUtils.isEmpty(StrName)){
                     Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                     name.requestFocus();
                     return;
                 }
                 if (TextUtils.isEmpty(StrCourse)){
                     Toast.makeText(MainActivity.this, "Enter Course", Toast.LENGTH_SHORT).show();
                     course.requestFocus();
                     return;
                 }
                 if (TextUtils.isEmpty(StrSemester)){
                     Toast.makeText(MainActivity.this, "Enter Semester", Toast.LENGTH_SHORT).show();
                     semester.requestFocus();
                     return;
                 }

                if (TextUtils.isEmpty(StrYear)){
                    Toast.makeText(MainActivity.this, "Enter Year", Toast.LENGTH_SHORT).show();
                    year.requestFocus();
                    return;
                }



                try{

                    // Send data
                    HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
                    String data = name1 + course1 + semester1 + year1;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    responseCode = conn.getResponseCode();

                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();

                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();
                   // return stringBuffer.toString();
                    Toast.makeText(getApplicationContext(), "User registration Success: ", Toast.LENGTH_LONG).show();
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error here : " + e.getMessage() , Toast.LENGTH_LONG).show();

                }

                resultDisplay.setText(" Name: " + StrName + " Course : " + StrCourse + " Semester : " + StrSemester + " Year: " + StrYear + " Response Code : " + responseCode);

                }





        });


       StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
       StrictMode.setThreadPolicy(policy);
    }
}
