package com.example.video.videoapp.data.db

import android.content.Context
import android.util.Log
import com.example.video.videoapp.data.db.model.DaoMaster
import com.example.video.videoapp.di.ApplicationContext
import com.example.video.videoapp.di.DatabaseInfo
import org.greenrobot.greendao.database.Database
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbOpenHelper @Inject
constructor(@ApplicationContext context: Context, @DatabaseInfo name: String) : DaoMaster.OpenHelper(context, name) {

    override fun onUpgrade(db: Database, oldVersion: Int, newVersion: Int) {
        super.onUpgrade(db, oldVersion, newVersion)
        Log.d("DEBUG", "DB_OLD_VERSION : $oldVersion, DB_NEW_VERSION : $newVersion")
       /* when (oldVersion) {

        }*///db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
        // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
    }
}
