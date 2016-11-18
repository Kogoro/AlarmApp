package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.ArrayList;
import java.util.List;

@Table(database = AppDatabase.class)
public class Rule extends BaseModel {
    @Column
    /**
     * The difference in milliseconds this rule will effect.
     */
    public long deltaT;
    @Column
    public String name;
    @PrimaryKey
    long id;

    public Rule() {
        this.name = name;
        this.deltaT = deltaT;
        this.id = id;
    }

    public Rule(String name, long deltaT, long id) {
        this.name = name;
        this.deltaT = deltaT;
        this.id = id;
    }

    public static List<Rule> getAll() {
        return SQLite.select().from(Rule.class).queryList();
    }

    public static List<Rule> getDummy() {
        List<Rule> rules = new ArrayList<>(3);
        rules.add(new Rule("Dies sind", 1, 0));
        rules.add(new Rule("Dummy-Daten", 33, 1));
        rules.add(new Rule("ACHTUNG!", 4444, 2));
        return rules;
    }

    public boolean eval() {
        List<Condition> conditions = SQLite.select().from(Condition.class).where(Condition_Table.rule_id.eq(id)).queryList();
        for (Condition condition : conditions) {
            if (!condition.eval()) return false;
        }
        return true;
    }

}
