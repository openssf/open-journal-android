package org.openssf.openjournal;

import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set content view to activity_home layout
        setContentView(R.layout.activity_add_note);

        // Initialize Toolbar from layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        // Handle back button in toolbar button press
        handleBackInput();
        // Return true because we performed back navigation
        return true;
    }

    @Override
    public void onBackPressed() {
        // Handle app back button press
        handleBackInput();
    }

    private void handleBackInput() {
        // Create & initialize new AlertDialog Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Set dialog title, message
        builder.setTitle(getString(R.string.discard_note))
                .setMessage(getString(R.string.discard_note_confirm))
                // Add "positive" button - discarding note
                .setPositiveButton(getString(R.string.discard), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Send Toast message telling user the note is being discarded
                        Toast.makeText(AddNoteActivity.this, getString(R.string.discarding), Toast.LENGTH_SHORT).show();
                        // Exit Activity & return to HomeActivity
                        finish();
                    }
                })
                // Set "negative" button - not discarding note
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing, because the note should NOT be discarded
                    }
                })
                // Show dialog box
                .show();
    }
}
