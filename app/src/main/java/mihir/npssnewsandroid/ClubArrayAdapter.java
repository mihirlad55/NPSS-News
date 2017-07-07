package mihir.npssnewsandroid;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import static android.content.ContentValues.TAG;

class ClubArrayAdapter extends ArrayAdapter<Club> {
    private final static String TAG = "ClubArrayAdapter";

    public ClubArrayAdapter(Context context, Club[] resource) {
        super(context, R.layout.club_list_view_item, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = LayoutInflater.from(getContext());
        if (convertView == null) convertView = inflator.inflate(R.layout.club_list_view_item, parent, false);

        Club club = getItem(position);
        TextView textViewClubName = (TextView) convertView.findViewById(R.id.textViewClubName);
        ImageView imageViewClubPicture = (ImageView) convertView.findViewById(R.id.imageViewClub);
        ImageView imageViewGender = (ImageView) convertView.findViewById(R.id.imageViewGender);
        TextView textViewGrade = (TextView) convertView.findViewById(R.id.textViewGrade);

        textViewClubName.setText(club.getName());
        textViewGrade.setText(String.format(getCurrentLocale(),"%d", club.getGrade().getValue()));
        imageViewGender.setImageResource( (club.getGender().getValue() == Club.Gender.MALE.getValue()) ? R.mipmap.male_icon : R.mipmap.female_icon);

        try {

            File clubImgFile = new File(getContext().getApplicationInfo().dataDir + "/soccer.jpg");
            imageViewClubPicture.setImageURI(Uri.fromFile(clubImgFile));
        } catch (Exception e) {
            Log.i(TAG, e.getMessage());
        }

        return convertView;
    }
    @TargetApi(Build.VERSION_CODES.N)
    public Locale getCurrentLocale(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            return getContext().getResources().getConfiguration().getLocales().get(0);
        } else{
            //noinspection deprecation
            return getContext().getResources().getConfiguration().locale;
        }
    }

    public String getFileSafeName(String s) {
        return s.toLowerCase().replaceAll(" ", "_");
    }
}
