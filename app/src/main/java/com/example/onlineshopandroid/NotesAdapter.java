package com.example.onlineshopandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NotesAdapter extends ArrayAdapter<Note>
{
    private Context context;
    private LayoutInflater inflater;
    private List<Note> noteList;

    public NotesAdapter(Context context, List<Note> notes)
    {
        super(context, 0, notes);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.noteList = notes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = this.inflater.inflate(R.layout.note_view, parent, false);
        Note note = this.noteList.get(position);

        TextView title = (TextView) listItem.findViewById(R.id.note_title);
        title.setText(note.title);

        TextView release = (TextView) listItem.findViewById(R.id.note_body);
        release.setText(note.body);

        return listItem;
    }
}
