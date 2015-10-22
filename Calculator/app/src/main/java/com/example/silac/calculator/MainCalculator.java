package com.example.silac.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainCalculator extends AppCompatActivity {

    private TextView tv1, tv2;

    private Button back, clear, sign, division;
    private Button btn7, btn8, btn9, multiplication;
    private Button btn4, btn5, btn6, minus;
    private Button btn1, btn2, btn3, plus;
    private Button btn0, point, eq;

    static String ch = "o", numS = "0", tvs1, tvs2;
    static double num, numF, numB = 0;
    static boolean i = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);

        final Toast toast1m = Toast.makeText(getApplicationContext(), "Число должно быть меньше чем 2147483646", Toast.LENGTH_SHORT);
        final Toast toast1b = Toast.makeText(getApplicationContext(), "Число должно быть больше чем -2147483646", Toast.LENGTH_SHORT);
        final Toast toast2 = Toast.makeText(getApplicationContext(), "Недопустимая операция", Toast.LENGTH_SHORT);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        back = (Button) findViewById(R.id.back);
        clear = (Button) findViewById(R.id.clear);
        sign = (Button) findViewById(R.id.sign);
        division = (Button) findViewById(R.id.division);

        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        multiplication = (Button) findViewById(R.id.multiplication);

        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        minus = (Button) findViewById(R.id.minus);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        plus = (Button) findViewById(R.id.plus);

        btn0 = (Button) findViewById(R.id.btn0);
        point = (Button) findViewById(R.id.point);
        eq = (Button) findViewById(R.id.eq);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv2.getText().length() > 0) {
                    if (tv2.getText().length() == 1) {
                        tv2.setText(null);
                        numS = "0";
                    } else {
                        tvs2 = String.valueOf(tv2.getText());
                        tv2.setText(tvs2.substring(0, tv2.getText().length() - 1));
                        tvs2 = null;
                        numS = String.valueOf(tv2.getText());
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText(null);
                tv2.setText(null);
                numS = "0";
                numB = 0;
                numF = 0;
                num = 0;
                ch = "o";
                i = false;
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = Double.parseDouble(numS);
                num *= -1;
                if (num - (int) num == 0) {
                    tv2.setText(String.valueOf((int) num));
                } else {
                    tv2.setText(String.valueOf(num));
                }
                num = 0;
                numS = String.valueOf(tv2.getText());
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(numS) > 2147483646 || Double.parseDouble(numS) < -2147483646) {
                    if (Double.parseDouble(numS) > 214748364) {
                        toast1m.show();
                    } else {
                        toast1b.show();
                    }
                } else {
                    tvs1 = String.valueOf(tv1.getText());
                    if (tvs1.trim().length() > 0) {
                        ch = (tvs1.substring(tv1.getText().length() - 1));
                    }
                    tvs1 = null;
                    if (tv2.getText().length() > 0) {
                        if (tv1.getText().length() > 0) {
                            tv2.setText(null);
                            num = Double.parseDouble(numS);
                            if (ch.equals("+")) MainCalculator.plus(numB, num);
                            if (ch.equals("-")) MainCalculator.minus(numB, num);
                            if (ch.equals("*")) MainCalculator.multiply(numB, num);
                            if (ch.equals("/")) MainCalculator.share(numB, num);
                            if (i) {
                                toast2.show();
                                tv1.setText(null);
                                numS = "0";
                                numB = 0;
                                numF = 0;
                                num = 0;
                                ch = "o";
                                i = false;
                            } else {
                                if (numF - (int) numF != 0 && (numF > 9999999.89 || numF < -9999999.89)) {
                                    tv2.setText(null);
                                    tv1.setText(null);
                                    numS = "0";
                                    numB = 0;
                                    numF = 0;
                                    num = 0;
                                    toast2.show();
                                } else {
                                    if (numF - (int) numF != 0) {
                                        tv1.setText(Double.toString(numF) + " /");
                                    } else {
                                        tv1.setText(Integer.toString((int) numF) + " /");
                                    }
                                    numB = numF;
                                }
                            }
                        } else {
                            tv2.setText(null);
                            numB = Double.parseDouble(numS);
                            if (numB - (int) numB != 0) {
                                tv1.setText(Double.toString(numB) + " /");
                            } else {
                                tv1.setText(Integer.toString((int) numB) + " /");
                            }
                        }
                    }
                    ch = "o";
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "7");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "8");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "9");
                numS = String.valueOf(tv2.getText());
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(numS) > 2147483646 || Double.parseDouble(numS) < -2147483646) {
                    if (Double.parseDouble(numS) > 214748364) {
                        toast1m.show();
                    } else {
                        toast1b.show();
                    }
                } else {
                    tvs1 = String.valueOf(tv1.getText());
                    if (tvs1.trim().length() > 0) {
                        ch = (tvs1.substring(tv1.getText().length() - 1));
                    }
                    tvs1 = null;
                    if (tv2.getText().length() > 0) {
                        if (tv1.getText().length() > 0) {
                            tv2.setText(null);
                            num = Double.parseDouble(numS);
                            if (ch.equals("+")) MainCalculator.plus(numB, num);
                            if (ch.equals("-")) MainCalculator.minus(numB, num);
                            if (ch.equals("*")) MainCalculator.multiply(numB, num);
                            if (ch.equals("/")) MainCalculator.share(numB, num);
                            if (i) {
                                toast2.show();
                                tv1.setText(null);
                                numS = "0";
                                numB = 0;
                                numF = 0;
                                num = 0;
                                ch = "o";
                                i = false;
                            } else {
                                if (numF - (int) numF != 0 && (numF > 9999999.89 || numF < -9999999.89)) {
                                    tv2.setText(null);
                                    tv1.setText(null);
                                    numS = "0";
                                    numB = 0;
                                    numF = 0;
                                    num = 0;
                                    toast2.show();
                                } else {
                                    if (numF - (int) numF != 0) {
                                        tv1.setText(Double.toString(numF) + " *");
                                    } else {
                                        tv1.setText(Integer.toString((int) numF) + " *");
                                    }
                                    numB = numF;
                                }
                            }
                        } else {
                            tv2.setText(null);
                            numB = Double.parseDouble(numS);
                            if (numB - (int) numB != 0) {
                                tv1.setText(Double.toString(numB) + " *");
                            } else {
                                tv1.setText(Integer.toString((int) numB) + " *");
                            }
                        }
                    }
                    ch = "o";
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "4");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "5");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "6");
                numS = String.valueOf(tv2.getText());
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(numS) > 2147483646 || Double.parseDouble(numS) < -2147483646) {
                    if (Double.parseDouble(numS) > 214748364) {
                        toast1m.show();
                    } else {
                        toast1b.show();
                    }
                } else {
                    tvs1 = String.valueOf(tv1.getText());
                    if (tvs1.trim().length() > 0) {
                        ch = (tvs1.substring(tv1.getText().length() - 1));
                    }
                    tvs1 = null;
                    if (tv2.getText().length() > 0) {
                        if (tv1.getText().length() > 0) {
                            tv2.setText(null);
                            num = Double.parseDouble(numS);
                            if (ch.equals("+")) MainCalculator.plus(numB, num);
                            if (ch.equals("-")) MainCalculator.minus(numB, num);
                            if (ch.equals("*")) MainCalculator.multiply(numB, num);
                            if (ch.equals("/")) MainCalculator.share(numB, num);
                            if (i) {
                                toast2.show();
                                tv1.setText(null);
                                numS = "0";
                                numB = 0;
                                numF = 0;
                                num = 0;
                                ch = "o";
                                i = false;
                            } else {
                                if (numF - (int) numF != 0 && (numF > 9999999.89 || numF < -9999999.89)) {
                                    tv2.setText(null);
                                    tv1.setText(null);
                                    numS = "0";
                                    numB = 0;
                                    numF = 0;
                                    num = 0;
                                    toast2.show();
                                } else {
                                    if (numF - (int) numF != 0) {
                                        tv1.setText(Double.toString(numF) + " -");
                                    } else {
                                        tv1.setText(Integer.toString((int) numF) + " -");
                                    }
                                    numB = numF;
                                }
                            }
                        } else {
                            tv2.setText(null);
                            numB = Double.parseDouble(numS);
                            if (numB - (int) numB != 0) {
                                tv1.setText(Double.toString(numB) + " -");
                            } else {
                                tv1.setText(Integer.toString((int) numB) + " -");
                            }
                        }
                    }
                    ch = "o";
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "1");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "2");
                numS = String.valueOf(tv2.getText());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "3");
                numS = String.valueOf(tv2.getText());
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(numS) > 2147483646 || Double.parseDouble(numS) < -2147483646) {
                    if (Double.parseDouble(numS) > 214748364) {
                        toast1m.show();
                    } else {
                        toast1b.show();
                    }
                } else {
                    tvs1 = String.valueOf(tv1.getText());
                    if (tvs1.trim().length() > 0) {
                        ch = (tvs1.substring(tv1.getText().length() - 1));
                    }
                    tvs1 = null;
                    if (tv2.getText().length() > 0) {
                        if (tv1.getText().length() > 0) {
                            tv2.setText(null);
                            num = Double.parseDouble(numS);
                            if (ch.equals("+")) MainCalculator.plus(numB, num);
                            if (ch.equals("-")) MainCalculator.minus(numB, num);
                            if (ch.equals("*")) MainCalculator.multiply(numB, num);
                            if (ch.equals("/")) MainCalculator.share(numB, num);
                            if (i) {
                                toast2.show();
                                tv1.setText(null);
                                numS = "0";
                                numB = 0;
                                numF = 0;
                                num = 0;
                                ch = "o";
                                i = false;
                            } else {
                                if (numF - (int) numF != 0 && (numF > 9999999.89 || numF < -9999999.89)) {
                                    tv2.setText(null);
                                    tv1.setText(null);
                                    numS = "0";
                                    numB = 0;
                                    numF = 0;
                                    num = 0;
                                    toast2.show();
                                } else {
                                    if (numF - (int) numF != 0) {
                                        tv1.setText(Double.toString(numF) + " +");
                                    } else {
                                        tv1.setText(Integer.toString((int) numF) + " +");
                                    }
                                    numB = numF;
                                }
                            }
                        } else {
                            tv2.setText(null);
                            numB = Double.parseDouble(numS);
                            if (numB - (int) numB != 0) {
                                tv1.setText(Double.toString(numB) + " +");
                            } else {
                                tv1.setText(Integer.toString((int) numB) + " +");
                            }
                        }
                    }
                    ch = "o";
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv2.setText(tv2.getText() + "0");
                numS = String.valueOf(tv2.getText());
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numS.contains(".")) {
                    tv2.setText(tv2.getText() + ".");
                    numS = String.valueOf(tv2.getText());
                }
            }
        });
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Double.parseDouble(numS) > 2147483646 || Double.parseDouble(numS) < -2147483646) {
                    if (Double.parseDouble(numS) > 214748364) {
                        toast1m.show();
                    } else {
                        toast1b.show();
                    }
                } else {
                    tvs1 = String.valueOf(tv1.getText());
                    tvs2 = String.valueOf(tv2.getText());
                    if (tvs2.trim().length() > 0 && tvs1.trim().length() > 0) {
                        ch = (tvs1.substring(tv1.getText().length() - 1));
                        num = Double.parseDouble(numS);
                        if (ch.equals("+")) MainCalculator.plus(numB, num);
                        if (ch.equals("-")) MainCalculator.minus(numB, num);
                        if (ch.equals("*")) MainCalculator.multiply(numB, num);
                        if (ch.equals("/")) MainCalculator.share(numB, num);
                        if (i) {
                            toast2.show();
                            tv1.setText(null);
                            tv2.setText(null);
                            numS = "0";
                            numB = 0;
                            numF = 0;
                            num = 0;
                            ch = "o";
                            i = false;
                        } else {
                            if (numF - (int) numF != 0 && (numF > 9999999.89 || numF < -9999999.89)) {
                                tv2.setText(null);
                                tv1.setText(null);
                                numS = "0";
                                numB = 0;
                                numF = 0;
                                num = 0;
                                toast2.show();
                            } else {
                                if (numF - (int) numF != 0) {
                                /*numF = numF * 10000;
                                numF = (int) numF;
                                numF = numF / 10000;*/
                                    tv2.setText(Double.toString(numF));
                                } else {
                                    tv2.setText(Integer.toString((int) numF));
                                }
                                numS = String.valueOf(tv2.getText());
                                tv1.setText(null);
                                num = 0;
                                numB = 0;
                                i = false;
                            }
                        }
                        ch = "o";
                    }
                    tvs1 = null;
                    tvs2 = null;
                }
            }
        });
    }

    public static void plus(double x, double y) {
        numF = x + y;
    }

    public static void minus(double x, double y) {
        numF = x - y;
    }

    public static void multiply(double x, double y) {
        numF = x * y;
    }

    public static void share(double x, double y) {
        if (y != 0) {
            numF = x / y;
        } else {
            i = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
