package devicelocation.abhi.com.newgetuserlocation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    String cityname;

    TextView latTextView;
    TextView longTextView;
    TextView locTextView;
    private LocationTracker locationTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        latTextView = findViewById(R.id.LattextView);
        longTextView = findViewById(R.id.LongtextView);
        locTextView = findViewById(R.id.LocationtextView);
        locationTracker = new LocationTracker(this, new LocationTracker.CityListener() {
            @Override
            public void onCityChanged(String cityName) {
                Toast.makeText(MainActivity.this, cityName, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationTracker.removeRequest();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        locationTracker.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.d("action_settings", "poo");
            locationTracker.requestLocation();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
