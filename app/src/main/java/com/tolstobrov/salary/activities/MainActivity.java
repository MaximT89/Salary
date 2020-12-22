package com.tolstobrov.salary.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tolstobrov.salary.R;
import com.tolstobrov.salary.data.AppDatabase;
import com.tolstobrov.salary.data.SalaryRecord;
import com.tolstobrov.salary.di.App;
import com.tolstobrov.salary.services.NetworkService;
import com.tolstobrov.salary.utils.CurrentDate;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.widget.Toast.makeText;
import static com.tolstobrov.salary.R.id.btnDeleteById;
import static com.tolstobrov.salary.R.id.btnSaveRecord;
import static com.tolstobrov.salary.R.id.editIdForDelete;
import static com.tolstobrov.salary.R.id.editSalarySize;
import static com.tolstobrov.salary.R.id.text;

public class MainActivity extends AppCompatActivity {

    @BindView(value = text) TextView mTextView;
    @BindView(value = editSalarySize) EditText mEditSalarySize;
    @BindView(value = editIdForDelete) EditText mEditIdForDelete;

    AppDatabase db;

    @Inject
    NetworkService networkService;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App)getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mTextView.setText(networkService.getHello());

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "salary").build();
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(value = btnSaveRecord)
    void onSaveClick() {
        SalaryRecord salaryRecord = new SalaryRecord();

        salaryRecord.date = CurrentDate.getCurrentTimeStamp();
        salaryRecord.reason = "Зарплата";
        salaryRecord.sizeSalary = Integer.parseInt(mEditSalarySize.getText().toString());

        Completable.fromAction(() -> db.getSalaryDao().insert(salaryRecord))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
                    }
                });
    }

    @SuppressLint("NonConstantResourceId")
    @OnClick(value = btnDeleteById)
    void onClickDeleteById() {
        long id = Long.parseLong(mEditIdForDelete.getText().toString());

        SalaryRecord salaryRecord = new SalaryRecord();
        salaryRecord.id = id;

        Completable.fromAction(() -> db.getSalaryDao().delete(salaryRecord))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        makeText(getApplicationContext(), "Запись удалена", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show();
                    }
                });
    }
}