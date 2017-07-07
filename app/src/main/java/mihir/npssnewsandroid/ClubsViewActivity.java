package mihir.npssnewsandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ClubsViewActivity extends AppCompatActivity {

    private static final String TAG = "ClubsViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs_view);

        Club[] clubs = {
                new Club("Soccer", "Soccer Stuff", Club.Gender.MALE, Club.Grade.NINE),
                new Club("Baseball", "Baseball Stuff", Club.Gender.FEMALE, Club.Grade.TEN),
                new Club("Basketball", "Basketball stuff", Club.Gender.FEMALE, Club.Grade.ELEVEN),
                new Club("Soccer", "Soccer Stuff", Club.Gender.MALE, Club.Grade.NINE),
                new Club("Baseball", "Baseball Stuff", Club.Gender.FEMALE, Club.Grade.TEN),
                new Club("Basketball", "Basketball stuff", Club.Gender.FEMALE, Club.Grade.ELEVEN),
                new Club("Soccer", "Soccer Stuff", Club.Gender.MALE, Club.Grade.NINE),
                new Club("Baseball", "Baseball Stuff", Club.Gender.FEMALE, Club.Grade.TEN),
                new Club("Basketball", "Basketball stuff", Club.Gender.FEMALE, Club.Grade.ELEVEN),
                new Club("Soccer", "Soccer Stuff", Club.Gender.MALE, Club.Grade.NINE),
                new Club("Baseball", "Baseball Stuff", Club.Gender.FEMALE, Club.Grade.TEN),
                new Club("Basketball", "Basketball stuff", Club.Gender.FEMALE, Club.Grade.ELEVEN) };

        ListAdapter listAdapter = new ClubArrayAdapter(this, clubs);
        ListView listViewClubs = (ListView) findViewById(R.id.listViewClubs);
        listViewClubs.setAdapter(listAdapter);
    }
}
