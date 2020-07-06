package Game.UserInteraction;

public class PlayerNickExceptions extends Exception {

    public static final int NO_ERROR=0;
    public static final int NO_TEXT=1;
    public static final int NO_STRING=2;
    public static final int ERROR_404=3;

    private final int errorCode;

    public PlayerNickExceptions(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        String desc= "no error";

        if (errorCode==1) desc="you did not insert any text!";
        if (errorCode==2) desc="Please use only letters!";
        if (errorCode==3) desc="ERROR 404";

        return desc;
    }
}
