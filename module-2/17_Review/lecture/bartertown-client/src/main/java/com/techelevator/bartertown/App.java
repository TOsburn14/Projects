package com.techelevator.bartertown;

import com.techelevator.bartertown.model.AuthenticatedUser;
import com.techelevator.bartertown.model.UserCredentials;
import com.techelevator.bartertown.services.AuthenticationService;
import com.techelevator.bartertown.services.ConsoleService;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";
    public static final int REGISTER_USER = 1;
    public static final int LOGIN_USER = 2;
    public static final int EXIT_APP = 0;
    public static final int SEND_ITEM = 1;
    public static final int VIEW_RECIEVED = 2;
    public static final int VIEW_HISTORY = 3;

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private AuthenticatedUser currentUser;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != EXIT_APP && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == REGISTER_USER) {
                handleRegister();
            } else if (menuSelection == LOGIN_USER) {
                handleLogin();
            } else if (menuSelection != EXIT_APP) {
                consoleService.printNotice("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        consoleService.printNotice("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            consoleService.printNotice("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != EXIT_APP) {
            showMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == SEND_ITEM) {
                // TODO: 2. Send an item to another user
            } else if (menuSelection == VIEW_RECIEVED) {
                // TODO: 3. Show items received from other users
            } else if (menuSelection == VIEW_HISTORY) {
                // TODO: 4. Show all barter history
            } else if (menuSelection == EXIT_APP) {
                continue;
            } else {
                consoleService.printNotice("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void showMainMenu() {

        int credits = 0;

        // TODO: 1. Get the credits for the user

        consoleService.printMainMenu(credits);
    }





}
