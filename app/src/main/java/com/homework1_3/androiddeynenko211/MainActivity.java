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
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;
    private CheckBox checkedChangeListener;
    private String info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        resetCheckBoxes();
        Ok();


    }

    private void Ok(){
        Button button = findViewById(R.id.btnOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(mInputMoney.getText().toString());
                String enter = getString(R.string.enter, value, info,
                        mInputInfo.getText().toString());
                Toast.makeText(MainActivity.this, enter, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews(){
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            mBankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            info = getString(R.string.bank_card_i);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mMobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            info = getString(R.string.mobile_i);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            mCashAddressChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            info = getString(R.string.cash_i);
                            break;
                        default:
                    }
                }
            }
        };
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }



}
