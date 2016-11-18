package de.bonding.hackathon.eighthundredtwelvers.model;

import com.raizlabs.android.dbflow.annotation.ManyToMany;
import com.raizlabs.android.dbflow.structure.BaseModel;

@ManyToMany(referencedTable = Condition.class)
public class Rule extends BaseModel {
}
