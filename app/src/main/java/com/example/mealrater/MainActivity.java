package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MealRaterDialog.SaveRatingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRatingButton();

    }

    private void initRatingButton() {
        Button button = findViewById(R.id.ratebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                MealRaterDialog mealRaterDialog = new MealRaterDialog();
                mealRaterDialog.show(fragmentManager, "RateMeal");
            }
        });
    }

    @Override
    public void didFinishMealRaterDialog(float rating, int x) {
        TextView textView = findViewById(R.id.userrating);
        textView.setText(String.valueOf(rating));
    }

    @Override
    public void sendName(String name) {

    }
}