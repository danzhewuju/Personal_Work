package Page;

import java.sql.Date;
import java.text.DecimalFormat;

/**
 * Created by Alx on 2017/7/26.
 */
public class Invest {

    private int iid;
    private int uid;
    private int fid;
    private String mode;
    private Date firstdate;
    private Date today;
    private double getincome;
    private double thisincome;
    private int count;
    private double amount;
    private double proalo;
    private double rifa;
    private double invest;
    private double firstyearprofit;
    private int bsale;
    private double xxir;

    public Invest() {
    }

    public Invest( int uid, int fid, String mode, Date firstdate, Date today, double getincome, double thisincome, int count, double amount, double proalo, double rifa, double invest, double firstyearprofit,int bsale) {

        this.uid = uid;
        this.fid = fid;
        this.mode = mode;
        this.firstdate = firstdate;
        this.today = today;
        this.getincome = getincome;
        this.thisincome = thisincome;
        this.count = count;
        this.amount = amount;
        this.proalo = proalo;
        this.rifa = rifa;
        this.invest = invest;
        this.firstyearprofit = firstyearprofit;
        this.bsale=bsale;


    }

    public int getIid() {
        return iid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public double getGetincome() {
        return getincome;
    }

    public void setGetincome(double getincome) {
        this.getincome = getincome;
    }

    public double getThisincome() {
        return thisincome;
    }

    public void setThisincome(double thisincome) {
        this.thisincome = thisincome;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getProalo() {
        return proalo;
    }

    public void setProalo(double proalo) {
        this.proalo = proalo;
    }

    public double getRifa() {
        return rifa;
    }

    public void setRifa(double rifa) {
        this.rifa = rifa;
    }

    public double getInvest() {
        return invest;
    }

    public void setInvest(double invest) {
        this.invest = invest;
    }

    public double getFirstyearprofit() {
        return firstyearprofit;
    }

    public void setFirstyearprofit(double firstyearprofit) {
        this.firstyearprofit = firstyearprofit;
    }

    public int getBsale() {
        return bsale;
    }

    public void setBsale(int bsale) {
        this.bsale = bsale;
    }

    public double getXxir() {
        return xxir;
    }

    public void setXxir() {
        double pay=amount-thisincome;
        xxir=thisincome/pay*365;

        DecimalFormat df=new DecimalFormat("0.0000");
        xxir=Double.valueOf(df.format(xxir)) ;

        //查找相关资料
    }

    public void setXxir(double xxir) {
        this.xxir = xxir;
    }
}
