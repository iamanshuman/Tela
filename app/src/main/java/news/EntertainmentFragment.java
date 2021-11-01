package news;

import android.example.tela.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {

    String api = "5d1f1893a3874f47870b387a042eef87";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";

    private RecyclerView recyclerviewofentertainment;
    private String category = "entertainment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.entertainmentfragment,null);

        recyclerviewofentertainment=v.findViewById(R.id.recyclerviewofentertainment);
        modelClassArrayList=new ArrayList<>();
        recyclerviewofentertainment.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerviewofentertainment.setAdapter(adapter);

        findNews();

        return v;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<ParentModelClass>() {
            @Override
            public void onResponse(Call<ParentModelClass> call, Response<ParentModelClass> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ParentModelClass> call, Throwable t) {

            }
        });
    }
}