package kaiyan.lh.cn.kaiyanvideo.Data

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by admin on 2018/6/28.
 * 官方通知数据类
 */
data class GovNews(var title: String, var data: String, var content: String, var url: String) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(data)
        dest.writeString(content)
        dest.writeString(url)
    }



    companion object CREATOR : Parcelable.Creator<GovNews> {
        override fun createFromParcel(parcel: Parcel): GovNews {
            return GovNews(parcel)
        }

        override fun newArray(size: Int): Array<GovNews?> {
            return arrayOfNulls(size)
        }
    }
}