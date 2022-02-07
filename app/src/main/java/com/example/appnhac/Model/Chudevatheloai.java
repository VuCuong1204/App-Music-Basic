package com.example.appnhac.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chudevatheloai {

@SerializedName("TheLoai")
@Expose
private List<Theloai> theloai = null;
@SerializedName("ChuDe")
@Expose
private List<Chude> chude = null;

public List<Theloai> getTheloai() {
return theloai;
}

public void setTheloai(List<Theloai> theLoai) {
this.theloai = theloai;
}

public List<Chude> getChude() {
return chude;
}

public void setChule(List<Chude> chuDe) {
this.chude = chude;
}

}
