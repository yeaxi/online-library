package ua.dudka.command;

import ua.dudka.command.admin.AdminAddBook;
import ua.dudka.command.admin.AdminRemoveBookCommand;
import ua.dudka.command.book.*;
import ua.dudka.command.user.*;

/**
 * Created by RASTA on 16.03.2016.
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    SIGNUP {
        {
            this.command = new SignUpCommand();
        }
    },
    ABOUTUSER {
        {
            this.command = new AboutUserCommand();
        }
    },
    ADDBOOK {
        {
            this.command = new AddBookCommand();
        }
    },
    ADMINADDBOOK {
        {
            this.command = new AdminAddBook();
        }
    },
    ABOUTBOOK {
        {
            this.command = new AboutBookCommand();
        }
    },
    SEARCH {
        {
            this.command = new SearchCommand();
        }
    },
    REMOVEBOOK {
        {
            this.command = new RemoveBookCommand();
        }
    },
    ADMINREMOVEBOOK {
        {
            this.command = new AdminRemoveBookCommand();
        }
    },
    SHOWBOOKS {
        {
            this.command = new ShowBooksCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
