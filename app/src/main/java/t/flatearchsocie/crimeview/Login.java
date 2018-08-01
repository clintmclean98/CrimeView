package t.flatearchsocie.crimeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       /* DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(drawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);





        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            drawerToggle.setHomeAsUpIndicator(R.drawable.ic_custom_drawer_icon); // drawer closed-reset icon
        } else {
            //open drawer
            drawerLayout.openDrawer(GravityCompat.START);
            drawerToggle.setHomeAsUpIndicator(R.drawable.ic_new_icon); // set your back icon
        }*/
    }
}
