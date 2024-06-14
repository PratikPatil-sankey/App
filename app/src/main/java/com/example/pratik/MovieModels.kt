package com.example.pratik

data class MovieResponse(
    val page: Int,
    val next: String,
    val entries: Int,
    val results: List<Movie>
)

data class Movie(
    val _id: String,
    val id: String,
    val primaryImage: PrimaryImage?,
    val titleType: TitleType,
    val titleText: TitleText,
    val originalTitleText: OriginalTitleText,
    val releaseYear: ReleaseYear,
    val releaseDate: ReleaseDate
)

data class PrimaryImage(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val caption: Caption
)

data class Caption(
    val plainText: String
)

data class TitleType(
    val text: String
)

data class TitleText(
    val text: String
)

data class OriginalTitleText(
    val text: String
)

data class ReleaseYear(
    val year: Int
)

data class ReleaseDate(
    val day: Int,
    val month: Int,
    val year: Int
)
