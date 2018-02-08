package view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.a340team.tickettoride.R;

import model.ClientRoot;
import presenter.LoginPresenter;

/**
 * A signin screen that offers signin via _username/_password.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private EditText _usernameSignInText;
    private EditText _passwordSignInText;
    private EditText _usernameRegisterText;
    private EditText _passwordRegisterText;
    private EditText _passwordConfirmText;
    private Button _signInButton;
    private Button _registerButton;
    private boolean _signInEnabled = false;
    private LoginPresenter _loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //This will start our main or first activity.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //We need to create an intent in order to "intend" for it to do something.
        Intent intent = getIntent();

        _setUpObserver();
        _initializeLoginElements();
        _createLoginListeners();

        startActivity(intent);
    }

    @Override
    public void enableSignIn(boolean enabled) {

    }

    @Override
    public void enableRegister(boolean enabled) {

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

    private void _verifySignInIsFilled() {

        //The user has to put some information in those text boxes
        String usernameTextBox = _usernameSignInText.getText().toString();
        String passwordTextBox = _passwordSignInText.getText().toString();
        if(!usernameTextBox.isEmpty() && !passwordTextBox.isEmpty()){
            if(!ViewUtilities.containsSpecialCharacters(usernameTextBox) &&
                    !ViewUtilities.containsSpecialCharacters(passwordTextBox)) {
                //Should be good to sign in
                _signInEnabled = true;
            }
        }


    }


    private void _disableInput(){
        _usernameSignInText.setFocusable(false);
        _passwordSignInText.setFocusable(false);
        _usernameRegisterText.setFocusable(false);
        _passwordRegisterText.setFocusable(false);
        _passwordConfirmText.setFocusable(false);
        _signInButton.setEnabled(false);
        _registerButton.setEnabled(false);

    }

    private void _enableInput(){
        _usernameSignInText.setFocusable(true);
        _passwordSignInText.setFocusable(true);
        _usernameRegisterText.setFocusable(true);
        _passwordRegisterText.setFocusable(true);
        _passwordConfirmText.setFocusable(true);
        _signInButton.setEnabled(true);
        _registerButton.setEnabled(true);

        _usernameSignInText.setFocusableInTouchMode(true);
        _passwordSignInText.setFocusableInTouchMode(true);
        _usernameRegisterText.setFocusableInTouchMode(true);
        _passwordRegisterText.setFocusableInTouchMode(true);
        _passwordConfirmText.setFocusableInTouchMode(true);
        _signInButton.setEnabled(true);
        _registerButton.setEnabled(true);

    }

    private void _setUpObserver(){

        ClientRoot root = ClientRoot.instance();
        _loginPresenter = new LoginPresenter(root);
        root.addObserver(_loginPresenter);
    }

    private void _initializeLoginElements(){

        //Sign In Portion
        _usernameSignInText = (EditText) findViewById(R.id.username);
        _passwordSignInText = (EditText) findViewById(R.id.password);
        _signInButton = (Button) findViewById(R.id.sign_in_button);

        //Register Portion
        _usernameRegisterText = (EditText) findViewById(R.id.register_username);
        _passwordRegisterText = (EditText) findViewById(R.id.register_password);
        _passwordConfirmText = (EditText) findViewById(R.id.register_password_confirm);
        _registerButton = (Button) findViewById(R.id.register_button);

    }

    private void _createLoginListeners(){

        //Button Listeners
        _signInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                _disableInput();
                _verifySignInIsFilled();

                if (_signInEnabled) {
                    //Set what ever is in the text, and sign in.
                    String username = _usernameSignInText.getText().toString();
                    String password = _passwordSignInText.getText().toString();
                    _loginPresenter.signIn(username,password);
                    //Switch activities if successful

                }
                _enableInput();
            }
        });

        _registerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                //Set up for register functionality.

            }
        });
    }


}

