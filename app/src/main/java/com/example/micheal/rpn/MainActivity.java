package com.example.micheal.rpn;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Iterator;

public class MainActivity extends Activity {

    private CalcNum currentNum;
    private ArrayDeque<CalcNum> stack;
    private Boolean justCalculated;
    private String tape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (isClicked) {
//            isClicked = false;
//            popUpWindow.showAtLocation(mainLayout, Gravity.BOTTOM, 10, 10);
//            popUpWindow.update(50, 50, 320, 90);
//        } else {
//            isClicked = true;
//            popUpWindow.dismiss();
//        }

        {
            tape = "0\n";
            justCalculated = false;
            stack = new ArrayDeque<>();
            currentNum = new CalcNum();
        }

        final View button_0 = findViewById(R.id.button_0);
        final View button_1 = findViewById(R.id.button_1);
        final View button_2 = findViewById(R.id.button_2);
        final View button_3 = findViewById(R.id.button_3);
        final View button_4 = findViewById(R.id.button_4);
        final View button_5 = findViewById(R.id.button_5);
        final View button_6 = findViewById(R.id.button_6);
        final View button_7 = findViewById(R.id.button_7);
        final View button_8 = findViewById(R.id.button_8);
        final View button_9 = findViewById(R.id.button_9);

        final View button_add = findViewById(R.id.button_add);
        final View button_backspace = findViewById(R.id.button_backspace);
        final View button_clear = findViewById(R.id.button_clear);
        final View button_decimal = findViewById(R.id.button_decimal);
        final View button_divide = findViewById(R.id.button_divide);
        final View button_enter = findViewById(R.id.button_enter);
        final View button_multiply = findViewById(R.id.button_multiply);
        final View button_negative = findViewById(R.id.button_negative);
        final View button_subtract = findViewById(R.id.button_subtract);
        final View button_swap = findViewById(R.id.button_swap);

        final TextView x_text = (TextView) findViewById(R.id.x_text);
        final TextView y_text = (TextView) findViewById(R.id.y_text);
        final TextView z_text = (TextView) findViewById(R.id.z_text);
        final TextView t_text = (TextView) findViewById(R.id.t_text);

        final View display_main = findViewById(R.id.display_main);

        final PopupWindow tape_disp = new PopupWindow(this);

        final LinearLayout containerLayout = new LinearLayout(this);
        final TextView tape_display_text = new TextView(this);
        tape_display_text.setText(tape);

        final LinearLayout.LayoutParams layout_params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        containerLayout.setOrientation(LinearLayout.VERTICAL);
        containerLayout.addView(tape_display_text, layout_params);
        tape_disp.setContentView(containerLayout);

        checkSize(stack);
        
        display_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tape_disp.isShowing()) {
                    tape_disp.dismiss();
                }
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("0");
                }
                else {
                    currentNum.buttonPress("0");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("1");
                }
                else {
                    currentNum.buttonPress("1");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("2");
                }
                else {
                    currentNum.buttonPress("2");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("3");
                }
                else {
                    currentNum.buttonPress("3");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("4");
                }
                else {
                    currentNum.buttonPress("4");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("5");
                }
                else {
                    currentNum.buttonPress("5");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("6");
                }
                else {
                    currentNum.buttonPress("6");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("7");
                }
                else {
                    currentNum.buttonPress("7");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("8");
                }
                else {
                    currentNum.buttonPress("8");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.setValString("9");
                }
                else {
                    currentNum.buttonPress("9");
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNum.changeDecimal();
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stores the value of currentNum in the stack; currentNum is cleared
                tapeOperandOperator("enter");
                stack.addFirst(new CalcNum(currentNum));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_enter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                tape_display_text.setText(tape);
                tape_disp.showAsDropDown(display_main);
                return true;
            }
        });

        button_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (justCalculated) {
                    currentNum.clearVal();
                }
                else {
                    currentNum.backspace();
                }
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // currentNum is cleared
                currentNum.clearVal();
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
                return true;
            }
        });

        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // divide; Z / Y --> Y'
                tapeOperandOperator("/");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Z.toDouble() / Y.toDouble()));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // multiply; Z * Y --> Y'
                tapeOperandOperator("*");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Z.toDouble() * Y.toDouble()));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_multiply.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // special function: Z^Y --> Y'
                tapeOperandOperator("^");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Math.pow(Z.toDouble(), Y.toDouble())));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
                return true;
            }
        });

        button_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // subtract; Z - Y --> Y'
                tapeOperandOperator("-");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Z.toDouble() - Y.toDouble()));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add; Z + Y --> Y'
                tapeOperandOperator("+");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Z.toDouble() + Y.toDouble()));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clear all; clear currentNum, clear stack
                tapeOperandOperator("clear");
                stack.clear();
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Swap the values of Y and Z; Y --> Z'; Z --> Y'
                tapeOperandOperator("swap");
                CalcNum Y = new CalcNum(stack.pollFirst());
                CalcNum Z = new CalcNum(stack.pollFirst());
                stack.addFirst(new CalcNum(Y));
                stack.addFirst(new CalcNum(Z));
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });

        button_swap.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // long click: the Y value is removed from the stack and put as the currentNum
                tapeOperandOperator("Y->X");
                CalcNum Y = new CalcNum(stack.pollFirst());
                currentNum.setVal(Y);
                justCalculated = true;
                tapeStack();
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
                return true;
            }
        });

        button_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentNum.changeNegative();
                justCalculated = false;
                updateDisplays(x_text, y_text, z_text, t_text, stack, currentNum);
            }
        });
    }

    private void dispCurrentNum(TextView textView, String newString) {
        textView.setText(newString);
    }

//    private void dispTape(String tape, PopupWindow popupWindow) {
//
//    }
//
//    private void dispCurrentNum(TextView textView, Double newDouble) {
//        textView.setText(String.valueOf(newDouble));
//    }

//    private void checkSize(TextView textView, Deque deque) {
//        while (deque.size() < 3) {
//            deque.addLast(new CalcNum());
//            numTimesAdded++;
//        }
//        textView.setText(String.valueOf(numTimesAdded));
//    }

    private void checkSize(ArrayDeque<CalcNum> deque) {
        while (deque.size() < 3) {
            deque.addLast(new CalcNum());
        }
    }

//    private void checkSize(ArrayDeque<CalcNum> deque, Integer minSize) {
//        while (deque.size() < minSize) {
//            deque.addLast(new CalcNum());
//        }
//    }

    private void updateDisplays(TextView textView1, TextView textView2, TextView textView3, TextView textView4, ArrayDeque<CalcNum> deque, CalcNum calcNum) {
        checkSize(deque);
        dispCurrentNum(textView1, calcNum.toString());
        Iterator iterator = deque.iterator();
        dispCurrentNum(textView2, iterator.next().toString());
        dispCurrentNum(textView3, iterator.next().toString());
        dispCurrentNum(textView4, iterator.next().toString());

    }

    private void tapeOperandOperator(String inputToken) {
        tape += inputToken + "\n";
    }

    private void tapeCurrent(String current) {
        tape += "Stack: [";
        if (current.length() > 0) {
            tape += current + ", ";
        }
        tapeStack();
    }

    private void tapeStack() {
        for (Object aStack : stack) {
            tape += aStack.toString() + ", ";
        }
        tape = tape.substring(0, tape.length() - 11);
        tape += "]\n";
    }
}
