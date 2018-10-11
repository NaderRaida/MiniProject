package com.goldcode.naderwalid.miniproject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ProgressBar;

public class NoUIFragment extends Fragment {

    private static final int INTENT_AUTH_CODE = 130;
    UserLoginTask mAuthTask;
    ProgressBar progressBar;
    String email;
    String password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("NoUIFragment::onCreate");

        setRetainInstance(true);

        Intent intent = getActivity().getIntent();
        email= intent.getStringExtra("email");
        password = intent.getStringExtra("password");
        mAuthTask = new UserLoginTask(email, password);
        mAuthTask.execute((Void) null);
    }


    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }


    private  class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Show progress
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return false;
            }

            // Check email and pass
            if (!email.equals("nader@gmail.com") || !password.equals("nader")){

                return false;

            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            if (success) {
                // Start MainActivity
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            } else {
                // Hide Progress and Show error
                progressBar.setVisibility(View.GONE);
                getActivity().setResult(Activity.RESULT_CANCELED);
                getActivity().finish();

            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            // Hide progress
            progressBar.setVisibility(View.GONE);
        }
    }

}
