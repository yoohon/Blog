package com.yoo.hon.board4;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.yoo.hon.common.UtilEtc;
public class Board4DTO {
    
    private String brdno, brdtitle, brdwriter, brdmemo, brddate, brdhit, brddeleteflag, filecnt;
    
    private List<MultipartFile> uploadfile;
    
    public String getFilecnt() {
        return filecnt;
    }

    public void setFilecnt(String filecnt) {
        this.filecnt = filecnt;
    }

    public List<MultipartFile> getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(List<MultipartFile> uploadfile) {
        this.uploadfile = uploadfile;
    }

    public String getShortTitle(Integer len) {
        return UtilEtc.getShortString(getBrdtitle(), len);
    }
    
    public String getBrdhit() {
        return brdhit;
    }

    public void setBrdhit(String brdhit) {
        this.brdhit = brdhit;
    }

    public String getBrddeleteflag() {
        return brddeleteflag;
    }

    public void setBrddeleteflag(String brddeleteflag) {
        this.brddeleteflag = brddeleteflag;
    }

    public String getBrdno() {
        return brdno;
    }

    public void setBrdno(String brdno) {
        this.brdno = brdno;
    }

    public String getBrdtitle() {
        return brdtitle.replaceAll("(?i)<script", "&lt;script");
    }

    public void setBrdtitle(String brdtitle) {
        this.brdtitle = brdtitle;
    }

    public String getBrdwriter() {
        return brdwriter.replaceAll("(?i)<script", "&lt;script");
    }

    public void setBrdwriter(String brdwriter) {
        this.brdwriter = brdwriter;
    }

    public String getBrdmemo() {
        return brdmemo.replaceAll("(?i)<script", "&lt;script");
    }

    public void setBrdmemo(String brdmemo) {
        this.brdmemo = brdmemo;
    }

    public String getBrddate() {
        return brddate;
    }

    public void setBrddate(String brddate) {
        this.brddate = brddate;
    }
    
}