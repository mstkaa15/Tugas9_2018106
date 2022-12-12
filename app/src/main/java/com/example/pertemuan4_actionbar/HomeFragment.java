package com.example.pertemuan4_actionbar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.pertemuan4_actionbar.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    RecyclerView recylerView;
    private FragmentHomeBinding binding;
    String s1[], s2[],s3[];
    int images[] =

            {R.drawable.kursi,R.drawable.meja,R.drawable.cermin};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueueUniqueWork("SUCCESS", ExistingWorkPolicy.REPLACE, request);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recylerView =
                getActivity().findViewById(R.id.recyclerViewHotel);
        s1 =
                getResources().getStringArray(R.array.Furnitures);
        s2 =
                getResources().getStringArray(R.array.Star);
        s3 =
                getResources().getStringArray(R.array.Harga);
        FurnituresAdapter appAdapter = new FurnituresAdapter(getActivity(), s1, s2, s3, images);
        recylerView.setAdapter(appAdapter);
        recylerView.setLayoutManager(new LinearLayoutManager(getActivity(),

                LinearLayoutManager.HORIZONTAL,false));
    }
}
