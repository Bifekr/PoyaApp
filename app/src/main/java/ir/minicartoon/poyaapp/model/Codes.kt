package ir.minicartoon.poyaapp.model

import android.os.Parcel
import android.os.Parcelable

class Codes(
    var id: String?,
    var title: String?,
    var text: String?,
    var codes: String?,
    var date: String?,
    var codeId: String?,
    var point: Int,
    var name: String?,
    var family: String?,
    var image: String?,
    var jensiat: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(codes)
        parcel.writeString(date)
        parcel.writeString(codeId)
        parcel.writeInt(point)
        parcel.writeString(name)
        parcel.writeString(family)
        parcel.writeString(image)
        parcel.writeInt(jensiat)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Codes> {
        override fun createFromParcel(parcel: Parcel): Codes {
            return Codes(parcel)
        }

        override fun newArray(size: Int): Array<Codes?> {
            return arrayOfNulls(size)
        }
    }
}