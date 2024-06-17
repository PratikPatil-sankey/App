package com.example.pratik.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pratik.R
import com.example.pratik.moviefetch.Movie
import com.squareup.picasso.Picasso
class DetailActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var captionTextView:TextView
    private lateinit var captionNewTextView:TextView
    private lateinit var releaseDateTextView:TextView
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        titleTextView = findViewById(R.id.titleTextView)
        captionTextView = findViewById(R.id.captionTextView)
        captionNewTextView = findViewById(R.id.captionNewTextView)
        releaseDateTextView = findViewById(R.id.releaseDateTextView)
        imageView = findViewById(R.id.imageView)

        val movie = intent.getParcelableExtra<Movie>("MOVIE")

        movie?.let {
            titleTextView.text = movie.titleText.text
            releaseDateTextView.text = "${it.releaseDate.day}-${it.releaseDate.month}-${it.releaseDate.year}"
            captionTextView.text = it.titleType.text
            captionNewTextView.text = it.primaryImage?.caption?.plainText

            it.primaryImage?.url?.let { imageUrl ->
                Picasso.get()
                    .load(imageUrl)
                    .resize(500, 750) // Adjust size as needed
                    .centerCrop()
                    .into(imageView)
            }
        }
    }
}
