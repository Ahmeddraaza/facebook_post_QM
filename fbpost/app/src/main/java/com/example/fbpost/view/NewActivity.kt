package com.example.fbpost.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fbpost.databinding.ActivityNewBinding
import com.squareup.picasso.Picasso

class NewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewBinding

    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUrl = intent.getStringExtra("image_url")
        val fbPostLink = intent.getStringExtra("fb_post_link")
        println("fb_post_link ${fbPostLink}")
        println("image_url ${imageUrl}")

        if (!imageUrl.isNullOrEmpty()) {
            Picasso.get().load(imageUrl).into(binding.imageView)
        }

        binding.likeButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(fbPostLink))
            startActivity(browserIntent)
        }

        binding.shareButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND, Uri.parse(fbPostLink))
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, fbPostLink)
            startActivity(Intent.createChooser(intent, "Share To:"))
        }

        binding.closeButton.setOnClickListener {
            finish()
        }

    }
}
