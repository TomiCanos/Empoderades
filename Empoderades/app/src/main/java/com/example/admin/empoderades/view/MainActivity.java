package com.example.admin.empoderades.view;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.admin.empoderades.R;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView newsButton;
    private TextView commonQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsButton = findViewById(R.id.news_button);
        commonQuestionButton = findViewById(R.id.common_question_button);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragmentContainer, new NewsFragment(), "tag");
        fragmentTransaction.commit();


        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFragmentContainer, new NewsFragment(), "tag");
                fragmentTransaction.commit();
                newsButton.setClickable(false);
                commonQuestionButton.setClickable(true);

            }
        });

        commonQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFragmentContainer, new CommonQuestionsFragment(), "tag");
                fragmentTransaction.commit();
                commonQuestionButton.setClickable(false);
                newsButton.setClickable(true);


            }
        });
    }

}
