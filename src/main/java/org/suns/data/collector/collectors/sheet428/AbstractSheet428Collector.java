package org.suns.data.collector.collectors.sheet428;

import org.suns.data.collector.collectors.AbstractDataCollector;
import org.suns.data.collector.connector.HostConnector;
import org.suns.database.utils.model.Sheet428CoreModel;
import org.suns.database.utils.model.Sheet428PersonalModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractSheet428Collector extends AbstractDataCollector{
    protected abstract String getObtainTimeCmd();
    protected abstract long getTimeDiffTolerance();
    protected abstract String getCorrectReport();

    protected void inspectHostById(HostsId hostsId, long timeServerDiff
            , Sheet428PersonalModel sheet428Model) throws Exception{
        final String[] hosts = getInspectHosts(hostsId);
        final String[] users = getUsers(hostsId);
        final String[] passwords = getPasswords(hostsId);
        final int[] ports = getPorts(hostsId);

        String result = "";
        for(int i=0; i<hosts.length; i++){

            long diff = getHostTimeDiff(hosts[i], users[i], passwords[i], ports[i]);
            long diffWithTimeServer = Math.abs(timeServerDiff - diff);
            long diffMinute = (diffWithTimeServer/1000)/60;

            if(diffWithTimeServer > getTimeDiffTolerance()){
                result = result + hosts[i] + " 与时间服务器相差 " + diffMinute + "分钟\n";
            }
        }

        if(result.equals("")){
            result = getCorrectReport();
        }

        setStatusById(hostsId, sheet428Model, result);
    }

    protected long getHostTimeDiff(String host
            , String username, String password, int port) throws Exception{

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sysBeginTime = new Date();

        HostConnector.connect(username
                , password
                , host, port);

        final String queryCmd = getObtainTimeCmd();
        String strTime = HostConnector.executeCommand(queryCmd);
        Date sysEndTime = new Date();
        Date hostTime = df.parse(strTime);

        HostConnector.disconnect();

        long sysTime = sysBeginTime.getTime()
                + (sysEndTime.getTime() - sysBeginTime.getTime())/2;
        return Math.abs(hostTime.getTime() - sysTime);
    }

    protected void setStatusById(HostsId hostsId
            , Sheet428PersonalModel sheet428PersonalModel, String status){
        switch (hostsId){
            case HOST1:
                sheet428PersonalModel.setStatus1(status);
                break;
            case HOST2:
                sheet428PersonalModel.setStatus2(status);
                break;
            case HOST3:
                sheet428PersonalModel.setStatus3(status);
                break;
            case HOST4:
                sheet428PersonalModel.setStatus4(status);
                break;
            case HOST5:
                Sheet428CoreModel sheet428CoreModel
                        = (Sheet428CoreModel)sheet428PersonalModel;
                sheet428CoreModel.setStatus5(status);
                break;
            default:
                break;
        }

    }
}
