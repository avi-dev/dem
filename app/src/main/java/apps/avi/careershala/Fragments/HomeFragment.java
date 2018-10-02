package apps.avi.careershala.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import apps.avi.careershala.Adapter.GuideAdapter;
import apps.avi.careershala.Model.Guide;
import apps.avi.careershala.R;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.DrawableBanner;
import ss.com.bannerslider.views.BannerSlider;

public class HomeFragment extends Fragment {

    private View view;
    List<Guide> guideList;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        BannerSlider bannerSlider = view.findViewById(R.id.bannerSlider);
        List<Banner> banners=new ArrayList<>();

        banners.add(new DrawableBanner(R.drawable.fu));
        banners.add(new DrawableBanner(R.drawable.se));
        banners.add(new DrawableBanner(R.drawable.fi));
        banners.add(new DrawableBanner(R.drawable.th));
        bannerSlider.setBanners(banners);

        guideList = new ArrayList<>();

        guideList.add(new Guide("After 10",R.drawable.aften));
        guideList.add(new Guide("After 12",R.drawable.after12));
        guideList.add(new Guide("Graduation",R.drawable.aftergrad));
        guideList.add(new Guide("Post Graduation",R.drawable.afterpost));

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
     //   recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        GuideAdapter adapter = new GuideAdapter(getActivity(),guideList);
        recyclerView.setAdapter(adapter);

    }
}
