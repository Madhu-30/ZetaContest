package com.example.zetacontest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<RecipeClass> recipeClasses;
    LayoutInflater layoutInflater;
    private Context context;

    GestureDetectorCompat gestureDetectorCompat;

    public Adapter(Context context , List<RecipeClass> recipeClasses){
        this.recipeClasses = recipeClasses;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
//        context = parent.getContext();

//        gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.OnGestureListener() {
//            @Override
//            public boolean onDown(MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public void onShowPress(MotionEvent e) {
//
//            }
//
//            @Override
//            public boolean onSingleTapUp(MotionEvent e) {
//                return false;
//            }
//
//            @Override
//            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//                return false;
//            }
//
//            @Override
//            public void onLongPress(MotionEvent e) {
//
//            }
//
//            @Override
//            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                Toast.makeText(context,"Fling" ,Toast.LENGTH_LONG).show();
//
//                return false;
//            }
//        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Dialog dialog = new Dialog(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.dialogbox, null);
                dialog.setContentView(view);
                dialog.show();

                return true;
            }
        });
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Dialog dialog = new Dialog(context);
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.dialogbox, null);

                dialog.setContentView(view);
                dialog.show();

                return true;
            }
        });

//        holder.cardView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN
//                }
//                return false;
//            }
//        });
//        holder.id.setText(String.valueOf(recipeClasses.get(position).getId()));
        holder.label.setText("Label : "+recipeClasses.get(position).getLabel());
        holder.category.setText("Category : "+recipeClasses.get(position).getCategory());
//        holder.description.setText(recipeClasses.get(position).getDescription());
        holder.price.setText("Price : "+recipeClasses.get(position).getPrice());
        holder.name.setText("Name : "+ recipeClasses.get(position).getName());
        Picasso.get().load(recipeClasses.get(position).getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return recipeClasses.size();
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        gestureDetectorCompat.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
    public class ViewHolder extends RecyclerView.ViewHolder{
//
//        CardStackView cardStackView ;
//        CardStackLayoutManager manager;
    CardView cardView;

        TextView name, id, label, description, category, price;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
//            id = itemView.findViewById(R.id.id);
            label = itemView.findViewById(R.id.label);
//            description = itemView.findViewById(R.id.description);
            category = itemView.findViewById(R.id.category);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardview);

//            cardStackView = itemView.findViewById(R.id.cardstackview);
//            manager = new CardStackLayoutManager(context, new CardStackListener() {
//                @Override
//                public void onCardDragging(Direction direction, float ratio) {
//
//                }
//
//                @Override
//                public void onCardSwiped(Direction direction) {
//
//                }
//
//                @Override
//                public void onCardRewound() {
//
//                }
//
//                @Override
//                public void onCardCanceled() {
//
//                }
//
//                @Override
//                public void onCardAppeared(View view, int position) {
//
//                }
//
//                @Override
//                public void onCardDisappeared(View view, int position) {
//
//                }
//            });
        }
    }
}
