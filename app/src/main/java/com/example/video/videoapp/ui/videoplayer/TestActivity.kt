package com.example.video.videoapp.ui.videoplayer

import android.content.Context
import android.content.Intent
import com.example.video.videoapp.R
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.video.videoapp.BuildConfig
import com.example.video.videoapp.ui.base.BaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.activity_video_player.*

class TestActivity : BaseActivity(), YouTubePlayer.OnInitializedListener{

    lateinit var mTitle:String
    lateinit var mPlayId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        mTitle = intent.getStringExtra(TestActivity.INTENT_TITLE)
                ?: throw IllegalStateException("field ${TestActivity.INTENT_TITLE} missing in Intent")
        mPlayId = intent.getStringExtra(TestActivity.INTENT_PLAY_ID)
                ?: throw IllegalStateException("field ${TestActivity.INTENT_PLAY_ID} missing in Intent")

        tv_video_title.text = mTitle

        (youtube_fragment as YouTubePlayerSupportFragment).initialize(BuildConfig.YOUTUBE_KEY, this)
    }

    override fun createProgressBar() : ProgressBar {
        return ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
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
            Toast.makeText(this,errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == TestActivity.RECOVERY_DIALOG_REQUEST)
            youtube_view.initialize(BuildConfig.YOUTUBE_KEY, this)
    }

    companion object {
        private val INTENT_TITLE = "title"
        private val INTENT_PLAY_ID = "play_id"
        private val RECOVERY_DIALOG_REQUEST = 1

        fun newIntent(context: Context, title: String, playId: String): Intent {
            val intent = Intent(context, TestActivity::class.java)
            intent.putExtra(INTENT_TITLE, title)
            intent.putExtra(INTENT_PLAY_ID, playId)
            return intent
        }
    }
}
