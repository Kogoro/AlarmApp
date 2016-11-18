package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

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
    public Rule rule;
    @Column
    public String uriToPlay;
    @Column
    public String name;
    @Column
    public boolean status;

    public Alarm() {
        this.name = name;
        this.time = time;
        this.status = status;
        this.id = id;
    }

    public Alarm(long time, String name, boolean status) {
        this.id = System.currentTimeMillis();
        this.time = time;
        this.name = name;
        this.status = status;
    }

    public static List<Alarm> getAll() {
        return SQLite.select().from(Alarm.class).queryList();
    }

}
