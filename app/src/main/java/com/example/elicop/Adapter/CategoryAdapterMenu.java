package com.example.elicop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.elicop.models.CategoryDomain;
import com.example.elicop.R;

import java.util.ArrayList;

public class CategoryAdapterMenu extends RecyclerView.Adapter<CategoryAdapterMenu.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapterMenu(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category_menu,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";
        switch (position){
            case 0: {
                picUrl="plato_aji_de_gallina"; break;
            }

            case 1: {
                picUrl="plato_estofado_gallina"; break;
            }

            case 2: {
                picUrl="plato_mondongo"; break;
            }

            case 3: {
                picUrl="tallarin_rojo_pollo"; break;
            }

            case 4: {
                picUrl="choncholi"; break;
            }

            case 5: {
                picUrl="lomo_a_lo_pobre"; break;
            }

            case 6: {
                picUrl="cau_cau"; break;
            }

            case 7: {
                picUrl="salchipapa"; break;
            }

            case 8: {
                picUrl="chicharron_chancho"; break;
            }

            case 9: {
                picUrl="papa_rellena"; break;
            }

            case 10: {
                picUrl="lomo_saltado"; break;
            }
        }

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
