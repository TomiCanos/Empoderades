package com.example.admin.empoderades.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.presenter.CommonQuestionsPresenter;

import java.util.List;

public class CommonQuestionsFragment extends Fragment {

    private CommonQuestionsPresenter commonQuestionsPresenter;
    private NewsSetter newsSetter;
    private Button getQuestionsFromFirebaseButton;

    public static CommonQuestionsFragment newInstance() {
        return new CommonQuestionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_questions_fragment, container, false);

        getQuestionsFromFirebaseButton = view.findViewById(R.id.getQuestionsFromFirebaseButton);
        commonQuestionsPresenter = new CommonQuestionsPresenter(new NewsSetter() {
            @Override
            public void setNews(List<News> news) {
            }
        });

        getQuestionsFromFirebaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commonQuestionsPresenter.getNews();
            }
        });

        return view;
    }



    public interface NewsSetter {
        void setNews(List<News> news);
    }
}

