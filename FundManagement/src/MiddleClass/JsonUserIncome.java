package MiddleClass;

import java.util.ArrayList;

public class JsonUserIncome {
    private ArrayList<JsonIncome> jsonIncomes;
    private  int count;

    public JsonUserIncome(ArrayList<JsonIncome> jsonIncomes) {
        this.jsonIncomes = jsonIncomes;
        count=jsonIncomes.size();
    }

    public ArrayList<JsonIncome> getJsonIncomes() {
        return jsonIncomes;
    }

    public void setJsonIncomes(ArrayList<JsonIncome> jsonIncomes) {
        this.jsonIncomes = jsonIncomes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
