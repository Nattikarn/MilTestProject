import android.app.LauncherActivity;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mil on 2/9/2018 AD.
 */

public class DbHelper extends SQLiteOpenHelper {


    private static final String TAG = "DbHelper";
    // Database Info
    private static final String DATABASE_NAME = "MilTestProject.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "ListItem";
    public static final String COLUMN_NAME = "ListItemName";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + "INTEGER PRIMARYKEY," + COLUMN_NAME + "LIST ITEM NAME )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


}
