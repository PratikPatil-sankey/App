package com.example.pratik.moviefetch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pratik.R
import com.example.pratik.activities.DetailActivity
import com.squareup.picasso.Picasso

class MovieAdapter(private val context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movies: List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("MOVIE", movie)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val releaseDateTextView: TextView = itemView.findViewById(R.id.releaseDateTextView)
        private val caption: TextView = itemView.findViewById(R.id.Caption)
        private val captionNew: TextView? = itemView.findViewById(R.id.CaptionNew)

        fun bind(movie: Movie) {
            titleTextView.text = movie.titleText.text
            releaseDateTextView.text = "${movie.releaseDate.day}-${movie.releaseDate.month}-${movie.releaseDate.year}"
            caption.text = movie.titleType.text
            captionNew?.text = movie.primaryImage?.caption?.plainText
            movie.primaryImage?.url?.let {
                Picasso.get()
                    .load(it)
                    .resize(150, 220)
                    .centerCrop()
                    .into(imageView)
            }

        }
    }
}
