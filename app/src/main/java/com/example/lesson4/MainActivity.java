package com.example.lesson4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button7, button8, button9, button1, button2, button3, button4, button5, button6, button0,btnPlus, btnMinus, btnMultilply;
    Button btnC, btnPlusMinus, btnTen, btnDivide, btnDot, btnDel,btnPercent;
    TextView tvSan, tvZapis;
    String birinshiSan, ekinshiSan, znak, zapisText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        sandarMethods();
        oshiruPlusMinusMethod();
        functionMethod();



    }
    public void initViews(){
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        button0 = findViewById(R.id.btn0);
        btnC = findViewById(R.id.btnC);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnDivide = findViewById(R.id.btn_divide);
        btnMultilply = findViewById(R.id.btn_multiply);
        btnPlusMinus = findViewById(R.id.btn_plusminus);
        btnTen = findViewById(R.id.btn_ten);
        btnDot = findViewById(R.id.btn_dot);
        btnDel = findViewById(R.id.btn_del);
        btnPercent = findViewById(R.id.btn_percent);

        tvSan = findViewById(R.id.tv_san);
        tvZapis = findViewById(R.id.tv_zapis);
    }
    public void sandarMethods(){
        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {

                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiRes = "";

                switch (view.getId()) {
                    case R.id.btn7:
                        basilganSan = "7";
                        break;

                    case R.id.btn0:
                        basilganSan = "0";
                        break;

                    case R.id.btn9:
                        basilganSan = "9";
                        break;

                    case R.id.btn8:
                        basilganSan = "8";
                        break;

                    case R.id.btn6:
                        basilganSan = "6";
                        break;

                    case R.id.btn5:
                        basilganSan = "5";
                        break;

                    case R.id.btn4:
                        basilganSan = "4";
                        break;

                    case R.id.btn3:
                        basilganSan = "3";
                        break;

                    case R.id.btn2:
                        basilganSan = "2";
                        break;

                    case R.id.btn1:
                        basilganSan = "1";
                        break;

                case R.id.btn_dot:
                  if(aldingiSan.contains(("."))){
                    basilganSan = "";
                  }else{
                    basilganSan = ".";
                  }
                break;
                case R.id.btn_del:
                  if(tvSan.length()>0) {
                    String deltxt = aldingiSan.substring(0, aldingiSan.length() - 1);
                    aldingiSan = deltxt;
                    basilganSan = "";
                  }
                break;
            }

                if (!aldingiSan.equals("0")) songiRes = aldingiSan + basilganSan;
                else songiRes = basilganSan;

                tvSan.setText(songiRes);
            }
        };


        button8.setOnClickListener(buttonSandar);
        button7.setOnClickListener(buttonSandar);
        button6.setOnClickListener(buttonSandar);
        button5.setOnClickListener(buttonSandar);
        button4.setOnClickListener(buttonSandar);
        button3.setOnClickListener(buttonSandar);
        button2.setOnClickListener(buttonSandar);
        button1.setOnClickListener(buttonSandar);
        button0.setOnClickListener(buttonSandar);
        button9.setOnClickListener(buttonSandar);
        btnTen.setOnClickListener(buttonSandar);
        btnDel.setOnClickListener(buttonSandar);
        btnDivide.setOnClickListener(buttonSandar);
        btnDot.setOnClickListener(buttonSandar);
        btnMultilply.setOnClickListener(buttonSandar);
        btnPlusMinus.setOnClickListener(buttonSandar);
        btnPercent.setOnClickListener(buttonSandar);
        btnPlus.setOnClickListener(buttonSandar);
    }
    public void oshiruPlusMinusMethod(){
        View.OnClickListener buttonCandPlusMinusDel = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btnC:
                        tvSan.setText("0");
                        tvZapis.setText("0");
                        break;
                    case R.id.btn_plusminus:
                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if (san > 0) tvSan.setText("-" + sanText);
                        else tvSan.setText(sanText);

                        break;
                }
            }
        };
        btnC.setOnClickListener(buttonCandPlusMinusDel);
        btnPlusMinus.setOnClickListener(buttonCandPlusMinusDel);
    }
    public void functionMethod(){
        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birinshiSan = tvSan.getText().toString();

                switch (view.getId()) {
                    case R.id.btn_plus:

                        znak = "+";

                        break;
                    case R.id.btn_minus:

                        znak = "-";

                        break;

                    case R.id.btn_multiply:

                        znak = "*";

                        break;

                    case R.id.btn_divide:

                        znak = "/";

                        break;
                    case R.id.btn_percent:
                        znak = "%";
                        break;

                }
                zapisText = birinshiSan + znak;
                tvZapis.setText(zapisText);
                tvSan.setText("0");
            }

        };

        btnPlus.setOnClickListener(btnFunctions);
        btnMinus.setOnClickListener(btnFunctions);
        btnDivide.setOnClickListener(btnFunctions);
        btnMultilply.setOnClickListener(btnFunctions);

        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekinshiSan = tvSan.getText().toString();
                int san1 = Integer.parseInt(birinshiSan);
                int san2 = Integer.parseInt(ekinshiSan);
                int res = 0;
                if (znak.equals("+")) {
                    res = san1 + san2;
                } else if (znak.equals("-")) {
                    res = san1 - san2;
                } else if (znak.equals("*")) {
                    res = san1 * san2;
                } else if (znak.equals("/")) {
                    res = san1 / san2;
                }else if(znak.equals("%")) {
                    res = san1 % san2;
                }


                zapisText = birinshiSan + znak + ekinshiSan + " = " + res;


                tvZapis.setText(zapisText);
                tvSan.setText("" + res);

            }
        });
    }
}
