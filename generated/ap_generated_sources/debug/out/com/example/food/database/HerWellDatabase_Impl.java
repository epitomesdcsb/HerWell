package com.example.food.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.food.dao.CartDAO;
import com.example.food.dao.CartDAO_Impl;
import com.example.food.dao.PromptDao;
import com.example.food.dao.PromptDao_Impl;
import com.example.food.dao.UserDao;
import com.example.food.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HerWellDatabase_Impl extends HerWellDatabase {
  private volatile UserDao _userDao;

  private volatile CartDAO _cartDAO;

  private volatile PromptDao _promptDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `her_well_users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `age` TEXT, `email` TEXT, `phone` TEXT, `password` TEXT, `profile` BLOB, `profileImagePath` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `logged_user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `age` TEXT, `email` TEXT, `phone` TEXT, `profile` BLOB, `profileImagePath` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `prompt_responses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `user` TEXT, `prompt` TEXT, `response` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cart` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `phoneNumber` TEXT, `itemName` TEXT, `price` REAL NOT NULL, `quantity` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'aa0398758eb6a15365a41fdd5bd21890')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `her_well_users`");
        db.execSQL("DROP TABLE IF EXISTS `logged_user`");
        db.execSQL("DROP TABLE IF EXISTS `prompt_responses`");
        db.execSQL("DROP TABLE IF EXISTS `cart`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsHerWellUsers = new HashMap<String, TableInfo.Column>(8);
        _columnsHerWellUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("age", new TableInfo.Column("age", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("profile", new TableInfo.Column("profile", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHerWellUsers.put("profileImagePath", new TableInfo.Column("profileImagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHerWellUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHerWellUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHerWellUsers = new TableInfo("her_well_users", _columnsHerWellUsers, _foreignKeysHerWellUsers, _indicesHerWellUsers);
        final TableInfo _existingHerWellUsers = TableInfo.read(db, "her_well_users");
        if (!_infoHerWellUsers.equals(_existingHerWellUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "her_well_users(com.example.food.entity.User).\n"
                  + " Expected:\n" + _infoHerWellUsers + "\n"
                  + " Found:\n" + _existingHerWellUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsLoggedUser = new HashMap<String, TableInfo.Column>(7);
        _columnsLoggedUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("age", new TableInfo.Column("age", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("profile", new TableInfo.Column("profile", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLoggedUser.put("profileImagePath", new TableInfo.Column("profileImagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLoggedUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLoggedUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLoggedUser = new TableInfo("logged_user", _columnsLoggedUser, _foreignKeysLoggedUser, _indicesLoggedUser);
        final TableInfo _existingLoggedUser = TableInfo.read(db, "logged_user");
        if (!_infoLoggedUser.equals(_existingLoggedUser)) {
          return new RoomOpenHelper.ValidationResult(false, "logged_user(com.example.food.entity.LoggedUser).\n"
                  + " Expected:\n" + _infoLoggedUser + "\n"
                  + " Found:\n" + _existingLoggedUser);
        }
        final HashMap<String, TableInfo.Column> _columnsPromptResponses = new HashMap<String, TableInfo.Column>(4);
        _columnsPromptResponses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromptResponses.put("user", new TableInfo.Column("user", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromptResponses.put("prompt", new TableInfo.Column("prompt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromptResponses.put("response", new TableInfo.Column("response", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPromptResponses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPromptResponses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPromptResponses = new TableInfo("prompt_responses", _columnsPromptResponses, _foreignKeysPromptResponses, _indicesPromptResponses);
        final TableInfo _existingPromptResponses = TableInfo.read(db, "prompt_responses");
        if (!_infoPromptResponses.equals(_existingPromptResponses)) {
          return new RoomOpenHelper.ValidationResult(false, "prompt_responses(com.example.food.entity.PromptResponse).\n"
                  + " Expected:\n" + _infoPromptResponses + "\n"
                  + " Found:\n" + _existingPromptResponses);
        }
        final HashMap<String, TableInfo.Column> _columnsCart = new HashMap<String, TableInfo.Column>(5);
        _columnsCart.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("itemName", new TableInfo.Column("itemName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCart = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCart = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCart = new TableInfo("cart", _columnsCart, _foreignKeysCart, _indicesCart);
        final TableInfo _existingCart = TableInfo.read(db, "cart");
        if (!_infoCart.equals(_existingCart)) {
          return new RoomOpenHelper.ValidationResult(false, "cart(com.example.food.entity.Cart).\n"
                  + " Expected:\n" + _infoCart + "\n"
                  + " Found:\n" + _existingCart);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "aa0398758eb6a15365a41fdd5bd21890", "5a6569a67cb5ce2b8705535783200981");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "her_well_users","logged_user","prompt_responses","cart");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `her_well_users`");
      _db.execSQL("DELETE FROM `logged_user`");
      _db.execSQL("DELETE FROM `prompt_responses`");
      _db.execSQL("DELETE FROM `cart`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CartDAO.class, CartDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(PromptDao.class, PromptDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public CartDAO cartDao() {
    if (_cartDAO != null) {
      return _cartDAO;
    } else {
      synchronized(this) {
        if(_cartDAO == null) {
          _cartDAO = new CartDAO_Impl(this);
        }
        return _cartDAO;
      }
    }
  }

  @Override
  public PromptDao promptDao() {
    if (_promptDao != null) {
      return _promptDao;
    } else {
      synchronized(this) {
        if(_promptDao == null) {
          _promptDao = new PromptDao_Impl(this);
        }
        return _promptDao;
      }
    }
  }
}
