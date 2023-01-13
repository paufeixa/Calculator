package edu.upc.feixa.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String op = "";
    String op1 = "";
    String op2 = "";
    double factor = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        switch (view.getId()) {
            case R.id.button0:
                op2=op2+"0";
                showDisplay(op2);
                break;
            case R.id.button1:
                op2=op2+"1";
                showDisplay(op2);
                break;
            case R.id.button2:
                op2=op2+"2";
                showDisplay(op2);
                break;
            case R.id.button3:
                op2=op2+"3";
                showDisplay(op2);
                break;
            case R.id.button4:
                op2=op2+"4";
                showDisplay(op2);
                break;
            case R.id.button5:
                op2=op2+"5";
                showDisplay(op2);
                break;
            case R.id.button6:
                op2=op2+"6";
                showDisplay(op2);
                break;
            case R.id.button7:
                op2=op2+"7";
                showDisplay(op2);
                break;
            case R.id.button8:
                op2=op2+"8";
                showDisplay(op2);
                break;
            case R.id.button9:
                op2=op2+"9";
                showDisplay(op2);
                break;
            case R.id.button10:
                if (op!="" && op1!="" && op2!="")
                {
                    operation();
                    op2=op1;
                    op="";
                }
                if (op1!="")
                {
                    op2=op1;
                    op1="";
                }
                showDisplay(op2);
                break;
            case R.id.button11:
                op1="";
                op="";
                op2="";
                showDisplay(op2);
                break;
            case R.id.button12:
                switchState();
                if (op!="" && op1!="")
                {
                    if (op2!="")
                    {
                        operation();
                        op="";
                        op2=String.valueOf(Math.sin(Double.valueOf(op1)*factor));
                    }
                    else
                    {
                        op2=String.valueOf(Math.sin(Double.valueOf(op1)*factor));
                    }
                }
                else if (op2!="")
                {
                    op2=String.valueOf(Math.sin(Double.valueOf(op2)*factor));
                }
                showDisplay(op2);
                break;
            case R.id.button13:
                switchState();
                if (op!="" && op1!="")
                {
                    if (op2!="")
                    {
                        operation();
                        op="";
                        op2=String.valueOf(Math.cos(Double.valueOf(op1)*factor));
                    }
                    else
                    {
                        op2=String.valueOf(Math.cos(Double.valueOf(op1)*factor));
                    }
                }
                else if (op2!="")
                {
                    op2=String.valueOf(Math.cos(Double.valueOf(op2)*factor));
                }
                showDisplay(op2);
                break;
            case R.id.button14:
                switchState();
                if (op!="" && op1!="")
                {
                    if (op2!="")
                    {
                        operation();
                        op="";
                        op2=String.valueOf(Math.tan(Double.valueOf(op1)*factor));
                    }
                    else
                    {
                        op2=String.valueOf(Math.tan(Double.valueOf(op1)*factor));
                    }
                }
                else if (op2!="")
                {
                    op2=String.valueOf(Math.tan(Double.valueOf(op2)*factor));
                }
                showDisplay(op2);
                break;
            case R.id.button15:
                op = "+";
                if (op!="" && op2!="") {
                    if (op1!="") {
                        operation();
                    }
                    else
                    {
                        op1 = op2;
                    }
                }
                op2 = "";
                showDisplay(op2);
                break;
            case R.id.button16:
                op = "-";
                if (op!="" && op2!="") {
                    if (op1!="") {
                        operation();
                    }
                    else
                    {
                        op1 = op2;
                    }
                }
                op2 = "";
                showDisplay(op2);
                break;
            case R.id.button17:
                op = "*";
                if (op!="" && op2!="") {
                    if (op1!="") {
                        operation();
                    }
                    else
                    {
                        op1 = op2;
                    }
                }
                op2 = "";
                showDisplay(op2);
                break;
            case R.id.button18:
                op = "/";
                if (op!="" && op2!="") {
                    if (op1!="") {
                        operation();
                    }
                    else
                    {
                        op1 = op2;
                    }
                }
                op2 = "";
                showDisplay(op2);
                break;
        }
    }

    public void switchState() {
        Switch degRad = (Switch)findViewById(R.id.switch1);
        if (degRad.isChecked()){
            factor=Math.PI/180;
        }
        else{
            factor=1;
        }
    }

    public void showDisplay(String result) {
        TextView textView = (TextView)findViewById(R.id.display);
        textView.setText(result);
    }

    public String operation(){
        double ope1= Double.parseDouble(op1);
        double ope2= Double.parseDouble(op2);
        double result=0;
        if (op=="+")
        {
            result = ope1+ope2;
        }
        if (op=="-")
        {
            result = ope1-ope2;
        }
        if (op=="*")
        {
            result = ope1*ope2;
        }
        if (op=="/")
        {
            result = ope1/ope2;
        }
        op1=String.valueOf(result);
        op2="";
        return String.valueOf(result);
    }
}