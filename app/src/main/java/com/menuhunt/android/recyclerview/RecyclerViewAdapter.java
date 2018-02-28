package com.menuhunt.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by byan on 1/25/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ContactItemHolder> {

    private Context context;
    private List<Contact> contacts;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public RecyclerViewAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public ContactItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
        ContactItemHolder contactItemHolder = new ContactItemHolder(view);
        return contactItemHolder;
    }

    @Override
    public void onBindViewHolder(ContactItemHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.imageView.setImageResource(contact.getImage());
        holder.imageView.setClipToOutline(true);
        holder.nameTextView.setText(contact.getName());
        holder.phoneTextView.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactItemHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView nameTextView;
        private TextView phoneTextView;

        public ContactItemHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.contact_img);
            nameTextView = itemView.findViewById(R.id.contact_name);
            phoneTextView = itemView.findViewById(R.id.contact_phone);

        }
    }

}
