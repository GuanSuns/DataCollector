import org.junit.Test;
import org.suns.data.collector.collectors.sheet411.Sheet411CoreCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411PersonalCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421CoreCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421PersonalCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422CoreCollector;
import org.suns.data.collector.collectors.sheet422.Sheet422PersonalCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423CoreCollector;
import org.suns.data.collector.collectors.sheet423.Sheet423PersonalCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424CoreCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428CoreCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429CoreCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;
import org.suns.database.utils.config.DBConfig;

/**
 * Created by guanl on 6/28/2017.
 */

public class CollectorsTest {

    @Test
    public void test_all_sheets(){
        try{
            DBConfig.setConfigToMySQL();
            Sheet411PersonalCollector sheet411PersonalCollector
                    = new Sheet411PersonalCollector();
            sheet411PersonalCollector.inspect();

            Sheet411CoreCollector sheet411CoreCollector
                    = new Sheet411CoreCollector();
            sheet411CoreCollector.inspect();

            Sheet421CoreCollector sheet421CoreCollector 
                    = new Sheet421CoreCollector();
            sheet421CoreCollector.inspect();
            
            Sheet421PersonalCollector sheet421PersonalCollector
                    = new Sheet421PersonalCollector();
            sheet421PersonalCollector.inspect();
            
            Sheet422PersonalCollector sheet422PersonalCollector
                    = new Sheet422PersonalCollector();
            sheet422PersonalCollector.inspect();

            Sheet422CoreCollector sheet422CoreCollector
                    = new Sheet422CoreCollector();
            sheet422CoreCollector.inspect();

            Sheet423CoreCollector sheet423CoreCollector
                    = new Sheet423CoreCollector();
            sheet423CoreCollector.inspect();

            Sheet423PersonalCollector sheet423PersonalCollector
                    = new Sheet423PersonalCollector();
            sheet423PersonalCollector.inspect();
            
            Sheet424PersonalCollector sheet424PersonalCollector
                    = new Sheet424PersonalCollector();
            sheet424PersonalCollector.inspect();

            Sheet424CoreCollector sheet424CoreCollector
                    = new Sheet424CoreCollector();
            sheet424CoreCollector.inspect();

            Sheet429CoreCollector sheet429CoreCollector
                    = new Sheet429CoreCollector();
            sheet429CoreCollector.inspect();

            Sheet429PersonalCollector sheet429PersonalCollector
                    = new Sheet429PersonalCollector();
            sheet429PersonalCollector.inspect();

            Sheet426CoreCollector sheet426CoreCollector
                    = new Sheet426CoreCollector();
            sheet426CoreCollector.inspect();

            Sheet426PersonalCollector sheet426PersonalCollector
                    = new Sheet426PersonalCollector();
            sheet426PersonalCollector.inspect();

            Sheet428CoreCollector sheet428CoreCollector
                    = new Sheet428CoreCollector();
            sheet428CoreCollector.inspect();

            Sheet428PersonalCollector sheet428PersonalCollector
                    = new Sheet428PersonalCollector();
            sheet428PersonalCollector.inspect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
