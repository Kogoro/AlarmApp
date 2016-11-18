package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ManyToMany;
import com.raizlabs.android.dbflow.annotation.MultipleManyToMany;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import de.bonding.hackathon.eighthundredtwelvers.common.Order;

@Table(database = AppDatabase.class)
@MultipleManyToMany({
        @ManyToMany(referencedTable = Rule.class),
        @ManyToMany(referencedTable = Alarm.class)
})
public class Condition extends BaseModel {
    @Column
    public String aspect;
    @Column
    public Order order;
    @Column
    public int value;

    public boolean eval() {
        int observedValue = 0; //TODO
        return order.compare(observedValue, value);
    }

}
