package palle.com.saveimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST=1888;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView1);
        Button photoButton= findViewById(R.id.button1);
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action;
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File pictureDirectory= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureName = getPictureName();
                File imageFile = new File(pictureDirectory,pictureName);
                Uri pictureUri= Uri.fromFile(imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                startActivityForResult(cameraIntent,CAMERA_REQUEST);
            }
        });
    }

    private String getPictureName() {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timeStamp =sdf.format(new Date());
        return "plane place image"+timeStamp+".jpg";
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RESULT_OK)
        {
            if (requestCode==CAMERA_REQUEST)
            {

            }
        }
    }
}
