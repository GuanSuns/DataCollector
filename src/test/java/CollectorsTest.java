import org.junit.Test;
import org.suns.data.collector.collectors.sheet411.Sheet411CoreCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411PersonalCollector;
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
            /*
            Sheet421CoreCollector.inspect();
            Sheet421PersonalCollector.inspect();
            Sheet422PersonalCollector.inspect();
            Sheet422CoreCollector.inspect();
            Sheet423PersonalCollector.inspect();
            Sheet423CoreCollector.inspect();
            Sheet424PersonalCollector.inspect();
            Sheet424CoreCollector.inspect();
            Sheet429CoreCollector.inspect();
            Sheet429PersonalCollector.inspect();
            Sheet426PersonalCollector.inspect();
            Sheet426CoreCollector.inspect();
            Sheet428PersonalCollector.inspect();
            Sheet428CoreCollector.inspect();
*/

        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
