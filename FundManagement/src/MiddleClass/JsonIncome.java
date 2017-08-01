package MiddleClass;

import java.util.ArrayList;
import java.util.Date;

public class JsonIncome {//专门用于脚本数据的传送 关于年

    private  int fid;
    private  String fname;
    private ArrayList<Double> investingincome;
    private ArrayList<String> dates;
    private double amount;
    private int count=0;


    public JsonIncome() {
    }

    public JsonIncome(int fid, String fname, ArrayList<Double> investingincome, ArrayList<String> dates, double amount) {
        this.fid = fid;
        this.fname = fname;
        this.investingincome = investingincome;
        this.dates = dates;
        this.amount = amount;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }


    public ArrayList<Double> getInvestingincome() {
        return investingincome;
    }

    public void setInvestingincome(ArrayList<Double> investingincome) {

        this.investingincome = investingincome;
        count=investingincome.size();
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
