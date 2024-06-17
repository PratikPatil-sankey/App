package com.example.pratik.moviefetch
import android.os.Parcel
import android.os.Parcelable

data class MovieResponse(
    val page: Int,
    val next: String?,
    val entries: Int,
    val results: List<Movie>
)


data class Movie(
    val id: String,
    val primaryImage: PrimaryImage?,
    val titleType: TitleType,
    val titleText: TitleText,
    val releaseDate: ReleaseDate
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(PrimaryImage::class.java.classLoader),
        parcel.readParcelable(TitleType::class.java.classLoader) ?: TitleType(""),
        parcel.readParcelable(TitleText::class.java.classLoader) ?: TitleText(""),
        parcel.readParcelable(ReleaseDate::class.java.classLoader) ?: ReleaseDate(0, 0, 0)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(primaryImage, flags)
        parcel.writeParcelable(titleType, flags)
        parcel.writeParcelable(titleText, flags)
        parcel.writeParcelable(releaseDate, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

data class PrimaryImage(
    val url: String,
    val caption: Caption
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(Caption::class.java.classLoader) ?: Caption("")
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeParcelable(caption, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PrimaryImage> {
        override fun createFromParcel(parcel: Parcel): PrimaryImage {
            return PrimaryImage(parcel)
        }

        override fun newArray(size: Int): Array<PrimaryImage?> {
            return arrayOfNulls(size)
        }
    }
}

data class Caption(
    val plainText: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(plainText)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Caption> {
        override fun createFromParcel(parcel: Parcel): Caption {
            return Caption(parcel)
        }

        override fun newArray(size: Int): Array<Caption?> {
            return arrayOfNulls(size)
        }
    }
}

data class TitleType(
    val text: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TitleType> {
        override fun createFromParcel(parcel: Parcel): TitleType {
            return TitleType(parcel)
        }

        override fun newArray(size: Int): Array<TitleType?> {
            return arrayOfNulls(size)
        }
    }
}

data class TitleText(
    val text: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString() ?: "")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TitleText> {
        override fun createFromParcel(parcel: Parcel): TitleText {
            return TitleText(parcel)
        }

        override fun newArray(size: Int): Array<TitleText?> {
            return arrayOfNulls(size)
        }
    }
}

data class ReleaseDate(
    val day: Int,
    val month: Int,
    val year: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(day)
        parcel.writeInt(month)
        parcel.writeInt(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReleaseDate> {
        override fun createFromParcel(parcel: Parcel): ReleaseDate {
            return ReleaseDate(parcel)
        }

        override fun newArray(size: Int): Array<ReleaseDate?> {
            return arrayOfNulls(size)
        }
    }
}
