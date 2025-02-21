package com.example.food.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.food.entity.Cart;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CartDAO_Impl implements CartDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cart> __insertionAdapterOfCart;

  private final EntityDeletionOrUpdateAdapter<Cart> __deletionAdapterOfCart;

  private final EntityDeletionOrUpdateAdapter<Cart> __updateAdapterOfCart;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCartByPhoneNumber;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCartItemByPhoneNumberAndItemName;

  public CartDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCart = new EntityInsertionAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `cart` (`id`,`phoneNumber`,`itemName`,`price`,`quantity`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPhoneNumber());
        }
        if (entity.getItemName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getItemName());
        }
        statement.bindDouble(4, entity.getPrice());
        statement.bindLong(5, entity.getQuantity());
      }
    };
    this.__deletionAdapterOfCart = new EntityDeletionOrUpdateAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `cart` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCart = new EntityDeletionOrUpdateAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `cart` SET `id` = ?,`phoneNumber` = ?,`itemName` = ?,`price` = ?,`quantity` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPhoneNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPhoneNumber());
        }
        if (entity.getItemName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getItemName());
        }
        statement.bindDouble(4, entity.getPrice());
        statement.bindLong(5, entity.getQuantity());
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteCartByPhoneNumber = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM cart WHERE phoneNumber = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCartItemByPhoneNumberAndItemName = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM cart WHERE phoneNumber = ? AND itemName = ?";
        return _query;
      }
    };
  }

  @Override
  public void insertCartItem(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCart.insert(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCartItem(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCart.handle(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCartItem(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCart.handle(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteCartByPhoneNumber(final String phoneNumber) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCartByPhoneNumber.acquire();
    int _argIndex = 1;
    if (phoneNumber == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, phoneNumber);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteCartByPhoneNumber.release(_stmt);
    }
  }

  @Override
  public void deleteCartItemByPhoneNumberAndItemName(final String phoneNumber,
      final String itemName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCartItemByPhoneNumberAndItemName.acquire();
    int _argIndex = 1;
    if (phoneNumber == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, phoneNumber);
    }
    _argIndex = 2;
    if (itemName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, itemName);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteCartItemByPhoneNumberAndItemName.release(_stmt);
    }
  }

  @Override
  public List<Cart> getAllCartItems() {
    final String _sql = "SELECT * FROM cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<Cart> _result = new ArrayList<Cart>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Cart _item;
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final String _tmpItemName;
        if (_cursor.isNull(_cursorIndexOfItemName)) {
          _tmpItemName = null;
        } else {
          _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
        }
        final double _tmpPrice;
        _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _item = new Cart(_tmpPhoneNumber,_tmpItemName,_tmpPrice,_tmpQuantity);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Cart> getCartItemsByPhoneNumber(final String phoneNumber) {
    final String _sql = "SELECT * FROM cart WHERE phoneNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phoneNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phoneNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "phoneNumber");
      final int _cursorIndexOfItemName = CursorUtil.getColumnIndexOrThrow(_cursor, "itemName");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final List<Cart> _result = new ArrayList<Cart>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Cart _item;
        final String _tmpPhoneNumber;
        if (_cursor.isNull(_cursorIndexOfPhoneNumber)) {
          _tmpPhoneNumber = null;
        } else {
          _tmpPhoneNumber = _cursor.getString(_cursorIndexOfPhoneNumber);
        }
        final String _tmpItemName;
        if (_cursor.isNull(_cursorIndexOfItemName)) {
          _tmpItemName = null;
        } else {
          _tmpItemName = _cursor.getString(_cursorIndexOfItemName);
        }
        final double _tmpPrice;
        _tmpPrice = _cursor.getDouble(_cursorIndexOfPrice);
        final int _tmpQuantity;
        _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        _item = new Cart(_tmpPhoneNumber,_tmpItemName,_tmpPrice,_tmpQuantity);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<String> getItemNamesByPhoneNumber(final String phoneNumber) {
    final String _sql = "SELECT itemName FROM cart WHERE phoneNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phoneNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phoneNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getTotalPriceByPhoneNumber(final String phoneNumber) {
    final String _sql = "SELECT SUM(price * quantity) FROM cart WHERE phoneNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phoneNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phoneNumber);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
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
