package com.example.nustapp.Activity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.nustapp.R;

public class InfoActivity extends AppCompatActivity {
LinearLayout expandablelinearlayout1;
LinearLayout expandablelinearlayout2;
LinearLayout expandablelinearlayout3;

CardView expandableCardview1;
CardView expandableCardview2;
CardView expandableCardview3;

ConstraintLayout expandableConstraintLayout1;
ConstraintLayout expandableConstraintLayout2;
ConstraintLayout expandableConstraintLayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info2);
        expandablelinearlayout1 = findViewById(R.id.infoexpandablelinearlayout1);
        expandablelinearlayout2 = findViewById(R.id.infoexpandablelinearlayout2);
        expandablelinearlayout3 = findViewById(R.id.infoexpandablelinearlayout3);
        expandableCardview1 = findViewById(R.id.infoexpandalbecardlayout1);
        expandableCardview2 = findViewById(R.id.infoexpandalbecardlayout2);
        expandableCardview3 = findViewById(R.id.infoexpandalbecardlayout3);
        expandableConstraintLayout1 = findViewById(R.id.infoexpnadableconstraintlayout1);
        expandableConstraintLayout2 = findViewById(R.id.infoexpnadableconstraintlayout2);
        expandableConstraintLayout3 = findViewById(R.id.infoexpnadableconstraintlayout3);



        expandablelinearlayout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        expandableCardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visiblilty = (expandableConstraintLayout1.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(expandablelinearlayout1, new AutoTransition());
                expandableConstraintLayout1.setVisibility(visiblilty);
               // expandablelastnameSociety.setVisibility(visiblilty);
            }
        });

        expandablelinearlayout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        expandableCardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visiblilty = (expandableConstraintLayout2.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(expandablelinearlayout2, new AutoTransition());
                expandableConstraintLayout2.setVisibility(visiblilty);
                // expandablelastnameSociety.setVisibility(visiblilty);
            }
        });
        expandablelinearlayout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        expandableCardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visiblilty = (expandableConstraintLayout3.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
                TransitionManager.beginDelayedTransition(expandablelinearlayout3, new AutoTransition());
                expandableConstraintLayout3.setVisibility(visiblilty);
                // expandablelastnameSociety.setVisibility(visiblilty);
            }
        });





    }
}