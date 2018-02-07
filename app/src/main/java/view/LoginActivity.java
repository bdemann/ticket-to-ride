package view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.a340team.tickettoride.R;

import guifacade.LoginGuiFacade;

/**
 * A login screen that offers login via username/password.
 */
public class LoginActivity extends AppCompatActivity{

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
//    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mUserNameView = null;
    private EditText mPasswordView = null;
    private EditText register_UserNameView = null;
    private EditText register_PasswordView = null;
    private EditText register_PasswordConfirmView = null;
    private Button SignInButton = null;
    private Button RegisterButton = null;
    private View mProgressView = null;
    private View mLoginFormView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //This will start our main or first activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //We need to create an intent in order to "intend" for it to do something.
        Intent intent = getIntent();


        //FragmentManager fm = getFragmentManager();
        //Fragment fragment = fm.findFragmentById(R.id.login_form);

        startActivity(intent);





        /*
        // Set up the login form.
        mUserNameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        register_UserNameView = (EditText) findViewById(R.id.register_user_name);
        register_PasswordView = (EditText) findViewById(R.id.register_password);
        register_PasswordConfirmView = (EditText) findViewById(R.id.register_password_confirm);
        SignInButton = (Button) findViewById(R.id.sign_in_button);
        SignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginGuiFacade.signIn(mUserNameView.getText().toString(), mPasswordView.getText().toString());
            }
        });
        RegisterButton = (Button) findViewById(R.id.register_button);
        RegisterButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginGuiFacade.register(register_UserNameView.getText().toString(), register_PasswordView.getText().toString(),
                        register_PasswordConfirmView.getText().toString());
            }
        });


        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);*/
    }


    public void disableInput(){
        mUserNameView.setFocusable(false);
        mPasswordView.setFocusable(false);
        register_UserNameView.setFocusable(false);
        register_PasswordView.setFocusable(false);
        register_PasswordConfirmView.setFocusable(false);
        SignInButton.setEnabled(false);
        RegisterButton.setEnabled(false);

    }

    public void enableInput(){
        mUserNameView.setFocusable(false);
        mPasswordView.setFocusable(false);
        register_UserNameView.setFocusable(false);
        register_PasswordView.setFocusable(false);
        register_PasswordConfirmView.setFocusable(false);
        SignInButton.setEnabled(false);
        RegisterButton.setEnabled(false);

    }



//    /**
//     * Shows the progress UI and hides the login form.
//     */
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
//    private void showProgress(final boolean show) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
//            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
//
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//                }
//            });
//
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mProgressView.animate().setDuration(shortAnimTime).alpha(
//                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//                }
//            });
//        } else {
//            // The ViewPropertyAnimator APIs are not available, so simply show
//            // and hide the relevant UI components.
//            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
//            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
//        }
//    }
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
//        return new CursorLoader(this,
//                // Retrieve data rows for the device user's 'profile' contact.
//                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
//                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,
//
//                // Select only email addresses.
//                ContactsContract.Contacts.Data.MIMETYPE +
//                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
//                .CONTENT_ITEM_TYPE},
//
//                // Show primary email addresses first. Note that there won't be
//                // a primary email address if the user hasn't specified one.
//                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
//        List<String> emails = new ArrayList<>();
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            emails.add(cursor.getString(ProfileQuery.ADDRESS));
//            cursor.moveToNext();
//        }
//
//        addEmailsToAutoComplete(emails);
//    }


}

