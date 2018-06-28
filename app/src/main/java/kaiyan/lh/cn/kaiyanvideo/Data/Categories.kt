package kaiyan.lh.cn.kaiyanvideo.Data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by admin on 2018/6/25.
 * 获取分类的栏目
 */
data class  Categories(val id: Int, val name: String , val alias: Any , val description: String,
                       val bgPicture: String, val bgColor: String, val headerImage: String,val defaultAuthorId:Long):Parcelable{
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            TODO("alias"),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readLong()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(bgPicture)
        parcel.writeString(bgColor)
        parcel.writeString(headerImage)
        parcel.writeLong(defaultAuthorId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Categories> {
        override fun createFromParcel(parcel: Parcel): Categories {
            return Categories(parcel)
        }

        override fun newArray(size: Int): Array<Categories?> {
            return arrayOfNulls(size)
        }
    }

}



