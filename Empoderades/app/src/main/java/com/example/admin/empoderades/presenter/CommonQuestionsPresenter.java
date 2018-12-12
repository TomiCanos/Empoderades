package com.example.admin.empoderades.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.view.CommonQuestionsFragment.NewsSetter;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommonQuestionsPresenter {

    private List<News> newsFromDatabase;
    private NewsSetter newsSetter;
    private DatabaseReference firebaseDatabase;


    public CommonQuestionsPresenter(NewsSetter newsSetter) {
        this.newsSetter = newsSetter;
        newsFromDatabase = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

    }

    public void getNews() {
        ValueEventListener newsListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                newsFromDatabase = (List<News>) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("firebase", "loadPost:onCancelled", databaseError.toException());
            }
        };
        firebaseDatabase.addValueEventListener(newsListener);

    }

}
