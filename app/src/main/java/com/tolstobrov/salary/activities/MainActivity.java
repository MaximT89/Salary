package com.tolstobrov.salary.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.tolstobrov.salary.R;
import com.tolstobrov.salary.utils.CurrentDate;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.tolstobrov.salary.R.id.text;

public class MainActivity extends AppCompatActivity {

    @BindView(value = text) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mTextView.setText(CurrentDate.getCurrentTimeStamp());
    }
}