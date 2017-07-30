package br.com.jordan.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btSom;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSom = (Button) findViewById(R.id.btSom);
        btSom.setOnClickListener(listenerSom);

        //Criando o Objeto para tocar a musica
        mediaPlayer = MediaPlayer.create(this, R.raw.lan);
    }

    private View.OnClickListener listenerSom  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mediaPlayer.isPlaying()){
                pausarMusica();
            }else{
                tocarMusica();
            }
        }
    };

    private void tocarMusica(){
        if(mediaPlayer !=  null){
            mediaPlayer.start();
            btSom.setText("Pausar");
        }
    }

    private void pausarMusica(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            btSom.setText("Start");
        }
    }

    @Override
    protected void onDestroy() {
        //Liberando recursos
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            //Libera recursos que estão sendo liberados
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();

    }
}
