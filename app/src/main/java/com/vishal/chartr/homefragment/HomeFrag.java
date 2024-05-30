package com.vishal.chartr.homefragment;

import android.app.Dialog;
import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import com.vishal.chartr.DirectionActivity;
import com.vishal.chartr.pass.MyPassActivity;
import com.vishal.chartr.R;
import com.vishal.chartr.pass.BuyPassActivity;
import com.vishal.chartr.profile.MyProfileActivity;
import com.vishal.chartr.tickets.AllTicketesActivity;
import com.vishal.chartr.tickets.BuyticketActivity;
import com.vishal.chartr.tickets.MyTicketActivity;

public class HomeFrag extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1    ##################################################################################
        //  Find the ImageView with id iv_profile jaha se hum ,y profile ko click se open kr rhe h

        ImageView ivProfile = view.findViewById(R.id.iv_profile);
        // Set OnClickListener to ivProfile
        ivProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MyProfileActivity when ivProfile is clicked
                Intent intent = new Intent(getActivity(), MyProfileActivity.class);
                startActivity(intent);
            }
        });

        // 2    ##################################################################################
        //this is for opnig the direction activity

        EditText edit_destination_stop = view.findViewById(R.id.edit_destination_stop);
        edit_destination_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Show custom dialog
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(getActivity(), DirectionActivity.class));
                    }
                }, 500); // 0.5 seconds delay

            }
        });


        // 3    ##################################################################################

        // Find the RelativeLayout container for buying tickets

        RelativeLayout rlBuyTicket = view.findViewById(R.id.buyticket);
        // Set OnClickListener to the buy ticket container
        rlBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start BuyticketActivity when buy ticket container is clicked
                Intent intent = new Intent(getActivity(), BuyticketActivity.class);
                startActivity(intent);
            }
        });

        // 4    ##################################################################################

        // Find the RelativeLayout container for buying passes
        RelativeLayout rlBuyPass = view.findViewById(R.id.buypass);
        // Set OnClickListener to the buy pass container
        rlBuyPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start BuyPassActivity when buy pass container is clicked
                Intent intent = new Intent(getActivity(), BuyPassActivity.class);
                startActivity(intent);
            }
        });


        // 5    ##################################################################################
        //this is what when click on the our past ticket to show thats tickets details

        RelativeLayout rlTickets = view.findViewById(R.id.rl_tickets);
        rlTickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Show custom dialog
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(getActivity(), MyTicketActivity.class));
                    }
                }, 1000); // 1 seconds delay


            }
        });

        // 6    ##################################################################################
        //this is what when click on the our past pass to show thats pass details

        LinearLayout llPastPassContainer = view.findViewById(R.id.ll_past_pass_container);

        llPastPassContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Show custom dialog
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_featching_dialog);
                dialog.setCancelable(false);
                dialog.show();

                // Start a delayed task to dismiss the dialog and start next activity after 4 seconds
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        startActivity(new Intent(getActivity(), MyPassActivity.class));
                    }
                }, 3000); // 3 seconds delay


            }
        });

        // Apply the blinking animation to the RelativeLayout
        //ye is liye jo pile vale k upr new ikha h blink ho rha h vahi
        RelativeLayout rlNew3 = view.findViewById(R.id.rl_new_3);
        Animation blinkAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.blink);
        rlNew3.startAnimation(blinkAnimation);


    }
}