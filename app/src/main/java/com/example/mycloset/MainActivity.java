package com.example.mycloset;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.GridView;

import com.example.mycloset.R;
import com.example.mycloset.db.DBAdapter;
import com.example.mycloset.db.DBHandler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHelper;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridView = (GridView) findViewById(R.id.activity_main_grid_view);
        this.dbHelper = new DBHandler(this);
        this.gridView.setAdapter(new DBAdapter(this, this.dbHelper.location(), false));
        this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.location());
    }

    public void addNewMemory(View view) {
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);
    }
}
