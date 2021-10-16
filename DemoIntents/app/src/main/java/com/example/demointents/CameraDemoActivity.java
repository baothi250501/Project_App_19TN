package com.example.demointents;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;

public class CameraDemoActivity extends AppCompatActivity {

    private ImageView imageView;
    private VideoView videoView;
    private MediaController mediaController;

    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_ID_VIDEO_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_demo);

        Button imgCapButton = findViewById(R.id.imgCapButton);
        Button vidCapButton = findViewById(R.id.vidCapButton);
        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);

        imgCapButton.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
        });

        vidCapButton.setOnClickListener(view -> {
            askPermission();
            captureVideo();
        });
    }

    private void askPermission() {
        int readPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int writePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (readPermission != PackageManager.PERMISSION_GRANTED || writePermission != PackageManager.PERMISSION_GRANTED){
            this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_ID_READ_WRITE_PERMISSION);
        }
    }

    private void captureVideo() {
        try{
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            File dir = Environment.getExternalStorageDirectory();
            if (!dir.exists()){
                dir.mkdirs();
            }
            String savePath = dir.getAbsolutePath() +"/capVideo.mp4";
            File videoFile = new File(savePath);
            Uri videoUri = Uri.fromFile(videoFile);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, videoUri);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());

            startActivityForResult(intent, REQUEST_ID_VIDEO_CAPTURE);
        } catch(Exception e) {
            Toast.makeText(CameraDemoActivity.this, "Error capture video" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ID_READ_WRITE_PERMISSION) {
            if (grantResults.length > 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();

                this.captureVideo();

            } else {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK){
                Bitmap bp = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bp);
            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Result canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Result failed", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_ID_VIDEO_CAPTURE){
            if (resultCode == RESULT_OK){
                Uri videoUri = data.getData();
                Toast.makeText(this, "Video saved to:\n" +
                        videoUri, Toast.LENGTH_LONG).show();
                videoView.setVideoURI(videoUri);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);
                videoView.start();
            } else if (resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Result canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Result failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
