package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import de.bonding.hackathon.eighthundredtwelvers.WeatherMagnitudes;
import de.bonding.hackathon.eighthundredtwelvers.common.Order;

@Table(database = AppDatabase.class)
public class Condition extends BaseModel {
    @Column
    public WeatherMagnitudes magnitude;
    @Column
    public Order order;
    @Column
    public int value;
    @ForeignKey
    public
    Rule rule;
    @PrimaryKey
    long id;

    public boolean eval() {
        int observedValue = Integer.parseInt(magnitude.getValue()); //TODO
        return order.compare(observedValue, value);
    }

}
