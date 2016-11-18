package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = AppDatabase.class)
public class Rule extends BaseModel {
    @PrimaryKey
    long id;

    public boolean eval() {
        List<Condition> conditions = SQLite.select().from(Condition.class).where(Condition_Table.rule_id.eq(id)).queryList();
        for (Condition condition : conditions) {
            if (!condition.eval()) return false;
        }
        return true;
    }

}
