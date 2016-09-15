package com.mayo.mvvm.list;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mayo.mvvm.R;
import com.mayo.mvvm.databinding.ActivityListBinding;
import com.mayo.mvvm.databinding.ItemNameBinding;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<NameModel> mNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityListBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_list);
        mNames = new ArrayList<>();

        NameModel model = new NameModel();
        model.name = "mayo";
        model.imageUrl = "http://lorempixel.com/400/200/";
        mNames.add(model);

        model = new NameModel();
        model.name = "rekha";
        model.imageUrl = "http://lorempixel.com/400/200/";
        mNames.add(model);

        model = new NameModel();
        model.name = "muni";
        model.imageUrl = "http://lorempixel.com/400/200/";
        mNames.add(model);

        model = new NameModel();
        model.name = "lalitha";
        model.imageUrl = "http://lorempixel.com/400/200/";
        mNames.add(model);

        model = new NameModel();
        model.name = "dumbu";
        model.imageUrl = "http://lorempixel.com/400/200/";
        mNames.add(model);

        binding.namesList.setLayoutManager(new LinearLayoutManager(this));

        NamesAdapter adapter = new NamesAdapter(mNames);
        binding.namesList.setAdapter(adapter);

    }

    static class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NameViewHolder> {
        private List<NameModel> mNames;

        public NamesAdapter(List<NameModel> names) {
            mNames = names;
        }


        @Override
        public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemNameBinding itemNameBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                    R.layout.item_name,
                    parent,false);

            return new NameViewHolder(itemNameBinding);
        }

        @Override
        public void onBindViewHolder(NameViewHolder holder, int position) {
            holder.bindData(new NameViewModel(mNames.get(position)));
        }

        @Override
        public int getItemCount() {
            return mNames.size();
        }

        static class NameViewHolder extends RecyclerView.ViewHolder {
            ItemNameBinding nameBinding;

            public NameViewHolder(ItemNameBinding itemNameBinding) {
                super(itemNameBinding.itemName);

                nameBinding = itemNameBinding;
            }

            public void bindData(NameViewModel viewModel){
                nameBinding.setNameViewModel(viewModel);

            }
        }
    }
}
