package sample.android.com.listviewtest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;

    /*String[] dist = {"Dhaka", "Chattagram", "Khulna", "Barisal",
       "Noakhali", "Comilla", "Chadpur", "Faridpur", "Feni", "Gazipur"};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvId);
        searchView = findViewById(R.id.searchViewId);

        final String[] dist = getResources().getStringArray(R.array.dist);

        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.sample_layout, R.id.tvItemId, dist);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                String text= newText;

                adapter.getFilter().filter(newText);

                return false;
            }
        });

        // String value = getResources().getString(R.string.dhaka);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


               /* adapterView.getSelectedItem();
                adapterView.getItemAtPosition(i);*/
                String selected = dist[i];

             // Go Details Activity
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("dist", selected);
                startActivity(intent);


            }
        });

    }

    @Override
    public void onBackPressed() {
        showDailog();
    }
    private void showDailog(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.exit);
        builder.setTitle("Exit ?");
        builder.setMessage("Are you sure to Exit ?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.create().show();
    }
}
