package com.Gaurav.basicbankingapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.Gaurav.basicbankingapp.R;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

   public void showAllUsers(View view) {
        Intent intent = new Intent(this, CustomerList.class);
        startActivity(intent);
    }

    public void showAllTransactions(View view) {
        Intent intent = new Intent(this, TransactionHistory.class);
        startActivity(intent);
    }

    public void about(View view){
        Intent intent = new Intent(this, infoActivity.class);
        startActivity(intent);
    }
}