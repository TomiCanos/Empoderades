package com.example.admin.empoderades.holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.admin.empoderades.R;
import com.example.admin.empoderades.model.CommonQuestion;
import com.example.admin.empoderades.model.News;

public class CommonQuestionViewHolder extends RecyclerView.ViewHolder {

    private TextView commonQuestionTitle;
    private TextView commonQuestionContent;

    public CommonQuestionViewHolder(@NonNull final View itemView) {
        super(itemView);
        commonQuestionTitle = itemView.findViewById(R.id.common_question_title);
        commonQuestionContent = itemView.findViewById(R.id.common_question_content);

    }

    public void onBind(CommonQuestion newItem) {
        commonQuestionTitle.setText(newItem.getTitle());
        commonQuestionContent.setText(newItem.getContent());
    }

}
