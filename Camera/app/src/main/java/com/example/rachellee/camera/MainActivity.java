package com.example.rachellee.camera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton button;
    ImageView imageView;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Create a file Uri for saving an image or video */
    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /** Create a File for saving an image or video */
    private static File getOutputMediaFile(int type) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "MyCameraApp");
       if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("MyCameraApp", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        File mediaFile = new File("image.jpg");
        return mediaFile;
    }


    public void onClick(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //File imageFile = new File(pictureDirectory, "image.jpg");
        //Uri pictureUri = Uri.fromFile(imageFile);
        //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
        if (takePictureIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(takePictureIntent,CAM_REQUEST);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       //if (requestCode == CAM_REQUEST && resultCode == RESULT_OK) {
       //     Bundle extras = data.getExtras();
       //     Bitmap imageBitmap = (Bitmap) extras.get("data");
      //      imageView.setImageBitmap(imageBitmap);
       // }
    }

    /** Called when the user taps the Share! button */
    public void createInstagramIntent (View view) {
        String type = "image/*";
        String filename = "/20171111_124615.jpg";
        //String filename = "/banana.jpg";
        String mediaPath = Environment.getExternalStorageDirectory() + "/../../self/primary/DCIM/Camera" + filename;
        Log.d("FPATH", mediaPath);
        // Create the new Intent using the 'Send' action.
        Intent share = new Intent(Intent.ACTION_SEND);
        // Set the MIME type
        share.setType(type);
        // Create the URI from the media
        File media = new File(mediaPath);
        Uri uri = Uri.fromFile(media);
        // Add the URI to the Intent.
        share.putExtra(Intent.EXTRA_STREAM, uri);
        // Broadcast the Intent.
        startActivity(Intent.createChooser(share, "Share to"));
    }

}
