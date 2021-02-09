package br.com.tms.controller.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;


@Entity
public class TerminalModel implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @JsonProperty("logic")
    @Column(updatable = false)
    private int logic;
    
    @JsonProperty("serial")
    private String serial;
    
    @JsonProperty("model")
    private String model;
    
    @JsonProperty("sam")
    private int sam;
    
    @JsonProperty("ptid")
    private String ptid;
    
    @JsonProperty("plat")
    private int plat;
    
    @JsonProperty("version")
    private String version;
    
    @JsonProperty("mxr")
    private int mxr;
    
    @JsonProperty("mxf")
    private int mxf;
    
    @JsonProperty("VERFM")
    private String verfm;

    public int getLogic() {
        return logic;
    }

    public void setLogic(int logic) {
        this.logic = logic;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSam() {
        return sam;
    }

    public void setSam(int sam) {
        this.sam = sam;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public int getPlat() {
        return plat;
    }

    public void setPlat(int plat) {
        this.plat = plat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getMxr() {
        return mxr;
    }

    public void setMxr(int mxr) {
        this.mxr = mxr;
    }

    public int getMxf() {
        return mxf;
    }

    public void setMxf(int mxf) {
        this.mxf = mxf;
    }

    public String getVerfm() {
        return verfm;
    }

    public void setVerfm(String verfm) {
        this.verfm = verfm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TerminalModel{logic=").append(logic);
        sb.append(", serial=").append(serial);
        sb.append(", model=").append(model);
        sb.append(", sam=").append(sam);
        sb.append(", ptid=").append(ptid);
        sb.append(", plat=").append(plat);
        sb.append(", version=").append(version);
        sb.append(", mxr=").append(mxr);
        sb.append(", mxf=").append(mxf);
        sb.append(", verfm=").append(verfm);
        sb.append('}');
        return sb.toString();
    }

   
}
