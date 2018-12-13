package com.example.admin.empoderades.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.adapters.CommonQuestionsListAdapter;
import com.example.admin.empoderades.model.CommonQuestion;
import com.example.admin.empoderades.model.News;
import com.example.admin.empoderades.presenter.CommonQuestionsPresenter;
import com.example.admin.empoderades.retrofit.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class CommonQuestionsFragment extends Fragment {

    private CommonQuestionsPresenter commonQuestionsPresenter;
    private List<CommonQuestion> commonQuestions;
    private RecyclerView recyclerView;


    public static CommonQuestionsFragment newInstance() {
        return new CommonQuestionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_questions_fragment, container, false);


        commonQuestionsPresenter = new CommonQuestionsPresenter();
        commonQuestions = new ArrayList<>();
        recyclerView = view.findViewById(R.id.common_question_recycler_view);

        commonQuestionsPresenter.getQuestions(new ResultListener<List<CommonQuestion>>() {
            @Override
            public void finish(List<CommonQuestion> resultado) {
                commonQuestions = resultado;
                loadData();
            }
        });

        return view;
    }

    private void loadData() {
        final CommonQuestionsListAdapter commonQuestionAdapter = new CommonQuestionsListAdapter();
        commonQuestionAdapter.setData(commonQuestions);
        recyclerView.setAdapter(commonQuestionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

}

