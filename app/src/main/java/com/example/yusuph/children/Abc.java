package com.example.yusuph.children;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.wifi.aware.PublishConfig;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static android.os.Build.VERSION_CODES.M;

public class Abc extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;
  private  MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
      @Override
      public void onCompletion(MediaPlayer mediaPlayer) {
releasedMediaPlayer();
      }
  };


    @Override
    protected void onStop() {
        super.onStop();
        releasedMediaPlayer();
    }
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releasedMediaPlayer();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final String[] str2 = {"A for Apple", "B for Ball", "C for Cat", "D for Dog", "E for Egg", "F for Goat",
                "G for Goat", "H for Goat" ,"I for Goat", "J for Goat", "K for Goat"};
        String[] str22 = {"A for Apple", "B for Ball", "C for Cat", "D for Dog", "E for Egg", "F for Goat",
                "G for Goat", "h for Goat", "I for Goat", "J for Goat", "K for Goat" };
        Integer[] img22 = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
                R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i,
                R.drawable.j, R.drawable.k};
       final Integer [] music = {R.raw.kkkkk, R.raw.kkkkk,  R.raw.kkkkk, R.raw.kkkkk,  R.raw.kkkkk,  R.raw.kkkkk,
               R.raw.kkkkk,  R.raw.kkkkk
        };


        ListView livv = (ListView) findViewById(R.id.list_v);
        NumbersAdapter wa = new NumbersAdapter(this, str2, str22, img22, music);
        livv.setAdapter(wa);
        livv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view, int positon, long id) {
                                            releasedMediaPlayer();
                                           // String st = str2[+positon];
                                            int result = audioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                                                    AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                                            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                                                // We have audio focus now.

                                                // Create and setup the {@link MediaPlayer} for the audio resource associated
                                                // with the current word
                                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.kkkkk);

                                                // Start the audio file
                                                mediaPlayer.start();

                                                // Setup a listener on the media player, so that we can stop and release the
                                                // media player once the sound has finished playing.
                                                mediaPlayer.setOnCompletionListener(mCompletionListener);
                                            }
                                        }
                                    }


        );}

    private void releasedMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

