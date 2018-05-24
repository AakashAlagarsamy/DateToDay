package com.aakash.datetoday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText date, month, year;
    int dd,mm,yy;
    String dayvalue,d,m,y;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.calc);
        date = (EditText)findViewById(R.id.datevalue);
        month = (EditText)findViewById(R.id.monthvalue);
        year = (EditText)findViewById(R.id.yearvalue);
        text = (TextView)findViewById(R.id.day);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                d = date.getText().toString();
                m = month.getText().toString();
                y = year.getText().toString();
                dd = Integer.parseInt(d);
                mm = Integer.parseInt(m);
                yy = Integer.parseInt(y);
                dayvalue = Getdate(dd,mm,yy);
                text.setText("Day is "+dayvalue);

            }
        });
    }

    public String Getdate(int dd, int mm, int yy) {
        int m[]={0,3,3,6,1,4,6,2,5,0,3,5};
        int a=0,b,c=0,e,t,z;
        if(yy>=2000&&yy<2100)
        {
            a=6;
            c=yy-2000;
        }
        else if(yy>=1900&&yy<2000)
        {
            a=0;
            c=yy-1900;
        }
        else if(yy>=1800&&yy<1900)
        {
            a=2;
            c=yy-1800;
        }
        else if(yy>=1700&&yy<1800)
        {
            a=4;
            c=yy-1700;
        }
        else if(yy>=1600&&yy<1700)
        {
            a=6;
            c=yy-1600;
        }
        else if(yy>=2100&&yy<2200)
        {
            a=4;
            c=yy-2100;
        }
        else if(yy>=2200&&yy<2300)
        {
            a=2;
            c=yy-2200;
        }
        else if(yy>=2300&&yy<2400)
        {
            a=0;
            c=yy-2300;
        }
        b=m[mm-1];
        e=c/4;
        t=dd+a+b+c+e;
        z=t%7;
        switch(z)
        {
            case 1  :   return"Monday";
            case 2  :   return"Tuesday";
            case 3  :   return"Wednesday";
            case 4  :   return"Thursday";
            case 5  :   return"Friday";
            case 6  :   return"Saturday";
            default :   return "Sunday";
        }
    }


}
