package org.suns.data.collector.collectors.sheet422;

import org.suns.data.collector.collectors.AbstractDBUsageCollector;
import org.suns.database.utils.model.AbstractUsageModel;
import org.suns.database.utils.model.Sheet422CoreModel;
import org.suns.database.utils.model.Sheet422PersonalModel;

public abstract class AbstractDBSheet422Collector extends AbstractDBUsageCollector {
    @Override
    protected AbstractUsageModel getNewModel(ModelType modelType) {
        switch (modelType){
            case CORE:
                return new Sheet422CoreModel();
            case PERSONAL:
                return new Sheet422PersonalModel();
            default:
                return null;
        }
    }
}
