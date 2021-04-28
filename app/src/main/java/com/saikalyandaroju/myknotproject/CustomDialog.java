package com.saikalyandaroju.myknotproject;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.github.andreilisun.swipedismissdialog.OnSwipeDismissListener;
import com.github.andreilisun.swipedismissdialog.Params;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDialog;
import com.github.andreilisun.swipedismissdialog.SwipeDismissDirection;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.saikalyandaroju.myknotproject.Model.MyResponse;
import com.squareup.picasso.Picasso;

public class CustomDialog  {
    private SwipeDismissDialog.Builder dialogBuilder;
    private SwipeDismissDialog dialog;
    private static final CustomDialog ourInstance =new CustomDialog();

  private CustomDialog(){

  }

    public static CustomDialog getInstance() {
        return ourInstance;
    }



    public void show(Context context, MyResponse myResponse) {
        if (dialog != null && dialog.isShown()) {
            return;
        }
        dialogBuilder = new SwipeDismissDialog.Builder(context)
                .setLayoutResId(R.layout.custom_dialog);
        dialogBuilder.setOnSwipeDismissListener(new OnSwipeDismissListener() {
            @Override
            public void onSwipeDismiss(View view, SwipeDismissDirection direction) {
               // view.setFitsSystemWindows(true);
                try {
                  dismiss(context);

                }
                catch (Exception e){
                    Log.i("error",e.getMessage());
                }
            }
        });


        dialog = dialogBuilder.build();
        dialog.requestFitSystemWindows();
   //     dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);




        MaterialTextView textView = dialog.findViewById(R.id.title);
        ShapeableImageView shapeableImageView = dialog.findViewById(R.id.image);
        MaterialButton materialButton = dialog.findViewById(R.id.url_open_button);
        textView.setText(myResponse.getTitle());
        Picasso.get().load(myResponse.getImageURL()).into(shapeableImageView);
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss(context);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(myResponse.getSuccess_url()));
                context.startActivity(i);
            }
        });
        if (context instanceof Activity) {
            if (!((Activity) context).isFinishing())
                dialog.show();
        }

    }




    public void dismiss(Context context) {
        if (dialog != null && dialog.isShown()) {
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing())
                    dialog.setOnTouchListener(null);
                    dialog.removeAllViews();
                }
            }
        }

}