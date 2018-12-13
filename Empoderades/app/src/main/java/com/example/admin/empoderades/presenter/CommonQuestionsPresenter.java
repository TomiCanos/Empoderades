package com.example.admin.empoderades.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.example.admin.empoderades.model.CommonQuestion;
import com.example.admin.empoderades.retrofit.ResultListener;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class CommonQuestionsPresenter {

    private List<CommonQuestion> commonQuestionsFromDatabase;
    private DatabaseReference firebaseDatabase;


    public CommonQuestionsPresenter() {
        commonQuestionsFromDatabase = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void getQuestions(final ResultListener<List<CommonQuestion>> listener) {

        ValueEventListener questionsListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    CommonQuestion commonQuestion = data.getValue(CommonQuestion.class);
                    commonQuestionsFromDatabase.add(commonQuestion);
                }
                listener.finish(commonQuestionsFromDatabase);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("firebase", "loadPost:onCancelled", databaseError.toException());
            }
        };
        firebaseDatabase.addValueEventListener(questionsListener);

    }

}
