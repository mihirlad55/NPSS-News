package mihir.npssnewsandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Integer, String> {

    private final static String TAG = "DownloadTask";
    private Context context;
    private PowerManager.WakeLock wakeLock;

    DownloadTask(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... sUrl) {
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;

        try {
            URL url = new URL(sUrl[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }

            input = connection.getInputStream();
            output = new FileOutputStream(context.getApplicationInfo().dataDir + "/soccer.jpg");

            byte[] data = new byte[4096];
            int count = 0;

            while ((count = input.read(data)) != -1) {
                if (isCancelled()) {
                    input.close();
                    return null;
                }
                output.write(data, 0, count);
            }

        } catch (Exception e) {
            Log.i(TAG, e.getMessage());
        }
        finally {
            try {
                if (output != null) output.close();
                if (input != null) input.close();
            } catch (IOException ignored) { }

            if (connection != null) connection.disconnect();
        }
        return null;
    }

    @Override
    protected  void onPreExecute() {
        super.onPreExecute();

        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
        wakeLock.acquire();
    }
}
