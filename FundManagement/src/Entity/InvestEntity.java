package Entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alx on 2017/7/26.
 */
@Entity
@Table(name = "invest", schema = "fund", catalog = "")
public class InvestEntity {
    private int iid;  //id
    private String mode;//模式
    private Date firstdate;
    private Date today;
    private double getincome;//已实现收益
    private double thisincome;//本轮收益
    private int count;//轮次
    private double amount;//账目总资产
    private double proalo;//持仓盈亏
    private double rifa;//涨幅度
    private double invest;//投资额度
    private double firstyearprofit;//首年化数

    @Id
    @Column(name = "iid")
    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    @Basic
    @Column(name = "mode")
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Basic
    @Column(name = "firstdate")
    public Date getFirstdate() {
        return firstdate;
    }

    public void setFirstdate(Date firstdate) {
        this.firstdate = firstdate;
    }

    @Basic
    @Column(name = "today")
    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    @Basic
    @Column(name = "getincome")
    public double getGetincome() {
        return getincome;
    }

    public void setGetincome(double getincome) {
        this.getincome = getincome;
    }

    @Basic
    @Column(name = "thisincome")
    public double getThisincome() {
        return thisincome;
    }

    public void setThisincome(double thisincome) {
        this.thisincome = thisincome;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "proalo")
    public double getProalo() {
        return proalo;
    }

    public void setProalo(double proalo) {
        this.proalo = proalo;
    }

    @Basic
    @Column(name = "rifa")
    public double getRifa() {
        return rifa;
    }

    public void setRifa(double rifa) {
        this.rifa = rifa;
    }

    @Basic
    @Column(name = "invest")
    public double getInvest() {
        return invest;
    }

    public void setInvest(double invest) {
        this.invest = invest;
    }

    @Basic
    @Column(name = "firstyearprofit")
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
}
