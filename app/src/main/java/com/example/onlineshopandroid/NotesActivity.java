package com.example.onlineshopandroid;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesActivity extends AppCompatActivity
{
    private final String FILE_NAME = "notes.json";

    private EditText noteEditTitle;
    private EditText noteEdit;
    private Button saveNoteButton;
    private List<Note> noteList;
    private ListView notesView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        this.noteEdit = (EditText) findViewById(R.id.note_edit_text);
        this.noteEditTitle = (EditText) findViewById(R.id.note_edit_title);
        this.saveNoteButton = (Button) findViewById(R.id.save_note_button);
        this.noteList = new ArrayList<Note>();
        this.notesView = (ListView) findViewById(R.id.notes);

        this.notesView.setAdapter(new NotesAdapter(getApplicationContext(), this.noteList));

        setOnClick(this.saveNoteButton, this.noteEdit, this.noteEditTitle);
        refreshNotes();
    }

    private void setOnClick(final Button button, final EditText text, final EditText title)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text.getText().toString().equals("") || title.getText().toString().equals("")) {
                    return;
                }

                JSONObject json = new JSONObject();

                try {
                    json.put("title", text.getText().toString());
                    json.put("body", text.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                text.setText("");
                title.setText("");

                File file = new File(v.getContext().getFilesDir(), FILE_NAME);

                try {
                    FileOutputStream outputStream = new FileOutputStream(file, true);
                    outputStream.write(json.toString().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                refreshNotes();
                saveNotesToDownloads();
            }
        });
    }

    public void refreshNotes() {
        noteList.clear();
        try {
            InputStream inputStream = openFileInput(FILE_NAME);
            String str = "";
            int b;
            while ((b = inputStream.read()) != -1) {
                if ((char)b == '{') {
                    String jsonStr = "";
                    while ((char) b != '}') {
                        jsonStr += (char) b;
                        b = inputStream.read();
                    }
                    jsonStr += (char) b;

                    JSONObject obj = new JSONObject(jsonStr);
                    Note note = new Note();
                    note.title = obj.get("title").toString();
                    note.body = obj.get("body").toString();

                    noteList.add(note);
                }
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveNotesToDownloads()
    {
        try {
            InputStream inputStream = openFileInput(FILE_NAME);
            String str = "";
            int b = inputStream.read();
            while (b != -1) {
                str += (char) b;
                b = inputStream.read();
            }
            inputStream.close();

            File file = new File(this.getApplicationContext().getExternalFilesDir(
                    Environment.DIRECTORY_DOWNLOADS), "TEEEEEEEEEEEEEEST.TXT");
            FileOutputStream outputStream = new FileOutputStream(file);
            System.out.println(str);
            outputStream.write(str.getBytes());
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
