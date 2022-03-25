package it.eldavo.soundboard;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int pos;
    MediaPlayer mediaPlayer;
    ArrayList<MediaPlayer> spamPlayers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button3);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button4);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button5);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button6);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button7);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button8);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button9);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button10);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button11);
        button.setOnClickListener(this::click);
        button = findViewById(R.id.button12);
        button.setOnClickListener(this::click);

    }

    public void click(View v) {
        switch (pos) {
            case 0:
                // Do nothing
                if (mediaPlayer != null) {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        mediaPlayer = go(v);
                        mediaPlayer.start();
                    }
                } else {
                    mediaPlayer = go(v);
                    mediaPlayer.start();
                }
                break;
            case 1:
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                }
                mediaPlayer = go(v);
                mediaPlayer.start();
                break;
            case 2:
                MediaPlayer mp = go(v);
                mp.start();
                spamPlayers.add(mp);
                ArrayList<MediaPlayer> toRemove = new ArrayList<>();
                // For each player in spamPlayers
                for (MediaPlayer m : spamPlayers) {
                    // If the player is not playing
                    if (!m.isPlaying()) {
                        // Reset the player
                        m.reset();
                        // Release the player
                        m.release();
                        // Remove the player from the list
                        toRemove.add(m);
                    }
                }
                spamPlayers.removeAll(toRemove);
        }

    }

    public MediaPlayer go(View v) {
        if (v.getId() == R.id.button) {
            return MediaPlayer.create(this, R.raw.button);
        }
        if (v.getId() == R.id.button2) {
            return MediaPlayer.create(this, R.raw.button2);
        }
        if (v.getId() == R.id.button3) {
            return MediaPlayer.create(this, R.raw.button3);
        }
        if (v.getId() == R.id.button4) {
            return MediaPlayer.create(this, R.raw.button4);
        }
        if (v.getId() == R.id.button5) {
            return MediaPlayer.create(this, R.raw.button5);
        }
        if (v.getId() == R.id.button6) {
            return MediaPlayer.create(this, R.raw.button6);
        }
        if (v.getId() == R.id.button7) {
            return MediaPlayer.create(this, R.raw.button7);
        }
        if (v.getId() == R.id.button8) {
            return MediaPlayer.create(this, R.raw.button8);
        }
        if (v.getId() == R.id.button9) {
            return MediaPlayer.create(this, R.raw.button9);
        }
        if (v.getId() == R.id.button10) {
            return MediaPlayer.create(this, R.raw.button10);
        }
        if (v.getId() == R.id.button11) {
            return MediaPlayer.create(this, R.raw.button11);
        }
        if (v.getId() == R.id.button12) {
            return MediaPlayer.create(this, R.raw.button12);
        }
        return null;
    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        parent.getItemAtPosition(pos);
        this.pos = pos;
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
