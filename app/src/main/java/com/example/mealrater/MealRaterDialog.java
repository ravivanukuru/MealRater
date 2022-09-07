package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

class Student {
    int count = 0;
    String name = "";
    float rating;
}

public class MealRaterDialog extends DialogFragment {

    public interface SaveRatingListener {
        void didFinishMealRaterDialog(float rating, int count);

        void sendName(String name);
    }

    public MealRaterDialog() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.mealrater, container);

        getDialog().setTitle("Rate Meal");

        final RatingBar ratingBar = view.findViewById(R.id.ratingBar);
        Button button = view.findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                saveRating(rating);
            }
        });


        return view;
    }

    private void saveRating(float rating) {
        SaveRatingListener activity = (SaveRatingListener) getActivity();
        activity.didFinishMealRaterDialog(rating, 5);
        activity.sendName("Imad");
        getDialog().dismiss();
    }

}