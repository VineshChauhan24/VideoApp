package com.example.video.videoapp.data.db


import com.example.video.videoapp.data.db.model.DaoMaster
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDbHelper @Inject
constructor(dbOpenHelper: DbOpenHelper): DbHelper {

    private var mDaoSession = DaoMaster(dbOpenHelper.writableDb).newSession()

    //db related methods

}
