package com.example.androidtodoapp.fragments;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.androidtodoapp.AppDatabase;
import com.example.androidtodoapp.AppDatabaseSingleton;
import com.example.androidtodoapp.R;
import com.example.androidtodoapp.Todo;
import com.example.androidtodoapp.TodoDAO;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainUpFragment extends Fragment {

    private TextView textView;
    private ListView listView;
    private ArrayAdapter<String> listViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_main_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.mainUpListView);
        listViewAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
        listView.setAdapter(listViewAdapter);

        new GetTodosAsync( AppDatabaseSingleton.getInstance(getContext()),(Activity)getContext() );
        new InsertTodoAsync(AppDatabaseSingleton.getInstance(getContext()),this);
    }

    private static class InsertTodoAsync extends AsyncTask<Void,Void,Integer>{
        private WeakReference<Fragment> weakReferenceFragment;
        private AppDatabase db;

        public InsertTodoAsync(AppDatabase db, Fragment fragment){
            this.db = db;
            this.weakReferenceFragment = new WeakReference<>(fragment);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return null;
        }
    }

    private static class GetTodosAsync extends AsyncTask<Void, Void, Integer> {
        private WeakReference<Activity> weakActivity;
        private AppDatabase db;

        public GetTodosAsync(AppDatabase db, Activity activity) {
            this.db = db;
            weakActivity = new WeakReference<>(activity);
        }

        @Override
        protected Integer doInBackground(Void... params) {
            List<Todo> todoList = db.tododAO().getAll();
            return 0;
        }

        @Override
        protected void onPostExecute(Integer code) {
            Activity activity = weakActivity.get();
            if(activity == null) {
                return;
            }
        }
    }
}
