package com.Gaurav.basicbankingapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.Gaurav.basicbankingapp.Database.UserContract.UserEntry;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;
    private static final String DATABASE_NAME = "User.db";
    private static final int DATABASE_VERSION = 1;
    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(9123,'Gaurav Tiwari', 'gtiwari912@gmail.com','9813','9970086264', 50000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9120,'Aman Sinha', 'aman@yahoo.com','9803','8043733257', 6000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8904,'Sohail Khan', 'sohail@hotmail.com','7445','9163527418', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8600,'Vijay Verma', 'vijay@gmail.com','7352','9904072235', 25000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8465,'Kamal Prasad', 'kamal@outlook.com','2643','9427835628', 3000)");
        db.execSQL("insert into " + TABLE_NAME + " values(8229,'Shivam Dubey', 'shivamd@gmail.com','9461','9367391085', 9500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8034,'Surya Kumar', 'kumar@gmail.com','6352','947293368', 45300)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Khushi Jain', 'khushi@gmail.com','4522','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7763,'Ritik Jain', 'ritik@gmail.com','4733','7366334764', 10000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7267,'Rohit Pal', 'rohit@gmail.com','5320','8453291201', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7056,'Ravi Teja', 'ranvi@gmail.com','4522','9499448736', 35000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6621,'Rohan Rai', 'rohan@gmail.com','9411','9372419565', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(6132,'Nisha Patil', 'nisha@gmail.com','9374','6293726253', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5241,'Ram Shukla', 'ram@gmail.com','3768','8943802746', 42000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4523,'Narend Singh', 'Narend@gmail.com','6632','7193971936', 8500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }


    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}