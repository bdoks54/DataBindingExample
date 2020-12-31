package com.company.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;
import android.view.View;

import com.company.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        viewModel = new ViewModel();
        binding.setViewModel(viewModel);
        viewModel.title.set("Hello Android");   //String 타입이 아닌 ObservableField<String> 타입이기때문에 set 메서드로 설정
    }



    public static class ViewModel{
        private int count = 0;
        public ObservableField<String> title = new ObservableField<>();

        public void sayHello() {
            count++;
            title.set("안녕하세요. " + count + "번째 클릭입니다.");
        }
    }
}

