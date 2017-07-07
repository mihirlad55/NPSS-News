package mihir.npssnewsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int LOGIN_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");
        new DownloadTask(MainActivity.this).execute("http://www.eastcobber.com/wp-content/uploads/2015/03/o-SOCCER-BALL-facebook1.jpg");

        Thread t = new Thread() {
            @Override
            public void run() {
                try
                {
                    super.run();
                    synchronized (this) {
                        wait(3000);
                    }
                } catch (Exception e)
                {
                    Log.i(TAG, e.getMessage());
                } finally

                {
                    try {
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        Log.i(TAG, "Starting Login Activity");
                        startActivityForResult(i, LOGIN_REQUEST_CODE);
                    } catch (Exception ex) {
                        Log.i(TAG, ex.getMessage());
                    }
                }
            }
        };

        t.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_REQUEST_CODE) {
            Intent i = new Intent(MainActivity.this, ClubsViewActivity.class);
            startActivity(i);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

}
