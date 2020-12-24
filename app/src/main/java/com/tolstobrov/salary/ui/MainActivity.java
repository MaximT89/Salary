package com.tolstobrov.salary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tolstobrov.salary.R;
import com.tolstobrov.salary.database.SalaryDao;
import com.tolstobrov.salary.entity.SalaryRecord;
import com.tolstobrov.salary.App;
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

    @Inject
    SalaryDao salaryDao;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.app().getAppComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @SuppressLint({"NonConstantResourceId", "CheckResult"})
    @OnClick(value = btnSaveRecord)
    void onSaveClick() {
        SalaryRecord salaryRecord = new SalaryRecord();

        salaryRecord.date = CurrentDate.getCurrentTimeStamp();
        salaryRecord.reason = "Зарплата";
        salaryRecord.sizeSalary = Integer.parseInt(mEditSalarySize.getText().toString());

        Completable.fromAction(() -> salaryDao.insert(salaryRecord))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> makeText(getApplicationContext(), "Запись добавлена", Toast.LENGTH_LONG).show(),
                        throwable -> makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show());
    }

    @SuppressLint({"NonConstantResourceId", "CheckResult"})
    @OnClick(value = btnDeleteById)
    void onClickDeleteById() {
        long id = Long.parseLong(mEditIdForDelete.getText().toString());

        SalaryRecord salaryRecord = new SalaryRecord();
        salaryRecord.id = id;

        Completable.fromAction(() -> salaryDao.delete(salaryRecord))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> makeText(getApplicationContext(), "Запись удалена", Toast.LENGTH_LONG).show(),
                        throwable -> makeText(getApplicationContext(), "Ошибка", Toast.LENGTH_LONG).show());
    }
}