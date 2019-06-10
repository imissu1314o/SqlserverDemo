package com.sc.sqlserverdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );




        new Thread( new Runnable() {
            @Override
            public void run() {
                DBBean dbBean=new DBBean();
                Connection connection=dbBean.getCon();

            ResultSet resultSet=dbBean.query( "select * from shop" );
            try {
                while(resultSet.next()){
                    Log.d("1",resultSet.getString("sp_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        } ).start();




//        new Thread( new Runnable() {
//            @Override
//            public void run() {
//                String ret = DBUtil.QuerySQL();
//            }
//        } ).start();



    }
}
