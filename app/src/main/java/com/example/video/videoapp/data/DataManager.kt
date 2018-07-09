package com.example.video.videoapp.data

import com.example.video.videoapp.data.db.DbHelper
import com.example.video.videoapp.data.network.ApiHelper

interface DataManager : ApiHelper, DbHelper
