package com.afiq.acad_expandablesview;

import android.os.Bundle;
import android.transition.AutoTransition; import android.transition.TransitionManager; import android.view.View;
import android.widget.ImageButton; import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity; import androidx.cardview.widget.CardView;
public class MainActivity extends AppCompatActivity { ImageButton arrow;
    LinearLayout hiddenView; CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.base_cardview); arrow = findViewById(R.id.arrow_button); hiddenView = findViewById(R.id.hidden_view);

        arrow.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) {

// If the CardView is already expanded, set its

            //      visibility more


// to gone and change the expand less icon to expand
            if (hiddenView.getVisibility() == View.VISIBLE) {
// The transition of the hiddenView is carried out
// by the TransitionManager class.
// Here we use an object of the AutoTransition
// Class to create a default transition.
                TransitionManager.beginDelayedTransition(cardView,
                        new AutoTransition()); hiddenView.setVisibility(View.GONE);


                arrow.setImageResource(R.drawable.baseline_expand_more_24);
            }

// If the CardView is not expanded, set its visibility
// to visible and change the expand more icon to expand

            //       less.


            else {

                TransitionManager.beginDelayedTransition(cardView,
                        new AutoTransition()); hiddenView.setVisibility(View.VISIBLE);


                arrow.setImageResource(R.drawable.baseline_expand_less_24);
            }
        }
        });
    }
}