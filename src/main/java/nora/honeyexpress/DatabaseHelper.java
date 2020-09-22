package nora.honeyexpress;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "OrdersManager";
    private static final String TABLE_ORDERS = "Orders";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CONTACT = "contact";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_TYPE = "type";
    private static final String KEY_REQUEST = "request";
    private static final String KEY_QUANTITY = "quantity";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + " (" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_REQUEST + " TEXT," + KEY_ADDRESS + "TEXT," + KEY_QUANTITY + "INTEGER,"
                + KEY_TYPE + "TEXT," + KEY_CONTACT + "TEXT)";
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(db);
    }

    // code to add the new contact
    void addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, order.get_name()); // Customer Name
        values.put(KEY_CONTACT, order.get_contact()); // Customer Contact
        values.put(KEY_ADDRESS, order.get_address()); // customer address
        values.put(KEY_QUANTITY, order.get_quantity()); // honey quantity
        values.put(KEY_TYPE, order.get_type()); // honey type
        values.put(KEY_REQUEST, order.get_request()); // special request

        // Inserting Row
        db.insert(TABLE_ORDERS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
}

