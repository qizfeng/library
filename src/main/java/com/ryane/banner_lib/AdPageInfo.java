package com.ryane.banner_lib;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Creator: qizfeng
 * Create Time: 2017/6/17.
 * Email: qizfeng@sina.com
 */

public class AdPageInfo implements Parcelable,Serializable {
    private static final long serialVersionUID = -4337711009801627866L;
    public String imageUrl;//图片地址
    public String linkType;//0：无链接；1：链接；2：文章
    public String link;
    public String categoryId;//分类id
    public String articleId;//文章id

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.linkType);
        dest.writeString(this.link);
        dest.writeString(this.categoryId);
        dest.writeString(this.articleId);
    }
    public AdPageInfo(){

    }
    protected AdPageInfo(Parcel in) {
        this.imageUrl = in.readString();
        this.linkType = in.readString();
        this.link = in.readString();
        this.categoryId = in.readString();
        this.articleId=in.readString();
    }

    public static final Creator<AdPageInfo> CREATOR = new Creator<AdPageInfo>() {
        @Override
        public AdPageInfo createFromParcel(Parcel source) {
            return new AdPageInfo(source);
        }

        @Override
        public AdPageInfo[] newArray(int size) {
            return new AdPageInfo[size];
        }
    };

    @Override
    public String toString() {
        return "AdPageInfo{" +
                "imageUrl='" + imageUrl + '\'' +
                ", linkType='" + linkType + '\'' +
                ", link='" + link + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", articleId='" + articleId + '\'' +
                '}';
    }
}
