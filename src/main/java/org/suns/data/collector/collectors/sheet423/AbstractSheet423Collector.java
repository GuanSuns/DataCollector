package org.suns.data.collector.collectors.sheet423;

import org.suns.data.collector.collectors.AbstractUsageCollector;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet423CoreModel;
import org.suns.database.utils.model.Sheet423PersonalModel;

public abstract class AbstractSheet423Collector extends AbstractUsageCollector{
    @Override
    protected AbstractUsageModel getNewModel(ModelType modelType) {
        switch (modelType){
            case CORE:
                return new Sheet423CoreModel();
            case PERSONAL:
                return new Sheet423PersonalModel();
            default:
                return null;
        }
    }
}
