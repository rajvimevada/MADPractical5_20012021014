package com.example.madpractical5_20012021014_1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.madpractical5_20012021014_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        var count:Int=0
        fun play(){
            Intent(applicationContext,MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply { startService(this) }
        }

        fun replay(){
            Intent(applicationContext,MyService::class.java).putExtra(MyService.DATA_KEY,MyService.DATA_VALUE).apply { onRestart() }
        }

        fun stop() {
            Intent(applicationContext, MyService::class.java).apply { stopService(this) }
        }

        binding.btnShuffle.setOnClickListener{
            play()
        }

        binding.btnPrevious.setOnClickListener{
            play()
        }

        binding.btnPlay.setOnClickListener{
            if(count%2==0) {
                play()
                binding.btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_pause_24))
                count++
            }

            else{
                stop()
                binding.btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_play_arrow_24))
                count++
            }


        }

        binding.btnNext.setOnClickListener{
            play()
        }

        binding.btnStop.setOnClickListener{
            binding.btnPlay.setImageDrawable(getDrawable(R.drawable.ic_baseline_play_arrow_24))
            stop()
            count++
        }
    }
}