package britt103.cardstack;

import android.nfc.cardemulation.CardEmulation;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Collections;
import java.util.Stack;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Stack<Card> CardStack = new Stack<>();
    private TextView topText;
    private ImageView middleImage;
    private ImageView bottomImage;
    private ImageView topImage;
    private TextView bottomText;
    int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relativecard);
        topText = (TextView) findViewById(R.id.topText);
        bottomText = (TextView) findViewById(R.id.bottomText);
        topImage = (ImageView) findViewById(R.id.topSymbol);
        middleImage = (ImageView) findViewById(R.id.bottomSymbol);
        bottomImage = (ImageView) findViewById(R.id.middleSymbol);

        CreateDeck();
        Collections.shuffle(CardStack);

        int temp = CardStack.peek().getValue();
        String tempSuit = CardStack.peek().getSuit();
        if (temp == 1){
            topText.setText("A");
            bottomText.setText("A");
        }else if (temp == 11){
            topText.setText("J");
            bottomText.setText("J");
        }else if (temp == 12){
            topText.setText("Q");
            bottomText.setText("Q");
        }else if (temp == 13){
            topText.setText("K");
            bottomText.setText("K");
        }
        else{
            topText.setText(String.valueOf(temp));
            bottomText.setText(String.valueOf(temp));
        }
        if (tempSuit == "hearts"){
            topText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            topImage.setImageResource(R.mipmap.hearts);
            middleImage.setImageResource(R.mipmap.hearts);
            bottomImage.setImageResource(R.mipmap.hearts);
        }else if (tempSuit == "diamonds"){
            topText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.holo_red_light));
            topImage.setImageResource(R.mipmap.diamonds);
            middleImage.setImageResource(R.mipmap.diamonds);
            bottomImage.setImageResource(R.mipmap.diamonds);
        }else if (tempSuit == "spades"){
            topText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            topImage.setImageResource(R.mipmap.spades);
            middleImage.setImageResource(R.mipmap.spades);
            bottomImage.setImageResource(R.mipmap.spades);
        }else if (tempSuit == "clubs"){
            topText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(),android.R.color.black));
            topImage.setImageResource(R.mipmap.clubs);
            middleImage.setImageResource(R.mipmap.clubs);
            bottomImage.setImageResource(R.mipmap.clubs);
        }
    }

    public void CreateDeck(){

        for (int i = 1; i <= 13; ++i){
            CardStack.push(new Card(i, "hearts"));
            CardStack.push(new Card(i, "diamonds"));
            CardStack.push(new Card(i, "spades"));
            CardStack.push(new Card(i, "clubs"));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    public void click(View view) {
        counter++;
        CardStack.pop();
        if (CardStack.isEmpty()) {
            finish();
        }else {

            int temp = CardStack.peek().getValue();
            String tempSuit= CardStack.peek().getSuit();
            if (temp == 1) {
                topText.setText("A");
                bottomText.setText("A");
            } else if (temp == 11) {
                topText.setText("J");
                bottomText.setText("J");
            } else if (temp == 12) {
                topText.setText("Q");
                bottomText.setText("Q");
            } else if (temp == 13) {
                topText.setText("K");
                bottomText.setText("K");
            } else {
                topText.setText(String.valueOf(temp));
                bottomText.setText(String.valueOf(temp));
            }
            if (tempSuit == "hearts") {
                topImage.setImageResource(R.mipmap.hearts);
                middleImage.setImageResource(R.mipmap.hearts);
                bottomImage.setImageResource(R.mipmap.hearts);
                topText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
                bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
            } else if (tempSuit == "diamonds") {
                topImage.setImageResource(R.mipmap.diamonds);
                middleImage.setImageResource(R.mipmap.diamonds);
                bottomImage.setImageResource(R.mipmap.diamonds);
                topText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
                bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_light));
            } else if (tempSuit == "spades") {
                topImage.setImageResource(R.mipmap.spades);
                middleImage.setImageResource(R.mipmap.spades);
                bottomImage.setImageResource(R.mipmap.spades);
                topText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
                bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
            } else if (tempSuit == "clubs") {
                topImage.setImageResource(R.mipmap.clubs);
                middleImage.setImageResource(R.mipmap.clubs);
                bottomImage.setImageResource(R.mipmap.clubs);
                topText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
                bottomText.setTextColor(ContextCompat.getColor(getApplicationContext(), android.R.color.black));
            }
        }
    }
}

