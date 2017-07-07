package mihir.npssnewsandroid;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    static private final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG, "Login Activity Loaded");
    }

    public void Login(View view) {
        String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        String password = ((EditText) findViewById(R.id.txtPassword)).getText().toString();


        if (email.replaceAll(" ", "").equals("") || password.replaceAll(" ", "").equals("") || !email.contains("@")) {
            alertOkOnlyDialogFragment dialog = new alertOkOnlyDialogFragment();
            dialog.show(getFragmentManager(), TAG, getResources().getString(R.string.dialog_incorrect_credentials_msg));
        }
        else {
            finish();
        }


    }

    public static class alertOkOnlyDialogFragment extends DialogFragment {
        private String message = "";
        private AlertDialog.Builder builder;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            return builder.create();
        }


        public void show(FragmentManager manager, String tag, String message) {
            this.message = message;
            super.show(manager, tag);
        }
    }

}
