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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView newsButton;
    private TextView commonQuestionButton;
    private TextView mapButton;
    private TextView favouritesButton;
    private TextView reportButton;
    private List<TextView> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsButton = findViewById(R.id.news_button);
        commonQuestionButton = findViewById(R.id.common_question_button);
        mapButton = findViewById(R.id.map_button);
        favouritesButton = findViewById(R.id.favourites_button);
        reportButton = findViewById(R.id.report_button);
        buttons = new ArrayList<>();
        buttons.add(newsButton);
        buttons.add(commonQuestionButton);
        buttons.add(mapButton);
        buttons.add(favouritesButton);
        buttons.add(reportButton);

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
                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                commonQuestionButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                buttonSelected(newsButton);
            }
        });

        commonQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainFragmentContainer, new CommonQuestionsFragment(), "tag");
                fragmentTransaction.commit();
                buttonSelected(commonQuestionButton);
            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelected(mapButton);
            }
        });

        favouritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelected(favouritesButton);
            }
        });

        reportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelected(reportButton);
            }
        });
    }

    private void buttonSelected (TextView selectedButton) {
        for (TextView button : buttons) {
            if (button != selectedButton){
                button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                button.setClickable(true);
            } else {
                button.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                button.setClickable(false);
            }
        }
    }

}
