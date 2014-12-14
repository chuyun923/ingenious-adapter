package com.chuyun.example;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.chuyun.example.bean.StuDetailInfo;
import com.chuyun.example.bean.Student;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = ((ListView) findViewById(R.id.listview));
        listView.setAdapter(new AdapterExm(this,createTestDatas()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Object> createTestDatas() {
        List<Object> list = new ArrayList();
        Student student = new Student();
        student.setName("张三");
        student.setNickName("小三儿");

        StuDetailInfo stuDetailInfo = new StuDetailInfo();
        stuDetailInfo.setAge(19);
        stuDetailInfo.setHeight(175);
        stuDetailInfo.setSex(StuDetailInfo.Sex.MALE);
        stuDetailInfo.setWeight(65);
        for(int i=0;i<5;i++) {
            list.add(student);
            list.add(stuDetailInfo);
        }
        return list;
    }
}
