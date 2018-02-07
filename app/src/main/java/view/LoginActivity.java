package view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.a340team.tickettoride.R;

import presenter.LoginPresenter;

/**
 * A signin screen that offers signin via username/password.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView{

    // UI references.
    private EditText usernameSignInText = null;
    private EditText passwordSignInText = null;
    private EditText usernameRegisterText = null;
    private EditText passwordRegisterText = null;
    private EditText passwordConfirmText = null;
    private Button signInButton = null;
    private Button registerButton = null;
    private View mProgressView = null;
    private View mLoginFormView = null;


    //Private data members
    private String username;
    private String password;
    private boolean signInEnabled = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //This will start our main or first activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //We need to create an intent in order to "intend" for it to do something.
        Intent intent = getIntent();
        startActivity(intent);

        //Set up the variables
        //Sign In Portion
        usernameSignInText = (EditText) findViewById(R.id.username);
        passwordSignInText = (EditText) findViewById(R.id.password);
        signInButton = (Button) findViewById(R.id.sign_in_button);

        //Register Portion
        usernameRegisterText = (EditText) findViewById(R.id.register_username);
        passwordRegisterText = (EditText) findViewById(R.id.register_password);
        passwordConfirmText = (EditText) findViewById(R.id.register_password_confirm);
        registerButton = (Button) findViewById(R.id.register_button);

        //Button Listeners
        signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                verifySignInIsFilled();

                if (signInEnabled) {
                    //Set what ever is in the text, and sign in.
                    setUsername(usernameSignInText.getText().toString());
                    setPassword(passwordSignInText.getText().toString());
                    LoginPresenter.signIn(username, password);
                }
                //Maybe display a message if they aren't filling in both username and password?
            }
        });

        registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //Set up for register functionality.

            }
        });


        //Not sure what these are for?
        //mLoginFormView = findViewById(R.id.login_form);
        //mProgressView = findViewById(R.id.login_progress);
    }



    public void disableInput(){
        usernameSignInText.setFocusable(false);
        passwordSignInText.setFocusable(false);
        usernameRegisterText.setFocusable(false);
        passwordRegisterText.setFocusable(false);
        passwordConfirmText.setFocusable(false);
        signInButton.setEnabled(false);
        registerButton.setEnabled(false);

    }

    public void enableInput(){
        usernameSignInText.setFocusable(false);
        passwordSignInText.setFocusable(false);
        usernameRegisterText.setFocusable(false);
        passwordRegisterText.setFocusable(false);
        passwordConfirmText.setFocusable(false);
        signInButton.setEnabled(false);
        registerButton.setEnabled(false);

    }

    @Override
    public void enableSignIn(boolean enabled) {

    }

    @Override
    public void enableRegister(boolean enabled) {

    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsernameSignIn() {
        return null;
    }

    @Override
    public String getPasswordSignIn() {
        return null;
    }

    @Override
    public String getUsernameRegister() {
        return null;
    }

    @Override
    public String getPasswordRegister() {
        return null;
    }

    @Override
    public void displayMessage(String message) {

    }

    private void verifySignInIsFilled() {

        //The user has to put some information in those text boxes
        String empty = "";
        String usernameTextBox = usernameSignInText.getText().toString();
        String passwordTextBox = passwordSignInText.getText().toString();
        if(!usernameTextBox.equals(empty) && !passwordTextBox.equals(empty)){
            //Should be good to sign in
            signInEnabled = true;
        }

    }




//    /**
//     * Shows the progress UI and hides the signin form.
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

