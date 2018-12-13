package com.example.admin.empoderades.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.holders.CommonQuestionViewHolder;
import com.example.admin.empoderades.model.CommonQuestion;

import java.util.ArrayList;
import java.util.List;

public class CommonQuestionsListAdapter extends RecyclerView.Adapter {

    private List<CommonQuestion> commonQuestions = new ArrayList<>();

    public void setData(final List<CommonQuestion> data) {
        commonQuestions.clear();
        commonQuestions.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.common_question_item_view, viewGroup, false);
        return new CommonQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        ((CommonQuestionViewHolder) viewHolder).onBind(commonQuestions.get(viewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return commonQuestions.size();
    }
}