package britt103.cardstack;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import static android.R.attr.value;

public class Card {
    public int value;
    public String Suit;

    public Card(int value, String Suit) {
        this.value = value;
        this.Suit = Suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return Suit;
    }

    public void setSuit(String Suit) {
        this.Suit = Suit;
    }
}
