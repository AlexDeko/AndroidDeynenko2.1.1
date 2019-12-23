package com.homework1_3.androiddeynenko211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputMoney;
    private EditText inputInfo;
    private CheckBox bankCardChkBx;
    private CheckBox mobilePhoneChkBx;
    private CheckBox cashAddressChkBx;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        resetCheckBoxes();
        getInfo();
    }

    private void getInfo() {
        Button button = findViewById(R.id.btnOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(inputMoney.getText().toString());
                String enter = getString(R.string.enter, value, info,
                        inputInfo.getText().toString());
                Toast.makeText(MainActivity.this, enter, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            bankCardChkBx.setChecked(true);
                            inputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            info = getString(R.string.bank_card_i);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mobilePhoneChkBx.setChecked(true);
                            inputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            info = getString(R.string.mobile_i);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            cashAddressChkBx.setChecked(true);
                            inputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            info = getString(R.string.cash_i);
                            break;
                        default:
                    }
                }
            }
        };
        inputMoney = findViewById(R.id.inputMoney);
        inputInfo = findViewById(R.id.inputInfo);
        bankCardChkBx = findViewById(R.id.bankCardChkBx);
        mobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        cashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        bankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        cashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes() {
        bankCardChkBx.setChecked(false);
        mobilePhoneChkBx.setChecked(false);
        cashAddressChkBx.setChecked(false);
    }
}
