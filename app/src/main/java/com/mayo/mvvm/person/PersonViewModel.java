package com.mayo.mvvm.person;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by Mahayogi Lakshmipathi on 13/9/16.
 *
 * @author <a href="mailto:mygreymatter@gmail.com">Mahayogi Lakshmipathi</a>
 * @version 1.0
 */
public class PersonViewModel extends BaseObservable{
    private IPersonView iPersonView;

    public ObservableField<String> name;
    public ObservableField<String> description;

    public PersonViewModel(IPersonView view){
        this.iPersonView = view;

        name = new ObservableField<>();
        description = new ObservableField<>();
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override public void afterTextChanged(Editable s) {
            name.set(s.toString());
        }
    };

    public void onShowToastClicked(View v){
        iPersonView.showToast("Hello, " + name.get());
    }
}
