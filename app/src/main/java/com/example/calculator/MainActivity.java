package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button number1,number2,number3,number4,number5,number6,number7,number8,number9,number0, sum, mult, div, sub, clear, dot, bkspc, equal;
    private TextView expression, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startComponents();

        getSupportActionBar().hide();

        //recupera o evento apartir do contexto actual
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);

        mult.setOnClickListener(this);
        div.setOnClickListener(this);
        sub.setOnClickListener(this);
        sum.setOnClickListener(this);
        dot.setOnClickListener(this);

        clear.setOnClickListener(view -> {
            expression.setText("");
            result.setText("");
        });

        bkspc.setOnClickListener(view -> {
            TextView express = findViewById(R.id.textView_expression);
            String string = express.getText().toString();

            if(!string.isEmpty()){
                byte var0 = 0;
                int var1 = string.length() - 1;
                String txtExpress = string.substring(var0, var1);
                expression.setText(txtExpress);
            }
            result.setText("");
        });

        equal.setOnClickListener(view -> {
            try {
                Expression exp = new ExpressionBuilder(expression.getText().toString()).build();
                double res = exp.evaluate();
                long longResult = (long) res;

                if(res == (double) longResult){
                    result.setText((CharSequence) String.valueOf(longResult));
                } else {
                    result.setText((CharSequence) String.valueOf(res));
                }
            }catch (Exception e){

            }
        });
    }

    private void startComponents(){
        number0 = findViewById(R.id.button_zero);
        number1 = findViewById(R.id.button_1);
        number2 = findViewById(R.id.button_2);
        number3 = findViewById(R.id.button_3);
        number4 = findViewById(R.id.button_4);
        number5 = findViewById(R.id.button_5);
        number6 = findViewById(R.id.button_6);
        number7 = findViewById(R.id.button_7);
        number8 = findViewById(R.id.button_8);
        number9 = findViewById(R.id.button_9);

        dot = findViewById(R.id.button_dot);
        mult = findViewById(R.id.button_mult);
        sub = findViewById(R.id.button_sub);
        sum = findViewById(R.id.button_sum);
        div = findViewById(R.id.button_div);
        bkspc = findViewById(R.id.button_bkspc);
        equal = findViewById(R.id.button_equal);
        clear = findViewById(R.id.button_clear);

        expression = findViewById(R.id.textView_expression);
        result = findViewById(R.id.textView_result);
    }

    public void addExpression(String string, boolean clearExp){
        if(expression.getText().equals("")){
            expression.setText(" ");
        }
        if(clearExp){
            result.setText(" ");
            expression.append(string);
        }else{
            expression.append(result.getText());
            expression.append(string);
            result.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_zero:
                addExpression("0",true);
                break;
            case R.id.button_1:
                addExpression("1",true);
                break;
            case R.id.button_2:
                addExpression("2",true);
                break;
            case R.id.button_3:
                addExpression("3",true);
                break;
            case R.id.button_4:
                addExpression("4",true);
                break;
            case R.id.button_5:
                addExpression("5",true);
                break;
            case R.id.button_6:
                addExpression("6",true);
                break;
            case R.id.button_7:
                addExpression("7",true);
                break;
            case R.id.button_8:
                addExpression("8",true);
                break;
            case R.id.button_9:
                addExpression("9",true);
                break;
            case R.id.button_dot:
                addExpression(".",true);
                break;
            case R.id.button_div:
                addExpression("/",false);
                break;
            case R.id.button_mult:
                addExpression("*",false);
                break;
            case R.id.button_sub:
                addExpression("-",false);
                break;
            case R.id.button_sum:
                addExpression("+",false);
                break;
        }
    }
}