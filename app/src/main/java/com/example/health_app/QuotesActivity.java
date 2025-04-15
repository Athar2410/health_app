package com.example.health_app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import java.util.Random;

public class QuotesActivity extends Activity {

    String[] quotes = {
            "You are stronger than you think.",
            "Every day is a fresh start.",
            "Believe in yourself.",
            "Your feelings are valid.",
            "You’ve got this.",
            "One step at a time.",
            "You matter. Always."
    };

    TextView quoteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        quoteView = findViewById(R.id.quoteText);
        Button newQuoteBtn = findViewById(R.id.newQuoteBtn);

        showRandomQuote();

        newQuoteBtn.setOnClickListener(v -> showRandomQuote());
    }

    private void showRandomQuote() {
        int index = new Random().nextInt(quotes.length);
        quoteView.setText(quotes[index]);
    }
}
