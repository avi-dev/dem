package apps.avi.careershala.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import apps.avi.careershala.Model.Guide;
import apps.avi.careershala.R;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    private Context mCtx;
    private List<Guide> guideList;

    public GuideAdapter(Context mCtx, List<Guide> productList) {
        this.mCtx = mCtx;
        this.guideList = productList;
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.card_row, null);
        return new GuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {

        Guide guide = guideList.get(position);
        holder.textViewTitle.setText(guide.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(guide.getImaage()));

    }


    @Override
    public int getItemCount() {
        return guideList.size();
    }


    class GuideViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;

        public GuideViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
