package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDatabase.class)
public class Alarm extends BaseModel {
    @Column
    /**
     * The default time to sound this alarm.
     */
    public long time;
    @PrimaryKey
    long id;
    @ForeignKey
    Rule rule;
    @Column
    String uriToPlay;
    @Column
    String name;
}
