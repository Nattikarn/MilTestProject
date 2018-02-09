import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class DbHelper extends SQLiteOpenHelper {


    private static final String TAG = "DbHelper";
    // Database Info
    private static final String DATABASE_NAME = "UserDatabase";
    private static final int DATABASE_VERSION = 1;

    //Table Names
    private static final String TABLE_USERNAMEDETAIL = "usernameDetail";

    //userdetail Table Columns
    private static final String USERNAME = "username";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERNAMEDETAIL_TABLE = "CREATE TABLE" + TABLE_USERNAMEDETAIL;
        db.execSQL(CREATE_USERNAMEDETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERNAMEDETAIL);

            onCreate(db);
        }
    }

    private static DbHelper mDbHelper;


    public static synchronized DbHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.

        if (mDbHelper == null) {
            mDbHelper = new DbHelper(context.getApplicationContext());
        }
        return mDbHelper;
    }


    /**
     * Constructor should be private to prevent direct instantiation.
     * Make a call to the static method "getInstance()" instead.
     */
    private DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



}
