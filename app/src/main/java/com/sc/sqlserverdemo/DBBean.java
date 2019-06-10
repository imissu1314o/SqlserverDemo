package com.sc.sqlserverdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Admin on 2019/6/10.
 */

public class DBBean {
    Connection con = null;
    Statement stat = null;
    PreparedStatement pstat = null;
    ResultSet rs = null;

    //�޲����Ĺ��캯��
    public DBBean() {}

    //ȡ�����ݿ�����
    public Connection getCon(){
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            String user="sa";
            String pass="12345";
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + "120.77.223.235" + ":1433/" + "student_course" + ";charset=utf8", user, pass);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return con;
    }

    //ִ�����ݿ��ѯ�����ز�ѯ���
    public ResultSet query(String sql){
        try{
            con = getCon();
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }

    //ִ�����ݿ����
    public void update(String sql){
        try{
            con = getCon();
            stat = con.createStatement();
            stat.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //ִ�����ݿ����
    public void update(String sql,String[] args){
        try{
            con = getCon();
            pstat = con.prepareStatement(sql);
            for (int i=0;i<args.length;i++){
                pstat.setString(i+1,args[i]);
            }
            pstat.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //�ر����ݿ�����
    public void close(){
        try{
            if (rs != null)rs.close();
            if (stat != null)stat.close();
            if (pstat != null)pstat.close();
            if (con != null)con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
