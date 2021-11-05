package com.henry.mvp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.henry.mvp.R;
import com.henry.mvp.interfaces.OperationPresenter;
import com.henry.mvp.interfaces.OperationView;
import com.henry.mvp.presenters.OperationPresenterImpl;


public class OperationActivyView extends AppCompatActivity implements OperationView {

    private EditText number1;
    private EditText number2;
    private TextView txtResult;
    private OperationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activy_operation);

        number1 = findViewById(R.id.txtNumber1);
        number2 = findViewById(R.id.txtNumber2);
        txtResult = findViewById(R.id.txtResult);
        presenter = new OperationPresenterImpl(this);

    }

    public void doAdd(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.add(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    public void doSubtract(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.subtract(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doMultiply(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.multiply(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doDivide(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.divide(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }

}