package cabme.cabmedashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Jay on 11/23/2015.
 */
public class find_a_ride extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Bitmap bm;
    ImageButton Image;
    LinearLayout details_2;
    boolean flag = false;
    RatingBar ratingBar;
    TextView route,from,destination,cartype,coTraveller;
    Button smoking,pets,music,book;
    ImageView seat1,seat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_a_ride_container);
        SettingUpVariables();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Image.setImageBitmap(getCircularBitmap(R.drawable.profile_user));
        details_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Slide slide = new Slide();
                slide.setSlideEdge(Gravity.TOP);
                TransitionManager.beginDelayedTransition(details_2.getContentScene().getSceneRoot(),slide);*/
                int visibility;
                if(!flag){
                    visibility = View.VISIBLE;}
                else {visibility = View.GONE;}
                flag = !flag;
                Image.setVisibility(visibility);
                ratingBar.setVisibility(visibility);
                route.setVisibility(visibility);
                from.setVisibility(visibility);
                destination.setVisibility(visibility);
                cartype.setVisibility(visibility);
                coTraveller.setVisibility(visibility);
                smoking.setVisibility(visibility);
                pets.setVisibility(visibility);
                music.setVisibility(visibility);
                book.setVisibility(visibility);
                seat1.setVisibility(visibility);
                seat2.setVisibility(visibility);

            }
        });

    }

    Bitmap getCircularBitmap(int image_given_path){
        bm = BitmapFactory.decodeResource(getResources(),image_given_path);
        return (new CircularBitmap().getCircleBitmap(bm));
    }
    void SettingUpVariables(){
        Image = (ImageButton) findViewById(R.id.bBookNow2);
        details_2 = (LinearLayout)findViewById(R.id.find_a_ride_details_2);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        route = (TextView)findViewById(R.id.find_a_ride_route2);
        from = (TextView)findViewById(R.id.find_a_ride_from2);
        destination = (TextView)findViewById(R.id.find_a_ride_destination2);
        cartype = (TextView)findViewById(R.id.find_a_ride_car_type2);
        smoking = (Button)findViewById(R.id.find_a_ride_smoking2);
        pets = (Button)findViewById(R.id.find_a_ride_pets2);
        music = (Button)findViewById(R.id.find_a_ride_music2);
        coTraveller = (TextView)findViewById(R.id.find_a_ride_per_co_traveller2);
        seat1 = (ImageView)findViewById(R.id.seat12);
        seat2 = (ImageView)findViewById(R.id.seat22);
        book = (Button)findViewById(R.id.find_a_ride_book2);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();

        if (id == R.id.book_a_cab_drawer_id) {
            delay_start_activity("cabme.cabmedashboard.BOOK_A_CAB", 300);
        }
        else if (id == R.id.login) {
            delay_start_activity("cabme.cabmedashboard.REGISTER_NOW", 300);
        }else if (id == R.id.post_a_cab_drawer_id) {
            //Intent open_main_activity=new Intent("cabme.cabmedashboard.LOGIN_ACTIVITY");
            //startActivity(open_main_activity);
        } else if (id == R.id.find_a_ride_drawer_id) {
            delay_start_activity("cabme.cabmedashboard.FIND_A_RIDE",300);

        } else if (id == R.id.profile_drawer_id) {
            delay_start_activity("cabme.cabmedashboard.PROFILE",300);
        } else if (id == R.id.myBookings) {
            delay_start_activity("cabme.cabmedashboard.MY_BOOKINGS",300);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    void delay_start_activity(final String intent, int delay){
        new Handler().postDelayed(new Runnable() {
            Intent open_main_activity = new Intent(intent);

            @Override
            public void run() {

                startActivity(open_main_activity);
                finish();
            }
        }, delay);

    }

}
