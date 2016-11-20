package com.bsu.mariacco.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private Button bgButton;
    public RelativeLayout relativeLayout;
    private Context context;
    CharSequence[] items = new CharSequence[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgButton = (Button)findViewById(R.id.choose_button);
        relativeLayout = (RelativeLayout)findViewById(R.id.activity_choose);
        context = MainActivity.this;
        bgButton.setOnClickListener(this);
        items[0] = getText(R.string.red);
        items[1] = getText(R.string.yellow);
        items[2] = getText(R.string.green);
    }

    public static class PicturePickerFragment extends DialogFragment {

        ArrayList<Integer> imageList = new ArrayList<Integer>();

        // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // fill an array with selected images
            imageList.add(R.color.redColor);
            imageList.add(R.color.greenColor);
            imageList.add(R.color.yellowColor);
            imageList.add(R.drawable.pattern1_back);
            imageList.add(R.drawable.pattern2_back);
            imageList.add(R.drawable.pattern3_back);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.message);
            builder.setAdapter(new ArrayAdapter<Integer>(getActivity(), R.layout.dialog, imageList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view;
                    if (convertView == null) {
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                        view = inflater.inflate(R.layout.dialog, parent, false);
                    } else {
                        view = convertView;
                    }
                    ImageView imageView = (ImageView) view.findViewById(R.id.image);
                    int resId = getItem(position);
                    imageView.setImageResource(resId);
                    return view;
                }
            }, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    MainActivity callingActivity = (MainActivity) getActivity();
                    Intent intent = new Intent();
                    intent.putExtra("tag", item);
                    callingActivity.onActivityResult(0, Activity.RESULT_OK, intent);
                }
            });
            return builder.create();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            int item = data.getIntExtra("tag", -1);
            switch (item) {
                case 0: {
                    relativeLayout.setBackgroundResource(R.color.redColor);
                    Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                    break;
                }
                case 1: {
                    relativeLayout.setBackgroundResource(R.color.yellowColor);
                    Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                    break;
                }
                case 2: {
                    relativeLayout.setBackgroundResource(R.color.greenColor);
                    Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                    break;
                }
                case 3: {
                    relativeLayout.setBackgroundResource(R.drawable.pattern1_layout);
                    Toast.makeText(context, R.string.pattern1, Toast.LENGTH_LONG).show();
                    break;
                }
                case 4: {
                    relativeLayout.setBackgroundResource(R.drawable.pattern2_layout);
                    Toast.makeText(context, R.string.pattern2, Toast.LENGTH_LONG).show();
                    break;
                }
                case 5: {
                    relativeLayout.setBackgroundResource(R.drawable.pattern3_layout);
                    Toast.makeText(context, R.string.pattern3, Toast.LENGTH_LONG).show();
                    break;
                }

            }
        }
    }
    @Override
    public void onClick(View v){
        DialogFragment newFragment = new PicturePickerFragment();
        newFragment.show(getFragmentManager(), "tag");
    }
}
