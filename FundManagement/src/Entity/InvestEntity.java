package Entity;

import Unit.HibernateUtils;
import org.hibernate.Session;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alx on 2017/7/26.
 */
@Entity
@Table(name = "invest", schema = "fund", catalog = "")
public class InvestEntity {
    private int iid;
    private int uid;
    private int fid;
    private String mode;//模式
    private Date firstdate;//首日投资日期
    private Date today;//今天日期
    private double getincome;//已实现盈利
    private double thisincome;//本轮盈利
    private int count;//轮次
    private double amount;//账目的总资产
    private double proalo;//持仓盈亏
    private double rifa;//涨跌幅
    private double invest;//投资份额
    private double firstyearprofit;//首度年化
    private FundEntity fundByFid;
    private  UserEntity userByUid;
    private int bsale;


    @Id
    @Column(name = "iid", nullable = false)
    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    @Basic
    @Column(name = "uid" ,insertable = false,updatable = false)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "fid",insertable = false,updatable = false)
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "mode", nullable = false, length = 50)
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Basic
    @Column(name = "firstdate", nullable = false)
    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    @Basic
    @Column(name = "today", nullable = false)
    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    @Basic
    @Column(name = "getincome", nullable = false, precision = 0)
    public double getGetincome() {
        return getincome;
    }

    public void setGetincome(double getincome) {
        this.getincome = getincome;
    }

    @Basic
    @Column(name = "thisincome", nullable = false, precision = 0)
    public double getThisincome() {
        return thisincome;
    }

    public void setThisincome(double thisincome) {
        this.thisincome = thisincome;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "proalo", nullable = false, precision = 0)
    public double getProalo() {
        return proalo;
    }

    public void setProalo(double proalo) {
        this.proalo = proalo;
    }

    @Basic
    @Column(name = "rifa", nullable = false, precision = 0)
    public double getRifa() {
        return rifa;
    }

    public void setRifa(double rifa) {
        this.rifa = rifa;
    }

    @Basic
    @Column(name = "invest", nullable = false, precision = 0)
    public double getInvest() {
        return invest;
    }

    public void setInvest(double invest) {
        this.invest = invest;
    }

    @Basic
    @Column(name = "firstyearprofit", nullable = false, precision = 0)
    public double getFirstyearprofit() {
        return firstyearprofit;
    }

    public void setFirstyearprofit(double firstyearprofit) {
        this.firstyearprofit = firstyearprofit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestEntity that = (InvestEntity) o;

        if (iid != that.iid) return false;
        if (Double.compare(that.getincome, getincome) != 0) return false;
        if (Double.compare(that.thisincome, thisincome) != 0) return false;
        if (count != that.count) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (Double.compare(that.proalo, proalo) != 0) return false;
        if (Double.compare(that.rifa, rifa) != 0) return false;
        if (Double.compare(that.invest, invest) != 0) return false;
        if (Double.compare(that.firstyearprofit, firstyearprofit) != 0) return false;
        if (mode != null ? !mode.equals(that.mode) : that.mode != null) return false;
        if (firstdate != null ? !firstdate.equals(that.firstdate) : that.firstdate != null) return false;
        if (today != null ? !today.equals(that.today) : that.today != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iid;
        result = 31 * result + (mode != null ? mode.hashCode() : 0);
        result = 31 * result + (firstdate != null ? firstdate.hashCode() : 0);
        result = 31 * result + (today != null ? today.hashCode() : 0);
        temp = Double.doubleToLongBits(getincome);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(thisincome);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + count;
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(proalo);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(rifa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(invest);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(firstyearprofit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fid", referencedColumnName = "fid", nullable = false)
    public FundEntity getFundByFid() {
        return fundByFid;
    }

    public void setFundByFid(FundEntity fundByFid) {
        this.fundByFid = fundByFid;
    }





    @ManyToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid", nullable = false)
    public UserEntity getUserByUid() {
        return userByUid;
    }

    public void setUserByUid(UserEntity userByUid) {
        this.userByUid = userByUid;
    }


    @Basic
    @Column(name = "bsale")
    public int getBsale() {
        return bsale;
    }

    public void setBsale(int bsale) {
        this.bsale = bsale;
    }
}
