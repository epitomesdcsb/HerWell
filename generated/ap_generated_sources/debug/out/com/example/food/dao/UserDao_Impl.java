package com.example.food.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.food.entity.LoggedUser;
import com.example.food.entity.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityInsertionAdapter<LoggedUser> __insertionAdapterOfLoggedUser;

  private final SharedSQLiteStatement __preparedStmtOfClearLoggedUser;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `her_well_users` (`id`,`name`,`age`,`email`,`phone`,`password`,`profile`,`profileImagePath`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final User entity) {
        statement.bindLong(1, entity.id);
        if (entity.name == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.name);
        }
        if (entity.age == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.age);
        }
        if (entity.email == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.email);
        }
        if (entity.phone == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.phone);
        }
        if (entity.password == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.password);
        }
        if (entity.profile == null) {
          statement.bindNull(7);
        } else {
          statement.bindBlob(7, entity.profile);
        }
        if (entity.profileImagePath == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.profileImagePath);
        }
      }
    };
    this.__insertionAdapterOfLoggedUser = new EntityInsertionAdapter<LoggedUser>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `logged_user` (`id`,`name`,`age`,`email`,`phone`,`profile`,`profileImagePath`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final LoggedUser entity) {
        statement.bindLong(1, entity.id);
        if (entity.name == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.name);
        }
        if (entity.age == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.age);
        }
        if (entity.email == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.email);
        }
        if (entity.phone == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.phone);
        }
        if (entity.profile == null) {
          statement.bindNull(6);
        } else {
          statement.bindBlob(6, entity.profile);
        }
        if (entity.profileImagePath == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.profileImagePath);
        }
      }
    };
    this.__preparedStmtOfClearLoggedUser = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM logged_user";
        return _query;
      }
    };
  }

  @Override
  public void insertUser(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertLoggedUser(final LoggedUser loggedUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLoggedUser.insert(loggedUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearLoggedUser() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearLoggedUser.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfClearLoggedUser.release(_stmt);
    }
  }

  @Override
  public User loginUser(final String phone, final String password) {
    final String _sql = "SELECT * FROM her_well_users WHERE phone = ? AND password = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    _argIndex = 2;
    if (password == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, password);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfProfile = CursorUtil.getColumnIndexOrThrow(_cursor, "profile");
      final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
      final User _result;
      if (_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAge;
        if (_cursor.isNull(_cursorIndexOfAge)) {
          _tmpAge = null;
        } else {
          _tmpAge = _cursor.getString(_cursorIndexOfAge);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpProfile;
        if (_cursor.isNull(_cursorIndexOfProfile)) {
          _tmpProfile = null;
        } else {
          _tmpProfile = _cursor.getBlob(_cursorIndexOfProfile);
        }
        final String _tmpProfileImagePath;
        if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
          _tmpProfileImagePath = null;
        } else {
          _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
        }
        _result = new User(_tmpName,_tmpAge,_tmpEmail,_tmpPhone,_tmpPassword,_tmpProfile,_tmpProfileImagePath);
        _result.id = _cursor.getInt(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LoggedUser getLoggedUser() {
    final String _sql = "SELECT * FROM logged_user LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfProfile = CursorUtil.getColumnIndexOrThrow(_cursor, "profile");
      final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
      final LoggedUser _result;
      if (_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAge;
        if (_cursor.isNull(_cursorIndexOfAge)) {
          _tmpAge = null;
        } else {
          _tmpAge = _cursor.getString(_cursorIndexOfAge);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final byte[] _tmpProfile;
        if (_cursor.isNull(_cursorIndexOfProfile)) {
          _tmpProfile = null;
        } else {
          _tmpProfile = _cursor.getBlob(_cursorIndexOfProfile);
        }
        final String _tmpProfileImagePath;
        if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
          _tmpProfileImagePath = null;
        } else {
          _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
        }
        _result = new LoggedUser(_tmpName,_tmpAge,_tmpEmail,_tmpPhone,_tmpProfile,_tmpProfileImagePath);
        _result.id = _cursor.getInt(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByPhone(final String phone) {
    final String _sql = "SELECT * FROM her_well_users WHERE phone = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfProfile = CursorUtil.getColumnIndexOrThrow(_cursor, "profile");
      final int _cursorIndexOfProfileImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "profileImagePath");
      final User _result;
      if (_cursor.moveToFirst()) {
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpAge;
        if (_cursor.isNull(_cursorIndexOfAge)) {
          _tmpAge = null;
        } else {
          _tmpAge = _cursor.getString(_cursorIndexOfAge);
        }
        final String _tmpEmail;
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _tmpEmail = null;
        } else {
          _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
        }
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        final byte[] _tmpProfile;
        if (_cursor.isNull(_cursorIndexOfProfile)) {
          _tmpProfile = null;
        } else {
          _tmpProfile = _cursor.getBlob(_cursorIndexOfProfile);
        }
        final String _tmpProfileImagePath;
        if (_cursor.isNull(_cursorIndexOfProfileImagePath)) {
          _tmpProfileImagePath = null;
        } else {
          _tmpProfileImagePath = _cursor.getString(_cursorIndexOfProfileImagePath);
        }
        _result = new User(_tmpName,_tmpAge,_tmpEmail,_tmpPhone,_tmpPassword,_tmpProfile,_tmpProfileImagePath);
        _result.id = _cursor.getInt(_cursorIndexOfId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
