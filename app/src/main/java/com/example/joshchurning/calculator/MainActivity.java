package com.example.joshchurning.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void changeOutput (String output){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(output);
    }

    public void buttonOnClickNUM(View view){
        String value = "";
       if (variables.operand == 0) {
               switch (view.getId()) {
                   case R.id.button0:
                       value = "0";
                       break;

                   case R.id.button1:
                       value = "1";
                       break;

                   case R.id.button2:
                       value = "2";
                       break;

                   case R.id.button3:
                       value = "3";
                       break;

                   case R.id.button4:
                       value = "4";
                       break;

                   case R.id.button5:
                       value = "5";
                       break;

                   case R.id.button6:
                       value = "6";
                       break;

                   case R.id.button7:
                       value = "7";
                       break;

                   case R.id.button8:
                       value = "8";
                       break;

                   case R.id.button9:
                       value = "9";
                       break;

                   case R.id.buttonDot:
                       Boolean containsDot = variables.leftSideS.contains(".");
                       if(containsDot){
                           break;
                       }
                       else{
                           value = ".";
                       }
                       break;
               }
               variables.leftSideS = variables.leftSideS + value;
               variables.output = variables.leftSideS;
               changeOutput(variables.output);
            }

       else {
           switch (view.getId()) {
               case R.id.button0:
                   value = "0";
                   break;

               case R.id.button1:
                   value = "1";
                   break;

               case R.id.button2:
                   value = "2";
                   break;

               case R.id.button3:
                   value = "3";
                   break;

               case R.id.button4:
                   value = "4";
                   break;

               case R.id.button5:
                   value = "5";
                   break;

               case R.id.button6:
                   value = "6";
                   break;

               case R.id.button7:
                   value = "7";
                   break;

               case R.id.button8:
                   value = "8";
                   break;

               case R.id.button9:
                   value = "9";
                   break;

               case R.id.buttonDot:
                   Boolean containsDot = variables.rightSideS.contains(".");
                   if(containsDot){
                       break;
                   }
                   else{
                       value = ".";
                   }
                   break;
           }
           if (value != ""){
               variables.rightSideS = variables.rightSideS + value;
               variables.output = variables.rightSideS;
               changeOutput(variables.output);
           }
       }

    }

    public void buttonOnClickCLR(View v){
        variables.leftSideS = "";
        variables.rightSideS = "";
        variables.leftSideF = 0;
        variables.rightSideF = 0;
        variables.operand = 0;
        variables.output = "";
        changeOutput(variables.output);
    }

    public void buttonOnClickOP(View v){

        if(variables.leftSideS != "") {

            switch (v.getId()) {

                case R.id.buttonADD:
                    variables.operand = 1;
                    break;

                case R.id.buttonSUB:
                    variables.operand = 2;
                    break;

                case R.id.buttonMULT:
                    variables.operand = 3;
                    break;

                case R.id.buttonDIV:
                    variables.operand = 4;
                    break;
            }

            variables.leftSideF = Float.parseFloat(variables.leftSideS);
            if (variables.rightSideS != "") {
                variables.rightSideF = Float.parseFloat(variables.rightSideS);

                switch (variables.operand) {
                    case 1: //ADD
                        variables.answer = variables.leftSideF + variables.rightSideF;
                        break;
                    case 2: //SUB
                        variables.answer = variables.leftSideF - variables.rightSideF;
                        break;
                    case 3: //MULT
                        variables.answer = variables.leftSideF * variables.rightSideF;
                        break;
                    case 4: //DIV
                        variables.answer = variables.leftSideF / variables.rightSideF;
                        break;
                }

                variables.leftSideF = variables.answer;
                variables.leftSideS = String.valueOf(variables.leftSideF);
                variables.rightSideF = 0;
                variables.rightSideS = "";
                variables.output = String.valueOf(variables.answer);
                changeOutput(variables.output);
            }
        }
    }
}
