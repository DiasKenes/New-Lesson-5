package com.example.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button  btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnNukte;
    Button  btnOshiru, btnPlusMinus, btndel;
    Button  btnPlus, btnMinus, btnX, btnBolu,  btnTen;
    TextView tvSan, tvzapis;


    String BirinshiSan, ekinshiSan,  znak, zapisText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnNukte = findViewById(R.id.btn_dot);

        btnOshiru = findViewById(R.id.btnC);
        btnPlusMinus = findViewById(R.id.btn_plusminus);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnX = findViewById(R.id.btn_multiply);
        btnBolu = findViewById(R.id.btn_divide);
        btnTen = findViewById(R.id.btn_ten);
        btndel = findViewById(R.id.btn_del);




        tvSan = findViewById(R.id.tv_san);
        tvzapis = findViewById(R.id.tv_zapis);


        View.OnClickListener buttonSandar = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String aldingiSan = tvSan.getText().toString();
                String basilganSan = "";
                String songiResult = "";
                switch (view.getId()){
                    case R.id.btn0:
                        basilganSan = "0";
                        break;
                    case R.id.btn1:
                        basilganSan = "1";
                        break;
                    case R.id.btn2:
                        basilganSan = "2";
                        break;
                    case R.id.btn3:
                        basilganSan = "3";
                        break;
                    case R.id.btn4:
                        basilganSan = "4";
                        break;
                    case R.id.btn5:
                        basilganSan = "5";
                        break;
                    case R.id.btn6:
                        basilganSan = "6";
                        break;
                    case R.id.btn7:
                        basilganSan = "7";
                        break;
                    case R.id.btn8:
                        basilganSan = "8";
                        break;
                    case R.id.btn9:
                        basilganSan = "9";
                        break;
                    case R.id.btn_dot:
                        if (aldingiSan.contains(".")){
                            basilganSan = "";
                        }else{
                            basilganSan = ".";
                        }

                        break;
                }
                if (!aldingiSan.equals("0")) songiResult = aldingiSan + basilganSan;
                else songiResult = basilganSan;
                tvSan.setText(songiResult);
            }
        };
        btn0.setOnClickListener(buttonSandar);
        btn1.setOnClickListener(buttonSandar);
        btn2.setOnClickListener(buttonSandar);
        btn3.setOnClickListener(buttonSandar);
        btn4.setOnClickListener(buttonSandar);
        btn5.setOnClickListener(buttonSandar);
        btn6.setOnClickListener(buttonSandar);
        btn7.setOnClickListener(buttonSandar);
        btn8.setOnClickListener(buttonSandar);
        btn9.setOnClickListener(buttonSandar);
        btnNukte.setOnClickListener(buttonSandar);
        View.OnClickListener buttonOwiruPlusMinus = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnC:
                        tvSan.setText("0");
                        break;

                    case R.id.btn_plusminus:

                        String sanText = tvSan.getText().toString();
                        int san = Integer.parseInt(sanText);

                        if(san > 0) tvSan.setText("-"+sanText);

                        else{
                            san = san * (-1);
                            tvSan.setText(""+san);
                        }


                        break;
                }

            }
        };

        btnOshiru.setOnClickListener(buttonOwiruPlusMinus);
        btnPlusMinus.setOnClickListener(buttonOwiruPlusMinus);


        View.OnClickListener btnFunctions = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BirinshiSan = tvSan.getText().toString();
                switch (view.getId()){

                    case R.id.btn_plus:
                        znak = "+";
                        break ;

                    case R.id.btn_minus:
                        znak = "-";
                        break ;

                    case R.id.btn_multiply:
                        znak = "*";
                        break ;

                    case R.id.btn_divide:
                        znak = "/";
                        break ;

                }

                zapisText = BirinshiSan + znak;
                tvzapis.setText(zapisText);
                tvSan.setText("0");


            }
        };
        View.OnClickListener button_C_Dell = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                switch (view.getId()){
                    case R.id.btnC:
                        tvSan.setText("0");
                        tvzapis.setText("0");

                        break;
                    case R.id.btn_del:
                        String sanText = tvSan.getText().toString();
                        int sanInt = Integer.parseInt(sanText);
                        int sanIntC = sanInt / 10;
                        int sanIntSony = sanInt-sanIntC;
                        tvSan.setText(""+sanIntC);
                        break;
                }
            }
        };
        btnOshiru.setOnClickListener(button_C_Dell);
        btndel.setOnClickListener(button_C_Dell);



        btnPlus.setOnClickListener(btnFunctions) ;
        btnMinus.setOnClickListener(btnFunctions);
        btnX.setOnClickListener(btnFunctions);
        btnBolu.setOnClickListener(btnFunctions);







        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ekinshiSan= tvSan.getText().toString();
                double res = 0;
                if(zapisText.contains(".")){
                    double san1 = Double.parseDouble(BirinshiSan);
                    double san2 = Double.parseDouble(ekinshiSan);
                    if(znak.equals("+")){
                        res = san1+san2;
                    }
                    else if(znak.equals("-")){
                        res = san1-san2;
                    }
                    else if(znak.equals("*")){
                        res = san1*san2;
                    }
                    else if(znak.equals("/")) {
                        res = san1 / san2;
                    }
                }
                else{
                    int san1 = Integer.parseInt(BirinshiSan);
                    int san2 = Integer.parseInt(ekinshiSan);
                    if (znak.equals("+")){
                        res = san1 + san2;
                    }else if (znak.equals("-")){
                        res = san1 - san2;
                    }else if (znak.equals("*")){
                        res = san1 * san2;
                    }else if (znak.equals("/")){
                        res = san1 / san2;

                    }
                }







                zapisText = BirinshiSan + znak + ekinshiSan + " = "+res;
                tvzapis.setText(zapisText);
                tvSan.setText(""+res);
            }
        });
    }
}