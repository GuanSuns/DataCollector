package org.suns.data.collector.collectors;

public class AbstractDBCollector extends AbstractDataCollector{
    
    protected String[] getSids(HostsId hostsId){
        switch (hostsId){
            case HOST1:
                return getSids1();
            case HOST2:
                return getSids2();
            case HOST3:
                return getSids3();
            case HOST4:
                return getSids4();
            case HOST5:
                return getSids5();
            case HOST6:
                return getSids6();
            case HOST7:
                return getSids7();
            case HOST8:
                return getSids8();
            default:
                return null;
        }
    }

    protected String[] getSids1(){
        return null;
    }
    protected String[] getSids2(){
        return null;
    }
    protected String[] getSids3(){
        return null;
    }
    protected String[] getSids4(){
        return null;
    }
    protected String[] getSids5(){
        return null;
    }
    protected String[] getSids6(){
        return null;
    }
    protected String[] getSids7(){
        return null;
    }
    protected String[] getSids8(){
        return null;
    }
    
}
