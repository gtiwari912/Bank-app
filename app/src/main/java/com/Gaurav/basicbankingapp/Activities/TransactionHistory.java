package com.Gaurav.basicbankingapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.Gaurav.basicbankingapp.Database.TransactionContract;
import com.Gaurav.basicbankingapp.Database.TransactionHelper;
import com.Gaurav.basicbankingapp.Model.Transaction;
import com.Gaurav.basicbankingapp.Adapters.TransactionHistoryAdapter;
import com.Gaurav.basicbankingapp.R;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Transaction> transactionArrayList;
    private TransactionHelper dbHelper;

    TextView emptyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        emptyList = findViewById(R.id.empty_text);

        transactionArrayList = new ArrayList<Transaction>();

        dbHelper = new TransactionHelper(this);

        displayDatabaseInfo();

        recyclerView = findViewById(R.id.transactions_list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new TransactionHistoryAdapter(this, transactionArrayList);
        recyclerView.setAdapter(myAdapter);
    }

    private void displayDatabaseInfo() {
        Log.d("TAG", "displayDataBaseInfo()");
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Log.d("TAG", "displayDataBaseInfo()1");

        String[] projection = {
                TransactionContract.TransactionEntry.COLUMN_FROM_NAME,
                TransactionContract.TransactionEntry.COLUMN_TO_NAME,
                TransactionContract.TransactionEntry.COLUMN_AMOUNT,
                TransactionContract.TransactionEntry.COLUMN_STATUS
        };

        Log.d("TAG", "displayDataBaseInfo()2");

        Cursor cursor = db.query(
                TransactionContract.TransactionEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        try {
            int fromNameColumnIndex = cursor.getColumnIndex(TransactionContract.TransactionEntry.COLUMN_FROM_NAME);
            int ToNameColumnIndex = cursor.getColumnIndex(TransactionContract.TransactionEntry.COLUMN_TO_NAME);
            int amountColumnIndex = cursor.getColumnIndex(TransactionContract.TransactionEntry.COLUMN_AMOUNT);
            int statusColumnIndex = cursor.getColumnIndex(TransactionContract.TransactionEntry.COLUMN_STATUS);

            Log.d("TAG", "displayDataBaseInfo()3");

            while (cursor.moveToNext()) {
                String fromName = cursor.getString(fromNameColumnIndex);
                String ToName = cursor.getString(ToNameColumnIndex);
                int accountBalance = cursor.getInt(amountColumnIndex);
                int status = cursor.getInt(statusColumnIndex);

                transactionArrayList.add(new Transaction(fromName, ToName, accountBalance, status));
            }
        } finally {
            cursor.close();
        }

        if (transactionArrayList.isEmpty()) {
            emptyList.setVisibility(View.VISIBLE);
        } else {
            emptyList.setVisibility(View.GONE);
        }
    }
}