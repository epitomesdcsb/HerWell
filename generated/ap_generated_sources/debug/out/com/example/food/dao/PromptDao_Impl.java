package com.example.food.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.food.entity.PromptResponse;
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
public final class PromptDao_Impl implements PromptDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PromptResponse> __insertionAdapterOfPromptResponse;

  public PromptDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPromptResponse = new EntityInsertionAdapter<PromptResponse>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `prompt_responses` (`id`,`user`,`prompt`,`response`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final PromptResponse entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getUser() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUser());
        }
        if (entity.getPrompt() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPrompt());
        }
        if (entity.getResponse() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getResponse());
        }
      }
    };
  }

  @Override
  public void insertPrompt(final PromptResponse promptResponse) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPromptResponse.insert(promptResponse);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PromptResponse> getAllPrompts() {
    final String _sql = "SELECT * FROM prompt_responses ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUser = CursorUtil.getColumnIndexOrThrow(_cursor, "user");
      final int _cursorIndexOfPrompt = CursorUtil.getColumnIndexOrThrow(_cursor, "prompt");
      final int _cursorIndexOfResponse = CursorUtil.getColumnIndexOrThrow(_cursor, "response");
      final List<PromptResponse> _result = new ArrayList<PromptResponse>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final PromptResponse _item;
        final String _tmpUser;
        if (_cursor.isNull(_cursorIndexOfUser)) {
          _tmpUser = null;
        } else {
          _tmpUser = _cursor.getString(_cursorIndexOfUser);
        }
        final String _tmpPrompt;
        if (_cursor.isNull(_cursorIndexOfPrompt)) {
          _tmpPrompt = null;
        } else {
          _tmpPrompt = _cursor.getString(_cursorIndexOfPrompt);
        }
        final String _tmpResponse;
        if (_cursor.isNull(_cursorIndexOfResponse)) {
          _tmpResponse = null;
        } else {
          _tmpResponse = _cursor.getString(_cursorIndexOfResponse);
        }
        _item = new PromptResponse(_tmpPrompt,_tmpResponse,_tmpUser);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
