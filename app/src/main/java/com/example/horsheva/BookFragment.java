package com.example.horsheva;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.fragment.app.Fragment;

public class BookFragment extends Fragment {
    private Book mBook;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mReadedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBook = new Book(); // Создание нового объекта Book
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_book, container, false);

        mDateButton = v.findViewById(R.id.book_date);
        // Установка текста кнопки с датой
        mDateButton.setText(mBook.getDate() != null ? mBook.getDate() : "No date set");
        mDateButton.setEnabled(false);

        mTitleField = v.findViewById(R.id.book_title);
        // Добавление слушателя изменений текста
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Здесь намеренно оставлено пустое место
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBook.setTitle(s.toString()); // Обновление заголовка книги
            }

            @Override
            public void afterTextChanged(Editable s) {
                // И здесь тоже
            }
        });

        mReadedCheckBox = v.findViewById(R.id.book_readed);
        // Установка слушателя изменения состояния флажка
        mReadedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> mBook.setReaded(isChecked));

        return v;
    }
}