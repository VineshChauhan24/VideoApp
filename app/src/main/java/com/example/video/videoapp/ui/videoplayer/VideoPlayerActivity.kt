package com.example.video.videoapp.ui.videoplayer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.video.videoapp.BuildConfig
import com.example.video.videoapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener {

    lateinit var mTitle:String
    lateinit var mPlayId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        mTitle = intent.getStringExtra(INTENT_TITLE)
                ?: throw IllegalStateException("field $INTENT_TITLE missing in Intent")
        mPlayId = intent.getStringExtra(INTENT_PLAY_ID)
                ?: throw IllegalStateException("field $INTENT_PLAY_ID missing in Intent")

        video_title.text = mTitle

        youtube_view.initialize(BuildConfig.YOUTUBE_KEY, this)
    }

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?,
                                         wasRestored: Boolean) {

        if (!wasRestored){
            player!!.loadVideo(mPlayId)
        }
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?,
                                         errorReason: YouTubeInitializationResult?) {

        if (errorReason!!.isUserRecoverableError)
            errorReason.getErrorDialog(this,1)
        else{
            val errorMessage = String.format(getString(R.string.error_player), errorReason.toString())
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == RECOVERY_DIALOG_REQUEST)
            youtube_view.initialize(BuildConfig.YOUTUBE_KEY, this)
    }



    companion object {
        private val INTENT_TITLE = "title"
        private val INTENT_PLAY_ID = "play_id"
        private val RECOVERY_DIALOG_REQUEST = 1

        fun newIntent(context: Context, title: String, playId: String): Intent{
            val intent = Intent(context, VideoPlayerActivity::class.java)
            intent.putExtra(INTENT_TITLE, title)
            intent.putExtra(INTENT_PLAY_ID, playId)
            return intent
        }
    }
}
